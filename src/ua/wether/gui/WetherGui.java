package ua.wether.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Component;
import javax.swing.Box;

public class WetherGui {

    private JFrame frame;
    private final ButtonGroup buttonGroup = new ButtonGroup();

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
     */
    public WetherGui() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 566, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel panel = new JPanel();
	frame.getContentPane().add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(10, 11, 530, 239);
	panel.add(tabbedPane);
	
	JPanel panel_1 = new JPanel();
	tabbedPane.addTab("\u0422\u0435\u043A\u0443\u0449\u0430\u044F \u043F\u043E\u0433\u043E\u0434\u0430", null, panel_1, null);
	panel_1.setLayout(null);
	
	JLabel lblTemperature = new JLabel("\u0422\u0435\u043C\u043F\u0435\u0440\u0430\u0442\u0443\u0440\u0430:");
	lblTemperature.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblTemperature.setBounds(10, 11, 94, 23);
	panel_1.add(lblTemperature);
	
	JLabel lblPressure = new JLabel("\u0414\u0430\u0432\u043B\u0435\u043D\u0438\u0435:");
	lblPressure.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblPressure.setBounds(10, 66, 94, 23);
	panel_1.add(lblPressure);
	
	JLabel lblH = new JLabel("\u0412\u043B\u0430\u0436\u043D\u043E\u0441\u0442\u044C:");
	lblH.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblH.setBounds(10, 120, 94, 23);
	panel_1.add(lblH);
	
	JLabel lblIcon = new JLabel("Icon");
	lblIcon.setIcon(new ImageIcon(WetherGui.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-warning@2x.png")));
	lblIcon.setBounds(408, 11, 95, 84);
	panel_1.add(lblIcon);
	
	JPanel panel_3 = new JPanel();
	tabbedPane.addTab("\u041F\u0440\u043E\u0433\u043D\u043E\u0437 \u043D\u0430 2 \u0434\u043D\u044F", null, panel_3, null);
	panel_3.setLayout(null);
	
	JLabel label = new JLabel("\u0417\u0430\u0432\u0442\u0440\u0430");
	label.setBounds(29, 11, 85, 14);
	panel_3.add(label);
	
	JLabel label_1 = new JLabel("\u041F\u043E\u0441\u043B\u0435\u0437\u0430\u0432\u0442\u0440\u0430");
	label_1.setBounds(331, 2, 129, 33);
	panel_3.add(label_1);
	
	JPanel panel_2 = new JPanel();
	tabbedPane.addTab("\u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043A\u0430 \u0437\u0430 \u043F\u043E\u0441\u043B\u0435\u0434\u043D\u044E\u044E \u043D\u0435\u0434\u0435\u043B\u044E", null, panel_2, null);
	panel_2.setLayout(null);
	
	JLabel lblWetherStatistic = new JLabel("Weather Statistic");
	lblWetherStatistic.setBounds(184, 0, 134, 41);
	panel_2.add(lblWetherStatistic);
	lblWetherStatistic.setFont(new Font("Tahoma", Font.BOLD, 14));
    }
}
