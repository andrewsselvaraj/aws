package com.atm.vo;



public class AmountBean {
	
	double denomonation;
	int noofnotes;
 
	double totalAmount;
	public AmountBean(	double dblDenomonation,int intNoofnotes,	double totalAmount )
	{
		this.denomonation = dblDenomonation;
		this.noofnotes = intNoofnotes;
		 
		this.totalAmount = totalAmount;
	}
	
 


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
		
	
	public double getDenomonation() {
		return denomonation;
	}
	public void setDenomonation(double denomonation) {
		this.denomonation = denomonation;
	}
	public int getNoofnotes() {
		return noofnotes;
	}
	public void setNoofnotes(int noofnotes) {
		this.noofnotes = noofnotes;
	}

	

}

