package seproject2Action;

import java.util.List;

import seproject2Class.Author;
import seproject2Class.Book;
import seproject2Service.DatabaseService;

import com.opensymphony.xwork2.Action;

public class SearchAction implements Action {

	private String authorname;
	private List<Book> books;
	private List<Author> authors;
	
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	@Override
	public String execute() throws Exception {
		
		DatabaseService ds = new DatabaseService();
		if (ds.SearchAuthorByName(authorname) != null){
			setAuthors(ds.SearchAuthorByName(authorname));
			setBooks(ds.SearchBookByName(authorname));
			return SUCCESS;
		}
		return ERROR;
	}

}
