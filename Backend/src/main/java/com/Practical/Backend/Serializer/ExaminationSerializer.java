package com.Practical.Backend.Serializer;

import com.Practical.Backend.Entity.Examination;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class ExaminationSerializer extends JsonSerializer<Examination> {

    @Override
    public void serialize(Examination examination, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", examination.getId());
        jsonGenerator.writeObjectField("subject", examination.getSubject());
        jsonGenerator.writeStringField("year", examination.getYear());
        jsonGenerator.writeStringField("section", examination.getSection());
        jsonGenerator.writeStringField("day", examination.getDay());
        jsonGenerator.writeStringField("studentGroup", examination.getStudentGroup());
        jsonGenerator.writeStringField("students", examination.getStudents());
        jsonGenerator.writeObjectField("internalExaminer", examination.getInternalExaminer());
        jsonGenerator.writeObjectField("externalExaminer", examination.getExternalExaminer());
        jsonGenerator.writeNumberField("phoneNo", examination.getPhoneNo());
        jsonGenerator.writeStringField("email", examination.getEmail());
        jsonGenerator.writeObjectField("timeSlot", examination.getTimeSlot());
        jsonGenerator.writeStringField("date", examination.getDate());
        jsonGenerator.writeObjectField("venue", examination.getVenue());
        jsonGenerator.writeEndObject();
    }
}
