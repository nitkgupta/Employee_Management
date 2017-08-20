package mini;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.EmbeddedServletOptions;

import dao.DataDAO;
import dao.Employee;

public class DisplayAll extends HttpServlet {
int i;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		DataDAO dd=new DataDAO();
		PrintWriter pw=response.getWriter();
			List<Employee> li=dd.displayall();
			PrintWriter out=response.getWriter();
			out.println(
					"<html><body><table border=1><b><tr><td>Employee No</td><td>Employee Name</td><td>Designation</td><td>Department</td><td>Basic Salary</td><td>DOB</td><td>Edu_Qual</td><td>1st Address</td><td>2nd Address</td><td>City</td><td>Pin</td><td>Phone</td></tr></b>");
			
			for(Employee e:li) {
				out.println("<tr><td>" + e.getEmp_No() + "</td><td>" + e.getFirst_Name() + " " + e.getLast_Name()
				+ "</td><td>" + e.getDesignation() + "</td><td>" + e.getDepartment() + "</td><td>"
				+ e.getBasic_Salary() + "</td><td>" + e.getDOB() + "</td><td>" + e.getEdu_Qual() + "</td><td>"
				+ e.getAddress1st() + "</td><td>" + e.getAddress2nd() + "</td><td>" + e.getCity() + "</td><td>"
				+ e.getPin() + "</td><td>" + e.getPhone() + "</td></tr>");
			}
			out.println("</table></body></html>");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
			
		}
	}

