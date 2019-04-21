# SupplyAndDemand
初步后端代码 采用SSM框架

开始的话需要对maven进行reimport导入相关的jar包

![1555818328145](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555818328145.png)







controller如图：

![1555817883146](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555817883146.png)

service如图：

![1555817905451](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555817905451.png)

dao如图：

![1555817926061](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555817926061.png)

entity如图：

![1555817941288](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555817941288.png)



Redis是调用redis的工具，需在本地安装redis并且启动redis服务

安装启动教程：<https://www.cnblogs.com/wxjnew/p/9160855.html>

![1555817970929](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555817970929.png)



util里面包含了一些小工具：

UUID生成器和准备用于python程序的socket通信部件

![1555818096138](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555818096138.png)





Test包里面可以对controller里面的方法进行测试：

![1555818126995](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555818126995.png)



测试的时候需要注意更改发送目标的url （就是下面的http:...........要和待测试的controller里面的方法的url相匹配）

![1555818140832](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555818140832.png)





mapper里面存放的是mybatis需要配置的文件

里面还需要补充相关函数的sql语句



![1555818223435](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555818223435.png)



![1555818280299](C:\Users\zhuzhu\AppData\Roaming\Typora\typora-user-images\1555818280299.png)







