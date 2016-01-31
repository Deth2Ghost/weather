package ua.wether.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Observable;


import javax.swing.ImageIcon;

import ua.wether.src.GetWeather;
import ua.wether.src.ImageParse;

public class WetherGui{
Observable observable;
private float temp = 600 ,press,humm;

    private JFrame frame;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	

	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    WetherGui window = new WetherGui();
		    window.frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

	
	
	/**
     * Create the application.
     * @throws IOException 
     * @throws InterruptedException 
     */
    public WetherGui() throws IOException, InterruptedException {
	initialize();
	
    }
	
	/**
     * Initialize the contents of the frame.
     * @throws MalformedURLException 
     * @throws IOException 
     * @throws InterruptedException 
     */
    private void initialize() throws MalformedURLException, IOException, InterruptedException  {
    	
	frame = new JFrame();
	frame.setBounds(100, 100, 471, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel panel = new JPanel();
	frame.getContentPane().add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(10, 11, 435, 239);
	panel.add(tabbedPane);
	
	JPanel panel_1 = new JPanel();
	tabbedPane.addTab("\u0422\u0435\u043A\u0443\u0449\u0430\u044F \u043F\u043E\u0433\u043E\u0434\u0430", null, panel_1, null);
	panel_1.setLayout(null);
	
	JLabel lblTemperature = new JLabel("\u0422\u0435\u043C\u043F\u0435\u0440\u0430\u0442\u0443\u0440\u0430:");
	lblTemperature.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblTemperature.setBounds(101, 32, 94, 23);
	panel_1.add(lblTemperature);
	
	JLabel lblPressure = new JLabel("\u0414\u0430\u0432\u043B\u0435\u043D\u0438\u0435:");
	lblPressure.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblPressure.setBounds(101, 86, 94, 23);
	panel_1.add(lblPressure);
	
	JLabel lblH = new JLabel("\u0412\u043B\u0430\u0436\u043D\u043E\u0441\u0442\u044C:");
	lblH.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblH.setBounds(101, 143, 94, 23);
	panel_1.add(lblH);
	
	JLabel lblIcon = new JLabel();
	
	
	lblIcon.setBounds(24, 24, 52, 52);
	panel_1.add(lblIcon);
	
	JLabel lblTemp = new JLabel();
	lblTemp.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
	lblTemp.setBounds(216, 33, 76, 22);
	panel_1.add(lblTemp);
	
	JLabel lblPress = new JLabel();
	lblPress.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
	lblPress.setBounds(216, 87, 94, 22);
	panel_1.add(lblPress);
	
	JLabel lblHum = new JLabel();
	lblHum.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblHum.setBounds(216, 144, 76, 22);
	panel_1.add(lblHum);
	
	JLabel label_2 = new JLabel("\u0414\u0430\u043D\u043D\u044B\u0435 \u043F\u043E\u0433\u043E\u0434\u044B \u0432\u0437\u044F\u0442\u044B \u0441 \u0441\u0430\u0439\u0442\u0430 yahoo.com");
	label_2.setFont(new Font("Georgia", Font.BOLD, 11));
	label_2.setBounds(10, 186, 275, 14);
	panel_1.add(label_2);
	
	JPanel panel_3 = new JPanel();
	tabbedPane.addTab("\u041F\u0440\u043E\u0433\u043D\u043E\u0437 \u043D\u0430 2 \u0434\u043D\u044F", null, panel_3, null);
	panel_3.setLayout(null);
	
	JLabel label = new JLabel("\u0417\u0430\u0432\u0442\u0440\u0430");
	label.setBounds(29, 11, 85, 14);
	panel_3.add(label);
	
	JLabel label_1 = new JLabel("\u041F\u043E\u0441\u043B\u0435\u0437\u0430\u0432\u0442\u0440\u0430");
	label_1.setBounds(331, 2, 129, 33);
	panel_3.add(label_1);
    
	Thread up = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(true){
		    	if (temp == 600){
		    		try {
						lblIcon.setIcon(new ImageIcon(new ImageParse().getImgSrc()));
						lblTemp.setText(Float.toString(new GetWeather().getTemp())+"C");
						lblPress.setText(Float.toString(new GetWeather().getPressure())+"μμ.");
						lblHum.setText(Float.toString(new GetWeather().getHumidity())+"%");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					try {
						lblIcon.setIcon(new ImageIcon(new ImageParse().getImgSrc()));
						lblTemp.setText(Float.toString(new GetWeather().getTemp())+"C");
						lblPress.setText(Float.toString(new GetWeather().getPressure())+"μμ.");
						lblHum.setText(Float.toString(new GetWeather().getHumidity())+"%");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lblHum.repaint();
					lblPress.repaint();
					lblTemp.repaint();
				}
		    	}
		}
	});
	up.start();
    }
	
	



	
}
