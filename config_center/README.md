config server

1. 可以在pom.xml和application.properties中选择注册中心(eureka或consul)
2. 默认从本地库读配置文件 resources/confg目录，可以在application.properties里修改成github的模式

测试接口：  
http://localhost:8766/config/dev 
http://localhost:8766/config/test
