package com.zoomcare.spring.jdbc.model;

public class Employee {

	private long ID;
	private String KEY;
	private String VALUE;
	private long SUPERVISOR_ID;
	
	public Employee() {
		
	}
	
	public Employee(long ID, String KEY, String VALUE, long SUPERVISOR_ID) {
		
		this.ID = ID;
		this.KEY = KEY;
		this.VALUE = VALUE;
		this.SUPERVISOR_ID = SUPERVISOR_ID;
		
	}
	
	public void setID(long ID) {
	    this.ID = ID;
	  }
	  
	  public long getID() {
	    return ID;
	  }
	  
		public String getKEY() {
			return KEY;
		}

		public void setKEY(String KEY) {
			this.KEY = KEY;
		}

		public String getVALUE() {
			return VALUE;
		}

		public void setVALUE(String VALUE) {
			this.VALUE = VALUE;
		}

	  public void setSUPERVISOR_ID(long SUPERVISOR_ID) {
		    this.SUPERVISOR_ID = SUPERVISOR_ID;
		  }
		  
		  public long getSUPERVISOR_ID() {
		    return SUPERVISOR_ID;
		  }
}
