package com.almundo.callcenter.objects;

public class Call {

	private int idCall;
	
	private String nameUserCall;
	
	private String phoneUserCall;
	
	private int callDuration;

	public Call(int idCall, String nameUserCall, String phoneUserCall, int callDuration) {
		super();
		this.idCall = idCall;
		this.nameUserCall = nameUserCall;
		this.phoneUserCall = phoneUserCall;
		this.callDuration = callDuration;
	}

	/**
	 * @return the idCall
	 */
	public int getIdCall() {
		return idCall;
	}

	/**
	 * @param idCall the idCall to set
	 */
	public void setIdCall(int idCall) {
		this.idCall = idCall;
	}

	/**
	 * @return the nameUserCall
	 */
	public String getNameUserCall() {
		return nameUserCall;
	}

	/**
	 * @param nameUserCall the nameUserCall to set
	 */
	public void setNameUserCall(String nameUserCall) {
		this.nameUserCall = nameUserCall;
	}

	/**
	 * @return the phoneUserCall
	 */
	public String getPhoneUserCall() {
		return phoneUserCall;
	}

	/**
	 * @param phoneUserCall the phoneUserCall to set
	 */
	public void setPhoneUserCall(String phoneUserCall) {
		this.phoneUserCall = phoneUserCall;
	}
	
	/**
	 * @return the callDuration
	 */
	public int getCallDuration() {
		return callDuration;
	}

	/**
	 * @param callDuration the callDuration to set
	 */
	public void setCallDuration(int callDuration) {
		this.callDuration = callDuration;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Call [idCall=" + idCall + ", nameUserCall=" + nameUserCall + ", phoneUserCall=" + phoneUserCall
				+ ", callDuration=" + callDuration + "]";
	}
	
	
	
}
