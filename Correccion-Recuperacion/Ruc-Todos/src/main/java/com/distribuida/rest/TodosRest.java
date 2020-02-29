package com.distribuida.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Todos;
import com.distribuida.service.TodosService;


@Path("/todos")
public class TodosRest {

	@Inject private TodosService todoService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todos> listarTodos() {
		List<Todos> todos = todoService.listarTodos();
		return todos;
	}
}
