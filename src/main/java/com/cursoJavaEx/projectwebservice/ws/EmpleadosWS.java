package com.cursoJavaEx.projectwebservice.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cursoJavaEx.projectwebservice.entity.Empleado;
import com.cursoJavaEx.projectwebservice.service.EmpleadoService;

@Path("empleadosWS")
public class EmpleadosWS {
	
	private EmpleadoService eSer = new EmpleadoService();
			
	
	
	@Path("test")
	@GET
	public String test() {
		return "probando webservices con Jersey";
	}
	
	
	@Path("consultarEmpleado")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleado() {
		return this.eSer.consultarEmpleado();
	}
	
	
	@Path("consultarListaEmpleado")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Empleado> consultarListaEmpleado() {
		return this.eSer.listEmpleado();
	}
	
	
	@Path("consultarEmpleadoRecibiendoInfo/{numEmp}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleadoRecibiendoInfo(@PathParam("numEmp") String numeroEmpleado) {
		return this.eSer.consultarEmpleadoPorId(numeroEmpleado);
	}
	
	
	@Path("consultarEmpleadoRecibiendoInfoResponse/{numEmp}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoRecibiendoInfoResponse(@PathParam("numEmp") String numeroEmpleado) {
		Empleado emplConsul =  this.eSer.consultarEmpleadoPorId(numeroEmpleado);
		
		if(emplConsul == null)
			return Response.noContent().build();
		
		GenericEntity<Empleado> empleadoGene = new GenericEntity<Empleado>(emplConsul, Empleado.class);
		return Response.ok(empleadoGene).build();
	}

	
	@Path("guardarEmpleado")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEmpleado(Empleado empleado) {
		if(empleado == null)
			return Response.status(400).entity("No se ingresoinfo del empleado").build();
		
		if(empleado.getNombre() == null || empleado.getNombre().isEmpty())
			return Response.status(400).entity("Nombre requerido").build();
		
		
		GenericEntity<Empleado> empleadoGene = new GenericEntity<Empleado>(empleado, Empleado.class);
		return Response.ok(empleadoGene).build();
	}

}
