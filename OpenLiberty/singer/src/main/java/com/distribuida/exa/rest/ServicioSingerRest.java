package com.distribuida.exa.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.exa.dto.SingerDto;
import com.distribuida.exa.servicios.ServicioSinger;

@Path("/singers")
@ApplicationScoped
@Produces(value=MediaType.APPLICATION_JSON)
public class ServicioSingerRest {

	@Inject private ServicioSinger servicio;
	
	@GET
	public List<SingerDto> listar( ) {
		return servicio.listar();
	}

	@GET
	@Path(value = "/{id}")
	public SingerDto  buscar( @PathParam("id") Integer id ) {
		return servicio.buscar( id );
	}
}
