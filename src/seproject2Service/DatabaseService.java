package seproject2Service;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import seproject2Class.Author;
import seproject2Class.Book;

public class DatabaseService {

//	static final String dburl = "jdbc:mysql://localhost:3306/sepro2";
	static final String dburl = "jdbc:mysql://lghrcopmvdvy.rds.sae.sina.com.cn:10283/sepro2";
	static final String dbuser = "root";
	static final String dbpaw = "wr19950705";
	
	public String addBook(Book book, Author author) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e){
			return e.getMessage();
		}
		
		try{
			Connection connect = DriverManager.getConnection(
					dburl,dbuser,dbpaw);
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
				return e.getMessage();
			}
				
		}catch(Exception e){
			System.out.println("60"+e);
			return e.getMessage();
		}
		return "success";
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
					dburl,dbuser,dbpaw);
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
						//	rsbook.getInt("AuthorID"),
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
					dburl,dbuser,dbpaw);
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
					dburl,dbuser,dbpaw);
			Statement stmt = connect.createStatement();
			stmt.executeUpdate("delete from book where ISBN = '"+del_book+"' ");
			return true;
		}catch (Exception e){
			System.out.println(e);
			return false;
		}
	}

	public List<Book> searchbook(String show_book) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e){
			System.out.println("157"+e);
			return null;
		}
		try{
			Connection connect = DriverManager.getConnection(
					dburl,dbuser,dbpaw);
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book where ISBN = '"+show_book+"' ");
			List<Book> book = new ArrayList<Book>();
			while (rs.next()){
				book.add(new Book(
								rs.getString("ISBN"),
								rs.getString("Title"),
								rs.getString("Publisher"),
								rs.getString("PublishDate"),
								rs.getFloat("Price")));
			}
			return book;
		}catch (Exception e){
			System.out.println("176"+e);
			return null;
		}
	}

	public boolean updatebook(Book book, String ori_ISBN) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e){
			System.out.println("186"+e);
			return false;
		}
		try{
			Connection connect = DriverManager.getConnection(
					dburl,dbuser,dbpaw);
			Statement stmt1 = connect.createStatement();
			ResultSet rs1 = stmt1.executeQuery("select * from book where ISBN = '"+ori_ISBN+"' ");
		//	int authorid = new ;
			rs1.next();
			int authorid = rs1.getInt("AuthorID");
			if (!delbook(ori_ISBN))
				return false;
			PreparedStatement Statement=connect.prepareStatement("insert into book values (?,?,?,?,?,?)");
			Statement.setString(1, book.getISBN());
			Statement.setString(2, book.getTitle());
			Statement.setInt(3,authorid);
			Statement.setString(4, book.getPublisher());
			Statement.setString(5, book.getPublishdate());
			Statement.setFloat(6, book.getPrice());
			Statement.executeUpdate();
			return true;
		}catch (Exception e){
			System.out.println("176"+e);
			return false;
		}
	}

}
