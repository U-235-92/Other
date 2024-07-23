package com.other.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.other.app.dto.PersonCardDTO;
import com.other.app.model.PersonCard;
import com.other.app.repository.AppRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppService {
	
	private final AppRepository repository;
	
	public List<PersonCard> getPersonCards() {
		return repository.getPersonCards();
	}
	
	public void addPersonCard(PersonCardDTO personCardDTO) {
		repository.addPersonCard(PersonCard.of(personCardDTO));
	}
}
