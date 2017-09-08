package net.dontdrinkandroot.example.springbootrestsecurityangular.configuration.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InstantDeserializer extends JsonDeserializer<Instant>
{
    @Override
    public Instant deserialize(
            JsonParser parser,
            DeserializationContext context
    ) throws IOException
    {
        //TODO: implement
        return null;
    }
}
