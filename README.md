# JavaEEWebApp
JavaEE learning

Подключаем драйвер к WildFly:
\wildfly-19.0.0.Beta3\bin\jboss-cli.bat --connect --file=jdbc_driver.cli

Подключаем security к WildFly:
\wildfly-19.0.0.Beta3\bin\jboss-cli.bat --connect --file=security.cli

Ошибки с timeZone вылечились запуском скрипта в mySQL:
set global time_zone = '-3:00';

