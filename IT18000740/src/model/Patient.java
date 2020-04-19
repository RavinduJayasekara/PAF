package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.protobuf.ByteString.Output;

public class Patient {

	private Connection connect() {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return con;
	}
	
	// get all information of a patient including password and username also
	
	public String retrievePatients() {
		
		Connection con = connect();
		
		String result = "";
		
		try {
			
			if(con == null) {
				return "Error Connecting to the database";
			}
			
			result = "<table border = \"5\"><tr><th>Patient ID</th><th>Patient Username</th><th>Patient Password</th><th>Patient Name</th><th>Patient Contact</th><th>Patient Address</th><th>Patient Email</th></tr>";
			
			
			String query = "select * from patients";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				String patientID = Integer.toString(rs.getInt("patientID"));
				String patientUserName = rs.getString("patientUserName");
				String patientPassword = rs.getString("patientPassword");
				String patientName = rs.getString("patientName");
				String patientContact = Integer.toString(rs.getInt("patientContact"));
				String patientAddress = rs.getString("patientAddress");
				String patientEmail = rs.getString("patientEmail");
				
				result += "<tr><td>" + patientID + "</td>";
				result += "<td>" + patientUserName + "</td>";
				result += "<td>" + patientPassword + "</td>";
				result += "<td>" + patientName + "</td>";
				result += "<td>" + patientContact + "</td>";
				result += "<td>" + patientAddress + "</td>";
				result += "<td>" + patientEmail + "</td></tr>";
				
				
			}
			
			con.close();
			result += "</table>";
			
		}catch(Exception e) {
			result = "Error while retrieving information from the patient table";
			e.printStackTrace();
		}
		
		return result;
	}
	

	
	public String getPatientFromId(String patientID) {
		
		// database connection
		Connection con = connect();
		String result = "";
		
		try {
			if(con == null) {
				return "Error while connecting to the data base.";
			}
			
			String query = "select patientName from patients where patientID = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, Integer.parseInt(patientID));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				result = "<table border = \"5\"><tr><th>Patient Name</th></tr>";
				
				String patientName = rs.getString("patientName");
				
				result += "<td>" + patientName + "</td>";
				
			}
			
			con.close();
			
			result += "</table>";
			
		}catch(Exception e) {
			
			result = "Error getting the patient name";
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	// get doctor's name for the patient for a given username
	
	public String getDoctorName(String username) {
		
		Connection con = connect();
		
		String result = "";
		
		try {
			
			String query = "select d.doctorName from patients p, doctor d where p.patientID = d.patientID and p.patientUserName = ?";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				result = "<table border = \"5\"><th>Doctor Name</th>";
				
				String doctorName = rs.getString("doctorName");
			
				result += "<tr><td>" + doctorName + "</td></tr>";
				
			}
			 
			con.close();
			
			result += "</table>";
			
		}catch(Exception e) {
			e.printStackTrace();
			result = "Error while getting doctor information";
			
		}
		
		return result;
	}
	
	// get payment detalis using passing patient username as a parameter
	
	public String getPaymentDetails(String username) {
		
		Connection con = connect();
		
		String result = "";
		
		try {
			
			String query = "select m.paymentName from patients p, payment m where p.patientID = m.patientID and p.patientUserName = ?";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				result = "<table border = \"5\"><th>Payment Name</th>";
				
				String paymentName = rs.getString("paymentName");
			
				result += "<tr><td>" + paymentName + "</td></tr>";
				
			}
			 
			con.close();
			
			result += "</table>";
			
		}catch(Exception e) {
			e.printStackTrace();
			result = "Error while getting payment information";
			
		}
		
		return result;
	}

	//get appointment details from the appointment table to a selected patiet

	public String getAppointmentNames(String username) {
		
		Connection con = connect();
		
		String result = "";
		
		try {
			
			String query = "select a.appointmentName from patients p, appointments a where p.patientID = a.patientID and p.patientUserName = ?";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				result = "<table border = \"5\"><th>Appointment Name</th>";
				
				String paymentName = rs.getString("appointmentName");
			
				result += "<tr><td>" + paymentName + "</td></tr>";
				
			}
			 
			con.close();
			
			result += "</table>";
			
		}catch(Exception e) {
			e.printStackTrace();
			result = "Error while getting appointment information";
			
		}
		
		return result;
	}
	
	
	public String insertPatient(String patientID,String patientName,String patientContact, String patientAddress,String patientEmail) {
		
		Connection con = connect();
		try {

			String query = "insert into patients values(?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);
			
			System.out.println(patientID + " " + patientName + " " + patientContact + " " + patientEmail + " " + patientAddress );
			
			ps.setInt(1, Integer.parseInt(patientID));
			ps.setString(2, patientName);
			ps.setInt(3, Integer.parseInt(patientContact));
			ps.setString(4, patientAddress);
			ps.setString(5, patientEmail);
			
			ps.execute();
			con.close();
			
			return "Inserted Successfully";
			
		}catch(Exception e) {
		
			e.printStackTrace();
			return "Error while inserting patient";
			
		}
		
	}
	
	//delete patient from the database using patientid
	
	public String deletePatient(String patientID) {
		
		Connection con = connect();
		String result = "";
		
		if(con == null) {
			return "Error while connecting to the database";
		}
		
		try {
		
		String query = "delete from patients where patientID = ?";
		
		//prepared statement for delete patient
		PreparedStatement ps = con.prepareStatement(query);
		
		//binding values
		ps.setInt(1,  Integer.parseInt(patientID));
		
		//execute the prepared statement
		ps.execute();
		
		con.close();
		
		result = "Deleted Successfully";
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String updatePatient(String patientID,String patientName,String patientContact, String patientAddress,String patientEmail)
	{
		Connection con = connect();
		
		String result = "";
		try {
			
			//sql statement
			
			String query = "UPDATE patients SET patientName=?,patientContact=?,patientAddress=?,patientEmail=? WHERE patientID=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			//binding values to specific fields
			
			ps.setString(1, patientName);
			ps.setInt(2, Integer.parseInt(patientContact));
			ps.setString(3, patientAddress);
			ps.setString(4, patientEmail);
			ps.setInt(5, Integer.parseInt(patientID));
			
			//execute update statement
			
			ps.execute();
			con.close();
			
			result = "Updated Successfully";
			
		}catch(Exception e) {
			
			result = "Error while updating the patient details";
			e.printStackTrace();
			
		}
		
		return result;
	}
	
	
	// login to the system 
	
	public String login(String username, String password) {
		
		Connection con = connect();
		String result = "";
		
		try {
			System.out.println(username + "\n" + password);
			if(con == null) {
				return "Error while connecting to the database";
			}
			
			String query = "select * from patients";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				String un = rs.getString("patientUserName");
				String pw = rs.getString("patientPassword");
				
				System.out.println(un + " " + pw);
				
				if(username.equals(un) && password.equals(pw)) {
					
					System.out.println(un + " " + pw);
					result = "Login Successfully";
					
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			result = "Error while logging into the system";

		}
		
		return result;
	}
}
