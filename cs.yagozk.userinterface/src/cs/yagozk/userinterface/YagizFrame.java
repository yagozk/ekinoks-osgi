package cs.yagozk.userinterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class YagizFrame extends JFrame {
	private JTextField number2Field;
	private JTextField number1Field;
	private JTextField resultField;
	private JButton btnAdd;
	private JButton btnSubstract;
	private JButton btnMultiply;
	private JButton btnDivide;
	//private Locale locale;
	private String language;
	
	public YagizFrame() {
		language = System.getProperty("user.language");
		//locale = Locale.getDefault();
		System.out.println("System language is: " +  language);

		setResizable(false);
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,300);
		
		JLabel lblNewLabel = new JLabel("Sayı 1:");
		if ( language.equalsIgnoreCase("en") )
			lblNewLabel.setText( "Number 1:");
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 110, 64);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNumber = new JLabel("Sayı 2:");
		if ( language.equalsIgnoreCase("en") )
			lblNumber.setText( "Number 2:");
		lblNumber.setFont(new Font("Calibri Light", Font.BOLD, 18));
		lblNumber.setBounds(10, 60, 110, 64);
		getContentPane().add(lblNumber);
		
		number2Field = new JTextField();
		number2Field.setBounds(116, 78, 541, 27);
		getContentPane().add(number2Field);
		number2Field.setColumns(10);
		
		number1Field = new JTextField();
		number1Field.setBounds(116, 28, 541, 27);
		getContentPane().add(number1Field);
		number1Field.setColumns(10);
		
		JLabel lblResult = new JLabel("Sonuç:");
		if ( language.equalsIgnoreCase("en") )
			lblResult.setText( "Result:");
		lblResult.setFont(new Font("Calibri Light", Font.BOLD, 18));
		lblResult.setBounds(10, 116, 110, 64);
		getContentPane().add(lblResult);
		
		resultField = new JTextField();
		resultField.setColumns(10);
		resultField.setBounds(116, 134, 541, 27);
		getContentPane().add(resultField);
		
		btnAdd = new JButton("Topla");
		if ( language.equalsIgnoreCase("en") )
			btnAdd.setText( "Add");
		btnAdd.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(UIManager.getColor("Button.background"));
		btnAdd.setBounds(116, 189, 110, 44);
		getContentPane().add(btnAdd);
		
		btnSubstract = new JButton("Çıkar");
		if ( language.equalsIgnoreCase("en") )
			btnSubstract.setText( "Sub");
		btnSubstract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubstract.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnSubstract.setBounds(251, 189, 125, 44);
		getContentPane().add(btnSubstract);
		
		btnMultiply = new JButton("Çarp");
		if ( language.equalsIgnoreCase("en") )
			btnMultiply.setText( "Multiply");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMultiply.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnMultiply.setBounds(404, 189, 124, 44);
		getContentPane().add(btnMultiply);
		
		btnDivide = new JButton("Böl");
		if ( language.equalsIgnoreCase("en") )
			btnDivide.setText( "Divide");
		btnDivide.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnDivide.setBounds(557, 189, 100, 44);
		getContentPane().add(btnDivide);
		// TODO Auto-generated constructor stub
	}
	
	public void setAllActions( ActionListener act) {
		btnAdd.addActionListener(act);
		btnSubstract.addActionListener(act);
		btnMultiply.addActionListener(act);
		btnDivide.addActionListener(act);

	}
	
	public JButton getAddButton() {
		return btnAdd;
	}
	
	public JButton getSubstractButton() {
		return btnSubstract;
	}
	
	public JButton getMultiplyButton() {
		return btnMultiply;
	}

	public JButton getDivideButton() {
		return btnDivide;
	}
	
	public String getNumberOne() {
		return number1Field.getText();
	}
	
	public String getNumberTwo() {
		return number2Field.getText();
	}
	
	public void setResultField( String result) {
		resultField.setText( result);
	}

}
