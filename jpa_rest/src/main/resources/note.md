# 基于jpa构建rest风格应用
#### 1.构建
- 1.pom
- 2.实体类
- 3.repository接口

#### 2.访问
- 1.查询(get)：
http://localhost:8080/实体类小写s
- 2.修改(put)
http://localhost:8080/实体类小写s/需要修改的id
- 3.增加(post):
http://localhost:8080/实体类小写s
- 4.删除(delete)
http://localhost:8080/实体类小写s/需要修改的id

#### 3.定制查询接口
- 1.方法名(按照jpa规则)；注意，方法的定义，参数要有 @Param 注解。
- 2.查询自定义接口:
 http://localhost:8080/实体类小写s/search
- 3.自定义访问接口名(按照jpa规则定制接口名太长)
```
方法中使用@RestResource注解
rel：表示接口查询中，这个方法的 key。
path：表示请求路径
exported：表示是否暴露接口，默认为true
```

#### 4.定制JSON 字符串中的集合名和单个 item 的名字
```
接口前使用@RepositoryRestResource注解
collectionResourceRel:json集合名
itemResourceRel:item名称
path:请求名称(即实体类小写s名称)
```

#### 5.其他配置
```
#统一接口前缀
spring.data.rest.base-path=/api
# 排序参数key
spring.data.rest.sort-param-name=sort
# 分页参数 页码key
spring.data.rest.page-param-name=page
# 分页参数 每页大小
spring.data.rest.limit-param-name=size
# 每页多大记录数 默认20
spring.data.rest.max-page-size=20
# 分页查询时默认开始页码
spring.data.rest.default-page-size=0
更新成功时是否返回更新记录
spring.data.rest.return-body-on-update=true
添加成功时是否返回添加记录
spring.data.rest.return-body-on-create=true
```
