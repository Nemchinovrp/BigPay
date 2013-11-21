package mma.fedor;


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
		JFrame frame = new JFrame(" Big Finance Api ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		JTabbedPane jtp = new JTabbedPane();
	
		jtp.addTab("First",  new FirstPanel());
		jtp.addTab("Second", new SecondPanel());
		jtp.addTab("Three", new ThreePanel());
		jtp.addTab("Four", new FourPanel());
		jtp.addTab("Five", new FivePanel());
		jtp.addTab("Six", new SixPanel());
		frame.getContentPane().add(jtp);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@SuppressWarnings("serial")
class FirstPanel extends JPanel implements ActionListener, Calculate {
		double principal;//первоначальная сумма
		double intRate;// процент по ссуде
		double numYears;//срок погашения ссуды в годах
		final int payPerYear = 12;// количество платежей
		NumberFormat nf;
		JTextField amountText,  paymentText, periodText, rateText;
		JButton dolt;
		
		public FirstPanel(){
			
			
	
	
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbag);
		
		JLabel heading= new JLabel("Вычисление ежемесячных платежей");
		JLabel amountLab = new JLabel("Сумма кредита: ");
		JLabel periodLab= new JLabel("Количество лет: ");
		JLabel rateLab = new JLabel("Процент по ссуде:");
		JLabel paymentLab = new JLabel("Ежемесячный платеж: ");
		

		amountText = new JTextField(10);
		paymentText = new JTextField(10);
		periodText = new JTextField(10);
		rateText = new JTextField(10);
		paymentText.setEditable(false);
		
		dolt = new JButton("Вычислить");
		
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(heading, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(amountLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(amountText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(periodLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(periodText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(rateLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(rateText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(paymentLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(paymentText, gbc);
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbag.setConstraints(dolt, gbc);
		
	    add(heading);
		add(amountLab);
		add(amountText);
		add(periodLab);
		add(periodText);
		add(rateLab);
		add(rateText);
		add(paymentLab);
		add(paymentText);
		add(dolt);
	
		amountText.addActionListener(this);
		dolt.addActionListener(this);
		periodText.addActionListener(this);
		rateText.addActionListener(this);
		
		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		}


	
		
		public void actionPerformed(ActionEvent e) {
			double result =0.0;
			
			String amountStr = amountText.getText();
			String periodStr = periodText.getText();
			String rateStr = rateText.getText();
			try{
				if(amountStr.length() !=0 && periodStr.length() !=0 && rateStr.length()!=0 ){
					principal = Double.parseDouble(amountStr);
					numYears = Double.parseDouble(periodStr);
					intRate = Double.parseDouble(rateStr);
					result = compute();
					paymentText.setText(nf.format(result));
					
				}
			}catch(Exception e1){
				System.out.println("Exception!!!");
			}
	
			
		}

		public double compute() {
			double numer, denom, b, ee;
			numer = intRate*principal/payPerYear;
			ee = -(payPerYear*numYears);
			b = (intRate/payPerYear)+1.0;
			denom = 10 - Math.pow(b, ee);
			
			return numer/denom;
		}
		
	}
@SuppressWarnings("serial")
class SecondPanel extends JPanel implements ActionListener, Calculate {
	JTextField amountText,  futvalText, periodText, rateText, compText;
	JButton dolt;
	double principal;//первоначальная сумма
	double rateOfRet;// процент по ссуде
	double numYears;//срок погашения ссуды в годах
	 int compPerYear ;// количество платежей
	NumberFormat nf;
	
	public SecondPanel(){
		
	
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbag);
		
		JLabel heading= new JLabel("Расчет будущей стоимости вклада ");
		JLabel amountLab = new JLabel("Начальная сумма: ");
		JLabel periodLab= new JLabel("Количество лет: ");
		JLabel rateLab = new JLabel("Норма прибыли:");
		JLabel compLab = new JLabel("Количество периодов: ");
		JLabel futvalLab = new JLabel("Будущая стоимость вклада: ");

		amountText = new JTextField(10);
		periodText = new JTextField(10);
		rateText = new JTextField(10);
		compText = new JTextField(10);
		futvalText = new JTextField(10);
		futvalText.setEditable(false);
		
		dolt = new JButton("Вычислить");
		
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(heading, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(amountLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(amountText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(periodLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(periodText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(rateLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(rateText, gbc);
		
		
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(compLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(compText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(futvalLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(futvalText, gbc);
		
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbag.setConstraints(dolt, gbc);
		
	    add(heading);
		add(amountLab);
		add(amountText);
		add(periodLab);
		add(periodText);
		add(rateLab);
		add(rateText);
		add(compLab);
		add(compText);
		add(futvalLab);
		add(futvalText);
		add(dolt);
		dolt.addActionListener(this);
		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		}




	
	public void actionPerformed(ActionEvent ee) {
		double result =0.0;
		
		String amountStr = amountText.getText();
		String periodStr = periodText.getText();
		String rateStr = rateText.getText();
		String compStr = compText.getText();
		try{
			if(amountStr.length() !=0 && periodStr.length() !=0 && rateStr.length()!=0 && compStr.length()!=0 ){
				principal = Double.parseDouble(amountStr);
				numYears = Double.parseDouble(periodStr);
				rateOfRet = Double.parseDouble(rateStr)/100;
				compPerYear = Integer.parseInt(compStr);
				result = compute();
				futvalText.setText(nf.format(result));
				
			}
		}catch(Exception e1){
			System.out.println("Exception!!!");
		}
		
	}
	public double compute() {
		double b, e;
		b = (1+ rateOfRet/compPerYear);
		e = compPerYear*numYears;
		
		return principal*Math.pow(b, e);
	}	
}
@SuppressWarnings("serial")
class ThreePanel extends JPanel implements ActionListener, Calculate{
	JTextField targetText,  initialText, periodText, rateText, compText;
	JButton dolt;
	double targetValue;//первоначальная сумма
	double rateOfRet;// процент по ссуде
	double numYears;//срок погашения ссуды в годах
	 int compPerYear ;// количество платежей
	NumberFormat nf;
	
	public ThreePanel(){
		
	
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbag);
		
		JLabel heading= new JLabel("Расчет первоначальной суммы вклада ");
		JLabel targetLab = new JLabel("Желаемая будущая сумма: ");
		JLabel periodLab= new JLabel("Количество лет: ");
		JLabel rateLab = new JLabel("Норма прибыли:");
		JLabel compLab = new JLabel("Количество периодов: ");
		JLabel initialLab = new JLabel("Требуемая сумма вклада: ");

		targetText = new JTextField(10);
		periodText = new JTextField(10);
		rateText = new JTextField(10);
		compText = new JTextField(10);
		initialText = new JTextField(10);
		initialText.setEditable(false);
		
		dolt = new JButton("Вычислить");
		
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(heading, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(targetLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(targetText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(periodLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(periodText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(rateLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(rateText, gbc);
		
		
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(compLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(compText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(initialLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(initialText, gbc);
		
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbag.setConstraints(dolt, gbc);
		
	    add(heading);
		add(targetLab);
		add(targetText);
		add(periodLab);
		add(periodText);
		add(rateLab);
		add(rateText);
		add(compLab);
		add(compText);
		add(initialLab);
		add(initialText);
		add(dolt);
		
		dolt.addActionListener(this);
		
		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		}




	
	public void actionPerformed(ActionEvent ee) {
		double result =0.0;
		
		String targetStr = targetText.getText();
		String periodStr = periodText.getText();
		String rateStr = rateText.getText();
		String compStr = compText.getText();
		
		try{
			if(targetStr.length() !=0 && periodStr.length() !=0 && rateStr.length()!=0 && compStr.length()!=0 ){
				
				targetValue = Double.parseDouble(targetStr);
				numYears = Double.parseDouble(periodStr);
				rateOfRet = Double.parseDouble(rateStr)/100;
				compPerYear = Integer.parseInt(compStr);
				result = compute();
				initialText.setText(nf.format(result));
				
			}
		}catch(Exception e1){
			System.out.println("Exception!!!");
		}
		
	}
	public double compute() {
		double b, e;
		b = (1+ rateOfRet/compPerYear);
		e = compPerYear*numYears;
		
		return targetValue/Math.pow(b, e);
	}	
}}


@SuppressWarnings("serial")
class FourPanel extends JPanel implements ActionListener, Calculate{
	JTextField regWDText,  initialText, periodText, rateText, numWDText;
	JButton dolt;
	double 	regWDAmount;//первоначальная сумма
	double rateOfRet;// процент по ссуде
	double numYears;//срок погашения ссуды в годах
	 int numPerYear ;// количество платежей
	NumberFormat nf;
	
	public FourPanel(){
		
		
		
	
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbag);
		
	    JLabel heading= new JLabel("Расчет первоначальной суммы вклада  " );
		JLabel heading1 = new JLabel(" для получения желаемого годового дохода ");
		JLabel regWDLab = new JLabel("Желаемая ежегодный доход: ");
		JLabel periodLab= new JLabel("Количество лет: ");
		JLabel rateLab = new JLabel("Норма прибыли:");
		JLabel numWDLab = new JLabel("К-во получений дохода в год: ");
		JLabel initialLab = new JLabel("Требуемая первонач. сумма вклада: ");

		regWDText = new JTextField(10);
		periodText = new JTextField(10);
		rateText = new JTextField(10);
		numWDText = new JTextField(10);
		initialText = new JTextField(10);
		initialText.setEditable(false);
		
		dolt = new JButton("Вычислить");
		
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(heading, gbc);
		gbag.setConstraints(heading1, gbc);
		
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(regWDLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(regWDText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(periodLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(periodText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(rateLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(rateText, gbc);
		
		
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(numWDLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(numWDText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(initialLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(initialText, gbc);
		
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbag.setConstraints(dolt, gbc);
		
		add(heading);
		add(heading1);
	   
		add(regWDLab);
		add(regWDText);
		add(periodLab);
		add(periodText);
		add(rateLab);
		add(rateText);
		add(numWDLab);
		add(numWDText);
		add(initialLab);
		add(initialText);
		add(dolt);
		
		dolt.addActionListener(this);
		
		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		}




	
	public void actionPerformed(ActionEvent ee) {
		double result =0.0;
		
		String regWDStr = regWDText.getText();
		String periodStr = periodText.getText();
		String rateStr = rateText.getText();
		String numWDStr = numWDText.getText();
		
		try{
			if(regWDStr.length() !=0 && periodStr.length() !=0 && rateStr.length()!=0 && numWDStr.length()!=0 ){
				
				regWDAmount = Double.parseDouble(regWDStr);
				numYears = Double.parseDouble(periodStr);
				rateOfRet = Double.parseDouble(rateStr)/100;
				numPerYear = Integer.parseInt(numWDStr);
				result = compute();
				initialText.setText(nf.format(result));
				
			}
		}catch(Exception e1){
			System.out.println("Exception!!!");
		}
		
	}
	public double compute() {
		double b, e, t1,t2;
		t1 = (regWDAmount*numPerYear)/rateOfRet;
		b = (1+ rateOfRet/numPerYear);
		e = numPerYear*numYears;
		
		t2 = 1-(1/Math.pow(b, e));
		return t1*t2;
	}	
}
@SuppressWarnings("serial")
class FivePanel extends JPanel implements ActionListener, Calculate{
	JTextField orgPText,   maxWDText, periodText, rateText, numWDText;
	JButton dolt;
	double 	principal ;//первоначальная сумма
	double rateOfRet;// процент по ссуде
	double numYears;//срок погашения ссуды в годах
	 int numPerYear ;// количество платежей
	NumberFormat nf;
	
	public FivePanel(){
		
		
		
	
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbag);
		
	    JLabel heading= new JLabel("Расчет максимального годового дохода  " );
		JLabel orgPLab = new JLabel("Первоначальная сумма вклада: ");
		JLabel periodLab= new JLabel("Количество лет: ");
		JLabel rateLab = new JLabel("Норма прибыли:");
		JLabel numWDLab = new JLabel("К-во получений дохода в год: ");
		JLabel maxWDLab = new JLabel("Максимальный годовой доход: ");

		orgPText = new JTextField(10);
		periodText = new JTextField(10);
		rateText = new JTextField(10);
		numWDText = new JTextField(10);
		 maxWDText = new JTextField(10);
		 maxWDText.setEditable(false);
		
		dolt = new JButton("Вычислить");
		
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(heading, gbc);
	
		
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(orgPLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(orgPText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(periodLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(periodText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(rateLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(rateText, gbc);
		
		
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(numWDLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(numWDText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(maxWDLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(maxWDText, gbc);
		
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbag.setConstraints(dolt, gbc);
		
		add(heading);
		add(orgPLab);
		add(orgPText);
		add(periodLab);
		add(periodText);
		add(rateLab);
		add(rateText);
		add(numWDLab);
		add(numWDText);
		add(maxWDLab);
		add(maxWDText);
		add(dolt);
		
		dolt.addActionListener(this);
		
		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		}




	
	public void actionPerformed(ActionEvent ee) {
		double result =0.0;
		
		String orgPStr = orgPText.getText();
		String periodStr = periodText.getText();
		String rateStr = rateText.getText();
		String numWDStr = numWDText.getText();
		
		try{
			if(orgPStr.length() !=0 && periodStr.length() !=0 && rateStr.length()!=0 && numWDStr.length()!=0 ){
				
				principal = Double.parseDouble(orgPStr);
				numYears = Double.parseDouble(periodStr);
				rateOfRet = Double.parseDouble(rateStr)/100;
				numPerYear = Integer.parseInt(numWDStr);
				result = compute();
				maxWDText.setText(nf.format(result));
				
			}
		}catch(Exception e1){
			System.out.println("Exception!!!");
		}
		
	}
	public double compute() {
		double b, e, t1,t2;
		t1 = rateOfRet/numPerYear;
		b = (1+ t1);
		
		e = numPerYear*numYears;
		
		t2 = Math.pow(b, e)-1;
		
		return principal*( t1/t2+t1);
	}	
}
@SuppressWarnings("serial")
class SixPanel extends JPanel implements ActionListener, Calculate{
	JTextField orgPText,   maxWDText, periodText, rateText, numWDText;
	JButton dolt;
	double 	principal ;//первоначальная сумма
	double rateOfRet;// процент по ссуде
	double numYears;//срок погашения ссуды в годах
	 int numPerYear ;// количество платежей
	NumberFormat nf;
	
	public SixPanel(){
		
		
		
	
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbag);
		
	    JLabel heading= new JLabel("Нахождение остатке баланса по ссуде " );
		JLabel orgPLab = new JLabel("Первоначальная сумма вклада: ");
		JLabel periodLab= new JLabel("Количество лет: ");
		JLabel rateLab = new JLabel("Норма прибыли:");
		JLabel numWDLab = new JLabel("К-во получений дохода в год: ");
		JLabel maxWDLab = new JLabel("Максимальный годовой доход: ");

		orgPText = new JTextField(10);
		periodText = new JTextField(10);
		rateText = new JTextField(10);
		numWDText = new JTextField(10);
		 maxWDText = new JTextField(10);
		 maxWDText.setEditable(false);
		
		dolt = new JButton("Вычислить");
		
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(heading, gbc);
	
		
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(orgPLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(orgPText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(periodLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(periodText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(rateLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(rateText, gbc);
		
		
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(numWDLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(numWDText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(maxWDLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(maxWDText, gbc);
		
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbag.setConstraints(dolt, gbc);
		
		add(heading);
		add(orgPLab);
		add(orgPText);
		add(periodLab);
		add(periodText);
		add(rateLab);
		add(rateText);
		add(numWDLab);
		add(numWDText);
		add(maxWDLab);
		add(maxWDText);
		add(dolt);
		
		dolt.addActionListener(this);
		
		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		}




	
	public void actionPerformed(ActionEvent ee) {
		double result =0.0;
		
		String orgPStr = orgPText.getText();
		String periodStr = periodText.getText();
		String rateStr = rateText.getText();
		String numWDStr = numWDText.getText();
		
		try{
			if(orgPStr.length() !=0 && periodStr.length() !=0 && rateStr.length()!=0 && numWDStr.length()!=0 ){
				
				principal = Double.parseDouble(orgPStr);
				numYears = Double.parseDouble(periodStr);
				rateOfRet = Double.parseDouble(rateStr)/100;
				numPerYear = Integer.parseInt(numWDStr);
				result = compute();
				maxWDText.setText(nf.format(result));
				
			}
		}catch(Exception e1){
			System.out.println("Exception!!!");
		}
		
	}
	public double compute() {
		double b, e, t1,t2;
		t1 = rateOfRet/numPerYear;
		b = (1+ t1);
		
		e = numPerYear*numYears;
		
		t2 = Math.pow(b, e)-1;
		
		return principal*( t1/t2+t1);
	}	
}
