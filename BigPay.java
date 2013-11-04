import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;



public class BigPay {
	
	public static void main(String[] args) {
		BigPay bp = new BigPay();
		bp.makeGui();

	}




	public void makeGui(){
		JFrame frame = new JFrame("Example TabbedPane! ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		JTabbedPane jtp = new JTabbedPane();
	
		jtp.addTab("First",  new FirstPanel());
		jtp.addTab("Second", new SecondPanel());
		jtp.addTab("Three", new ThreePanel());
		
		frame.getContentPane().add(jtp);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
