package seproject2Action;

import seproject2Service.DatabaseService;

import com.opensymphony.xwork2.Action;

public class DelBookAction implements Action {

	String del_book;
	
	public String getDel_book() {
		return del_book;
	}

	public void setDel_book(String del_book) {
		this.del_book = del_book;
	}

	@Override
	public String execute() throws Exception {
		
		DatabaseService ds = new DatabaseService();
		System.out.println("This is " + del_book);
		if (ds.delbook(del_book))
			return SUCCESS;
		else
			return ERROR;
		
	}

}
