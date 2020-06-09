package com.atm.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.atm.data.Denomination;
import com.atm.vo.AmountBean;

public class ATMNewSwing2 extends JFrame{
	
	List<AmountBean> amountBeans = new ArrayList<AmountBean>();
	List<AmountBean> processBeans = new ArrayList<AmountBean>();
	List<AmountBean> amountBeansTemp = new ArrayList<AmountBean>();
	
	TreeSet<Integer> tsSorteds = Denomination.denomonation();
	double totalBalance = 0;
	double totalBalanceCal=0;
	JComboBox<String> denominationCB=new JComboBox<String>();

	JTextField amountTobeDepositedTF=new JTextField("      ");
	JTextField amountTobeWidthTF=new JTextField("      ");
	JLabel total=new JLabel("Total");
	JTextArea statmentLable=new JTextArea("DepositStatement",20,20);
	
	ArrayList<String> statement = new ArrayList<String>();
	
	//HashMap<String,AmountBean> hmBeans = new HashMap<String,AmountBean>();
	
	LinkedHashMap<String,Double> withdrawalMap = new LinkedHashMap<String,Double>();
	

	
	private void withdrawalold()
	{
		//amountBeans.forEach(x)->(x.)
		amountBeans.forEach((amountBean)->{
			System.out.println( amountBean.getDenomonation() );

					
		});
		
	}
 
	private void withdrawal()
	{
		amountBeansTemp = new ArrayList<AmountBean>();
		String withdramAMount = amountTobeWidthTF.getText().trim();
		if( withdramAMount.equalsIgnoreCase("") )
		{
			JFrame f=new JFrame();  
			JOptionPane.showMessageDialog(f,"Enter Amount greater than 0 and Balance Amount ","Alert",JOptionPane.WARNING_MESSAGE); 
			
		}
 
		Double withdramAMountDbl[] = new Double[1];
		withdramAMountDbl[0]=Double.parseDouble(withdramAMount);;
		if(withdramAMountDbl[0]> totalBalance || withdramAMountDbl[0]== 0  )
		{
			JFrame f=new JFrame();  
			JOptionPane.showMessageDialog(f,"Enter Amount greater than 0 and Balance Amount ","Alert",JOptionPane.WARNING_MESSAGE); 
			
		}
		else
		{
		
	
		
	
		tsSorteds.forEach(denominations -> {
			System.out.println("totalBalanceCal"+totalBalanceCal);
			amountBeans.stream().filter(x -> x.getDenomonation() == denominations.intValue()).collect(Collectors.summarizingDouble(AmountBean::getDenomonation));


			Double transamount = amountBeans.stream().filter(x -> x.getDenomonation() == denominations.intValue())
					.collect(Collectors.summarizingDouble(AmountBean::getDenomonation)).getSum();
			Double getNoofnotes = amountBeans.stream()
					.filter(x -> x.getDenomonation() == denominations.intValue())
					.collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();
			Double totalAvailbleAmountForthisDenom = transamount * getNoofnotes;
			Double rowTotal= denominations.intValue()* getNoofnotes;
			double denom = Double.parseDouble(denominations.toString());
			if (withdramAMountDbl[0].doubleValue() > rowTotal)
			{
				System.out.println(">");	
			System.out.println("Denomination " + denominations.toString() + " and * No of notes " + getNoofnotes + "   Total Amount = "+(rowTotal));
			JFrame f=new JFrame();  
			//JOptionPane.showMessageDialog(f,"1)"+"Denomination " + denominations.toString() + " and * No of notes " + getNoofnotes +"\n TOtalRequestedAmount = "+ withdramAMountDbl[0].doubleValue() + " > Rowttotal"+  rowTotal,"Alert",JOptionPane.WARNING_MESSAGE);
			if(getNoofnotes>0)
			{
			int noodnotetobedelivered = (int)(withdramAMountDbl[0]/denom);

			//.showMessageDialog(f," noodnotetobedelivered "+noodnotetobedelivered,"Alert",JOptionPane.WARNING_MESSAGE);
			if (noodnotetobedelivered > 0)
				{
				withdramAMountDbl[0] = withdramAMountDbl[0] - (noodnotetobedelivered * denom);
				AmountBean temp = new AmountBean(denom, noodnotetobedelivered, (noodnotetobedelivered * denom));
				amountBeansTemp.add(temp);
				//JOptionPane.showMessageDialog(f," withdrawamount "+withdramAMountDbl[0]+" totalBalanceCal = "+totalBalanceCal,"Alert",JOptionPane.WARNING_MESSAGE);
	
				totalBalanceCal = totalBalanceCal - withdramAMountDbl[0];
				}
			}
			//JOptionPane.showMessageDialog(f," after deduction withdrawamount "+withdramAMountDbl[0]+" totalBalanceCal = "+totalBalanceCal,"Alert",JOptionPane.WARNING_MESSAGE);
			//JOptionPane.showMessageDialog(f,"1 end )"+"withdramAMountDbl[0] = "+withdramAMountDbl[0]+" totalBalanceCal = "+totalBalanceCal,"Alert",JOptionPane.WARNING_MESSAGE);
			
			}
			else if (withdramAMountDbl[0].doubleValue()<=rowTotal)
			{
				

				System.out.println(">");	
			System.out.println("Denomination " + denominations.toString() + " and * No of notes " + getNoofnotes + "   Total Amount = "+(rowTotal));
			JFrame f=new JFrame();  
			//JOptionPane.showMessageDialog(f,"2)"+"Denomination " + denominations.toString() + " and * No of notes " + getNoofnotes +"\n TOtalRequestedAmount = "+ withdramAMountDbl[0].doubleValue() + " > Rowttotal"+  rowTotal,"Alert",JOptionPane.WARNING_MESSAGE);
			if(getNoofnotes>0)
			{
			int noodnotetobedelivered = (int)(withdramAMountDbl[0]/denom);
			if(noodnotetobedelivered>0)
				{
				//JOptionPane.showMessageDialog(f," noodnotetobedelivered "+noodnotetobedelivered,"Alert",JOptionPane.WARNING_MESSAGE);
				withdramAMountDbl[0] = withdramAMountDbl[0] - (noodnotetobedelivered * denom);
				AmountBean temp = new AmountBean(denom, noodnotetobedelivered, (noodnotetobedelivered * denom));
				amountBeansTemp.add(temp);
				//JOptionPane.showMessageDialog(f," withdrawamount "+withdramAMountDbl[0]+" totalBalanceCal = "+totalBalanceCal,"Alert",JOptionPane.WARNING_MESSAGE);
	
				totalBalanceCal = totalBalanceCal - withdramAMountDbl[0];
				}
			}
			//JOptionPane.showMessageDialog(f," after deduction withdrawamount "+withdramAMountDbl[0]+" totalBalanceCal = "+totalBalanceCal,"Alert",JOptionPane.WARNING_MESSAGE);
			//JOptionPane.showMessageDialog(f,"2 end )"+"withdramAMountDbl[0] = "+withdramAMountDbl[0]+" totalBalanceCal = "+totalBalanceCal,"Alert",JOptionPane.WARNING_MESSAGE);
			
			
				
			}

			

			

		});
		


	
		UpdateDenominationRecord();
		printAfterDeposit();
		
		if(withdramAMountDbl[0].doubleValue()==Double.parseDouble(withdramAMount))
		{
			JFrame f=new JFrame();  
			JOptionPane.showMessageDialog(f,"Amount Dispatch is not successful due to invalid denomiation","Alert",JOptionPane.WARNING_MESSAGE); 
		}
		else
		{
			JFrame f=new JFrame();  
			JOptionPane.showMessageDialog(f,"Amount Dispatched Succcessfully","Alert",JOptionPane.WARNING_MESSAGE); 
		}
		
		
		}
	}
	public void UpdateDenominationRecord()
	{
		List<AmountBean> processBeans = new ArrayList<AmountBean>();
		processBeans.forEach((amountBean)->{
			System.out.println("for Eachbeafore"+amountBean.getDenomonation() +" * " +amountBean.getNoofnotes());
		 
			
					
		});
		Integer arrayIntegator[] = new Integer[1];
		arrayIntegator[0] = 0;
		tsSorteds.forEach(denominations -> {
			
			System.out.println("Started");
			
			Double transamountOLD = amountBeans.stream()						.filter(x -> x.getDenomonation() == denominations.intValue())
					.collect(Collectors.summarizingDouble(AmountBean::getDenomonation)).getSum();
			Double getNoofnotesOLD = amountBeans.stream()
					.filter(x -> x.getDenomonation() == denominations.intValue())
					.collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();
			Double transamountNew = amountBeansTemp.stream()						.filter(x -> x.getDenomonation() == denominations.intValue())
					.collect(Collectors.summarizingDouble(AmountBean::getDenomonation)).getSum();
			Double getNoofnotesNew = amountBeansTemp.stream()
					.filter(x -> x.getDenomonation() == denominations.intValue())
					.collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();
	
			double transamountBalance = transamountOLD - transamountNew;
			double getNoofnotesBalance = getNoofnotesOLD - getNoofnotesNew;
			
			double sumofrow= denominations.intValue() * getNoofnotesBalance;

			processBeans.add(new AmountBean(denominations.intValue(),(int) getNoofnotesBalance,sumofrow));
			arrayIntegator[0] = arrayIntegator[0] + 1;
			});
		//amountBeans = 
		// amountBeansTemp = new ArrayList<AmountBean>();
		System.out.println( "  OK Start"); 
		arrayIntegator[0] = 0;
		amountBeans = null;
		amountBeans =processBeans;
		processBeans.forEach((amountBean)->{
			arrayIntegator[0] = arrayIntegator[0] + 1;
			System.out.println("for each after "+(arrayIntegator[0])+" amountBean.getDenomonation()" +" * " +amountBean.getNoofnotes());
		 
			
					
		});
		
		System.out.println( "  AMOUNT BEAN"); 
		arrayIntegator[0] =0;
		amountBeans.forEach((amountBean)->{
			arrayIntegator[0] = arrayIntegator[0] + 1;
			System.out.println("for each after "+(arrayIntegator[0])+ "amountBean.getDenomonation() = "+ amountBean.getDenomonation() +" * " +amountBean.getNoofnotes());
		 
			
					
		});
		 
		System.out.println( "OK END"); 
	}

	public void deposit()
	{



		String denominationAmount = null;;
 	 


			Object deno = denominationCB.getSelectedItem();

			System.out.println(deno);

			denominationAmount = deno.toString();
			String amount= amountTobeDepositedTF.getText().trim();
			if( amount.equalsIgnoreCase("")  )
			{
				JFrame f=new JFrame();  
				JOptionPane.showMessageDialog(f,"Please Enter Valid Amount  ","Alert",JOptionPane.WARNING_MESSAGE); 
				
			}
			//JOptionPane.showMessageDialog(f,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE); 
			int amountTobeDeposited = Integer.parseInt(amount);
			if( amount.equalsIgnoreCase("") || amountTobeDeposited<=0 )
			{
				JFrame f=new JFrame();  
				JOptionPane.showMessageDialog(f,"Please Enter Valid Amount  ","Alert",JOptionPane.WARNING_MESSAGE); 
				
			}
			if(amountTobeDeposited>0)
			{
			
			double denoAmount=Double.parseDouble(denominationAmount);
			double  TotalRowamount =  (double) (denoAmount* amountTobeDeposited);
			AmountBean ab = new AmountBean(denoAmount, amountTobeDeposited, TotalRowamount);
			amountBeans.add(ab);
			
			//hmBeans.put(key, ab);
			
			//amountBeans.stream().flatMap(AmountBean);()
			JFrame f=new JFrame();  
			JOptionPane.showMessageDialog(f,"Amount Deposited Succcessfully","Alert",JOptionPane.WARNING_MESSAGE); 
			printAfterDeposit();

			}
			else
			{
				JFrame f=new JFrame();  
				JOptionPane.showMessageDialog(f,"Enter Amount Valid Amount","Alert",JOptionPane.WARNING_MESSAGE); 
			
			}
			
			

			
		
	}
	

	


	
	
 
	
	private void printAfterDeposit() {

		statmentLable.setText("");
		
		statement = new ArrayList<String>();

		
		
		
		tsSorteds.forEach(denominations -> {
			Double transamount = amountBeans.stream()						.filter(x -> x.getDenomonation() == denominations.intValue())
					.collect(Collectors.summarizingDouble(AmountBean::getDenomonation)).getSum();
			Double getNoofnotes = amountBeans.stream()
					.filter(x -> x.getDenomonation() == denominations.intValue())
					.collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();

			//System.out.println("Denomination " + transamount + " and * No of notes " + getNoofnotes);
			statement.add("Denomination " + denominations.toString() + " and * No of notes " + getNoofnotes + "Total Amount ="+(denominations.intValue()* getNoofnotes));
			


			//AmountBean ab = new AmountBean(	 denomonation,amountTobeDeposited,	 TotalRowamount );
			
			// pamtBean = new AmountBean(denominations.doubleValue(), getNoofnotes.intValue(), (denominations.doubleValue()* getNoofnotes.intValue()));
			//processBeans.add(pamtBean);

			 

		});


		DoubleSummaryStatistics totalAmount = amountBeans.stream()
				.collect(Collectors.summarizingDouble(AmountBean::getTotalAmount));
		System.out.println(""+totalAmount.getSum());

		System.out.println("Type S to SKIP   or ");
 
        String[] strArray = statement.toArray(new String[statement.size()]);
        
        String s= Arrays.toString(strArray);
        String printStatment = "";
        for(int i=0;i<statement.size();i++)
        {
        	printStatment =         	printStatment + statement.get(i)+"\n";
        }
        
        statmentLable.setText(printStatment);
		DoubleSummaryStatistics totalAmountFinal = amountBeans.stream()
				.collect(Collectors.summarizingDouble(AmountBean::getTotalAmount));
		System.out.println("BALANCE "+totalAmount.getSum());
        total.setText("Balance :"+totalAmountFinal.getSum());
        totalBalance = totalAmountFinal.getSum();

	}
	


	public ATMNewSwing2()
	{

		
		JPanel debitPanel=new JPanel(new FlowLayout());
		JPanel resultPanel=new JPanel(new FlowLayout());
		JPanel withdrawal=new JPanel(new FlowLayout());

		
		tsSorteds.forEach(denominations -> {
			denominationCB.addItem(denominations.toString());


		});
		
		

		Border blackline = BorderFactory.createLineBorder(Color.blue);
		
		JButton depositButton=new JButton("Deposit");
		JButton statementButton=new JButton("ATM Balance");
		depositButton.setName("Deposit");
		
		//JButton resetAtM=new JButton("RESET");
		
		JButton withdrawalButton=new JButton("Widthraw");
		withdrawalButton.setName("Widthraw");
		 
		amountTobeDepositedTF.setText("                                                                 ");

		amountTobeWidthTF.setText("                                                                 ");

		 

		statmentLable.setText("");
		total.setText("");
		 

		debitPanel.add(denominationCB);

		debitPanel.add(amountTobeDepositedTF);
		debitPanel.add(depositButton);

		
		debitPanel.setBorder(blackline);

		withdrawal.add(amountTobeWidthTF);
		withdrawal.add(withdrawalButton);
		
		withdrawal.setBorder(blackline);

		resultPanel.add(statementButton);
		resultPanel.add(total);
		resultPanel.add(statmentLable);
		resultPanel.add(statmentLable);
		resultPanel.setBorder(blackline);



		depositButton.addActionListener(new ActionListenerExample());
		withdrawalButton.addActionListener(new DebitActionListenerExample());

		statementButton.addActionListener(new StatementActionListenerExample());

		
		
		
		
		 
	    
		JPanel pane=new JPanel(new GridLayout(1,0));  
	    pane.setBounds(50,50,200,200);  
	    pane.add("Deposit",debitPanel); 
	    pane.add("Withdrawal",withdrawal); 
	    pane.add("Balance",resultPanel);  
	    
	    JTabbedPane jtabbedPane = new  JTabbedPane();
	   
	    jtabbedPane.addTab("Intel Bank",pane);
	    
	    this.add(jtabbedPane);

		

 
		
	
		
	}
	public void clearStament()
	{
		statmentLable.setText("");
	}
	public static void main(String[] args) {
		
		ATMNewSwing2 a = new ATMNewSwing2();
		a.setSize(800, 800);
		a.setVisible(true);
		
	
		
		
	}

	class ActionListenerExample implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			 clearStament();
			 deposit();
			

			
		}  

	  
	} 
 

	class DebitActionListenerExample implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			clearStament();
			withdrawal();
			
		}

	

	  
	} 
	
	
	class StatementActionListenerExample implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			clearStament();
			printAfterDeposit();
			
		}

	

	  
	} 
 

}

 
