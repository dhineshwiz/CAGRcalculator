package com.projection.report;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.projection.pojo.ReportItem;
import com.projection.util.NumberToWord;
import com.projection.util.ProjectionUtil;

public class HtmlGenerator
{
	public final static String	GREEN_CODE	= "00FF66";
	public final static String	RED_CODE	= "FF6600";
	
	public static String generateHtml(List<ReportItem> reportItemsList)
	{
		String redBG = "bgcolor='#"+RED_CODE+"'";
		String greenBG = "bgcolor='#"+GREEN_CODE+"'";
		String begin = "<html><body><table border='1'>";
		String tableHead = "<tr><th>Name</th>" +
		"<th>purchase date</th>" +
		"<th>purchase amaount</th>" +
		"<th>final value</th>" +
		"<th>bank final value</th>" +
		"<th>diff amount</th>" +
		"<th>CAGR (%)</th>" +
		"<th>time diff</th></tr>";
		
		String tableBody = "";
		for (ReportItem reportItem : reportItemsList)
		{
			String loop = "<tr>" +
					"<td>" + reportItem.getName() + "</td>" +
					"<td>" + getFormattedDate(reportItem.getPurchaseDate()) + "</td>" +
					"<td>" + getIndianRupeeFormat(reportItem.getPurchaseAmount()) + "</td>";
					if (reportItem.getFinalValueColor().equals(ProjectionUtil.RED))
					{
						loop += "<td " + redBG + ">" + getIndianRupeeFormat(reportItem.getFinalAmount()) + "</td>";
					}else{
						loop += "<td " + greenBG + ">" + getIndianRupeeFormat(reportItem.getFinalAmount()) + "</td>";
					}
					loop += "<td>" + getIndianRupeeFormat(reportItem.getFinalBankAmount()) + "</td>" +
					"<td>" + getIndianRupeeFormat(reportItem.getDiffAmount()) + "</td>" ;
					if (reportItem.getFinalValueColor().equals(ProjectionUtil.RED))
					{
						loop += "<td " + redBG + ">" + getRoundOff(reportItem.getCagr()) + "</td>";
					}else{
						loop += "<td " + greenBG + ">" + getRoundOff(reportItem.getCagr()) + "</td>";
					}

					loop += "<td>" + getRoundOff(reportItem.getTimeDiff()) + "</td>" +
					"</tr>";
			
					tableBody += loop;
		}
		
		String end = "</table></body></html>";
		String html = begin + tableHead + tableBody + end;
		return html;

	}
	
	private static String getIndianRupeeFormat(Double amount)
	{
		long rounded = getRoundOffForAmount(amount);
//		 NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
//		 String moneyString = formatter.format(rounded);
//		 return moneyString;
		 
		 return "<b>"+format(rounded) + "</b> - "+ NumberToWord.convertNumberToWord(rounded);
	}
	
	public static String format(long value) {
	    if(value < 1000) {
	        return format("###", value);
	    } else {
	        double hundreds = value % 1000;
	        int other = (int) (value / 1000);
	        return format(",##", other) + ',' + format("000", hundreds);
	    }
	}

	private static String format(String pattern, Object value) {
	    return new DecimalFormat(pattern).format(value);
	}

	private static long getRoundOffForAmount(Double amount)
	{
		long roundOff =  Math.round(amount) ;
		return roundOff;
	}

	private static double getRoundOff(Double amount)
	{
		double roundOff =  (double)Math.round(amount * 100)/100 ;
		return roundOff;
	}

	
	private static String getFormattedDate(Date dNow)
	{
//		      SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		SimpleDateFormat ft = new SimpleDateFormat ("MMM yyyy");

		      return ft.format(dNow);
	}
}
