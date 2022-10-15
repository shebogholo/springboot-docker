## Spring Boot with Docker

### Docker Commands
1. Build the image: ` docker build -t spring-boot-docker . `
2. Run the container: ` docker run -p 8080:8080 spring-boot-docker `
3. Test the application: ` curl http://localhost:8080 `

## Docker
1. Stop container on port 80: ` docker stop $(docker ps -a -q -f publish=80) `
2. Remove exited containers: ` docker rm $(docker ps -a -q -f status=exited) `
3. Remove unused images: ` docker image prune -a -f `

### Docker Compose
1. Build the image: ` docker-compose up --build `
2. Stop the container: ` docker-compose down `
3. Test the application: ` curl http://localhost:8080 `


### Samples
1. ` GRANT ALL ON spring-docker.* TO 'spring-docker'@'%'; `
