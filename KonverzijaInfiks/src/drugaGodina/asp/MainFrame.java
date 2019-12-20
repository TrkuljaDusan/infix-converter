package drugaGodina.asp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class MainFrame extends JFrame {
	
	private JTextField Text= new JTextField();
	
	private JTextArea Text1= new JTextArea();
	private JTextArea Text2= new JTextArea();
	private JTextArea Text3= new JTextArea();
	private JTextArea Text4= new JTextArea();

	
	private JButton btn1 = new JButton("Convert");
	
	private JButton btn2 = new JButton("Next step");
	
	private JLabel lab = new JLabel("Stack");
	
	private JPanel btns = new JPanel(new FlowLayout());
	
	private JPanel texts= new JPanel(new GridLayout(1,3));
	
	public MainFrame () {
		super("Conversion");
		setLayout(new BorderLayout());
		setSize(500,600);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(Text, BorderLayout.NORTH);
		add(btns, BorderLayout.SOUTH);
		//add(lab,BorderLayout.NORTH);
		btns.add(btn1);
		//btns.add(btn2);
		texts.add(Text1);
		texts.add(Text2);
		texts.add(Text3);
		texts.add(Text4);
		
		add(texts, BorderLayout.CENTER);
//		btn2.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String line= Text.getText().split("\\n")[0];
//				try {
//					Expression i= new Expression(line);
//					i.next(Text1, Text2);
//				} catch (InvalidExpressionException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//			
//		});
//		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (String line : Text.getText().split("\\n")) {
						try {
							try {
							Text2.setText("Expression\n");
							Text3.setText("Stack\n");
							Text1.setText("Current\n");
							Text4.setText("Rank\n");
							Expression i = new Expression (line);
							i.postfix();
							//Text.setText("\n\n"+i.postfix());
							for(int j=0; j<i.steps;j++){
								Text2.append(i.expressionSteps[j]+"\n");
								Text3.append(i.stackSteps[j]+"\n");
								Text4.append(i.rSteps[j]+"\n");
								Text1.append(i.symbolStep[j]+"\n");
								
							}

							}
							catch (InvalidExpressionException g) {
								for(int j=0; j<g.exp.steps;j++){
									Text2.append(g.exp.expressionSteps[j]+"\n");
									Text3.append(g.exp.stackSteps[j]+"\n");
									Text4.append(g.exp.rSteps[j]+"\n");
									Text1.append(g.exp.symbolStep[j]+"\n");}
								
								Text1.append(g.getMessage());
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				
			}
			
			
		});
	}
}
