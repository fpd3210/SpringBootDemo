# springboot静态资源存放
### 1.spring boot静态资源默认有5个存放位置分别为：
```
classpath:/META-INF/resources/
classpath:/resources/
classpath:/static/
classpath:/public/
/
```
默认不自定义配置只可以访问static下的资源
访问http://localhost:8080/2.png
http://localhost:8080/资源名

### 2.自定义静态资源位置
###### 1.application.properties配置
```
# 存放资源位置
spring.resources.static-locations=classpath:/aaa
# /** 表示可以匹配任意层级的路径
spring.mvc.static-path-pattern=/**

```
访问：http://localhost:8080/资源名
###### 2.java配置
```
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
    }
}
```
访问：http://localhost:8080/资源名
