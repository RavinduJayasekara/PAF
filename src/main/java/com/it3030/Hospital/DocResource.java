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
import Model.DocModel;

@Path("docResource")
public class DocResource {
	@GET
	@Path("docs")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<DocModel> getAllHospitals() throws Exception {
		return DocController.getInstance().searchAll();
	}

	@GET
	@Path("doc/{doctorID}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public DocModel getHospital(@PathParam("doctorID") int doctorID) throws Exception {
		return DocController.getInstance().search(doctorID);
	}

	@POST
	@Path("doc")
	public String saveDoc(DocModel obj) throws Exception {
		DocController.getInstance().save(obj);
		return "doc Saved";
	}

	@PUT
	@Path("doc")
	public String updateDoc(DocModel obj) throws Exception {
		DocController.getInstance().update(obj);
		return "doc Updated";
	}

	@DELETE
	@Path("doc/{doctorID}")
	public String deleteDoc(@PathParam("doctorID") int doctorID) throws Exception {
		DocModel obj = new DocModel();
		obj.setDoctorID(doctorID);
		DocController.getInstance().delete(obj);
		return "doc Deleted";
	}
}
