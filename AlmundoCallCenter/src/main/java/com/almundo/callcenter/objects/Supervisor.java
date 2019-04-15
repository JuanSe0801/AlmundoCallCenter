package com.almundo.callcenter.objects;

public class Supervisor extends Employee{

	private int id;
	
	private String name;
		
	private String address;
	
	private String cellphoneNumber;
	
	public Supervisor(int id, String name, String address, String cellphoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.cellphoneNumber = cellphoneNumber;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Supervisor [id=" + id + ", name=" + name + ", address=" + address + ", cellphoneNumber="
				+ cellphoneNumber + "]";
	}
	
	
	
}
