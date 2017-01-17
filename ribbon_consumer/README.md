ribbon consumer & hystrix client

1. 依赖service_provider服务
2. 可以在pom.xml和application.properties中选择注册中心(eureka或consul)

提供的测试接口：  
http://localhost:8763/hello  (此url有hystrix, 目的是测试turbin集群)
http://localhost:8763/add?num=number  
