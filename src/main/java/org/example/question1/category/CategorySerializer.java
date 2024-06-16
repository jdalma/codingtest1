package org.example.question1.category;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CategorySerializer extends JsonSerializer<Category> {

    @Override
    public void serialize(Category value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        gen.writeFieldName("category");
        gen.writeStartObject();
        gen.writeFieldName("name");
        gen.writeString(value.getName());

        gen.writeFieldName("board");
        gen.writeObject(value.getBoard());

        gen.writeFieldName("children");
        gen.writeObject(value.getChildren());
        gen.writeEndObject();

        gen.writeEndObject();
    }
}
