import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Quiz implements ActionListener{

	String[] questions = {
			"Which company created Java?",
			"Which year was Java Created?",
			"What was Java originally called?",
			"whos is credited with creating Java?"
	};
	
	String[][] options = { 
			{"Sun MicroSystem","Microsoft","Pathao","Kantipur"},
			{"1989","1996","1972","1492"},
			{"Apple","Late","Oak","Koffing"},
			{"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"}
	};
	
	char[] answers = {
			'A',
			'B',
			'C',
			'C'
	};
	
	 char guess;
	 char answer;
	 int index;
	 int correct_guesses = 0;
	 int total_questions = questions.length;
	 int result;
	 int seconds = 10;
	 
	 JFrame frame = new JFrame();
	 JTextField textField = new JTextField();
	 JTextArea textArea = new JTextArea();
	 JButton buttonA = new JButton();
	 JButton buttonB = new JButton();
	 JButton buttonC = new JButton();
	 JButton buttonD = new JButton();
	 JLabel answer_labelA = new JLabel();
	 JLabel answer_labelB = new JLabel();
	 JLabel answer_labelC = new JLabel();
	 JLabel answer_labelD = new JLabel();
	 JLabel time_label = new JLabel();
	 JLabel seconds_left = new JLabel();
	 JTextField number_right = new JTextField();
	 JTextField percentage = new JTextField();
	 
	
	public Quiz() { 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textField.setBounds(0,0,650,50);
		textField.setBackground(new Color(20,20,20));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free",Font.BOLD,30));
		textField.setBorder(BorderFactory.createBevelBorder(1));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setEditable(false);
		
		textArea.setBounds(0,50,650,50);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(new Color(20,20,20));
		textArea.setForeground(new Color(25,255,0));
		textArea.setFont(new Font("MV Boli",Font.BOLD,25));
		textArea.setBorder(BorderFactory.createBevelBorder(1));
		//textArea.setHorizontalAlignment(JTextField.CENTER);
		textArea.setEditable(false);
		
		buttonA.setBounds(0, 100, 100, 100);
		buttonA.setFont(new Font(null,Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0, 200, 100, 100);
		buttonB.setFont(new Font(null,Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B"); 
		
		buttonC.setBounds(0, 300, 100, 100);
		buttonC.setFont(new Font(null,Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0, 400, 100, 100);
		buttonD.setFont(new Font(null,Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font(null, Font.PLAIN, 35));
		
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font(null, Font.PLAIN, 35));
		
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font(null, Font.PLAIN, 35));
		
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font(null, Font.PLAIN, 35));
		
		seconds_left.setBounds(535,510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font(null, Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(535,475,100,25);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,0,0));
		time_label.setFont(new Font(null,Font.PLAIN,20));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("Timer");
		


		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
	
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);

		
		
		frame.add(number_right);
		frame.add(percentage);
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textField);
		frame.add(textArea);
		frame.setVisible(true);
		
	}
	public void nextQuestion() {
		
	}
	
	public void displayAnser() {
		
	}
	
	public void results() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
