package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnector.Connector;
import Model.DocModel;

public class DocController {

	Connector con = Connector.getInstance();

	private DocController() {

	}

	private static final DocController obj = new DocController();

	public static DocController getInstance() {
		return obj;
	}

	public void save(DocModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO doc(doctorName,specialization,designation,price,date) VALUES ('" + obj.getDoctorName() + "', "
				+ "'" + obj.getSpecialization() + "', '" + obj.getDesignation() + "', '" + obj.getPrice() + "','"
				+ obj.getDate() + "')");
	}

	public void update(DocModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE doc SET doctorName = '" + obj.getDoctorName() + "', specialization = '"
				+ obj.getSpecialization() + "', designation = '" + obj.getDesignation() + "'," + "price = '" + obj.getPrice() + "','"
				+ obj.getDate() + "' " + "WHERE doctorID='" + obj.getDoctorID() + "'");
	}

	public void delete(DocModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM doc WHERE doctorID='" + obj.getDoctorID() + "'");
	}

	public List<DocModel> searchAll() throws Exception {
		List<DocModel> list = new ArrayList<DocModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM doc");
		while (rset.next()) {
			DocModel obj = new DocModel();
			obj.setDoctorID(rset.getInt(1));
			obj.setDoctorName(rset.getString(2));
			obj.setSpecialization(rset.getString(3));
			obj.setDesignation(rset.getString(4));
			obj.setPrice(rset.getDouble(5));
			obj.setDate(rset.getString(6));

			list.add(obj);
		}
		return list;
	}

	public DocModel search(int doctorID) throws Exception {
		con.getConnection();
		DocModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM doc WHERE doctorID='" + doctorID + "'");
		while (rset.next()) {
			obj = new DocModel();
			obj.setDoctorID(rset.getInt(1));
			obj.setDoctorName(rset.getString(2));
			obj.setSpecialization(rset.getString(3));
			obj.setDesignation(rset.getString(4));
			obj.setPrice(rset.getDouble(5));
			obj.setDate(rset.getString(6));

		}
		return obj;
	}
	public boolean checkDoctorAvailability(int doctorID) throws Exception {
		con.getConnection();
		boolean idAvaliabillity = true;
		ResultSet rset = con.srh("SELECT * FROM doc WHERE doctorID='" + doctorID + "'");
		while (rset.next()) {
			idAvaliabillity = false;
		}
		return idAvaliabillity;
	}
}
