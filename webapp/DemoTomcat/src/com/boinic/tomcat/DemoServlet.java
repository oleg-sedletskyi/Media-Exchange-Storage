package com.boinic.tomcat;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
			 
	    public String databaseCall() {
	        Connection con = null;
	        Statement st = null;
	        ResultSet rs = null;
	        String myVersion = "";
	 
	        //String url = "jdbc:mysql://127.3.224.130:3306/java"; //make sure that this database name exists;
	        String url = "JunkDB:mysql://127.3.96.130:3306"; //make sure that this database name exists;
	        //mysql://adminx8mVKcQ:G4xbfTrTbrEZ@127.3.96.130:3306
	        String user = "admin";
	        String password = "G4xbfTrTbrEZ";
	 
	        try {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException cnfe) {
	                return cnfe.getMessage();
	            }
	            con = DriverManager.getConnection(url, user, password);
	            st = con.createStatement();
	            rs = st.executeQuery("SELECT * from users;");
	 
	            if (rs.next()) {
	                System.out.println(rs.getString(1));
	                myVersion = rs.getString(1);
	            }
	 
	        } catch (SQLException ex) {
	            myVersion = ex.getMessage();
	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (st != null) {
	                    st.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	 
	            } catch (SQLException ex) {
	                myVersion = ex.getMessage();
	            }
	        }
	        return myVersion;
	    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("Hello from Servlet");
		databaseCall();
		out.println("After DB query");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
