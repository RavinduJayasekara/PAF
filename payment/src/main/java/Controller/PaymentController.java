package Controller;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.client.spi.Connector;

import Model.PaymentModel;
import DBConnection.Connector;


public class PaymentController {
	
	
	Connector con = Connector.getInstance();

	private PaymentController() {
	}

	private static final PaymentController obj = new PaymentController();

	public static PaymentController getInstance() {
		return obj;
	}

	public void save(PaymentModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO payment(pay_id,ctype,chname,cnum,cexdate,secnum) VALUES ('" + obj.getPay_id() + "', '"
				+ obj.getCtype() + "', '" + obj.getChname() + "', '" + obj.getCnum() + "', '" + obj.getCexdate() + "', '" + obj.getSecnum() +"')");
	}

	public void update(PaymentModel obj) throws Exception {
		((DBConnection.Connector) con).getConnection();
		((DBConnection.Connector) con).aud("UPDATE payment SET name = '" + obj.getPay_id() + "', '"
				+ obj.getCtype() + "', '" + obj.getChname() + "', '" + obj.getCnum() + "', '" + obj.getCexdate() + "', '" + obj.getSecnum() +"')");
	}

	public void delete(PaymentModel obj) throws Exception {
		((DBConnection.Connector) con).getConnection();
		((DBConnection.Connector) con).aud("DELETE FROM payment WHERE pay_id='" + obj.getPay_id() + "'");
	}

	public List<PaymentModel> searchAll() throws Exception {
		List<PaymentModel> list = new ArrayList<PaymentModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM payment");
		while (rset.next()) {
			PaymentModel obj = new PaymentModel();
			obj.setPay_id(rset.getInt(1));
			obj.setCtype(rset.getString(2));
			obj.setChname(rset.getString(3));
			obj.setCnum(rset.getString(4));
			obj.setCexdate(rset.getString(5));
			obj.setSecnum(rset.getString(6));
			
			list.add(obj);
		}
		return list;
	}

	public PaymentModel search(int pay_id) throws Exception {
		con.getConnection();
		PaymentModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM payment WHERE app_no='" + pay_id + "'");
		while (rset.next()) {
			obj = new PaymentModel();
			obj.setPay_id(rset.getInt(1));
			obj.setCtype(rset.getString(2));
			obj.setChname(rset.getString(3));
			obj.setCnum(rset.getString(4));
			obj.setCexdate(rset.getString(5));
			obj.setSecnum(rset.getString(6));

		}
		return obj;
	}


}
