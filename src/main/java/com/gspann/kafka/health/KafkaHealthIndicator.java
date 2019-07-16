package com.gspann.kafka.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class KafkaHealthIndicator implements HealthIndicator {
	private final Logger log = LoggerFactory.getLogger(KafkaHealthIndicator.class);

	private KafkaTemplate<String, String> kafka;

	public KafkaHealthIndicator(KafkaTemplate<String, String> kafka) {
		this.kafka = kafka;
	}

	/**
	 *
	 * @return the health of Kafka.
	 */
	@Override
	public Health health() {
		try {
			System.out.println("Kafka health");
			kafka.send("kafka-health-indicator", "❥").get(100, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			return Health.down(e).build();
		}
		return Health.up().build();
	}
}
