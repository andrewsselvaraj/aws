package com.atm.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.atm.data.Denomination;
import com.atm.vo.AmountBean;

public class ATMNew {
	
	List<AmountBean> amountBeans = new ArrayList<AmountBean>();
	TreeSet<Integer> tsSorteds = Denomination.denomonation();
	List<AmountBean> amountBeansTemp = new ArrayList<AmountBean>();
	double totalBalance = 0;
	
	public void withdraw()
	{


		System.out.print("Enter AMOUNT withdraw ");
		Scanner withdrwaamount = new Scanner(System.in);

		DoubleSummaryStatistics dstats = amountBeans.stream()
				.collect(Collectors.summarizingDouble(AmountBean::getTotalAmount));
		double allTOtal = dstats.getSum();
		System.out.println(" (NOte : Balance is)" + allTOtal);
		Double tempwidthdrwaAmount[] = new Double[1];
		tempwidthdrwaAmount[0] = allTOtal;
		Double withdrawamt[] = new Double[1];
		withdrawamt[0]=withdrwaamount.nextDouble();;
		Boolean disbursement[] = new Boolean[1];
		disbursement[0]= false;
		// System.out.println("withdrwaamount.toString()"+withdrwaamount.toString());
		
		

		// double d = Double.parseDouble(withdrwaamount.toString());
		if (withdrawamt[0] > allTOtal) {
			System.out.println("Balance is not sufficent");
		}

		else
		{
			Map<Double,List<AmountBean>> lab= amountBeans.stream().collect(Collectors.groupingBy(AmountBean::getDenomonation));
			 Map<Double,List<AmountBean>> unSortedMap = lab;
			 Map<Double,List<AmountBean>> reverseSortedMap = new TreeMap<Double,List<AmountBean>>(Collections.reverseOrder());
			 
			 reverseSortedMap.putAll(unSortedMap);
			 
			 System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
			Set<Double> denominations= reverseSortedMap.keySet();
			
	 
			 
						
			AmountBean temp = null;
			Double total_temp_amount = allTOtal;
			String disburseStatus = "initiated";
			Double amount_remaining_requested_tobedisbursed_forCurrentDenomination = withdrawamt[0];
			Double main_amount_remaining_tobedisbursed = withdrawamt[0];
			Double remaining_notes_tobedisbursed = null;
			for (Double denoman : denominations) {
				System.out.println("\n");
				Double noofNotes = reverseSortedMap.get(denoman.doubleValue()).stream().collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();				
				Double sumOfdenominaation = reverseSortedMap.get(denoman.doubleValue()).stream().collect(Collectors.summarizingDouble(AmountBean::getDenomonation)).getSum();
				//Long countOfdenominaation = reverseSortedMap.get(x.doubleValue()).stream().collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).;
				System.out.println("no "+denoman+" *   "+noofNotes.intValue() +" and denomiation = "+sumOfdenominaation);

				int status = Double.compare(total_temp_amount, amount_remaining_requested_tobedisbursed_forCurrentDenomination);
				System.out.println("Status "+status);
				
				double amount_allowedforthis_disbursement = denoman.doubleValue() * noofNotes;
				
				if(total_temp_amount >= amount_allowedforthis_disbursement)// if it fails all the time then no matching denomination
				{
					disburseStatus = "excessAmount";
					double modeDivisble =  (int)(amount_remaining_requested_tobedisbursed_forCurrentDenomination / denoman.doubleValue());
					double modReminder =  amount_remaining_requested_tobedisbursed_forCurrentDenomination % denoman.doubleValue();
					double  amount_availble_forCurrentDisbursementinCurrentDenomination = sumOfdenominaation;
					
					
					
				
					//he is asking 4 rupee but only 2 ruppersare avaiable
					//count no of rupees and check it is >= requested deomniation

						System.out.println("Amount available Please proceedd");
					
					//total_temp_amount = total_temp_amount-amount_remaining_tobedisbursed_cal;
 
						if(amount_remaining_requested_tobedisbursed_forCurrentDenomination - amount_allowedforthis_disbursement  >=0)
						{
							amount_remaining_requested_tobedisbursed_forCurrentDenomination=amount_remaining_requested_tobedisbursed_forCurrentDenomination-amount_allowedforthis_disbursement;
							total_temp_amount = total_temp_amount -amount_allowedforthis_disbursement;
							temp = new AmountBean(sumOfdenominaation,noofNotes.intValue(),amount_remaining_requested_tobedisbursed_forCurrentDenomination);
							amountBeansTemp.add(temp);
						}
						else if(amount_remaining_requested_tobedisbursed_forCurrentDenomination - amount_allowedforthis_disbursement  < 0)
						{
							Double excessamountforthisdemoniation = (amount_allowedforthis_disbursement - amount_remaining_requested_tobedisbursed_forCurrentDenomination);
							int eligbleCountofDenomination = (int)(excessamountforthisdemoniation/denoman.doubleValue());
							amount_allowedforthis_disbursement = eligbleCountofDenomination * denoman.doubleValue();
							amount_remaining_requested_tobedisbursed_forCurrentDenomination=amount_remaining_requested_tobedisbursed_forCurrentDenomination-amount_allowedforthis_disbursement;
							total_temp_amount = total_temp_amount -amount_allowedforthis_disbursement;
							temp = new AmountBean(amount_allowedforthis_disbursement,eligbleCountofDenomination,amount_remaining_requested_tobedisbursed_forCurrentDenomination);
							amountBeansTemp.add(temp);
						}
					else
					{
						System.out.println("denomiation is not mactinchg");
					}
						

					
				
				} 
				else if(total_temp_amount < amount_remaining_requested_tobedisbursed_forCurrentDenomination)
				{
					disburseStatus = "rety";
					
					System.out.println("disburseStatus "+disburseStatus+" and amount_remaining_tobedisbursed "+amount_remaining_requested_tobedisbursed_forCurrentDenomination+" \n and amount_remaining "+total_temp_amount+" and sumOfdenominaation "+sumOfdenominaation);
				}
				else  
				{

					disburseStatus = "SUCCESS";
					double modeDivisble =  (int)(amount_remaining_requested_tobedisbursed_forCurrentDenomination / denoman.doubleValue());
					double modReminder =  amount_remaining_requested_tobedisbursed_forCurrentDenomination % denoman.doubleValue();
					double  amount_availble_forCurrentDisbursementinCurrentDenomination = sumOfdenominaation;
					
					double amount_remaining_tobedisbursed_cal = denoman.doubleValue() * modeDivisble;
					//he is asking 4 rupee but only 2 ruppersare avaiable
					//count no of rupees and check it is >= requested deomniation
					if(amount_remaining_requested_tobedisbursed_forCurrentDenomination<=amount_availble_forCurrentDisbursementinCurrentDenomination)
					{
					total_temp_amount = total_temp_amount-amount_remaining_tobedisbursed_cal;
					amount_remaining_requested_tobedisbursed_forCurrentDenomination = amount_remaining_requested_tobedisbursed_forCurrentDenomination - amount_remaining_tobedisbursed_cal ;
					temp = new AmountBean(sumOfdenominaation,noofNotes.intValue(),amount_remaining_requested_tobedisbursed_forCurrentDenomination);
					amountBeansTemp.add(temp);
					}
					
					
					System.out.println("disburseStatus "+disburseStatus+" and amount_remaining_tobedisbursed "+amount_remaining_requested_tobedisbursed_forCurrentDenomination+" and amount_remaining"+total_temp_amount);


				
				
					
				}
				
				
			    }
			System.out.println("Remaininig anojutn"+total_temp_amount);
			System.out.println("amount_remaining_tobedisbursed"+amount_remaining_requested_tobedisbursed_forCurrentDenomination);
			
			tsSorteds.forEach(denominations1 -> {
				Double transamount = amountBeansTemp.stream()
						.filter(x -> x.getDenomonation() == denominations1.intValue())
						.collect(Collectors.summarizingDouble(AmountBean::getDenomonation)).getSum();
				Double transamountold = amountBeans.stream()
						.filter(x -> x.getDenomonation() == denominations1.intValue())
						.collect(Collectors.summarizingDouble(AmountBean::getDenomonation)).getSum();
				Double getNoofnotes = amountBeansTemp.stream()
						.filter(x -> x.getDenomonation() == denominations1.intValue())
						.collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();
				Double getNoofnotesOld = amountBeans.stream()
						.filter(x -> x.getDenomonation() == denominations1.intValue())
						.collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();

				//System.out.println("Denomination " + transamount + " and * No of notes " + getNoofnotes);
				//System.out.println("Denomination old" + transamountold + " and * No of notes " + getNoofnotesOld);

			});
			
			tsSorteds.forEach(denominations1 -> {
			//	AmountBean  toberemoved= amountBeansTemp.stream().filter(x -> x.getDenomonation() == denominations1.intValue()).findFirst().get();
			//	AmountBean  toberemovedOLD= amountBeans.stream().filter(x -> x.getDenomonation() == denominations1.intValue()).findFirst().get();
			 
				Double transamount = amountBeansTemp.stream()
						.filter(x -> x.getDenomonation() == denominations1.intValue())
						.collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();	
				Double transamountold = amountBeans.stream()
						.filter(x -> x.getDenomonation() == denominations1.intValue())
						.collect(Collectors.summarizingDouble(AmountBean::getDenomonation)).getSum();
				Double getNoofnotes = amountBeansTemp.stream()
						.filter(x -> x.getDenomonation() == denominations1.intValue())
						.collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();
				Double getNoofnotesOld = amountBeans.stream()
						.filter(x -> x.getDenomonation() == denominations1.intValue())
						.collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();

				System.out.println("Denomination " + transamount + " and * No of notes " + getNoofnotes);
				System.out.println("Denomination old" + transamountold + " and * No of notes " + getNoofnotesOld);

			});

			
 
			 
		}
			
 
			
 
			 
			 
			 
			 
			 
	
		
	}
	
	
 
 

	public void deposit()
	{
		String addorskip = "S";
		Scanner amount = new Scanner(System.in);

		String more = null;
		do {

			System.out.print("Please Enter denomination  to deposit ");
			tsSorteds.forEach(denominations -> {

				System.out.print(" " + denominations.intValue());

			});
			more = amount.next();
			if (more.equalsIgnoreCase(addorskip)) {
				break;
			}
			double demomianation = Double.parseDouble(more);
			System.out.print(" Please Enter No of Notes ");
			more = amount.next();
			int no = Integer.parseInt(more);
			//no = -no ;
			//demomianation = - demomianation;
			totalBalance = demomianation * no;
			AmountBean ab = new AmountBean(demomianation, no,totalBalance);
			amountBeans.add(ab);
			
			//amountBeans.stream().flatMap(AmountBean);

			tsSorteds.forEach(denominations -> {
				Double transamount = amountBeans.stream()						.filter(x -> x.getDenomonation() == denominations.intValue())
						.collect(Collectors.summarizingDouble(AmountBean::getDenomonation)).getSum();
				Double getNoofnotes = amountBeans.stream()
						.filter(x -> x.getDenomonation() == denominations.intValue())
						.collect(Collectors.summarizingDouble(AmountBean::getNoofnotes)).getSum();

				System.out.println("Denomination " + transamount + " and * No of notes " + getNoofnotes);

			});


			DoubleSummaryStatistics totalAmount = amountBeans.stream()
					.collect(Collectors.summarizingDouble(AmountBean::getTotalAmount));
			System.out.println(""+totalAmount.getSum());

			System.out.println("Type S to SKIP   or ");
		} while (!amount.equals(addorskip));
		
	}

	public static void main(String[] args) {
		
		/*ATMNew aTMNew = new ATMNew();
		aTMNew.withdraw();*/
		
		  ATMNew aTMNew = new ATMNew();
		System.out.println("Automated Teller Machine");
		Scanner mainEntry = new Scanner(System.in);
		while (true) {
			
			

			System.out.print("Choose 1 for Add Amount");
			System.out.print("Choose 2 for Width Draw Amount");
			System.out.print("Choose 3 for Check Balance");
			System.out.print("Choose 4 for EXIT ");
			System.out.println("Choose the operation you want to perform:");
			int n = mainEntry.nextInt();
			switch (n) {
			
			case 1:
				aTMNew.deposit();
				break;
			case 2:
				aTMNew.withdraw();
				break;
			case 3:
				aTMNew.balance();
				break;
				
			}
		}
		 
	}


	private void balance() {
		DoubleSummaryStatistics totalAmount = amountBeans.stream()
				.collect(Collectors.summarizingDouble(AmountBean::getTotalAmount));
		System.out.println("BALANCE "+totalAmount.getSum());
		
		//sum and take 
		
	}

 

}
