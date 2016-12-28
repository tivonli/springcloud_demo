hystrix dashboard
1. 在浏览器打开dashboard: http://localhost:8764/hystrix
2. 监控此流： http://localhost:8763/hystrix.stream
3. 在service_provider打开和关闭的情况下分别访问ribbon_consumer服务的接口L:
http://localhost:8763/hello
http://localhost:8763/random

在dashboard中观测此二接口调用成功与失败的实时情况