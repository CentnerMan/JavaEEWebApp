# JavaEEWebApp
JavaEE learning

Подключаем драйвер к WildFly:
F:\wildfly-19.0.0.Beta3\bin\jboss-cli.bat --connect --file=jdbc_driver.cli

Ошибки с timeZone вылечились запуском скрипта в mySQL:
set global time_zone = '-3:00';

