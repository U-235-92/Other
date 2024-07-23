package com.other.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.other.app.model.PersonCard;

@Repository
public class AppRepository {

	private Map<String, PersonCard> personCardStore = new HashMap<>();
	
	public List<PersonCard> getPersonCards() {
		return new ArrayList<PersonCard>(personCardStore.values());
	}
	
	public void addPersonCard(PersonCard personCard) {
		personCardStore.put(personCard.getId(), personCard);
	}
}
