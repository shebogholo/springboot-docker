## Spring Boot with Docker

### Technologies
1. Spring Boot
2. MariaDB 
3. Docker

### Getting Started using Docker
1. Install Docker from repository:  [Install from repository](https://docs.docker.com/engine/install/ubuntu/#install-using-the-repository)
2. Run the following command to build the image: ` docker compose up --build `
3. Access the application at: [http://localhost:150](http://localhost:150)


### Docker Commands
1. Stop container on port 80: ` docker stop $(docker ps -a -q -f publish=80) `
2. Remove exited containers: ` docker rm $(docker ps -a -q -f status=exited) `
3. Remove unused images: ` docker image prune -a -f `


### TODO
1. Roles
2. Permissions
3. Authentication

### Side Notes
1. The application is running on port 150
2. The database is running on port 3308
3. This API can be accessed at [this link on server](https://shebogholo.com/springboot1/)
