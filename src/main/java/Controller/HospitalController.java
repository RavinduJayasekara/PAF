package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.HospitalModel;

import DBConnector.Connector;

public class HospitalController {

	Connector con = Connector.getInstance();

	private HospitalController() {
	}

	private static final HospitalController obj = new HospitalController();

	public static HospitalController getInstance() {
		return obj;
	}

	public void save(HospitalModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO hospital(name,address,email,contact_no) VALUES ('" + obj.getName() + "', " + "'"
				+ obj.getAddress() + "', '" + obj.getEmail() + "', '" + obj.getContact_no() + "')");
	}

	public void update(HospitalModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE hospital SET name = '" + obj.getName() + "', address = '" + obj.getAddress() + "', email = '"
				+ obj.getEmail() + "'," + "contact_no = '" + obj.getContact_no() + "' " + "WHERE hospital_id='"
				+ obj.getHospital_id() + "'");
	}

	public void delete(HospitalModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM hospital WHERE hospital_id='" + obj.getHospital_id() + "'");
	}

	public List<HospitalModel> searchAll() throws Exception {
		List<HospitalModel> list = new ArrayList<HospitalModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM hospital");
		while (rset.next()) {
			HospitalModel obj = new HospitalModel();
			obj.setHospital_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAddress(rset.getString(3));
			obj.setEmail(rset.getString(4));
			obj.setContact_no(rset.getString(5));

			list.add(obj);
		}
		return list;
	}

	public HospitalModel search(int hospital_id) throws Exception {
		con.getConnection();
		HospitalModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM hospital WHERE hospital_id='" + hospital_id + "'");
		while (rset.next()) {
			obj = new HospitalModel();
			obj.setHospital_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAddress(rset.getString(3));
			obj.setEmail(rset.getString(4));
			obj.setContact_no(rset.getString(5));

		}
		return obj;
	}

	public boolean checkHospitalAvailability(int hospital_id) throws Exception {
		con.getConnection();
		boolean idAvaliabillity = true;
		ResultSet rset = con.srh("SELECT * FROM hospital WHERE hospital_id='" + hospital_id + "'");
		while (rset.next()) {
			idAvaliabillity = false;
		}
		return idAvaliabillity;
	}

}
