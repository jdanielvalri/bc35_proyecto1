FROM openjdk:11.0-oracle
COPY "./target/prjMicroClientes-0.0.1-SNAPSHOT.jar" "clientJar.jar"
EXPOSE 8095
ENTRYPOINT ["java", "-jar", "clientJar.jar"]