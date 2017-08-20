package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.State;

import connection.MyConnection;

public class DataDAO {
	Connection con = MyConnection.getConnection();

	public String addrecord(String s13, String s1, String s2, String s3, String s4, String s5, String s6, String s7,
			String s8, String s9, String s10, String s11, String s12) throws ClassNotFoundException, SQLException {

		String sql1 = "insert into EmployeeDetail1 values(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql1);
		ps.setString(1, s13);
		ps.setString(2, s1);
		ps.setString(3, s2);
		ps.setString(5, s4);
		ps.setString(4, s5);
		ps.setString(6, s6);
		String sql2 = "insert into EmployeeDetail2 values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.setString(1, s13);
		ps2.setString(2, s3);
		ps2.setString(3, s7);
		ps2.setString(4, s8);
		ps2.setString(5, s9);
		ps2.setString(6, s10);
		ps2.setString(7, s11);
		ps2.setString(8, s12);
		int a = ps.executeUpdate();
		int a2 = ps2.executeUpdate();
		if (a > 0 && a2 > 0)
			return "Data Entered Succesfully....";
		else
			return "Data entering failed.....";

	}

	public String deleterecord(String s1) throws ClassNotFoundException, SQLException {

		String sql = "delete from EmployeeDetail1 where Emp_No='" + s1 + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		int a = ps.executeUpdate();
		String sql2 = "delete from EmployeeDetail2 where Emp_No='" + s1 + "'";
		PreparedStatement ps2 = con.prepareStatement(sql2);
		int a2 = ps2.executeUpdate();
		if (a > 0)
			return "Data Deleted Succesfully";
		else
			return "Data Deleting failed";
	}

	public String modifyrecord(String str, String s3, String s4, String s5, String s6, String s7, String s8, String s9,
			String s10, String s11, String s12) throws ClassNotFoundException, SQLException {

		String sql = "update EmployeeDetail1 set Designation=?,Department=?,Basic_Salary=? where Emp_No='" + str + "'";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(2, s4);// depart 5
		ps.setString(1, s5);// desig 4
		ps.setString(3, s6);// salary 6
		String sql2 = "update EmployeeDetail2 set DOB=?,Edu_Qual=?,Address1st=?,Address2nd=?,City=?,Pin=?,Phone=? where Emp_No='"
				+ str + "'";
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.setString(1, s3);// dob
		ps2.setString(2, s7);
		ps2.setString(3, s8);
		ps2.setString(4, s9);
		ps2.setString(5, s10);
		ps2.setString(6, s11);
		ps2.setString(7, s12);

		int a = ps.executeUpdate();
		int a1 = ps2.executeUpdate();
		if (a > 0 && a1 > 0)
			return "Data Updated Succesfully";
		else
			return "Data Updation failed";
	}

	public Employee displayone(String s1) throws SQLException {
		Employee e = new Employee();
		Statement s = con.createStatement();
		String sql = "select * from EmployeeDetail1 where Emp_No='" + s1 + "'";
		ResultSet rs = s.executeQuery(sql);
		Statement s2 = con.createStatement();
		String sql2 = "select * from EmployeeDetail2 where Emp_No='" + s1 + "'";
		ResultSet rs2 = s2.executeQuery(sql2);
		rs.next();
		rs2.next();
		e.setEmp_No(rs.getString(1));
		e.setFirst_Name(rs.getString(2));
		e.setLast_Name(rs.getString(3));
		e.setDesignation(rs.getString(4));
		e.setDepartment(rs.getString(5));
		e.setBasic_Salary(rs.getString(6));

		e.setDOB(rs2.getString(2));
		e.setEdu_Qual(rs2.getString(3));
		e.setAddress1st(rs2.getString(4));
		e.setAddress2nd(rs2.getString(5));
		e.setCity(rs2.getString(6));
		e.setPin(rs2.getString(7));
		e.setPhone(rs2.getString(8));

		return e;

	}

	public List<Employee> displayall() throws SQLException {
		List<Employee> li = new ArrayList<Employee>();
		try {
			Statement st = con.createStatement();
			Statement st2 = con.createStatement();
			ResultSet rs = st.executeQuery("select * from EmployeeDetail1");
			ResultSet rs2 = st2.executeQuery("select * from EmployeeDetail2");

			while (rs.next() && rs2.next()) {
				Employee e = new Employee();
				e.setEmp_No(rs.getString(1));
				e.setFirst_Name(rs.getString(2));
				e.setLast_Name(rs.getString(3));
				e.setDesignation(rs.getString(4));
				e.setDepartment(rs.getString(5));
				e.setBasic_Salary(rs.getString(6));

				e.setDOB(rs2.getString(2));
				e.setEdu_Qual(rs2.getString(3));
				e.setAddress1st(rs2.getString(4));
				e.setAddress2nd(rs2.getString(5));
				e.setCity(rs2.getString(6));
				e.setPin(rs2.getString(7));
				e.setPhone(rs2.getString(8));
				li.add(e);

			}
			return li;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return li;
	}

}
