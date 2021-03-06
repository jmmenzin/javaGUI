package temperatureConversion;

import java.util.Arrays;
import java.util.List;

public class temperatureConverter {

	private final static List<String> allowedUnits = Arrays.asList("Fahrenheit", "Celsius", "Kelvin");  
	
	public temperatureConverter() {}
	
	public static double Convert(double temp, String unit_from, String unit_to) throws ConversionUnitException 
	{
		if (!(allowedUnits.contains(unit_from)))
		{
			throw new ConversionUnitException(unit_from);
		}
		if(!(allowedUnits.contains(unit_to)))
		{
			throw new ConversionUnitException(unit_to);
		}
		
		switch(unit_from) {
			case("Fahrenheit"):
				if(unit_to == "Celsius") return ((temp - 32)/(1.8));
				else return ((temp + 459.67)/(1.8));
			
			case("Celsius"):
				if(unit_to == "Fahrenheit") return (temp * 1.8 + 32);
				else return (temp + 273.15);
					
			case("Kelvin"):
				if(unit_to == "Celsius") return (temp - 273.15);
				else return (temp * 1.8 - 459.67);
		}
		return temp;
	}
}
