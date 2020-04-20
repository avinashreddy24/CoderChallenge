package utils;

import model.Feedback;

public interface Formater {

	public String formatDate(String date);
	
	public String trimLength(Feedback feedback);
	
	public String printFeedback(Feedback feedback);
	
	public String formatRating(int rating);
	
}
