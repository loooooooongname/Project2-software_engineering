package seproject2Service;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import seproject2Class.Author;
import seproject2Class.Book;

public class DatabaseService {

	public boolean addBook(Book book, Author author) {
	//	System.out.println("in");
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e){
			return false;
		}
		
		try{
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sepro2","root","wr19950705");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from author");
			int id = 0;
			boolean ext = false;
			while (rs.next()){
				id++;
				if (rs.getString("Name").equals(author.getName())
					&& rs.getInt("Age") == author.getAge()
					&& rs.getString("Country").equals(author.getCountry())){
					id = rs.getInt("AuthorID");
					ext = true;
				}
			}
			
			if (!ext){
				id++;
				PreparedStatement Statement=connect.prepareStatement("INSERT INTO author VALUES (?,?,?,?)");
				Statement.setInt(1, id);
				Statement.setString(2, author.getName());
				Statement.setInt(3, author.getAge());
				Statement.setString(4, author.getCountry());
				Statement.executeUpdate();
			}
			try{
				PreparedStatement Statement=connect.prepareStatement("insert into book values (?,?,?,?,?,?)");
				Statement.setString(1, book.getISBN());
				Statement.setString(2, book.getTitle());
				Statement.setInt(3,id);
				Statement.setString(4, book.getPublisher());
				Statement.setString(5, book.getPublishdate());
				Statement.setFloat(6, book.getPrice());
				Statement.executeUpdate();
			}catch(Exception e){
				System.out.println("55"+e);
				return false;
			}
				
		}catch(Exception e){
			System.out.println("60"+e);
			return false;
		}
		return true;
	}

	public List<Book> SearchBookByName(String authorname) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e){
			return null;
		}
		try{
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sepro2","root","wr19950705");
			Statement stmt = connect.createStatement();
			Statement stmt2 = connect.createStatement();
			List<Book> lb = new ArrayList<Book>();
			
			ResultSet rs = stmt.executeQuery("select * from author where Name = '"+authorname+"' ");
			while (rs.next()){
				int authorid = rs.getInt("AuthorID");
				ResultSet rsbook = stmt2.executeQuery("select * from book where AuthorID = '"+authorid+"' ");
				while (rsbook.next()){
					Book b = new Book(rsbook.getString("ISBN"),
							rsbook.getString("Title"),
							rsbook.getString("Publisher"),
							rsbook.getString("PublishDate"),
							rsbook.getFloat("Price"));
					lb.add(b);
				}				
			}
			return lb;
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
		
	}

	public List<Author> SearchAuthorByName(String authorname) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e){
			System.out.println("Open failed");
			return null;
		}
		try{
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sepro2","root","wr19950705");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from author where Name = '"+authorname+"' ");
			List<Author> la = new ArrayList<Author>();
			
			while (rs.next()){	
				Author a = new Author(rs.getString("Name"),rs.getInt("Age"),rs.getString("Country"));
				la.add(a);
			}
			return la;
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}

	public boolean delbook(String del_book) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e){
			System.out.println(e);
			return false;
		}
		
		try{
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sepro2","root","wr19950705");
			Statement stmt = connect.createStatement();
			stmt.executeUpdate("delete from book where ISBN = '"+del_book+"' ");
			return true;
		}catch (Exception e){
			System.out.println(e);
			return false;
		}
	}
}
