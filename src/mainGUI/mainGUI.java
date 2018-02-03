package mainGUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import temperatureConversion.temperatureConverter;

import java.text.DecimalFormat;

public class MainGUI {

	private JFrame frame;
	public static int width = 800;
	public static int height = 300;
	public static JButton btn1;
	public static JTextField input;
	public static JPanel panel1;
	public static JPanel result;
	private final String decimalFormat = "#.##";
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI(width,height);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainGUI(int frame_width, int frame_height) 
	{
		initialize(frame_width, frame_height);
	}
	
	private void initialize(int frame_width, int frame_height) {
		frame = new JFrame("Test GUI");
		frame.setSize(frame_width, frame_height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.add(new JLabel("Converter"));
		
		input = new JTextField(20);
		panel1.add(input);
		
		btn1 = new JButton(String.format("Convert"));
		btn1.addActionListener(new ActionListener()  {
			public void actionPerformed (ActionEvent e)
			{
				try {
				double temperature = temperatureConverter.Convert(Double.parseDouble(input.getText()), 'k', 'c');
				btn1.setText("Temp: " + new DecimalFormat(decimalFormat).format(temperature));
				}
				catch (Exception f){
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