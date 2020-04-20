package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import codingChallenge.DashBoard;
import model.Feedback;
import utils.DashBoardFormater;


public class DashBoardTest {

	String swashbucklerFeedback =  "{ 'word':'swashbuckler',"
			+ " 'comment':'Yar, a good word, matey! Shiver me timbers!',"
			+ " 'rating':85, 'date':'19 Sep 2019 12:12:00 GMT'}";
	
	String slubberFeedback = "{ 'word':'slubber',"
			+ " 'comment':'Slubber sounds like slobber. So gross! More pretty words, please!',"
			+ " 'rating':31, 'date':'10 Sep 2019 04:14:00 PST'}";
	
	
	String textlationshipFeedback= "{ 'word':'textlationship',"
			+ " 'comment':'I m in a textlationship with my friend! We text all the time! I feel like its every second! LMAO!',"
			+ " 'rating':60, 'date':'10 Sep 2019 04:14:00 PST'}";
	
	String  hyperbolicFeedback = "{ 'word':'hyperbolic',"
			+ " 'comment':'How come teethpaste isnt in the dictionary?',"
			+ " 'date':'22 Aug 2019 01:20:00 PST'}";
	Feedback feedback;
	
	@Before
	public void setup(){

		GsonBuilder builder = new GsonBuilder(); 
	      builder.setPrettyPrinting(); 
	      
	      Gson gson = builder.create(); 
	       feedback = gson.fromJson(swashbucklerFeedback, Feedback.class);
	}
	@Test
	public void should_format_feedback() {
		DashBoardFormater dashboardformater = new DashBoardFormater();
		
		String expected_value ="swashbuckler: Yar,"
				+ " a good word, matey! Shiver me"
				+ " timbers! ★★★★ (9/19/2019)";
		DashBoard dashboard= new DashBoard(swashbucklerFeedback);
		
		assertEquals(
				dashboard.getFormatedValue(),
				expected_value);
	}
	
	@Test
	public void should_format_over80_characters() {
		System.out.println(feedback);
		String expected_value ="slubber: Slubber sounds "
				+ "like slobber. "
				+ "So gross! More"
				+ " pretty words, please! ★";
		DashBoard dashboard= new DashBoard(slubberFeedback);
		assertEquals(dashboard.getFormatedValue(),expected_value);
	}
	@Test
	public void should_format_over80_after_date_removed() {
		System.out.println(feedback);
		String expected_value ="textlationship: I m in a"
				+ " textlationship with my friend!"
				+ " We text all the t... ★★★";
		DashBoard dashboard= new DashBoard(textlationshipFeedback);
		assertEquals(dashboard.getFormatedValue(),expected_value);
	}
	
	@Test
	public void should_display_rating_omitted() {
		System.out.println(feedback);
		String expected_value ="hyperbolic: "
				+ "How come teethpaste"
				+ " isnt in the dictionary? (8/22/2019)";
		DashBoard dashboard= new DashBoard(hyperbolicFeedback);
		System.out.println(dashboard.getFormatedValue());
		assertEquals(dashboard.getFormatedValue(),expected_value);
	}

}
