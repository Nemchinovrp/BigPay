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
