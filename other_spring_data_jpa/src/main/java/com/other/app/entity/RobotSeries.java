package com.other.app.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class RobotSeries {

	private int number;
	private String model_value;
}
