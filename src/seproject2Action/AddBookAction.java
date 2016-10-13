package seproject2Action;

import seproject2Class.Author;
import seproject2Class.Book;
import seproject2Service.DatabaseService;

import com.opensymphony.xwork2.Action;

public class AddBookAction implements Action {

	private Book book;
	private Author author;
	private String errormeg;
	
	public String getErrormeg() {
		return errormeg;
	}

	public void setErrormeg(String errormeg) {
		this.errormeg = errormeg;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String execute() throws Exception {
		
		DatabaseService ds = new DatabaseService();
		
		String flag = ds.addBook(book,author);
		if (flag.equals("success"))
			return SUCCESS;
		else{
			setErrormeg(flag);
			return ERROR;
		}
	}

}
