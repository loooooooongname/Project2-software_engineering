package seproject2Action;

import seproject2Class.Book;
import seproject2Service.DatabaseService;

import com.opensymphony.xwork2.Action;

public class UpdateBookAction implements Action {

	Book book;
	String ori_ISBN;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getOri_ISBN() {
		return ori_ISBN;
	}

	public void setOri_ISBN(String ori_ISBN) {
		this.ori_ISBN = ori_ISBN;
	}

	@Override
	public String execute() throws Exception {
		
		DatabaseService ds = new DatabaseService();
		if (ds.updatebook(book,ori_ISBN))
			return SUCCESS;
		else
			return ERROR;

	}

}
