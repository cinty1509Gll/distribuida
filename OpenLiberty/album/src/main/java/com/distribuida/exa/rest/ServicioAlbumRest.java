package com.distribuida.exa.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.exa.dto.AlbumDto;
import com.distribuida.exa.servicios.ServicioAlbum;

@Path("/albums")
@ApplicationScoped
@Produces(value=MediaType.APPLICATION_JSON)
public class ServicioAlbumRest {

	@Inject private ServicioAlbum servicio;
	
	@GET
	public List<AlbumDto> listar( ) {
		return servicio.listar();
	}
	
	@GET
	@Path(value = "/{id}")
	public AlbumDto  buscar( @PathParam("id") Integer id ) {
		return servicio.buscar( id );
	}
}
