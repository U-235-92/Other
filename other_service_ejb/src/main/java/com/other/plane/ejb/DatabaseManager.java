package com.other.plane.ejb;

import com.other.plane.cdi.PlaneEnum;
import com.other.plane.cdi.PlaneType;
import com.other.plane.entity.Plane;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@DataSourceDefinition(
		className = "org.h2.jdbcx.JdbcDataSource",
		name = "java:global/other_service_ejb/plane_ds",
		url = "jdbc:h2:mem:plane_db",
		maxPoolSize = 32)
@Startup
public class DatabaseManager {

	@EJB
	private PlaneController planeController;
	@Inject @PlaneType(manufacturer = PlaneEnum.McDOUGLAS)
	private Plane dc10;
	@Inject @PlaneType(manufacturer = PlaneEnum.ILUSHIN)
	private Plane il62;
	
	public DatabaseManager() {
		super();
	}
	
	@PostConstruct
	protected void fillDB() {
		planeController.create(dc10);
		planeController.create(il62);
	}
	
	@PreDestroy
	protected void dropDB() {
		planeController.dropAll();
	}
}
