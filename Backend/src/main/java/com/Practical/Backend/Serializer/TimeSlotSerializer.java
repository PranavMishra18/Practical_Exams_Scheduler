package com.Practical.Backend.Serializer;

import com.Practical.Backend.Entity.TimeSlot;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class TimeSlotSerializer extends JsonSerializer<TimeSlot> {

    @Override
    public void serialize(TimeSlot timeSlot, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", timeSlot.getId());
        jsonGenerator.writeStringField("timeSlot", timeSlot.getTimeSlot());
        jsonGenerator.writeEndObject();
    }
}
