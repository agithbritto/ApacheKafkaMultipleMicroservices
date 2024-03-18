# ApacheKafkaMultipleMicroservices
Apache Kafka with multiple SpringBoot microservices

Hit this API http://localhost:8080/api/v1/orders with payload,

{
    "orderName":"sdfsd",
    "quantity":1
}

Order Microservices will create an order and assigns it to orderevent
The order event is the sent to the Kafka topic by Producer

Now we have 2 Concumer microservices
Email
Stock
They consume the Order event from broker and writes log.

To start zookeeper in windows .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties To start kafka in windows .\bin\windows\kafka-server-start.bat .\config\server.properties
