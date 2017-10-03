Job of load balancer is to distribute the client request among multiple instances of server. so it seats between client and server.

Ribbon is Netflix's client side load balancer. It should know where all server instances are running. It figures out these instances network locations through service discovery or you can configure the instances list. 
e.g. listOfServers: localhost:8181,localhost:8282,localhost:8383 

Ribbon provides different strategies to ping these instances and figure out the active instances. pinging interval can be configured. 
e.g. ServerListRefreshInterval: 15000

Ribbon provides different strategies to choose one instance among multiple instances and forward the client request to the chosen instance.

![alt text](https://github.com/vivekthite/getting-started/blob/master/spring-cloud-netflix-ribbon/load-balancer.png)

More details of ribbon can be found @ https://github.com/Netflix/ribbon.

==============================================================================

How to run this application : 
1. Run the three instances of hello-service @ three different ports- 8181,8282,8383 
2. Run the ribbon-client and hit the url - http://localhost:8080/v1/hi
3. Observer the logs for 3 instances of hello-service
