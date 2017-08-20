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
 * Servlet implementation class DeleteRecord
 */
public class DeleteRecord extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("t1");
		DataDAO dd=new DataDAO();
		PrintWriter pw=response.getWriter();
		try {
			pw.println(dd.deleterecord(str));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
