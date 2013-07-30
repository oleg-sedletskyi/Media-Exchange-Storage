

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TomcatServlet
 */
@WebServlet("/TomcatServlet")
public class TomcatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TomcatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection comm =  getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createTable();
		response.getWriter().print("hello");
	}
	
	static void createTable()  {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = getConnection(); 
			ps = conn.prepareStatement(
				"CREATE TABLE users(id int, username varchar(63), password varchar(255), PRIMARY KEY(id));");
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
			if(conn != null)
				try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.3.96.130:3306/java";
		String username = "adminx8mVKcQ";
		String password = "G4xbfTrTbrEZ";
		
		return  DriverManager.getConnection(url, username, password);
	}  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
