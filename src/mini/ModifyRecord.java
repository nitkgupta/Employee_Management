package mini;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataDAO;

/**
 * Servlet implementation class ModifyRecord
 */
public class ModifyRecord extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String str=request.getParameter("str");
		String t3 = request.getParameter("t3");
		String t4 = request.getParameter("t4");
		String t5 = request.getParameter("t5");
		String t6 = request.getParameter("t6");
		String t7 = request.getParameter("t7");
		String t8 = request.getParameter("t8");
		String t9 = request.getParameter("t9");
		String t10 = request.getParameter("t10");
		String t11 = request.getParameter("t11");
		String t12 = request.getParameter("t12");
		DataDAO dd = new DataDAO();
		PrintWriter pw = response.getWriter();
		
		pw.println(dd.modifyrecord(str,t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
