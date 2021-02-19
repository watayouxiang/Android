# MySQL安装和配置（mac版）



## MySQL安装和配置

- 官网：https://dev.mysql.com/downloads/mysql/

- 登录密码：wangtao0709

```
// 使用homebrew安装MySQL
brew install mysql

// 初始化mysql配置
mysql_secure_installation

// 后台启动mysql
brew service start mysql

// 前台启动mysql(关闭控制台，服务停止)
mysql.server start

// 连接mysql服务器
// -u后接用户名，默认用户名是root，-p表示输入密码
mysql -u root -p

// 查看所有本地数据库
show databases;

```



[]: 

