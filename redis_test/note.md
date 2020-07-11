
# springboot 整合Redis

## 方案1 pring Data Redis
- 在传统的 SSM 中，需要开发者自己来配置 Spring Data Redis ，这个配置比较繁琐，主要配置 3 个东西：连接池、连接器信息以及 key 和 value 的序列化方案。
- 在 Spring Boot 中，默认集成的 Redis 就是 Spring Data Redis，默认底层的连接池使用了 lettuce ，开发者可以自行修改为自己的熟悉的，例如 Jedis。

#### 1.引入依赖
```properties
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-pool2</artifactId>
    </dependency>
</dependencies>
```
#### 2.配置
```properties
spring.redis.database=0
spring.redis.password=123
spring.redis.port=6379
spring.redis.host=192.168.66.128
spring.redis.lettuce.pool.min-idle=5
spring.redis.lettuce.pool.max-idle=10
spring.redis.lettuce.pool.max-active=8
spring.redis.lettuce.pool.max-wait=1ms
spring.redis.lettuce.shutdown-timeout=100ms
```

#### 3.自动化配置
当开发者在项目中引入了 Spring Data Redis ，并且配置了 Redis 的基本信息，此时，自动化配置就会生效。
```java
@Configuration(proxyBeanMethods = false)
//在RedisOperations存在时才会生效
@ConditionalOnClass(RedisOperations.class)  
//导入在 application.properties 中配置的属性
@EnableConfigurationProperties(RedisProperties.class)  
//然后再导入连接池信息（如果存在的话）
@Import({ LettuceConnectionConfiguration.class, JedisConnectionConfiguration.class })  
public class RedisAutoConfiguration {
   
   	/**
   	 * 配置两个bean
   	 */
	@Bean
	@ConditionalOnMissingBean(name = "redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}
	@Bean
	@ConditionalOnMissingBean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

}
```

#### 4.两个bean的默认序列化方案
- redisTemplate：JdkSerializationRedisSerializer
- stringRedisTemplate：stringRedisTemplate

修改默认序列化方案
```java
redisTemplate.setKeySerializer(new StringRedisSerializer());
```

## 方案2：Spring Cache + Redis做缓存

#### 1.引入依赖
```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-cache</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```

#### 2.配置
```properties
spring.redis.port=6379
spring.redis.host=127.0.0.1

# 给缓存起一个名字        
spring.cache.cache-names=c1
```

#### 3.启动类添加注解
```java
@SpringBootApplication
@EnableCaching
public class RedisTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisTestApplication.class, args);
	}

}
```

#### 4.缓存使用

##### @CacheConfig
这个注解在类上使用，用来描述该类中所有方法使用的缓存名称，当然也可以不使用该注解，直接在具体的缓存注解上配置名称，示例代码如下：
```java
@Service
@CacheConfig(cacheNames = "c1")
public class UserService {
}

```

#### @Cacheable
这个注解一般加在查询方法上，表示将一个方法的返回值缓存起来，默认情况下，缓存的key就是方法的参数，缓存的value就是方法的返回值。示例代码如下：
```java
    @Cacheable(key = "#id")
    public User getUserById(Integer id,String name){
       return  userDao.getById(id);
    }
```
这里默认使用多个参数做key,如果只需要其中某一个参数做key，则可以在@Cacheable注解中，通过key属性来指定key，如上代码就表示只使用id作为缓存的key。

#### @CachePut
这个注解一般加在更新方法上，当数据库中的数据更新后，缓存中的数据也要跟着更新，使用该注解，可以将方法的返回值自动更新到已经存在的key上，示例代码如下：
```java
    @CachePut(key = "user.id")
    public User updateUserById(User user){
        return user;
    }
```

#### @CacheEvict
这个注解一般加在删除方法上，当数据库中的数据删除后，相关的缓存数据也要自动清除，该注解在使用的时候也可以配置按照某种条件删除（condition属性）
或者或者配置清除所有缓存（allEntries属性），示例代码如下：
```java
    @CacheEvict
    public void delUserById(Integer id){
        //删除操作
    }
```

##  JRedis 使用
#### 1.引入依赖
```xml
<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>3.1.0</version>
		</dependency>
```

#### 2.测试连接
```java
 public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        String ping = jedis.ping();
        System.out.println(ping);
    }
```

#### 3.连接池
```java
public static void main(String[] args) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(20);
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("k3","v3");
        System.out.println(jedis.ping());
        System.out.println(jedis.get("k3"));
    }
```