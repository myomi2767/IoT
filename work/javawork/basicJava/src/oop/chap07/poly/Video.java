package oop.chap07.poly;

public class Video extends Content{
	private String genre;
	public Video() {
		
	}
	public Video(String title, String genre) {
		super(title);
		this.genre = genre;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void totalPrice() {
		if((this.genre).equals("new")) {
			setPrice(2000);
		} else if((this.genre).equals("comic")){
			setPrice(1500);
		} else if((this.genre).equals("child")) {
			setPrice(1000);
		} else {
			setPrice(500);
		}
	}
}
