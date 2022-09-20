import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class JavaFrame {

	private JFrame frmFactorialCalculator;
	private JTextField textField;
	private JLabel lblAnswer;
	private JLabel lblAnswerText;
	private JLabel lblDirections;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaFrame window = new JavaFrame();
					window.frmFactorialCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Function calls for the application.
	 */
	public BigInteger factorial(BigInteger x) {
		if(x==BigInteger.ZERO) {
			return BigInteger.ONE;
		} else {
			return (x.multiply(factorial(x.subtract(BigInteger.ONE))));
		}
	}

	/**
	 * Create the application.
	 */
	public JavaFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFactorialCalculator = new JFrame();
		frmFactorialCalculator.setResizable(false);
		frmFactorialCalculator.setTitle("Factorial Calculator");
		frmFactorialCalculator.setBounds(100, 100, 450, 300);
		frmFactorialCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFactorialCalculator.getContentPane().setLayout(null);
		
		lblAnswer = new JLabel("Answer");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAnswer.setBounds(10, 172, 414, 32);
		frmFactorialCalculator.getContentPane().add(lblAnswer);
		
		textField = new JTextField();
		textField.setBounds(109, 102, 88, 23);
		frmFactorialCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigInteger answer = BigInteger.ZERO;
				
				try {
					 answer =  factorial(BigInteger.valueOf(Integer.parseInt(textField.getText())));
					 lblAnswerText.setText(String.valueOf(answer));
					}
				catch(Exception error) {
					 lblAnswerText.setText("");
					 JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number."); 
					}
			}
		});
		btnNewButton.setBounds(219, 102, 89, 23);
		frmFactorialCalculator.getContentPane().add(btnNewButton);
		
		lblAnswerText = new JLabel("");
		lblAnswerText.setHorizontalAlignment(JLabel.CENTER);
		lblAnswerText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAnswerText.setBounds(10, 206, 414, 32);
		frmFactorialCalculator.getContentPane().add(lblAnswerText);
		
		lblDirections = new JLabel("Please input a Number in the field below");
		lblDirections.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirections.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDirections.setBounds(10, 34, 414, 32);
		frmFactorialCalculator.getContentPane().add(lblDirections);
	}

}
