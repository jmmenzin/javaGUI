package mainGUI;

import java.awt.EventQueue;
import temperatureConversion.TemperatureConversionGUI;

public class MainGUI {

	public static int width = 800;
	public static int height = 300;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					TemperatureConversionGUI gui = new TemperatureConversionGUI(width, height);
				} catch (Exception e) {
					System.out.println("An error has occurred");
					e.printStackTrace();
					
				}
			}
		});
	}
}