FROM openjdk:11.0-oracle
COPY "./target/prjMicroProductos-0.0.1-SNAPSHOT.jar" "productJar.jar"
EXPOSE 8096
ENTRYPOINT ["java", "-jar", "productJar.jar"]