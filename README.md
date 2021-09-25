# eclipse_maven_spring_boot_tomcat
 Eclipse Maven Spring Boot Deploy to Tomcat

Import maven project into eclipse 

Right click on project -> Run as -> Run Configuration -> MavenTomcat1

[MavenTomcat1]
Base Directory: ${project_loc}
Goals: clean install tomcat7:deploy

-> Run
 
 
Note: if build is successful, but you can't connect after putting http://localhost:8080/DeployMavenToTomcat in browser url,
try to start up Tomcat first

D:\Tomcat\apache-tomcat-9.0.53\bin
cmd
>startup

