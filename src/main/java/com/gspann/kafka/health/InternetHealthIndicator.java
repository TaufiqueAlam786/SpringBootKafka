package com.gspann.kafka.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InternetHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		return null;
	}

}
