$ docker-machine.exe env
export DOCKER_TLS_VERIFY="1"
export DOCKER_HOST="tcp://192.168.99.100:2376"
export DOCKER_CERT_PATH="C:\Users\vivekanandt\.docker\machine\machines\default"
export DOCKER_MACHINE_NAME="default"
============================

export above env variables on mvn terminal and issue following cmds - 

mvn install dockerfile:build

docker run -p 8080:8080 -t hello/spring-boot-docker:latest

Using spring profile - 

docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t hello/spring-boot-docker:latest

or 

docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 -t hello/spring-boot-docker:latest

For debugging the application

docker run -e "JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n" -p 8080:8080 -p 8000:8000 -t hello/spring-boot-docker:latest

