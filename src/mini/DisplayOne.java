package mini;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataDAO;
import dao.Employee;

public class DisplayOne extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String str = request.getParameter("t1");
			DataDAO dd = new DataDAO();
			PrintWriter out = response.getWriter();
			Employee e = dd.displayone(str);
			out.println(
					"<html><body><table border=1><tr><td>Employee No</td><td>Employee Name</td><td>Designation</td><td>Department</td><td>Basic Salary</td><td>DOB</td><td>Edu_Qual</td><td>1st Address</td><td>2nd Address</td><td>City</td><td>Pin</td><td>Phone</td></tr>");
			out.println("<tr><td>" + e.getEmp_No() + "</td><td>" + e.getFirst_Name() + " " + e.getLast_Name()
					+ "</td><td>" + e.getDesignation() + "</td><td>" + e.getDepartment() + "</td><td>"
					+ e.getBasic_Salary() + "</td><td>" + e.getDOB() + "</td><td>" + e.getEdu_Qual() + "</td><td>"
					+ e.getAddress1st() + "</td><td>" + e.getAddress2nd() + "</td><td>" + e.getCity() + "</td><td>"
					+ e.getPin() + "</td><td>" + e.getPhone() + "</td></tr></table></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
