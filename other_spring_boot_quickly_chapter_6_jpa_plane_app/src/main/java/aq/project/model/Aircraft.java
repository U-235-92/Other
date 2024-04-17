package aq.project.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {

	@Id
	@GeneratedValue
	private Long id;
	private String callsign, squawk, reg, flightno, route, type, category;
	private int altitude, heading, speed;
	@JsonProperty("selected_altitude")
	private int selectedAltitude;
	private double lat, lon, barometer;
	@JsonProperty("polar_distance")
	private double polarDistance;
	@JsonProperty("polar_bearing")
	private double polarBearing;
	@JsonProperty("is_adsb")
	private boolean isADSB;
	@JsonProperty("is_on_ground")
	private boolean isOnGround;
	@JsonProperty("last_seen_time")
	private Instant lastSeenTime;
	@JsonProperty("pos_update_time")
	private Instant posUpdateTime;
	@JsonProperty("bds40_seen_time")
	private Instant bds40SeenTime;

	/* Don't need after add @RedisHash
	 * public String getLastSeenTime() { return lastSeenTime.toString(); }
	 * 
	 * public void setlastSeenTime(String lastSeenTime) { if (null != lastSeenTime)
	 * { this.lastSeenTime = Instant.parse(lastSeenTime); } else { this.lastSeenTime
	 * = Instant.ofEpochSecond(0); } }
	 * 
	 * public Instant getPosUpdateTime() { return posUpdateTime; }
	 * 
	 * public void setPosUpdateTime(String posUpdateTime) { if(null !=
	 * posUpdateTime) { this.posUpdateTime = Instant.parse(posUpdateTime); } else {
	 * this.posUpdateTime = Instant.ofEpochSecond(0); } }
	 * 
	 * public Instant getBds40SeenTime() { return bds40SeenTime; }
	 * 
	 * public void setBds40SeenTime(String bds40SeenTime) { if(null !=
	 * bds40SeenTime) { this.bds40SeenTime = Instant.parse(bds40SeenTime); } else {
	 * this.bds40SeenTime = Instant.ofEpochSecond(0); } }
	 */

}
