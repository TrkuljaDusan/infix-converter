package drugaGodina.asp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


class MainFrame extends JFrame {
	
	private JTextArea Text= new JTextArea();
	
	private JButton btn = new JButton("Convert");
	
	public MainFrame () {
		super("Conversion");
		setLayout(new BorderLayout());
		setSize(400,600);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(Text, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (String line : Text.getText().split("\\n")) {
						try {
							Izraz i = new Izraz (line);
							Text.append("\n\n"+i.postfix);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				
			}
			
			
		});
	}
}
