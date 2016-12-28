zuul

1. 依赖service-provider和ribbon-consumer服务(/api*映射至服务ribbon-consumer)
2. 可以在pom.xml和application.properties中选择注册中心(eureka或consul)

提供的测试接口：  
http://localhost:8765/api/hello?accessToken=1
http://localhost:8765/api/random  (无accessToken参数， forbidden)
