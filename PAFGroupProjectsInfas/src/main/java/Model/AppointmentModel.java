package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AppointmentModel {
	
	private int app_no;
	private String name;
	private String age;
	private String address;
	private String phone;
	private String disease;
	private String doctor_name;
	private String app_date;
	private String app_time;
	private String hospital;


	public AppointmentModel() {
		super();
	}

	public AppointmentModel(int app_no, String name, String age, String address,String phone, String disease, String doctor_name, String app_date, String app_time, String hospital) {
		super();
		this.app_no = app_no;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.disease = disease;
		this.doctor_name = doctor_name;
		this.app_date = app_date;
		this.app_time = app_time;
		this.hospital = hospital;
	}

	public int getApp_no() {
		return app_no;
	}

	public void setApp_no(int app_no) {
		this.app_no = app_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getApp_date() {
		return app_date;
	}

	public void setApp_date(String app_date) {
		this.app_date = app_date;
	}
	
	public String getApp_time() {
		return app_time;
	}

	public void setApp_time(String app_time) {
		this.app_time = app_time;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "AppointmentModel [app_no=" + app_no + ", name=" + name + ", age=" + age + ", address=" + address +  ", phone=" + phone + ", disease=" + disease +
				", doctor_name=" + doctor_name + ", app_date=" + app_date + ", app_time=" + app_time + ", hospital=" + hospital +"]";
	}

}
