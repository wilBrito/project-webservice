package com.cursoJavaEx.projectwebservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cursoJavaEx.projectwebservice.entity.Empleado;

public class EmpleadoService {
	

	public Empleado consultarEmpleadoPorId(String numEmpleado) {
		List<Empleado> listEmple = this.listEmpleado();
		
		for (Empleado i : listEmple) {
			if(i.getNumeroEmpleado().equals(numEmpleado)) {
				return i;
			}
		}
		
		return null;
		
	}
	
	public Empleado consultarEmpleado() {
		 Empleado empleado = new Empleado("1","Diego", "Lopez", "Brito", 21, LocalDateTime.now());
		 return empleado;
	}
	
	public List<Empleado> listEmpleado(){
		List<Empleado> listEmple = new ArrayList<Empleado>();
		
		Empleado empl1 = new Empleado("2","Erik", "Lop", "Zar", 26, LocalDateTime.now());
		Empleado empl2 = new Empleado("3","E", "p", "r", 6, LocalDateTime.now());
		
		listEmple.add(empl1);
		listEmple.add(empl2);
		
		return listEmple;
	}
	
	

}
