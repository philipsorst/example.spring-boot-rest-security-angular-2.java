package net.dontdrinkandroot.example.springbootrestsecurityangular2.configuration.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InstantSerializer extends JsonSerializer<Instant>
{
    @Override
    public void serialize(
            Instant value,
            JsonGenerator generator,
            SerializerProvider serializers
    ) throws IOException
    {
        if (null == value) {
            generator.writeNull();
        } else {
            generator.writeString(value.toString());
        }
    }
}
