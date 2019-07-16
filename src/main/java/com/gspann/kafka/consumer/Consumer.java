package com.gspann.kafka.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	/**
	 * One topic read by One Consumer --- Solution : topics = "topic4" Multiple
	 * topics read by one Consumer.---- Solution : topics =
	 * {"topic4","topic5","topic6" }
	 */
//	@KafkaListener(topics = {"topic4","topic5","topic6" }, groupId = "group_id")
//	public void consume(String message) throws IOException {
//		logger.info(String.format("#### -> Consumed message -> %s", message));
//		System.out.println("Consumer done-------------");
//	}

//	@KafkaListener(topics = "topic7", 
//			topicPartitions= {@TopicPartition(topic = "topic7", partitions = { "0", "1"})},groupId = "groupId")
//	public void consume(String message) throws IOException {
//		logger.info(String.format("#### -> Consumed message -> %s", message));
//		System.out.println("Consumer Reading done-------------");
//	}
	
	@KafkaListener(topics = "ocf-oots-sh-outbound", groupId = "group_id")
	public void consume(String message) throws IOException {
		logger.info(String.format("#### -> Consumed message -> %s", message));
		System.out.println("Consumer done-------------");
	}
	
}