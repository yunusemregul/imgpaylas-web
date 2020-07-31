package com.imgpaylas.server.converter;

import javax.persistence.AttributeConverter;
import java.awt.*;

// https://thorben-janssen.com/jpa-21-how-to-implement-type-converter/
public class ColorConverter implements AttributeConverter<Color, String>
{
	private static final String SEPARATOR = ",";

	@Override
	public String convertToDatabaseColumn(Color color)
	{
		return color.getRed() + SEPARATOR +
				color.getGreen() +
				SEPARATOR +
				color.getBlue() +
				SEPARATOR +
				color.getAlpha();
	}

	@Override
	public Color convertToEntityAttribute(String colorString)
	{
		String[] rgb = colorString.split(SEPARATOR);
		return new Color(Integer.parseInt(rgb[0]),
				Integer.parseInt(rgb[1]),
				Integer.parseInt(rgb[2]),
				Integer.parseInt(rgb[3]));
	}
}
