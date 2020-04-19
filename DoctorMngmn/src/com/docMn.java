package com;

import model.DoctorM;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/DoctorM")
public class docMn {

	DoctorM DoctorMObj = new DoctorM();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctorM() {
		return DoctorMObj.readDoctorM();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctorM(
			@FormParam("doctorName") String doctorName, 
			@FormParam("pantientID") String pantientID,
			@FormParam("pantientName") String pantientName,
			@FormParam("date") String date,
			@FormParam("time") String time, 
			@FormParam("price") String price, 
			@FormParam("des") String des) {
		String output = DoctorMObj.insertDoctorM(doctorName, pantientID, pantientName, date, time, price, des);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctorM(String doctorData) {
		// Convert the input string to a JSON object
		JsonObject DoctorObject = new JsonParser().parse(doctorData).getAsJsonObject();
		// Read the values from the JSON object
		String docId = DoctorObject.get("docId").getAsString();
		String doctorName = DoctorObject.get("doctorName").getAsString();
		String pantientID = DoctorObject.get("pantientID").getAsString();
		String pantientName = DoctorObject.get("pantientName").getAsString();
		String date = DoctorObject.get("date").getAsString();
		String time = DoctorObject.get("time").getAsString();
		String price = DoctorObject.get("price").getAsString();
		String des = DoctorObject.get("des").getAsString();
		String output = DoctorMObj.updateDoctorM(docId, doctorName, pantientID, pantientName, date, time, price, des);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctorM(String doctorData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(doctorData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String docId = doc.select("docId").text();
		String output = DoctorMObj.deleteDoctorM(docId);
		return output;
	}
//finish
}
