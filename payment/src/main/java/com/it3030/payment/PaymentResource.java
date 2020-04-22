package com.it3030.payment;

import java.util.List;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import Controller.PaymentController;
import Model.PaymentModel;


@Path("paymentResource")
public class PaymentResource {
	@GET
	@Path("payment")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<PaymentModel> getAllPayment() throws Exception {
		return PaymentController.getInstance().searchAll();
	}

	@GET
	@Path("payment/{pay_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public PaymentModel getPayment(@PathParam("pay_id") int pay_id) throws Exception {
		return PaymentController.getInstance().search(pay_id);
	}

	@POST
	@Path("payment")
	public String savePayment(PaymentModel obj) throws Exception {
		PaymentController.getInstance().save(obj);
		return "payment Saved";
	}

	@PUT
	@Path("payment")
	public String updatePaymnet(PaymentModel obj) throws Exception {
		PaymentController.getInstance().update(obj);
		return "payment Updated";
	}

	@DELETE
	@Path("payment/{pay_id}")
	public String deletePayment(@PathParam("pay_id") int pay_id) throws Exception {
		PaymentModel obj = new PaymentModel();
		obj.setPay_id(pay_id);
		PaymentController.getInstance().delete(obj);
		return "payment Deleted";
	}

}
