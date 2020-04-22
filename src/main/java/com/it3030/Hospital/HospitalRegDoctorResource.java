package com.it3030.Hospital;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Controller.DocController;
import Controller.HospitalController;
import Controller.HospitalRegDoctorController;
import Model.HospitalRegDoctorModel;

@Path("hospitalRegDoctorResource")
public class HospitalRegDoctorResource {
	@GET
	@Path("hospitalRegDoctors")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<HospitalRegDoctorModel> getAllHospitals() throws Exception {
		return HospitalRegDoctorController.getInstance().searchAll();
	}

	@GET
	@Path("hospitalRegDoctor/{hospital_reg_doctor_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public HospitalRegDoctorModel getHospital(@PathParam("hospital_reg_doctor_id") int hospital_reg_doctor_id)
			throws Exception {
		return HospitalRegDoctorController.getInstance().search(hospital_reg_doctor_id);
	}

	@POST
	@Path("hospitalRegDoctor")
	public String saveHospital(HospitalRegDoctorModel obj) throws Exception {
		if (HospitalController.getInstance().checkHospitalAvailability(obj.getHospital_id())) {
			return "hospital id Invalid";
		} else if (DocController.getInstance().checkDoctorAvailability(obj.getDoctorID())) {
			return "doctor id Invalid";
		} else {
			HospitalRegDoctorController.getInstance().save(obj);
			return "hospitalRegDoctor Saved";
		}
	}

	@PUT
	@Path("hospitalRegDoctor")
	public String updateHospital(HospitalRegDoctorModel obj) throws Exception {
		if (HospitalController.getInstance().checkHospitalAvailability(obj.getHospital_id())) {
			return "hospital id Invalid";
		} else if (DocController.getInstance().checkDoctorAvailability(obj.getDoctorID())) {
			return "doctor id Invalid";
		} else {
			HospitalRegDoctorController.getInstance().update(obj);
			return "hospitalRegDoctor Updated";
		}
	}

	@DELETE
	@Path("hospitalRegDoctor/{hospital_reg_doctor_id}")
	public String deleteHospital(@PathParam("hospital_reg_doctor_id") int hospital_reg_doctor_id) throws Exception {
		HospitalRegDoctorModel obj = new HospitalRegDoctorModel();
		obj.setHospital_id(hospital_reg_doctor_id);
		HospitalRegDoctorController.getInstance().delete(obj);
		return "hospitalRegDoctor Deleted";
	}
}
