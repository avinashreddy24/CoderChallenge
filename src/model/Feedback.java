package model;



public class Feedback {
	
	private String word;
	private String comment;
	private String date;
	
	int rating;
	public Feedback(String word, String comment, String date, int rating) {
		super();
		this.word = word;
		this.comment = comment;
		this.date = date;
		this.rating = rating;
	}
	
	
	public Feedback(String word, String comment, String date) {
		super();
		this.word = word;
		this.comment = comment;
		this.date = date;
	}


	public String getWord() {
		return word;
	}
	public String getComment() {
		return comment;
	}
	public String getDate() {
		return date;
	}
	
	public int getRating() {
		return rating;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Feedback [word=" + word + ", comment=" + comment + ", date=" + date + ", rating=" + rating + "]";
	}
	
	
	
	
}
