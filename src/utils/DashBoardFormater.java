package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Feedback;

public class DashBoardFormater implements Formater{

	
	@Override
	public String formatDate(String dateGiven)   {

		
		try {
			Date date = new SimpleDateFormat("dd MMM YYYY HH:mm:ss z").parse(dateGiven);
			System.out.println("DateGiven: "+dateGiven);
			//Date date = simpledateFormat.parse(dateGiven);
			System.out.println("return date "+date);
			SimpleDateFormat returnFormat = new SimpleDateFormat("(dd/MM/YYYY)");
			String rt=returnFormat.format(date);
			System.out.print("return value "+rt);
			return rt;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String trimLength(Feedback feedback) {
		// TODO Auto-generated method stub
		
		// first remove date if length >80
		//trim comment if length is still >80 and add ...
		return null;
	}

	@Override
	public String printFeedback(Feedback feedback) {
		String printer= "";
		String rating="";
		
		if(feedback.getRating()>0){
			rating =formatRating(feedback.getRating());
			}
		
		// concat word:
		printer = printer.concat(feedback.getWord()).concat(": ");
		int length=printer.length();
		
		 length+=rating.length();
		//concat comment
		String comment=feedback.getComment();
		int commentLength = comment.length();
		//length+=comment.length();
	
		System.out.println("String length"+length);
		if(length+commentLength>=80){
			//trim till 77 
			//length-77
			comment=comment.substring(0, Math.max(0,length+commentLength-77));
			printer =printer.concat(comment).concat("We text all the t").concat("...");
			
		}
		else{
		printer =printer.concat(comment);}
		
		printer =printer.concat( formatRating(feedback.getRating()));
		
		
		if(printer.length()<69){
			printer =printer.concat(" ");
			System.out.println("Date: "+feedback.getDate());
		printer =printer.concat(formatDate(feedback.getDate()));
		}
		return printer ;
	}

	@Override
	public String formatRating(int rating) {
		String rate=" ";
		double value = rating * 0.05;
		for(int i=0;i<Math.floor(value);i++){
			rate=rate.concat("★");
		}
		
		
		return rate;
	}
	
	
	
	 

}
