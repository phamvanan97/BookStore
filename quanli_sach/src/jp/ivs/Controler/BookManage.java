package jp.ivs.Controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ivs.Model.Book;
import jp.ivs.Model.DBUtils;

/**
 * Servlet implementation class BookManage
 */
@WebServlet("/")
public class BookManage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookManage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Xem URL người ta chọn hành động gì
		String action = request.getServletPath();
		// tùy thuộc vào hành động là gì, mà gọi HÀM được viết ở ngoài doGet cho gọn
	    try {
            switch (action) 
            {
            case "/":
            	listBook(request, response);
                break;
            case "/list":
                listBook(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	// Hàm hiện tất cả các sách trong DB
		private void listBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	        // Lấy về tất cả các sách 
			List<Book> listBook=DBUtils.getByAll();
			
			// Sử dụng chức năng điều hướng
			 RequestDispatcher dispatcher = request.getRequestDispatcher("List_Book.jsp");
		        request.setAttribute("listBook", listBook);   // Truyền dữ liệu ra trang jsp
		        // thực hiện điều hướng
		        dispatcher.forward(request, response);
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
