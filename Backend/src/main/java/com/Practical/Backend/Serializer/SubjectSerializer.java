package com.Practical.Backend.Serializer;

import com.Practical.Backend.Entity.Subject;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class SubjectSerializer extends JsonSerializer<Subject> {

    @Override
    public void serialize(Subject subject, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", subject.getId());
        jsonGenerator.writeStringField("subjectCode", subject.getSubjectCode());
        jsonGenerator.writeStringField("subjectName", subject.getSubjectName());
        jsonGenerator.writeEndObject();
    }
}
