# 指定基础镜像
FROM openjdk:11-jre-slim

# 维护者信息
MAINTAINER Your Name <you@example.com>

# 将当前目录下的jar包复制到容器中的 /app 目录下
COPY target/demo-app.jar /app/

# 容器启动时运行的命令
CMD ["java", "-jar", "/app/demo-app.jar"]
