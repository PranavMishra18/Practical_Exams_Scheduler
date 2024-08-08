package com.Practical.Backend.Serializer;

import com.Practical.Backend.Entity.Venue;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class VenueSerializer extends JsonSerializer<Venue> {

    @Override
    public void serialize(Venue venue, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", venue.getId());
        jsonGenerator.writeStringField("venue", venue.getVenue());
        jsonGenerator.writeEndObject();
    }
}
