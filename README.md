## Active MQ spring boot sample ##
#### Note
simulate data retrieval and processing

### running as docker swarm stack
``` bash
#do this to run docker in swarm mode
docker swarm init

#to build and run the project
# you can change the image here. but make sure to change it in the docker-composer.yml (line 19)as well
docker build . -t aranga/amq-app:latest
docker stack deploy --compose-file docker-compose.xml amq-demo

```