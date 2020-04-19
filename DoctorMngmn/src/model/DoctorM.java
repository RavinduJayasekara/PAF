package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoctorM {

	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doc", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	public String insertDoctorM(String doctorName, String pantientID, String pantientName, String date, String time,
			String price, String des) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			
			// create a prepared statement
			String query = " insert into doct (docId, doctorName, pantientID,  pantientName, date, time, price, des)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, doctorName);
			preparedStmt.setInt(3, Integer.parseInt(pantientID));
			preparedStmt.setString(4, pantientName);
			preparedStmt.setString(5, date);
			preparedStmt.setString(6, time);
			preparedStmt.setDouble(7, Double.parseDouble(price));
			preparedStmt.setString(8, des);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the appoinment." + e;
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readDoctorM() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Doctor ID</th><th>Doctor Name</th><th>Patient ID</th><th>Patient Name</th><th>Date</th><th>Time</th><th>Price</th><th>des</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from doct";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set

			while (rs.next()) {
				String docId = Integer.toString(rs.getInt("docId"));
				String doctorName = rs.getString("doctorName");
				String pantientID = Integer.toString(rs.getInt("pantientID"));
				String pantientName = rs.getString("pantientName");
				String date = rs.getString("date");
				String time = rs.getString("time");
				String price = Double.toString(rs.getDouble("price"));
				String des = rs.getString("des");

				// Add into the html table
				output += "<tr><td>" + docId + "</td>";
				output += "<td>" + doctorName + "</td>";
				output += "<td>" + pantientID + "</td>";
				output += "<td>" + pantientName + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + time + "</td>";
				output += "<td>" + price + "</td>";
				output += "<td>" + des + "</td>";
				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"appoinments.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
						+ "<input name=\"docId\" type=\"hidden\" value=\"" + docId + "\">" + "</form></td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the appoinments.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateDoctorM(String docId, String doctorName, String pantientID, String pantientName, String date, String time, String price, String des) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE doct SET doctorName=?,pantientID=?,pantientName=?,date=?,time=?,price=?,des=? WHERE docId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, doctorName);
			preparedStmt.setInt(2, Integer.parseUnsignedInt(pantientID));
			preparedStmt.setString(3, pantientName);
			preparedStmt.setString(4, date);
			preparedStmt.setString(5, time);
			preparedStmt.setDouble(6, Double.parseDouble(price));
			preparedStmt.setString(7, des);
			preparedStmt.setInt(8, Integer.parseUnsignedInt(docId));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the appoinment.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteDoctorM(String docId) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from doct where docId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(docId));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the appoinment.";
			System.err.println(e.getMessage());

		}

		return output;
	}

}
