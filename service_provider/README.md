restful service provider

1. 可以在pom.xml和application.properties中选择注册中心(eureka或consul)

提供的测试接口：  
http://localhost:8762/greeting?name=world  
http://localhost:8762/add?num=1　
http://localhost:8762/config     (测试从配置中心读取配置值) 

加密配置说明:  
  1). 下载并安装jasypt, 直接解压即可  
  2). encrypt.bat input="password123" password="secritkey"  
      其中, input是待加密的字符, password相当于密钥  
  3). 加密属性值用ENC()标识, 如: password=ENC(wVnSEflCskO99xuEEiU+CvUVWu0xJxFX),  
      ENC()里面是前面password123的加密结果  
  4). 需要获取解密值的应用里,增加依赖: jasypt-spring-boot-starter  
      并在application.properties里, 设置密钥: jasypt.encryptor.password=secritkey  
