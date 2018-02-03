package temperatureConversion;

public class ConversionUnitException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private Character unit;
	public ConversionUnitException(Character unit_input)
	{
		unit = unit_input;
		System.out.println(unit + " is not a valid unit");
	}
	public Character getUnit()
	{
		return unit;
	}
}
