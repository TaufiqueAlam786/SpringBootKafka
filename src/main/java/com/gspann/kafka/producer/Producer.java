package com.gspann.kafka.producer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC4 = "topic4";
	private static final String TOPIC5 = "topic5";
	private static final String TOPIC6 = "topic6";
	private static final String TOPIC7 = "topic7";
	private static final String TOPIC8 = "topic8";
	private static final String testKafka = "testKafka";
	private static final String test = "test";

	List<String> list = new ArrayList<String>();
	@Autowired
	private KafkaTemplate<String, String> kafkaTemp;

	public void sendMessage(String message) {

		// Sending Same message to different topics.
//		list.add(TOPIC4);
//		list.add(TOPIC5);
//		list.add(TOPIC6);
//		for (String topic : list) {
//			logger.info(String.format("#### -> Producing message -> %s", message));
//			this.kafkaTemp.send(topic, message);
//			System.out.println("Producer Produced message " + topic + " and " + message);
//		}
		
		logger.info(String.format("#### -> Producing message -> %s", message));
		this.kafkaTemp.send(test, message);
		System.out.println("Producer Produced message " + test + " and " + message);
		
		// Send message to different (specific) partitions of same topic.

//		this.kafkaTemp.setDefaultTopic(TOPIC7);
//		this.kafkaTemp.sendDefault(0, "key1", message);
//		this.kafkaTemp.sendDefault(1, "key2", message);

	}
}
