package com.Practical.Backend.Serializer;

import com.Practical.Backend.Entity.Subject;
import com.Practical.Backend.Entity.Teacher;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TeacherSerializer extends JsonSerializer<Teacher> {

    @Override
    public void serialize(Teacher teacher, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", teacher.getId());
        jsonGenerator.writeStringField("name", teacher.getName());
        jsonGenerator.writeStringField("email", teacher.getEmail());
        jsonGenerator.writeNumberField("phoneNo", teacher.getPhoneNo());
        // Serialize subjects
        jsonGenerator.writeArrayFieldStart("subjects");
        for (Subject subject : teacher.getSubjects()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", subject.getId());
            jsonGenerator.writeStringField("subjectCode", subject.getSubjectCode());
            jsonGenerator.writeStringField("subjectName", subject.getSubjectName());
            // You can add more fields if needed
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
