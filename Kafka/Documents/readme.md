# Documents
## Open Source Kafka set up in local (Windows) ##
1. Required for without zookeeper: to generate cluster ID(eg : AbcdDefghIbjgKuu) Cluster UUID
   
    ```bin\windows\kafka-storage.bat random-uuid```

3. Format log Directories
   
    ```bin\windows\kafka-storage.bat format -t <clusterId> -c config\server.properties```

5. Start kafka Server /Broker
   
    ```bin\windows\kafka-server-start.bat config\server.properties```

7. Create Topic
   
    ```bin\windows\kafka-topics.bat --create --topic demo-events --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3```
    ```bin\windows\kafka-topics.bat --create --topic demoEvent2-events --bootstrap-server localhost:9092 --replication-factor 1 --partitions 2```

9. List down topics
    
    ```bin\windows\kafka-topics.bat --broker-list localhost:9092 --list```
    ```bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list```

11. Describe Topic
    
    ```bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic demo-events```

13. Producer message
    
    ```bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic demo-events```

15. send csv file as message
    
    ```type <>path\random_data.csv |.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic demo-events```

17. consume message
    ```bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic demo-events```

