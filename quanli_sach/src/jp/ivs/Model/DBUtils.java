package jp.ivs.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
	private static final long serialVersionUID = 1L;
	
	private static String JDBC_DRIVER="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/ql_sach";
	private static String USER="root";
	private static String PASS="";
	
	protected static Connection connectionDB() throws SQLException
	{
		Connection jdbConnection;
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new SQLException();
		}
		jdbConnection= DriverManager.getConnection(URL, USER, PASS);
		return jdbConnection;
	}
	public static List<Book> getByAll() throws SQLException
	{
		//tạo biến lưu DB
		List<Book> listBook= new ArrayList<Book>();
		//tao ket noi DB
		Connection dbConnection= connectionDB();
		String sql= "select* from sach";
		Statement statement = dbConnection.createStatement();
		ResultSet ketqua= statement.executeQuery(sql);
		
		// duyệt bảng kết quả
		while (ketqua.next())
		{
			int id=ketqua.getInt("Book_id");
			String title=ketqua.getString("Title");
			String author=ketqua.getString("Author");
			Float price= ketqua.getFloat("Price");
			//goi lai vao bien book
			Book book= new Book(id, title, author, price);
			// them vao danh sach cac Book
			listBook.add(book);		
		}
		ketqua.close();
		statement.close();
		dbConnection.close();
		
		return listBook;
	}
}
