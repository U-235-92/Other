package aq.project.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import aq.project.model.Aircraft;

@Service
public class PlaneFinderService {

	private final String[] callsigns = {"EJA428", "AAL2913", "N63OCC", "PWF3560", "KLN5588", "IIOR8431"};
	private final String[] squawks = {"1646", "1146", "6255"};
	private final String[] regs = {"N428QS", "N737US", "N355PU"};
	private final String[] filightnumbers = {"5X2910", "AA1202", "AA1659"};
	private final String[] routes = {"BTR-DAL", "SDF-ONT", "DFW-IND"};
	private final String[] types = {"E55P", "MD11", "A321", "B777", "B737"};
	private final String[] categories = {"FJO984", "GH2586", "DQ5855"};
	private final int[] altitudes = {41000, 35975, 37000, 45555, 30000};
	private final int[] headings = {189, 23, 77 , 55, 40};
	private final int[] speeds = {390, 460, 417, 332};
	private final double[] lats = {38.66, 38.47, 38.55, 38.06};
	private final double[] lons = {-90.034, -90.875, -90.585, -90.333};
	private final Instant[] lastSeeingTimes = {Instant.ofEpochSecond(1000), Instant.now(), Instant.ofEpochSecond(10000000)};
	
	public List<Aircraft> getAircraft() {
		return Stream
				.generate(() -> new Aircraft(1L, callsigns[(int) (Math.random() * (callsigns.length - 1))], squawks[(int) (Math.random() * (squawks.length - 1))], regs[(int) (Math.random() * (regs.length - 1))], filightnumbers[(int) (Math.random() * (filightnumbers.length - 1))], routes[(int) (Math.random() * (routes.length - 1))], types[(int) (Math.random() * (types.length - 1))], categories[(int) (Math.random() * (categories.length - 1))], altitudes[(int) (Math.random() * (altitudes.length - 1))], headings[(int) (Math.random() * (headings.length - 1))], speeds[(int) (Math.random() * (speeds.length - 1))], 0, lats[(int) (Math.random() * (lats.length - 1))], lons[(int) (Math.random() * (lons.length - 1))], 0, 0, 0, false, false, lastSeeingTimes[(int) (Math.random() * (lastSeeingTimes.length - 1))], null, null))
				.limit((int) (3 + Math.random() * 10))
				.collect(Collectors.toList());
	}
}
