package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HospitalRegDoctorModel {

	private int hospital_reg_doctor_id;
	private int doctorID;
	private int hospital_id;
	private String date;

	public HospitalRegDoctorModel() {
		super();
	}

	public HospitalRegDoctorModel(int hospital_reg_doctor_id, int doctorID, int hospital_id, String date) {
		super();
		this.hospital_reg_doctor_id = hospital_reg_doctor_id;
		this.doctorID = doctorID;
		this.hospital_id = hospital_id;
		this.date = date;
	}

	public int getHospital_reg_doctor_id() {
		return hospital_reg_doctor_id;
	}

	public void setHospital_reg_doctor_id(int hospital_reg_doctor_id) {
		this.hospital_reg_doctor_id = hospital_reg_doctor_id;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "HospitalRegDoctorModel [hospital_reg_doctor_id=" + hospital_reg_doctor_id + ", doctorID=" + doctorID
				+ ", hospital_id=" + hospital_id + ", date=" + date + "]";
	}

}
