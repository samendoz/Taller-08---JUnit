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
	Date date = new Date();
   	 LocalDate localDate = date.toInstant()
            .atZone(ZoneId.systemDefault()).toLocalDate();
    	int month = localDate.getMonthValue();
	
	@Test
	//Caso de prueba para retorno nulo con worker
	public void evaluatesNullW() {
		Employee employee= new Employee(500,"noUSD", 
			        100f, EmployeeType.Worker);
		assertNotNull("objeto nulo",employee);
	}
	@Test
	//Caso de prueba para retorno nulo con supervisor
	public void evaluatesNullS() {
		Employee employee= new Employee(500,"noUSD", 
			        100f, EmployeeType.Supervisor);
		assertNotNull("objeto nulo",employee);
	}
	@Test
	//Caso de prueba para retorno nulo con manager
	public void evaluatesNullM() {
		Employee employee= new Employee(500,"noUSD", 
			        100f, EmployeeType.Manager);
		assertNotNull("objeto nulo",employee);
	}
	
	@Test
	//Caso de prueba en cs para no USD con Worker en mes par/impar
	public void evaluatesExpressionNUW() {
		Employee employee= new Employee(500,"noUSD", 
			        100f, EmployeeType.Worker);
		float salario= employee.cs();
		if(month%2==0) {
			assertEquals(475, salario, 0.5);
		}else {
			assertEquals(539.33, salario, 0.5);	
		}
	}
	@Test
	//Caso de prueba en cs para no USD con Supervisor en mes par/impar
	public void evaluatesExpressionNUS() {
		Employee employee= new Employee(500,"noUSD", 
		        100f, EmployeeType.Supervisor);
		float salario= employee.cs();
		if(month%2==0) {
			assertEquals(510, salario, 0.5);
		}else {
			assertEquals(574.33, salario, 0.5);	
		}
	}
	@Test
	//Caso de prueba en cs para no USD con Manager en mes par/impar
	public void evaluatesExpressionNUM() {
		Employee employee= new Employee(500,"noUSD", 
		        100f, EmployeeType.Manager);
		float salario= employee.cs();
		if(month%2==0) {
			assertEquals(545, salario, 1);
		}else {
			assertEquals(610.33, salario, 1);	
		}
	}
	
	@Test
	//Caso de prueba 1: Calculo de Salarios
	
	//Prueba 1: divisa USD a empleado en mes par/impar
	public void evaluateCSUSDWorker() {
		Employee employee = new Employee(600.0f, "USD", 1.25f, EmployeeType.Worker);
		float salario = employee.cs();
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
        //mes par
        if(month%2 == 0) assertEquals(670.0f, salario, 0.5f);
        //mes impar
        else{assertEquals(734.33, salario, 0.5f);}
	}
	
	
	
	//Caso de prueba 2: calculo del bono de fin de año
	
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
