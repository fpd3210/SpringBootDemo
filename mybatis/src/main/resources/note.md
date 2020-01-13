# springboot整合mybatis

### 1、配置
```

```
### 2、xml文件存放位置
1.跟mapper接口一个位置
问题：xml文件会自动扫描到，但是打包时maven会忽略java目录下的xml文件
解决：在pom文件中添加如下配置
```
<build>
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
        </resource>
        <resource>
            <directory>src/main/resources</directory>
        </resource>
    </resources>
</build>
```
2.放在resource下
问题：不会被自动扫描到
解决：application.properties配置
```
mybatis.mapper-locations=classpath:mapper/*.xml
```


###3.mapper扫描方法
1.在接口上@Mapper注解(每个接口都需要注解)
2.启动类扫描
```
@SpringBootApplication
@MapperScan(basePackages = "com.dpf.mybatis.mapper")
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
```

### 4.全注解
在接口的方法前标注注解@Select\@Insert\@update\@delete
@Results


### 5.多数据源配置
application.properties
```

spring.datasource.one.url=jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8
spring.datasource.one.username=root
spring.datasource.one.password=123456
spring.datasource.one.type=com.alibaba.druid.pool.DruidDataSource

spring.datasource.two.url=jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8
spring.datasource.two.username=root
spring.datasource.two.password=123456
spring.datasource.two.type=com.alibaba.druid.pool.DruidDataSource

```

DatasourceConfig
```
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.one")
    DataSource dsOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.two")
    DataSource dsTwe(){
        return DruidDataSourceBuilder.create().build();
    }

}
```

MyBatisConfigOne
```
@Configuration
@MapperScan(basePackages = "com.dpf.mybatis2.mapper1",sqlSessionFactoryRef = "sqlSessionFactory1",sqlSessionTemplateRef = "sqlSessionTemplate1")
public class MyBatisConfigOne {
    @Resource(name = "dsOne")
    DataSource dsOne;

    @Bean
    SqlSessionFactory sqlSessionFactory1() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        try {
            bean.setDataSource(dsOne);
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate1() {
        return new SqlSessionTemplate(sqlSessionFactory1());
    }
}

MyBatisConfigTwo
```
@Configuration
@MapperScan(basePackages = "com.dpf.mybatis2.mapper2", sqlSessionFactoryRef = "sqlSessionFactory2", sqlSessionTemplateRef = "sqlSessionTemplate2")
public class MyBatisConfigTwo {

    @Resource(name = "dsTwo")
    DataSource dsTwo;

    @Bean
    SqlSessionFactory sqlSessionFactory2() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        try {
            bean.setDataSource(dsTwo);
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate2() {
        return new SqlSessionTemplate(sqlSessionFactory2());
    }
}



