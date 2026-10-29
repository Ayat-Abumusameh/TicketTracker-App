# enviromnet to run java
FROM eclipse-temurin:17-jdk

# spicfy the work's folder inside the containaor of docker     
WORKDIR /app

# copy project files into inside the contatinar 
COPY . /app

# if you want to run application direct when you do run to docker
CMD ["java", "-version"]