package com.Practical.Backend.Serializer;

import com.Practical.Backend.Entity.External;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class ExternalSerializer extends JsonSerializer<External> {

    @Override
    public void serialize(External external, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", external.getId());
        jsonGenerator.writeObjectField("externalExaminer", external.getExternalExaminer());
        jsonGenerator.writeStringField("date", external.getDate());
        jsonGenerator.writeStringField("day", external.getDay());
        jsonGenerator.writeObjectField("timeSlot", external.getTimeSlot());
        jsonGenerator.writeEndObject();
    }
}
