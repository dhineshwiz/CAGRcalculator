package com.projection.pojo;

import java.util.Date;
import java.util.List;

public class PurchaseItem
{

	private String			name;
	private Date			purchaseDate;
	private Double			purchaseAmount;
	private List<Amount>	futureAmounts;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getPurchaseDate()
	{
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate)
	{
		this.purchaseDate = purchaseDate;
	}

	public Double getPurchaseAmount()
	{
		return purchaseAmount;
	}

	public void setPurchaseAmount(Double purchaseAmount)
	{
		this.purchaseAmount = purchaseAmount;
	}

	public List<Amount> getFutureAmounts()
	{
		return futureAmounts;
	}

	public void setFutureAmounts(List<Amount> futureAmounts)
	{
		this.futureAmounts = futureAmounts;
	}
}
