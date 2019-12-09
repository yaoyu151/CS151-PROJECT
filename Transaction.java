import java.io.Serializable;
public class Transaction implements Serializable 
{

	/*
	 * getter and setter methods for transaction types and amounts.
	 */
	public Transaction()
	{
		date = "";  
		CheckNO = 0; 
		transactionType = 0;
		TransactionsDes = ""; 
		amount = 0;
	}
	
	public int getTransactionType()
	{
		return transactionType;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setTransactionType(int newType)
	{
		transactionType = newType;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getTransactionDes()
	{
		return TransactionsDes;
	}
	
	public void setTransactionDes(String TransactionDes)
	{
		this.TransactionsDes = TransactionDes;
	}
	
	public int getCheckNO()
	{
		return CheckNO;
	}
	
	public void setCheckNO(int CheckNO)
	{
		this.CheckNO = CheckNO;
	}
	
	private int transactionType;
	private double amount;
	private int CheckNO;
	private String date;
	private String TransactionsDes;
}