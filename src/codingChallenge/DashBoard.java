package codingChallenge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Feedback;
import utils.DashBoardFormater;

public class DashBoard {

	Feedback feedback;
	
	public DashBoard(String apiValue) {
		super();
		this.feedback=convertJsonToObject(apiValue);
		// TODO Auto-generated constructor stub
	}
	
	public Feedback convertJsonToObject(String apivalue){
		GsonBuilder builder = new GsonBuilder();
		builder.serializeNulls();
	      builder.setPrettyPrinting(); 
	      
	      Gson gson = builder.create(); 
	       return gson.fromJson(apivalue, Feedback.class);
	}

	
	
	public String getFormatedValue() {
		// TODO Auto-generated method stub
		// format date
		// remove date
		DashBoardFormater dashboardformater = new DashBoardFormater();
		return dashboardformater.printFeedback(feedback);
	}
	
}
