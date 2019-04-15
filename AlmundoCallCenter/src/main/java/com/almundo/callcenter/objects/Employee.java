package com.almundo.callcenter.objects;

public class Employee {

	private int id;
	
	private String name;
		
	private String address;
	
	private String cellphoneNumber;
	
	private boolean available;
	
	private String typeEmployee;
	
	private Call callUser;
	
	public Employee () {
		
	}

	

	public Employee(int id, String name, String address, String cellphoneNumber, boolean available, String typeEmployee,
			Call callUser) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.cellphoneNumber = cellphoneNumber;
		this.available = available;
		this.typeEmployee = typeEmployee;
		this.callUser = callUser;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the cellphoneNumber
	 */
	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	/**
	 * @param cellphoneNumber the cellphoneNumber to set
	 */
	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}
	
	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	
	
	/**
	 * @return the callUser
	 */
	public Call getCallUser() {
		return callUser;
	}

	/**
	 * @param callUser the callUser to set
	 */
	public void setCallUser(Call callUser) {
		this.callUser = callUser;
	}



	/**
	 * @return the typeEmployee
	 */
	public String getTypeEmployee() {
		return typeEmployee;
	}



	/**
	 * @param typeEmployee the typeEmployee to set
	 */
	public void setTypeEmployee(String typeEmployee) {
		this.typeEmployee = typeEmployee;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", cellphoneNumber=" + cellphoneNumber
				+ ", available=" + available + ", typeEmployee=" + typeEmployee + ", callUser=" + callUser + "]";
	}

	

	
	
}
