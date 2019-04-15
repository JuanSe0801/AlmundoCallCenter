package com.almundo.callcenter.thread;

import java.util.concurrent.atomic.AtomicInteger;

import com.almundo.callcenter.logic.Dispatcher;
import com.almundo.callcenter.objects.Call;
import com.almundo.callcenter.objects.CallResponse;

public class CallThread extends Thread{
	
	private Call call;
	
	private long initialTime;

	
	
	
	public CallThread(Call call, long initialTime ) {
		super();
		this.call = call;
		this.initialTime = initialTime;
	}



	public void run() {
			System.out.println("LA LLAMADA " + this.call.getIdCall() + " COMIENZA A PROCESAR " 
					+ " EN EL TIEMPO: " 
					+ (System.currentTimeMillis() - this.initialTime) / 1000 
					+ "seg");
			Dispatcher dispatcher = new Dispatcher();
			dispatcher.dispatchCall(call, this.initialTime);
			System.out.println("LA LLAMADA " + this.call.getIdCall() + " TERMINA DE PROCESAR " 
					+ " EN EL TIEMPO: " 
					+ (System.currentTimeMillis() - this.initialTime) / 1000 
					+ "seg");

	}



	/**
	 * @return the call
	 */
	public Call getCall() {
		return call;
	}



	/**
	 * @param call the call to set
	 */
	public void setCall(Call call) {
		this.call = call;
	}



	/**
	 * @return the initialTime
	 */
	public long getInitialTime() {
		return initialTime;
	}



	/**
	 * @param initialTime the initialTime to set
	 */
	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	
	
}
