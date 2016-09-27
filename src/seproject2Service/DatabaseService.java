package seproject2Service;

import java.sql.*;

import seproject2Class.Author;
import seproject2Class.Book;

public class DatabaseService {

	public boolean addBook(Book book, Author author) {
		System.out.println("in");
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e){
			System.out.println(e.toString());
            System.out.println("--------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------");
            e.printStackTrace();
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
				return false;
			}
				
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
