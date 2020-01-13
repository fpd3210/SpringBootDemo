# 定义系统启动任务的两种方式
1.CommandLineRunner 
2.ApplicationRunner

区别：ApplicationRunner功能比CommandRunner更强大，可以接受key/value类型参数

# 测试
### 1.CommandLineRunner 
1.在配置configuration中的Environment中的program arguments中填入参数启动
2.先打包(maven工具中Lifecycle->package)然后启动java -jar xxx.jar 参数列表
