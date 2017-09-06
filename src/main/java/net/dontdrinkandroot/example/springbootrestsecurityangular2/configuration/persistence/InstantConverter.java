package net.dontdrinkandroot.example.springbootrestsecurityangular2.configuration.persistence;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;

/**
 * Persistence converter that translates {@link Instant}s to their {@link Long} timestamp and vice versa.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Converter(autoApply = true)
public class InstantConverter implements AttributeConverter<Instant, Long>
{
    @Override
    public Long convertToDatabaseColumn(Instant attribute)
    {
        if (null == attribute) {
            return null;
        }

        return attribute.toEpochMilli();
    }

    @Override
    public Instant convertToEntityAttribute(Long dbData)
    {
        if (null == dbData) {
            return null;
        }

        return Instant.ofEpochMilli(dbData);
    }
}
