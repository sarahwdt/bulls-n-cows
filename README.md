# bulls-n-cows
Тестовое задание

В проекте используются следующие библиотеки:
org.hibernate.orm:hibernate-core:6.0.0.Alpha5
org.postgresql:postgresql:42.2.14.jre7
javax:javaee-api:8.0.1
javax.servlet:servlet-api:3.0-alpha-1

Для сборки проекта используется maven. Сборка происходит с помощью плагина
org.apache.tomcat.maven:tomcat7-maven-plugin:2.2
Конфигурация
<configuration>
	<url>http://localhost:8080/manager/text</url>
	<server>TomcatServer</server>
	<path>/</path>
</configuration>
Проект собирается с помощью команды tomcat7:deploy
(tomcat7:undeploy)

Настройки для maven и tomcat предоставлены в папке misc

В проекте используется база данных postgresql 12. Настройки для подключения указаны в файле hibernate.cfg.xml
(..\bulls-n-cows\src\main\webapp\WEB-INF\classes\hibernate.cfg.xml)
bulls_and_cows.backup - дамп базы данных для проекта

Проект разрабатывался в Intelij IDEA 2020.1.2 (Community Edition)
