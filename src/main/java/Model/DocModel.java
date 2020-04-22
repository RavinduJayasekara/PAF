package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DocModel {

	private int doctorID;
	private String doctorName;
	private String specialization;
	private String designation;
	private double price;
	private String date;

	public DocModel() {
		super();
	}

	public DocModel(int doctorID, String doctorName, String specialization, String designation, double price,
			String date) {
		super();
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.designation = designation;
		this.price = price;
		this.date = date;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
