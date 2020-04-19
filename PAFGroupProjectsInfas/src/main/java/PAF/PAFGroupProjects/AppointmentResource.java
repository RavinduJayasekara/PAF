package PAF.PAFGroupProjects;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Controller.AppointmentController;
import Model.AppointmentModel;

@Path("appointmentResources")
public class AppointmentResource {
		@GET
		@Path("appointment")
		@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		public List<AppointmentModel> getAllAppointment() throws Exception {
			return AppointmentController.getInstance().searchAll();
		}

		@GET
		@Path("appointment/{app_no}")
		@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		public AppointmentModel getAppointment(@PathParam("app_no") int app_no) throws Exception {
			return AppointmentController.getInstance().search(app_no);
		}

		@POST
		@Path("appointment")
		public String saveAppointment(AppointmentModel obj) throws Exception {
			AppointmentController.getInstance().save(obj);
			return "appointment Saved";
		}

		@PUT
		@Path("appointment")
		public String updateAppointment(AppointmentModel obj) throws Exception {
			AppointmentController.getInstance().update(obj);
			return "appointment Updated";
		}

		@DELETE
		@Path("appointment/{app_no}")
		public String deleteAppointment(@PathParam("app_no") int app_no) throws Exception {
			AppointmentModel obj = new AppointmentModel();
			obj.setApp_no(app_no);
			AppointmentController.getInstance().delete(obj);
			return "appointment Deleted";
		}
	


}
