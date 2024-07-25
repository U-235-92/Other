package com.other.app.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Robot {

	@EmbeddedId
	private RobotSeries robotSeries;
	private String name;
	@ElementCollection
	@CollectionTable(name = "robot_parameters")
	@MapKeyColumn(name = "param_name")
	@Column(name = "param_value")
	private Map<String, String> parameters = new HashMap<>();
	@ElementCollection
	@CollectionTable(name = "robot_engines")
	@MapKeyColumn(name = "engine_name")
	@Column(name = "engine_value")
	@OneToMany(cascade = CascadeType.ALL)
	private Map<String, Engine> engines = new HashMap<>();
	@ElementCollection
	@CollectionTable(name = "robot_commands")
	@Column(name = "command")
	private List<String> commands = new ArrayList<>();
}
