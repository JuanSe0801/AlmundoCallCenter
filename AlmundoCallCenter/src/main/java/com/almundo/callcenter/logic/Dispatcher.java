package com.almundo.callcenter.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.almundo.callcenter.objects.Call;
import com.almundo.callcenter.objects.Director;
import com.almundo.callcenter.objects.Employee;
import com.almundo.callcenter.objects.Operator;
import com.almundo.callcenter.objects.Supervisor;

public class Dispatcher {
	
	public List<Employee> employees = new ArrayList<Employee>();
	public List<Operator> operators = new ArrayList<Operator>();
	public List<Supervisor> supervisors = new ArrayList<Supervisor>();
	public List<Director> directors = new ArrayList<Director>();
	public AtomicInteger countCalls = new AtomicInteger(0);
	
	List<Employee> employeesSinc = Collections.synchronizedList(new ArrayList<Employee>()); 

	public Dispatcher () {
		this.getAllEmployees ();
	}

	public void dispatchCall (Call call, long initialTime){
		String message = "";
		Employee employee = null;
		int actualCalls = 0;
		try {
			System.out.println("countCalls"+countCalls);
			if(countCalls.get()<=10) {
				employee = findAvailableOperator(call);
				if(employee != null && !employee.isAvailable() ) {
					actualCalls = countCalls.getAndIncrement();
					message = "La llamada fue asignada a un operador";
				}else {
					employee = findAvailableSupervisor(call);
					if(employee != null && !employee.isAvailable() ) {
						actualCalls = countCalls.getAndIncrement();
						message = "La llamada fue asignada a un supervisor";
					}else {
						employee = findAvailableDirector(call);
						if(employee != null && !employee.isAvailable() ) {
							actualCalls = countCalls.getAndIncrement();
							message = "La llamada fue asignada a un director";
						}
					}
				}
				this.timerCall (call.getCallDuration());
				System.out.println("Proceso la llamada " +
						+ call.getIdCall() + "->Tiempo: " 
						+ (System.currentTimeMillis() - initialTime) / 1000 
						+ "seg");
				
				actualCalls = countCalls.getAndDecrement();
			}else {
				Employee nexOperator = waitNextOperator();
				message = "Por favor permanezca en linea durante "+nexOperator.getCallUser().getCallDuration()+ 
						" segundos mientras se le asigna un operador";
				
				System.out.println("Esperando operador..." +
						+ call.getIdCall() + "->Tiempo: " 
						+ (System.currentTimeMillis() - initialTime) / 1000 
						+ "seg");
				
				Thread.sleep(nexOperator.getCallUser().getCallDuration() * 1000);
				System.out.println("Fin de espera...Buscando un nuevo operador" +
						+ call.getIdCall() + "->Tiempo: " 
						+ (System.currentTimeMillis() - initialTime) / 1000 
						+ "seg");
				dispatchCall(call, initialTime);
				
			}
		}catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	
	private void timerCall(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	} 
	
	private Employee findAvailableOperator (Call call) {
		Employee assignedEmployee = null;
		
		for(Employee temp:employees) {
			if(temp instanceof Operator && temp.isAvailable()) {
				temp.setAvailable(false);
				temp.setCallUser(call);
				assignedEmployee = temp;
				break;
			}
		}
		return assignedEmployee;
	}
	
	private Employee findAvailableSupervisor (Call call) {
		Employee assignedEmployee = null;
		for(Employee temp:employees) {
			if(temp instanceof Supervisor && temp.isAvailable()) {
				temp.setAvailable(false);
				temp.setCallUser(call);
				assignedEmployee = temp;
				break;
			}
		}
		return assignedEmployee;
	}
	
	private Employee findAvailableDirector (Call call) {
		Employee assignedEmployee = null;
		for(Employee temp:employees) {
			if(temp instanceof Director && temp.isAvailable()) {
				temp.setAvailable(false);
				temp.setCallUser(call);
				assignedEmployee = temp;
				break;
			}
		}
		return assignedEmployee;
	}
	
	
	private Employee waitNextOperator () {
		int minimalTime = 0;
		Employee nextOperator = null;
		//Se busca el menor tiempo posible
		for(Employee temp:employees) {
			if(!temp.isAvailable()) {
				if(minimalTime == 0) {
					minimalTime = temp.getCallUser().getCallDuration();
					nextOperator = temp;
				}else {
					if(minimalTime > temp.getCallUser().getCallDuration()) {
						minimalTime = temp.getCallUser().getCallDuration();
						nextOperator = temp;
					}
				}
			}
		}
		return nextOperator;
	}
	
	
	private void getAllEmployees() {
		int operators = 6;
		int supervisor = 3;
		int director = 1;
		
		Employee employee = null;
		
		for(int i = 0; i<operators; i++) {
			employee = new Operator(i, "Operator"+i, "AddressOperator"+1, "30060578");
			employees.add(employee);
		}
		
		for(int i = 0; i<supervisor; i++) {
			employee = new Supervisor(i, "Supervisor"+i, "AddressSupervisor"+1, "30060578");
		}
		
		for(int i = 0; i<director; i++) {
			employee = new Director(i, "Director"+i, "AddressDirector"+1, "30060578");
		}
	}

}
