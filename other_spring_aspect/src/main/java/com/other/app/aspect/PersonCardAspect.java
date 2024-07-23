package com.other.app.aspect;

import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.other.app.dto.PersonCardDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Aspect
@Component
public class PersonCardAspect {

	@Autowired
	private Validator validator;
	
	@SuppressWarnings("unchecked")
	@Around("execution(* com.other.app.controller.AppController.addPersonCardAspect(..))")
	public ResponseEntity<String> validatePersonCard(ProceedingJoinPoint pjp) {
		ResponseEntity<String> returnValue = null;
		try {
			PersonCardDTO personCardDTO = (PersonCardDTO) pjp.getArgs()[0];
			Set<ConstraintViolation<PersonCardDTO>> constraintViolations = validator.validate(personCardDTO);
			if(!constraintViolations.isEmpty()) {
				String violations = constraintViolations
						.stream()
						.map(violation -> violation.getPropertyPath() + " = " + violation.getInvalidValue() + " ")
						.reduce("", (s1, s2) -> s1.concat(s2));
				return ResponseEntity.badRequest().body("Invalid person card -> " + violations);
			} else {				
				returnValue = (ResponseEntity<String>) pjp.proceed();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}
