package temperatureConversion;

public class ConversionUnitException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private String unit;
	public ConversionUnitException(String unit_input)
	{
		unit = unit_input;
		System.out.println(unit + " is not a valid unit");
	}
	public String getUnit()
	{
		return unit;
	}
}
