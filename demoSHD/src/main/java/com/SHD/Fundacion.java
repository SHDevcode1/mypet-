package com.SHD;
import java.io.Serializable;
public class Fundacion implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	
	
	@Override
	public String toString() {
		return "Fundacion [id=" + id + ", fun_name=" + fun_name + ", fun_nit=" + fun_nit + ", fun_email=" + fun_email
				+ ", fun_dir=" + fun_dir + ", fun_cel=" + fun_cel + "]";
	}


	public Fundacion(long id, String fun_name, String fun_nit, String fun_email, String fun_dir, int fun_cel) {
		
		this.id = id;
		this.fun_name = fun_name;
		this.fun_nit = fun_nit;
		this.fun_email = fun_email;
		this.fun_dir = fun_dir;
		this.fun_cel = fun_cel;
	}
	
	
	public Fundacion() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFun_name() {
		return fun_name;
	}
	public void setFun_name(String fun_name) {
		this.fun_name = fun_name;
	}
	public String getFun_nit() {
		return fun_nit;
	}
	public void setFun_nit(String fun_nit) {
		this.fun_nit = fun_nit;
	}
	public String getFun_email() {
		return fun_email;
	}
	public void setFun_email(String fun_email) {
		this.fun_email = fun_email;
	}
	public String getFun_dir() {
		return fun_dir;
	}
	public void setFun_dir(String fun_dir) {
		this.fun_dir = fun_dir;
	}
	public int getFun_cel() {
		return fun_cel;
	}
	public void setFun_cel(int fun_cel) {
		this.fun_cel = fun_cel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String fun_name;
	private String fun_nit;
	private String fun_email;
	private String fun_dir;
	private int fun_cel;
	
}
