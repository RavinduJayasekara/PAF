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

import Model.HospitalModel;

import Controller.HospitalController;

@Path("hospitalResources")
public class HospitalResource {
	@GET
	@Path("hospitals")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<HospitalModel> getAllHospitals() throws Exception {
		return HospitalController.getInstance().searchAll();
	}

	@GET
	@Path("hospital/{hospital_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public HospitalModel getHospital(@PathParam("hospital_id") int hospital_id) throws Exception {
		return HospitalController.getInstance().search(hospital_id);
	}

	@POST
	@Path("hospital")
	public String saveHospital(HospitalModel obj) throws Exception {
		HospitalController.getInstance().save(obj);
		return "hospital Saved";
	}

	@PUT
	@Path("hospital")
	public String updateHospital(HospitalModel obj) throws Exception {
		HospitalController.getInstance().update(obj);
		return "hospital Updated";
	}

	@DELETE
	@Path("hospital/{hospital_id}")
	public String deleteHospital(@PathParam("hospital_id") int hospital_id) throws Exception {
		HospitalModel obj = new HospitalModel();
		obj.setHospital_id(hospital_id);
		HospitalController.getInstance().delete(obj);
		return "hospital Deleted";
	}
}
