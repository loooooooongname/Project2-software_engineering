package seproject2Action;

import java.util.List;

import seproject2Class.Book;
import seproject2Service.DatabaseService;

import com.opensymphony.xwork2.Action;

public class ShowBookAction implements Action {

	String show_book;
	List<Book> books;
	
	
	

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getShow_book() {
		return show_book;
	}

	public void setShow_book(String show_book) {
		this.show_book = show_book;
	}


	@Override
	public String execute() throws Exception {
		DatabaseService ds = new DatabaseService();
		if (ds.searchbook(show_book) != null){
			setBooks(ds.searchbook(show_book));
			return SUCCESS;
		}else
			return ERROR;
	}

}
