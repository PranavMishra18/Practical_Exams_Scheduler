package com.Practical.Backend.Serializer;

import com.Practical.Backend.Entity.TimeTable;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class TimeTableSerializer extends JsonSerializer<TimeTable> {

    @Override
    public void serialize(TimeTable timeTable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", timeTable.getId());
        jsonGenerator.writeStringField("section", timeTable.getSection());
        jsonGenerator.writeStringField("studentGroup", timeTable.getStudentGroup());
        jsonGenerator.writeStringField("students", timeTable.getStudents());
        jsonGenerator.writeStringField("day", timeTable.getDay());
        jsonGenerator.writeStringField("year", timeTable.getYear());
        jsonGenerator.writeObjectField("subject", timeTable.getSubject());
        jsonGenerator.writeObjectField("teacher", timeTable.getTeacher());
        jsonGenerator.writeStringField("phoneNumber", timeTable.getPhoneNumber());
        jsonGenerator.writeObjectField("timeSlot", timeTable.getTimeSlot());
        jsonGenerator.writeObjectField("venue", timeTable.getVenue());
        jsonGenerator.writeEndObject();
    }
}
