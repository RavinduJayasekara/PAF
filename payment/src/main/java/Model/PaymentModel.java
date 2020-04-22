package Model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class PaymentModel {
	
	private int pay_id;
	private String ctype;
	private String chname;
	private String cnum;
	private String cexdate;
	private String secnum;
	
	public PaymentModel() {
		super();
	}
	
	public PaymentModel(int pay_id, String ctype, String chname, String cnum,String cexdate, String secnum) {
		super();
		this.pay_id = pay_id;
		this.ctype = ctype;
		this.chname = chname;
		this.cnum = cnum;
		this.cexdate = cexdate;
		this.secnum = secnum;
		
	}
	
	public int getPay_id() {
		return pay_id;
	}

	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getChname() {
		return chname;
	}

	public void setChname(String chname) {
		this.chname = chname;
	}
	
	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public String getCexdate() {
		return cexdate;
	}

	public void setCexdate(String cexdate) {
		this.cexdate = cexdate;
	}

	public String getSecnum() {
		return secnum;
	}

	public void setSecnum(String secnum) {
		this.secnum = secnum;
	}
	
	@Override
	public String toString() {
		return "PaymentModel [pay_id=" + pay_id + ", ctype=" + ctype + ", chname=" + chname + ", cnum=" + cnum +  ", cexdate=" + cexdate + ", secnum=" + secnum + "]";
	}
}
