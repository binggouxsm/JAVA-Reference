# Proxy

## 作用

客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。

优点：
1. 代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用
2. 代理对象可以扩展目标对象的功能
3. 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度，增加了程序的可扩展性

缺点：
1. 类的数量增加
2. 增加一个代理对象，会造成请求处理速度变慢

![Proxy 模式](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/Proxy.png)

## 实现




## 动态代理
jdk.proxy.ProxyGenerator.saveGeneratedFiles true