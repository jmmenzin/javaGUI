package temperatureConversion;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TemperatureConversionGUI
{
	public static JFrame frame;
	public static JPanel panel1;
	public static JButton btn1;
	public static JTextField input;
	public static JComboBox<String> inputList;
	public static JComboBox<String> outputList;
	
	private double temperature;
	private final String frame_text = "Temperature Convertor";
	private final String decimalFormat = "#.##";
	private int frame_width;
	private int frame_height;
	private String[] unitTypes = {"Fahrenheit", "Celsius", "Kelvin"};
	
	public TemperatureConversionGUI(int frame_width_input, int frame_height_input) 
	{
		frame_width = frame_width_input;
		frame_height = frame_height_input;
		this.initialize();
	}
	
	private void initialize() {
		frame = new JFrame(frame_text);
		frame.setSize(frame_width, frame_height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.add(new JLabel("Input Temperature"));
		
		input = new JTextField(20);
		panel1.add(input);
		
		inputList = new JComboBox<String>(unitTypes);
		outputList = new JComboBox<String>(unitTypes);
		panel1.add(inputList); 
		panel1.add(outputList);
		
		btn1 = new JButton("Convert");
		btn1.addActionListener(new ActionListener()  {
			public void actionPerformed (ActionEvent e)
			{
				try {
					if((String)inputList.getSelectedItem() == (String)outputList.getSelectedItem()) 
						{
						temperature = Double.parseDouble(input.getText());
						}
					else
					{
					temperature = temperatureConverter.Convert(Double.parseDouble(input.getText()), (String)inputList.getSelectedItem(), (String)outputList.getSelectedItem());
					btn1.setText("Temp: " + new DecimalFormat(decimalFormat).format(temperature));
					}
				}
				catch (Exception f)
				{
					btn1.setText("Not a valid temperature");
				}
			}
		});
		panel1.add(btn1);
		
		frame.getContentPane().add(panel1);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setVisible(true);
	}	
}
