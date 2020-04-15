
@echo off 

echo 请确认generatorConfig.xml配置正确 

set input=
set /p input= 回车继续

call mvn mybatis-generator:generate


set input2=
set /p input2= 回车关闭