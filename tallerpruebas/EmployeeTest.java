package tallerpruebas;

import static org.junit.Assert.assertEquals;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class EmployeeTest{

	@Test
	//Caso de prueba 1: Calculo de Salarios
	
	//Prueba 1: divisa USD a empleado en mes par/impar
	public void evaluateCSUSDWorker() {
		Employee employee = new Employee(600.0f, "USD", 1.25f, EmployeeType.Worker);
		float salario = employee.cs();
		Date date = new Date();
        LocalDate localDate;
        localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        //mes par
        if(month%2 == 0) assertEquals(600.0f, salario, 0.5f);
        //mes impar
        else{assertEquals(664.3f, salario, 0.5f);}
	}
	@Test
	//Prueba 2: divisa USD a supervisor en mes par/impar
	public void evaluateCSUSDSupervisor() {
		Employee employee = new Employee(600.0f, "USD", 100f, EmployeeType.Supervisor);
		float salario = employee.cs();
		Date date = new Date();
        LocalDate localDate;
        localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        //mes par
        if(month%2 == 0) assertEquals(635.0f, salario, 0.5f);
        //mes impar
        else{assertEquals(699.33, salario, 0.5f);}
	}
	@Test
	//Prueba 3: divisa USD a manager en mes par/impar
	public void evaluateCSUSDManager() {
		Employee employee = new Employee(600.0f, "USD", 100f, EmployeeType.Manager);
		float salario = employee.cs();
		Date date = new Date();
        LocalDate localDate;
        localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        //mes par
        if(month%2 == 0) assertEquals(670.0f, salario, 0.5f);
        //mes impar
        else{assertEquals(734.33, salario, 0.5f);}
	}
	
	
	
	//Caso de prueba 2: calculo del bono de fin de a�o
	
	@Test
	//Prueba 3: divisa USD a manager 
	public void evaluateCalcularBonoUSDManager() {
		Employee employee = new Employee(600.0f, "USD", 100f, EmployeeType.Manager);
		float salario = employee.CalculateYearBonus();
		assertEquals(986.0f, salario, 0.5f);

	}

	@Test
	//Prueba 4: aplica descuento por cambio de moneda a worker
	public void evaluateCalcularConDescuentoWorker() {
		Employee employee = new Employee(600.0f, "EU", 100f, EmployeeType.Worker);
		float salario = employee.CalculateYearBonus();
		assertEquals(386.0f, salario, 0.5f);
	}
	

}
