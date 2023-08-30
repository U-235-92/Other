package com.other.json_test.gson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Locale;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.other.json_test.obj.Ticket;
import com.other.json_test.obj.TicketType;

public class TicketTypeAdapter extends TypeAdapter<Ticket> {

	@Override
	public void write(JsonWriter writer, Ticket ticket) throws IOException {
		writer.beginObject();
		writer.name("sale_date");
		writer.value(ticket.getTicketSaleDate()
				.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.getDefault())));
		writer.name("type");
		writer.value(ticket.getTicketType().name().toLowerCase());
		writer.name("serial_number");
		writer.value(ticket.getTicketSerialNumber());
		writer.name("id");
		writer.value(ticket.getId());
		writer.name("price");
		writer.value(ticket.getTicketPrice());
		writer.name("description");
		writer.value(ticket.getTicketDescription());
		writer.name("check_codes");
		writer.beginArray();
		ticket.getCheckCodes().forEach(code -> {
			try {
				writer.value(Integer.valueOf(code));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		writer.endArray();
		writer.endObject();
	}

	@Override
	public Ticket read(JsonReader reader) throws IOException {
		Ticket ticket = new Ticket();
		reader.beginObject();
		String fieldName = null;
		while (reader.hasNext()) {
			JsonToken token = reader.peek();
			if (token == JsonToken.NAME) {
				fieldName = reader.nextName();
			} else if (token == JsonToken.STRING) {
				String value = reader.nextString();
				if(fieldName.equals("sale_fate")) {
					ticket.setTicketSaleDate(LocalDateTime.parse(value, DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.getDefault())));
				} else if(fieldName.equals("type")) {
					ticket.setTicketType(TicketType.valueOf(value.toUpperCase()));
				} else if(fieldName.equals("serial_number")) {
					ticket.setTicketSerialNumber(value);
				} else if(fieldName.equals("price")) {
					ticket.setTicketPrice(value);
				} else if(fieldName.equals("description")) {
					ticket.setTicketDescription(value);
				}
			} else if(token == JsonToken.NUMBER) {
				int value = reader.nextInt();
				if(fieldName.equals("id")) {
					ticket.setId(value);
				}
			} else if (token == JsonToken.BEGIN_ARRAY) {
				reader.beginArray();
				var checkCodes = new ArrayList<Integer>();
				while (reader.hasNext()) {
					JsonToken tmpToken = reader.peek();
					if(tmpToken == JsonToken.NUMBER) {						
						int value = reader.nextInt();
						checkCodes.add(value);
					}
				}
				ticket.setCheckCodes(checkCodes);
				reader.endArray();
			} else {
				reader.skipValue();
			}

		}
		reader.endObject();
		return ticket;
	}

}
