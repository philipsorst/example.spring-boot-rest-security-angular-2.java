package net.dontdrinkandroot.example.springbootrestsecurityangular2.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Converter(autoApply = true)
public class InstantConverter implements AttributeConverter<Instant, Long>
{
    @Override
    public Long convertToDatabaseColumn(Instant attribute)
    {
        return attribute.toEpochMilli();
    }

    @Override
    public Instant convertToEntityAttribute(Long dbData)
    {
        return Instant.ofEpochMilli(dbData);
    }
}
