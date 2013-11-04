class SecondPanel extends JPanel {
	public SecondPanel(){
		JTextField amountText,  paymentText, periodText, rateText;
		JButton dolt;
	
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbag);
		
		JLabel heading= new JLabel("Future value of Inverstment ");
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
	
		}}
