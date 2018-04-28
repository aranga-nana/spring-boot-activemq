## Active MQ spring boot sample ##
#### Note
simulate data retrieval and processing

### running as docker swarm stack
``` bash
#do this to run docker in swarm mode
docker swarm init

#to build and run the project
docker stack deploy --compose-file docker-compose.xml amq-demo

```