package com.distribuida.exa.web.actions;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.exa.web.dto.Todos;
import com.distribuida.exa.web.servicios.TodosService;

import lombok.Getter;

@SessionScoped @Named("todoAction")
public class TodoAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject private TodosService servicio;
	
	@Getter private List<Todos> todos;
	
	
	public String iniciar( ) {
		todos = servicio.listarTodos();
		
		return "todos";
	}
	
	
}
