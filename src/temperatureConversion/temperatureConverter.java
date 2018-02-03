package temperatureConversion;

import java.util.Arrays;
import java.util.List;

public class temperatureConverter {

	private final static List<Character> allowedUnits = Arrays.asList('f','c','k');  
	
	public temperatureConverter() {}
	
	public static double Convert(double temp, Character unit_from, Character unit_to) throws ConversionUnitException 
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
			case('f'):
				if(unit_to == 'c') return ((temp - 32)/(1.8));
				else return ((temp + 459.67)/(1.8));
			
			case('c'):
				if(unit_to == 'f') return (temp * 1.8 + 32);
				else return (temp + 273.15);
					
			case('k'):
				if(unit_to == 'c') return (temp - 273.15);
				else return (temp * 1.8 - 459.67);
		}
		return temp;
	}
}
