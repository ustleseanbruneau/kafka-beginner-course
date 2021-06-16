package com.leseanbruneau.kafka.tutorial1;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerDemo {
	
	public static void main(String[] args) {
		//System.out.println("hello world");
		String bootstrapServers = "127.0.0.1:9092";
		
		// create producer properties
		Properties properties = new Properties();
		//properties.setProperty("bootstrap.servers", bootstrapServers);
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		//properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		//properties.setProperty("value.serializer", StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		
		// create the producer
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties); 
		
		// create a producer record
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", "hello world");
		
		// send data
		producer.send(record);
		
		// flush data
		producer.flush();
		
		// flush and close producer
		producer.close();
		
		
		// start a zookeeper, kafka server, and client from command line
		// zookeeper-server-start.sh config/zookeeper.properties
		// kafka-server-start.sh config/server.properties
		// kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-third-application
		
		// useful sites
		// https://kafka.apache.org/documentation/
		// http://jtuts.com/2014/09/02/useful-shortcuts-in-eclipse-and-sts/
		// https://mvnrepository.com/artifact/org.slf4j/slf4j-simple/1.7.30
		// https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients/2.8.0
		// Google search:  kafka maven
		
		
		
	}

}
