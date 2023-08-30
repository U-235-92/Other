package com.other.json_test.obj;

import java.time.LocalDateTime;
import java.util.List;

public class Ticket {

	public static int totalCount;
	private int id;
	private LocalDateTime ticketSaleDate;
	private TicketType ticketType;
	private String ticketDescription;
	private String ticketSerialNumber;
	private transient String ticketPrice;
	private List<Integer> checkCodes;
	
	public Ticket() {
		this(null, null, null, null, null, null);
		id = -1;
	}

	public Ticket(LocalDateTime ticketSaleDate, TicketType ticketType, String ticketDescription,
			String ticketSerialNumber, String ticketPrice, List<Integer> checkCodes) {
		super();
		totalCount++;
		this.id = (int) (totalCount * (int) 1 + Math.random() * 32);
		this.ticketSaleDate = ticketSaleDate;
		this.ticketType = ticketType;
		this.ticketDescription = ticketDescription;
		this.ticketSerialNumber = ticketSerialNumber;
		this.ticketPrice = ticketPrice;
		this.checkCodes = checkCodes;
	}

	public LocalDateTime getTicketSaleDate() {
		return ticketSaleDate;
	}
	
	public void setTicketSaleDate(LocalDateTime ticketSaleDate) {
		this.ticketSaleDate = ticketSaleDate;
	}
	
	public TicketType getTicketType() {
		return ticketType;
	}
	
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	
	public String getTicketDescription() {
		return ticketDescription;
	}
	
	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}
	
	public String getTicketSerialNumber() {
		return ticketSerialNumber;
	}
	
	public void setTicketSerialNumber(String ticketSerialNumber) {
		this.ticketSerialNumber = ticketSerialNumber;
	}
	
	public String getTicketPrice() {
		return ticketPrice;
	}
	
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(this.id == -1) {			
			this.id = id;
		}
	}
	
	public List<Integer> getCheckCodes() {
		return checkCodes;
	}

	public void setCheckCodes(List<Integer> checkCodes) {
		this.checkCodes = checkCodes;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", ticketSaleDate=" + ticketSaleDate + ", ticketType=" + ticketType
				+ ", ticketDescription=" + ticketDescription + ", ticketSerialNumber=" + ticketSerialNumber
				+ ", ticketPrice=" + ticketPrice + ", checkCodes=" + checkCodes + "]";
	}
}
