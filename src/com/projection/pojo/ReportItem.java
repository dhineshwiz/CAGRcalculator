package com.projection.pojo;

import java.util.Date;

public class ReportItem
{
	private String	name;
	private Date	purchaseDate;
	private Double	purchaseAmount;
	private Double	finalAmount;
	private Double	finalBankAmount;
	private Double	diffAmount;
	private Double	cagr;
	private Double	timeDiff;
	private Date	finalDate;
	private String  finalValueColor;

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

	public Double getFinalAmount()
	{
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount)
	{
		this.finalAmount = finalAmount;
	}

	public Double getFinalBankAmount()
	{
		return finalBankAmount;
	}

	public void setFinalBankAmount(Double finalBankAmount)
	{
		this.finalBankAmount = finalBankAmount;
	}

	public Double getDiffAmount()
	{
		return diffAmount;
	}

	public void setDiffAmount(Double diffAmount)
	{
		this.diffAmount = diffAmount;
	}

	public Double getCagr()
	{
		return cagr;
	}

	public void setCagr(Double cagr)
	{
		this.cagr = cagr;
	}

	public Double getTimeDiff()
	{
		return timeDiff;
	}

	public void setTimeDiff(Double timeDiff)
	{
		this.timeDiff = timeDiff;
	}

	public Date getFinalDate()
	{
		return finalDate;
	}

	public void setFinalDate(Date finalDate)
	{
		this.finalDate = finalDate;
	}

	public String getFinalValueColor()
	{
		return finalValueColor;
	}

	public void setFinalValueColor(String finalValueColor)
	{
		this.finalValueColor = finalValueColor;
	}
}
