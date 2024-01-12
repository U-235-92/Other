package com.other.plane.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Singleton
@Startup
@DataSourceDefinition(
	className = "org.apache.derby.iapi.jdbc.AutoloadedDriver",
	name = "java:global/jdbc/plane_ds",
	url = "jdbc:derby:memory:plane;create=true")
public class DatabaseFiller {

	@EJB
	private PlaneEJB planeEJB;
	
	@PostConstruct
	private void fillDB() {
		
	}
	
	@PreDestroy
	private void clearDB() {
		
	}
}
