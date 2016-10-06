package seproject2Class;

public class Book {
	
	private String ISBN;
	private String title;
	private String publisher;
	private String publishdate;
	private float price;
	
	public Book(String i,String t,String p,String pd,float pr){
		ISBN = i;
		title = t;
		publisher = p;
		publishdate = pd;
		price = pr;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
