package tallerpruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
	
	
	
	//Caso de prueba 2: Calculo del bono de fin de aÃ±o
	
	@Test
	//Prueba 1: Divisa USD a Worker
	public void evaluateCalcularBonoUSDWorker() {
		Employee employee = new Employee(650.0f, "USD", 100f, EmployeeType.Worker);
		float salario = employee.CalculateYearBonus();
		assertEquals(500.0f, salario, 0.5f);
	}
	
	@Test
	//Prueba 2: Divisa USD a Supervisor
	public void evaluateCalcularBonoUSDSupervisor() {
		Employee employee = new Employee(650.0f, "USD", 100f, EmployeeType.Supervisor);
		float salario = employee.CalculateYearBonus();
		assertEquals(450.0f, salario, 0.5f);
	}
	
	@Test
	//Prueba 3: Divisa USD a Manager 
	public void evaluateCalcularBonoUSDManager() {
		Employee employee = new Employee(600.0f, "USD", 100f, EmployeeType.Manager);
		float salario = employee.CalculateYearBonus();
		assertEquals(986.0f, salario, 0.5f);

	}

	@Test
	//Prueba 4: Aplica descuento por cambio de moneda a worker
	public void evaluateCalcularConDescuentoWorker() {
		Employee employee = new Employee(600.0f, "EU", 100f, EmployeeType.Worker);
		float salario = employee.CalculateYearBonus();
		assertEquals(386.0f, salario, 0.5f);
	}
	
	//Prueba 5: Calcula el bono de fin de año de un supervisor
	@Test
	public void evaluateCalcularYearBonusSupervisor() {
		Employee employee = new Employee(750.0f, "noUSD", 100f, EmployeeType.Supervisor);
		float salario=employee.CalculateYearBonus();
		assertEquals(905.5f,salario,0.5f);
	}
	
	//Prueba 6: Calcula el bono de fin de año de un Manager
		@Test
		public void evaluateCalcularYearBonusManager() {
			Employee employee = new Employee(850.0f, "noUSD", 100f, EmployeeType.Manager);
			float salario=employee.CalculateYearBonus();
			assertEquals(1193.5f,salario,0.5f);
		}

}
