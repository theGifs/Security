# SpringBoot  For  Security
SecurityShiro
RBAC 
##### git clone  到本地 
##### mvn clean package 编译  
##### 导入 base.sql 

##### 2019-12-26  add 导入导出   For Alibaba easyExcel 
- 阿里的easyExcel 在读取数据的时候 , 需要继承一个`AnalysisEventListener<T>`监听器 [对应实体类泛型]
- 重写其中的两个方法, 其中一个是在读取一行的时候会执行, 另一个则是在全部读取完毕再次执行

## 番外篇 
### 2019-12-27  多数据源   (基于spring Boot 1.X 版本 Oracle And  Mysql  DB)
 - 主要配置文件 在 `jdbc.properties` 文件中   