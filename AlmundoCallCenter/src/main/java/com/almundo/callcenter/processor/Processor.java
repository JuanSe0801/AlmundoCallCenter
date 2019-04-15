package com.almundo.callcenter.processor;

import com.almundo.callcenter.objects.Call;
import com.almundo.callcenter.thread.CallThread;

public class Processor {

	public static void main(String[] args) {

		int numberCalls = 30;
		
		for(int i=1; i <= numberCalls; i++) {
			int segundos = ((int)(Math.random()*(5-11)+11));
			System.out.println("La llamada durara "+segundos+ " segundos");
			long initialTime = System.currentTimeMillis();
			Call call = new Call(i, "nameUser"+i, ""+i, segundos);
			CallThread callThread = new CallThread(call, initialTime);
			
			callThread.start();
		}
		
	}

}
