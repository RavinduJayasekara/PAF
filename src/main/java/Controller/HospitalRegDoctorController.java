package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnector.Connector;
import Model.HospitalRegDoctorModel;

public class HospitalRegDoctorController {

	Connector con = Connector.getInstance();

	private HospitalRegDoctorController() {

	}

	private static final HospitalRegDoctorController obj = new HospitalRegDoctorController();

	public static HospitalRegDoctorController getInstance() {
		return obj;
	}

	public void save(HospitalRegDoctorModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO hospital_reg_doctor(doctorID,hospital_id,date) VALUES ('" + obj.getDoctorID() + "', '"
				+ obj.getHospital_id() + "', '" + obj.getDate() + "')");
	}

	public void update(HospitalRegDoctorModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE hospital_reg_doctor SET doctorID = '" + obj.getDoctorID() + "', hospital_id = '"
				+ obj.getHospital_id() + "'," + "date = '" + obj.getDate() + "' " + "WHERE hospital_reg_doctor_id='"
				+ obj.getHospital_reg_doctor_id() + "'");
	}

	public void delete(HospitalRegDoctorModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM hospital_reg_doctor WHERE hospital_reg_doctor_id='" + obj.getHospital_reg_doctor_id()
				+ "'");
	}

	public List<HospitalRegDoctorModel> searchAll() throws Exception {
		List<HospitalRegDoctorModel> list = new ArrayList<HospitalRegDoctorModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM hospital_reg_doctor");
		while (rset.next()) {
			HospitalRegDoctorModel obj = new HospitalRegDoctorModel();
			obj.setHospital_reg_doctor_id(rset.getInt(1));
			obj.setDoctorID(rset.getInt(2));
			obj.setHospital_id(rset.getInt(3));
			obj.setDate(rset.getString(4));

			list.add(obj);
		}
		return list;
	}

	public HospitalRegDoctorModel search(int hospital_reg_doctor_id) throws Exception {
		con.getConnection();
		HospitalRegDoctorModel obj = null;
		ResultSet rset = con
				.srh("SELECT * FROM hospital_reg_doctor WHERE hospital_reg_doctor_id='" + hospital_reg_doctor_id + "'");
		while (rset.next()) {
			obj = new HospitalRegDoctorModel();
			obj.setHospital_reg_doctor_id(rset.getInt(1));
			obj.setDoctorID(rset.getInt(2));
			obj.setHospital_id(rset.getInt(3));
			obj.setDate(rset.getString(4));

		}
		return obj;
	}

}
