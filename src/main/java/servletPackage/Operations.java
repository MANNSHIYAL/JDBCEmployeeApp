package servletPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Operations {
	Scanner input = new Scanner(System.in);
	public static Connection connect() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/programs","root","Mann@123#");
		return connection;
		
	}
	public static int insertEmployee(String name,String phoneNumber,String email,String country,int salary,String style) throws ClassNotFoundException {
		String empty = "";
		if(name.equals(empty) || phoneNumber.equals(empty) || email.equals(empty) || country.equals(empty) || salary == 0) return 0;
		try {
			Connection connection = connect();
			Statement statement = connection.createStatement();
			// To get sr_no
			ResultSet result = statement.executeQuery("select * from practicle;");
			int sr_no = 0;
			while(result.next())sr_no++;
			// 
			String query = "insert into practicle(sr_no,names,phone_no,email,country,salery,style) values(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,sr_no + 1);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, phoneNumber);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, country);
			preparedStatement.setInt(6, salary);
			preparedStatement.setString(7, style);
			preparedStatement.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return 0;
	}
	public static ArrayList<Employee> listEmployee() throws ClassNotFoundException {
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			Connection connection = connect();
			String query = "select * from practicle";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Employee employee = new Employee();
				employee.setSr_no(result.getInt(1));
				employee.setName(result.getString(2));
				employee.setPhoneNumber(result.getString(3));
				employee.setEmail(result.getString(4));
				employee.setCountry(result.getString(5));
				employee.setSalary(result.getInt(6));
				employee.setStyle(result.getString(7));
				list.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static Employee findEmployee(int sr_no) throws ClassNotFoundException {
		Employee employee = new Employee();
		try {
			Connection connection = connect();
			String query = "select * from practicle where sr_no = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,sr_no);
			ResultSet result = preparedStatement.executeQuery(); 
			while(result.next()) {
				if(result.getInt(1) == sr_no) {
					employee.setSr_no(result.getInt(1));
					employee.setName(result.getString(2));
					employee.setPhoneNumber(result.getString(3));
					employee.setEmail(result.getString(4));
					employee.setCountry(result.getString(5));
					employee.setSalary(result.getInt(6));
					employee.setStyle(result.getString(7));
					return employee;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static int deleteEmployee(int sr_no) throws ClassNotFoundException {
		try {
			Connection connection = connect();
			String query = "delete from practicle where sr_no = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,sr_no);
			preparedStatement.executeUpdate();
			return 1;
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
