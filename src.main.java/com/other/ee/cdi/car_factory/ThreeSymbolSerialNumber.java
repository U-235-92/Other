package com.other.ee.cdi.car_factory;

import java.util.Optional;
import java.util.stream.Stream;

@ThreeSymbol
public class ThreeSymbolSerialNumber implements SerialNumberGen {

	@Override
	public String getSerialNumber() {
		Optional<String> strOptional = Stream.generate(() -> Character.valueOf(getRandomChar())).limit(3).
				map(t -> String.valueOf(t)).reduce((t, u) -> t + u);
		return strOptional.orElse("ABC");
	}
}
