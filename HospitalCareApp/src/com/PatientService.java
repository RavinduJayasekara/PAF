package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Patient;

@Path("/Patient")
public class PatientService {

	Patient patient = new Patient();

	//retrieve all patients information 
	
	@GET
	@Path("/all")
	@Produces(MediaType.TEXT_HTML)
	public String readPatients() {
		return patient.retrievePatients();
	}
	
	// retrieve information of a selected patient
	
	@GET
	@Path("/fromID")
	@Produces(MediaType.TEXT_HTML)
	public String getPatientFromId(String data)
	{

		Document document = Jsoup.parse(data, "", Parser.htmlParser());
		
		String patientID = document.select("patientID").text();
		
		String output = patient.getPatientFromId(patientID);
		
		return output;
		
	}
	
	//retrieve information giving id as the path variable
	
	@GET
	@Path("/username/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String FromId(@PathParam("id") String id)
	{
		return patient.getPatientFromId(id);
	}


	// login to the system using an xml document
	
	@GET
	@Path("/login")
	@Produces(MediaType.TEXT_HTML)
	public String login(String data) {
		
		Document document = Jsoup.parse(data, "", Parser.xmlParser());
		
		String username = document.select("patientUserName").text();
		String password = document.select("patientPassword").text();
		
		System.out.println(username + "\n" + password);
		
		String result = patient.login(username, password);
		System.out.println(result);
		return result;
	}
	
	// login to the system using address bar as parameters
	
	@GET
	@Path("/login1/{username}/{password}")
	@Produces(MediaType.TEXT_HTML)
	public String login(@PathParam("username") String username,
						@PathParam("password") String password) {
		return patient.login(username, password);
	}

	// get doctor name of a selected patient using patirnt's username
	
	@GET
	@Path("/doctor/{username}")
	@Produces(MediaType.TEXT_HTML)
	public String getDoctorName(@PathParam("username") String username) {
		
		String result = patient.getDoctorName(username);
		
		return result;
		
	}
	
	// get payment details of a selected patient using patient's username

	@GET
	@Path("/payment/{username}")
	@Produces(MediaType.TEXT_HTML)
	public String getPaymentDetails(@PathParam("username") String username) {

		String result = patient.getPaymentDetails(username);
		
		return result;
		
	}
	
	//get appointments which has taken place from the patient
	
	@GET
	@Path("/appointment/{username}")
	@Produces(MediaType.TEXT_HTML)
	public String getAppointmentNames(@PathParam("username") String username) {

		String result = patient.getAppointmentNames(username);
		
		return result;
		
	}

	//patient insert
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(@FormParam("patientID") String patientID,
							@FormParam("patientName") String patientName,
							@FormParam("patientContact") String patientContact,
							@FormParam("patientAddress") String patientAddress,
							@FormParam("patientEmail") String patientEmail)
	{
		String insertResult = patient.insertPatient(patientID, patientName, patientContact, patientAddress, patientEmail);
		return insertResult;
	}

	
	
	//delete patient
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String data) 
	{
		Document document = Jsoup.parse(data, "", Parser.htmlParser());
		
		String patientID = document.select("patientID").text();
		
		String output = patient.deletePatient(patientID);
		
		return output;
	}
	
	//update patient object
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String patientData)
	{
		// convert patientData to a JSON object(patientObject)
		
		JsonObject patientObject = new JsonParser().parse(patientData).getAsJsonObject(); 
		
		// retrieve values form the JSON object(patientObject)
		
		String patientID = patientObject.get("patientID").getAsString();
		String patientName = patientObject.get("patientName").getAsString();
		String patientContact = patientObject.get("patientContact").getAsString();
		String patientAddress = patientObject.get("patientAddress").getAsString();
		String patientEmail = patientObject.get("patientEmail").getAsString();
		
		String result = patient.updatePatient(patientID, patientName, patientContact, patientAddress, patientEmail);
		
		return result;
		
	}
	

	
}
