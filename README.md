# Disease_reporting_system 疫情直报系统
​	当前该项目是学校JavaEE大作业的后端系统，采用**SSM+Mysql**框架进行开发。该系统主要实现案例录入、案例管理（CRUD）、统计分析、数据展现和留言讨论等功能。



------

### 如何开始

#### 1. 克隆并导入依赖

​	克隆该项目到本地后用IDEA打开，并用Maven导入pom.xml中所注明的依赖包

#### 2. 准备好本地数据库

​	在本地mysql数据库中，创建名为drs（disease_report_system的缩写）的数据库，然后运行create_table.sql脚本以创建具体的表格

#### 3. 修改数据库配置文件

​	修改resources文件夹下的dbconfig.properties文件，将数据库用户名和密码改为自己的用户名和密码。

#### 4. 在Tomcat上部署该web应用，并启动Tomcat

