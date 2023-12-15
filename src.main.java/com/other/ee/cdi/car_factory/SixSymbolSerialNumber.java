package com.other.ee.cdi.car_factory;

import java.util.Optional;
import java.util.stream.Stream;

@SixSymbol
public class SixSymbolSerialNumber implements SerialNumberGen {

	@Override
	public String getSerialNumber() {
		Optional<String> strOptional = Stream.generate(() -> Character.valueOf(getRandomChar())).limit(6).
				map(t -> String.valueOf(t)).reduce((t, u) -> t + u);
		return strOptional.orElse("ABCDEF");
	}
}
