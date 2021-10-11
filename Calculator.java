import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Calculator extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	String dizi = new String();
	Queue<String> statement = new LinkedList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clickButton(String str) { //it writes that button to the textField when every time the button is clicked
		textField.setText(textField.getText() + str);
	}
	
public static Queue<String> convertion(Queue<String> infix) { //convertion infix to postfix
		
		Stack<String> stack = new Stack<>();
		Queue<String> postfix = new LinkedList<>(); //for keep the postfix statement
		
		while(!infix.isEmpty()) {
			
			if(infix.peek() == "+" || infix.peek() == "-" || infix.peek() == "*" || infix.peek() == "/" || infix.peek() == "(" || infix.peek() == ")") {
				
				switch(infix.peek()) {
				case "+":	//all elements in the stack are pop to queue. Because '+' and '-' lowest priority.
					if(stack.isEmpty() || stack.peek() == "(") {
						stack.add(infix.remove());
					}
					else {
						while(!stack.isEmpty()) {
							postfix.add(stack.pop());
						}
						stack.add(infix.remove());
					}
						break;
				case "-":
					if(stack.isEmpty() || stack.peek() == "(") {
						stack.add(infix.remove());
					}
					else {
						while(!stack.isEmpty()) {
							postfix.add(stack.pop());
						}
						stack.add(infix.remove());
					}
					break;
				case "*":
					if(stack.isEmpty() || stack.peek() == "(") {
						stack.add(infix.remove());
					}
					else {
						if( stack.peek() == "*" ||  stack.peek() == "/") {
							postfix.add(stack.pop());
							stack.add(infix.remove());
						}
						else {
							stack.add(infix.remove());
						}
					}
					break;
				case "/":
					if(stack.isEmpty() || stack.peek() == "(") {
						stack.add(infix.remove());
					}
					else {
						if( stack.peek() == "*" ||  stack.peek() == "/") {
							postfix.add(stack.pop());
							stack.add(infix.remove());
						}
						else {
							stack.add(infix.remove());
						}
					}
					break;
				case "(":
					stack.add(infix.remove());
					break;
				case ")":
					while(stack.peek() != "(") {
						postfix.add(stack.pop());
					}
					stack.pop();
					infix.remove();
					break;
				}
				
			}
			else { //number are added directly to postfix notation
				
				postfix.add(infix.remove());
				
			}
			
		}
		while(!stack.isEmpty()) { //lastest the remaining elements in the stack are added to the queue
			postfix.add(stack.pop());
		}
		
		return postfix;
		
	}
public static double calculate(Queue<String> queue) { //calculate of statement in postfix notation

	Stack<String> stack = new Stack<>();
	
	while(!queue.isEmpty()) {
		
		if(queue.peek() == "+" || queue.peek() == "-" || queue.peek() == "*" || queue.peek() == "/") {
			
			double d2 = Double.parseDouble(stack.pop());
			double d1 = Double.parseDouble(stack.pop());
			
			double d3 = 0;
			
			switch(queue.peek()) {
				case "+":
					d3 = d1 + d2;
					break;
				case "-":
					d3 = d1 - d2;
					break;
				case "*":
					d3 = d1 * d2;
					break;
				case "/":
					d3 = d1 / d2;
					break;
					
			}
			String s = Double.toString(d3);
			stack.add(s);
			queue.remove();
		}
		else {
			stack.add(queue.remove());
		}
		
	}
	
	double result = Double.parseDouble(stack.pop());
	
	return result;
}
	
	

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setType(Type.UTILITY);
		setTitle("CALCULATOR");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel screen = new JPanel();
		screen.setBounds(12, 0, 365, 89);
		contentPane.add(screen);
		screen.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Dialog", Font.BOLD, 20));
		textField.setBounds(0, 22, 365, 55);
		screen.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(0, 0, 365, 15);
		screen.add(label);
		
		JPanel buttons = new JPanel();
		buttons.setBounds(12, 101, 365, 328);
		contentPane.add(buttons);
		buttons.setLayout(new GridLayout(5, 4, 20, 20));
		
		JButton button_1 = new JButton("7");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				dizi += e.getActionCommand();
				
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_1);
		
		JButton button_2 = new JButton("8");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				dizi += e.getActionCommand();
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_2);
		
		JButton button_4 = new JButton("9");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				dizi += e.getActionCommand();
			}
		});
		button_4.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_4);
		
		JButton button_13 = new JButton("/");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				if(dizi != "") {
					statement.add(dizi);
					dizi = "";
				}
				statement.add(e.getActionCommand());
				
			}
		});
		button_13.setBackground(Color.GRAY);
		button_13.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_13);
		
		JButton button = new JButton("4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				dizi += e.getActionCommand();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button);
		
		JButton button_8 = new JButton("5");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				dizi += e.getActionCommand();
			}
		});
		button_8.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_8);
		
		JButton button_7 = new JButton("6");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				dizi += e.getActionCommand();
			}
		});
		button_7.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_7);
		
		JButton button_9 = new JButton("*");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				if(dizi != "") {
					statement.add(dizi);
					dizi = "";
				}
				statement.add(e.getActionCommand());
			}
		});
		button_9.setBackground(Color.GRAY);
		button_9.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_9);
		
		JButton button_12 = new JButton("1");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				dizi += e.getActionCommand();
			}
		});
		button_12.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_12);
		
		JButton button_11 = new JButton("2");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				dizi += e.getActionCommand();
			}
		});
		button_11.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_11);
		
		JButton button_10 = new JButton("3");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				dizi += e.getActionCommand();
			}
		});
		button_10.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_10);
		
		JButton button_15 = new JButton("-");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				if(dizi != "") {
					statement.add(dizi);
					dizi = "";
				}
				statement.add(e.getActionCommand());
			}
		});
		button_15.setBackground(Color.GRAY);
		button_15.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_15);
		
		JButton button_14 = new JButton("0");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());//kendi yazdığımız clickButton methodunu çağırıp içine button ın üzerindeki değeri atıyoruz
				dizi += e.getActionCommand();
			}
		});
		button_14.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_14);
		
		JButton btnNewButton = new JButton("00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());//kendi yazdığımız clickButton methodunu çağırıp içine button ın üzerindeki değeri atıyoruz
				dizi += e.getActionCommand();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton(".");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				dizi += e.getActionCommand();
			}
		});
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(btnNewButton_3);
		
		JButton button_6 = new JButton("+");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());
				if(dizi != "") {
					statement.add(dizi);
					dizi = "";
				}
				statement.add(e.getActionCommand());
			}
		});
		button_6.setBackground(Color.GRAY);
		button_6.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_6);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				label.setText("");
				dizi = "";
				while(!statement.isEmpty()) {
					statement.remove();
				}
			}
		});
		btnC.setBackground(Color.RED);
		btnC.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(btnC);

		
		JButton btnNewButton_1 = new JButton("(");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton(e.getActionCommand());

				statement.add(e.getActionCommand());
				
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(")");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dizi != "") {
					statement.add(dizi);
					dizi = "";
				}
				clickButton(e.getActionCommand());

				statement.add(e.getActionCommand());
				
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(btnNewButton_2);
		
		JButton button_5 = new JButton("=");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(dizi != "")
					statement.add(dizi);

				double result = calculate(convertion(statement));
				textField.setText(Double.toString(result));
				
				while(!statement.isEmpty()) {
					statement.remove();
				}
				dizi = Double.toString(result);
				
			}
		});
		button_5.setBackground(Color.GREEN);
		button_5.setFont(new Font("Dialog", Font.BOLD, 20));
		buttons.add(button_5);
		

	}
}
