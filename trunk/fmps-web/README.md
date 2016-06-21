1、修改配置文件/plug-in/ueditor1_4_3-utf8-jsp/jsp/config.json
2、在共享盘建立 /data/www/fmps/ 建立 upload 目录
3、在  10.1.18.88   10.1.18.89 发布脚本中加入  /opt/fmps_files/deployfmps.sh 
     rm -rf /usr/local/tomcat/webapps/fmps/upload
     ln -s /data/www/fmps/upload  /usr/local/tomcat/webapps/fmps/upload
4、执行脚本导入初始数据
5、生产webservice 链接检查。
6、菜单同步。 
7、增加公共实体类工程 http://10.1.20.150/svn/Fifth-Commons/trunk/fubon-common-entity ，项目打包前需要先 mvn clean install 公共JAR包