package net.dontdrinkandroot.example.springbootrestsecurityangular2.configuration.jackson;

import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Component
public class InstantModule extends SimpleModule
{
    @Override
    public void setupModule(SetupContext context)
    {
        SimpleSerializers serializers = new SimpleSerializers();
        SimpleDeserializers deserializers = new SimpleDeserializers();

        serializers.addSerializer(Instant.class, new InstantSerializer());
        deserializers.addDeserializer(Instant.class, new InstantDeserializer());

        context.addSerializers(serializers);
        context.addDeserializers(deserializers);
    }
}
