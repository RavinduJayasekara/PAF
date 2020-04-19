package Controller;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import Model.AppointmentModel;
import connection.Connector;

public class AppointmentController {
	
	Connector con = Connector.getInstance();

	private AppointmentController() {
	}

	private static final AppointmentController obj = new AppointmentController();

	public static AppointmentController getInstance() {
		return obj;
	}

	public void save(AppointmentModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO appointment(app_no,name,age,address,phone,disease,doctor_name,app_date,app_time,hospital) VALUES ('" + obj.getApp_no() + "', '"
				+ obj.getName() + "', '" + obj.getAge() + "', '" + obj.getAddress() + "', '" + obj.getPhone() + "', '" + obj.getDisease() + "', '" + obj.getDoctor_name() + "', '" + obj.getApp_date()+ 
				"', '" + obj.getApp_time() + "', '" + obj.getHospital()+"')");
	}

	public void update(AppointmentModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE appointment SET name = '" + obj.getApp_no() + "', '"
				+ obj.getName() + "', '" + obj.getAge() + "', '" + obj.getAddress() + "', '" + obj.getPhone() + "', '" + obj.getDisease() + "', '" + obj.getDoctor_name() + "', '" + obj.getApp_date()+ 
				"', '" + obj.getApp_time() + "', '" + obj.getHospital()+ "'");
	}

	public void delete(AppointmentModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM appointment WHERE app_no='" + obj.getApp_no() + "'");
	}

	public List<AppointmentModel> searchAll() throws Exception {
		List<AppointmentModel> list = new ArrayList<AppointmentModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM hospital");
		while (rset.next()) {
			AppointmentModel obj = new AppointmentModel();
			obj.setApp_no(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAge(rset.getString(3));
			obj.setAddress(rset.getString(4));
			obj.setPhone(rset.getString(5));
			obj.setDisease(rset.getString(6));
			obj.setDoctor_name(rset.getString(7));
			obj.setApp_date(rset.getString(8));
			obj.setApp_time(rset.getString(9));
			obj.setHospital(rset.getString(10));

			list.add(obj);
		}
		return list;
	}

	public AppointmentModel search(int app_no) throws Exception {
		con.getConnection();
		AppointmentModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM appointment WHERE app_no='" + app_no + "'");
		while (rset.next()) {
			obj = new AppointmentModel();
			obj.setApp_no(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAge(rset.getString(3));
			obj.setAddress(rset.getString(4));
			obj.setPhone(rset.getString(5));
			obj.setDisease(rset.getString(6));
			obj.setDoctor_name(rset.getString(7));
			obj.setApp_date(rset.getString(8));
			obj.setApp_time(rset.getString(9));
			obj.setHospital(rset.getString(10));

		}
		return obj;
	}

}
