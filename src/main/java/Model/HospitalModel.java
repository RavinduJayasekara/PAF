package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HospitalModel {

	private int hospital_id;
	private String name;
	private String address;
	private String email;
	private String contact_no;

	public HospitalModel() {
		super();
	}

	public HospitalModel(int hospital_id, String name, String address, String email, String contact_no) {
		super();
		this.hospital_id = hospital_id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.contact_no = contact_no;
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	@Override
	public String toString() {
		return "HospitalModel [hospital_id=" + hospital_id + ", name=" + name + ", address=" + address + ", email="
				+ email + ", contact_no=" + contact_no + "]";
	}

}
