package com.other.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.other.app.entity.Robot;
import com.other.app.entity.RobotSeries;

public interface RobotRepository extends JpaRepository<Robot, RobotSeries> {

}
