package com.distribuida.exa.web.servicios.producers;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.distribuida.exa.web.dto.Address;
import com.distribuida.exa.web.dto.Company;
import com.distribuida.exa.web.dto.Todos;
import com.distribuida.exa.web.dto.Usuario;
import com.distribuida.exa.web.servicios.HttpExaUtils;
import com.distribuida.exa.web.servicios.TodosService;
import com.distribuida.exa.web.servicios.UsuarioService;

@ApplicationScoped
public class ServicioProducer {

	public static final String URL= "http://127.0.0.1:7005";
	

	@Produces
	@ApplicationScoped
	public TodosService todosService() {

		return new TodosService() {

			@Override
			public List<Todos> listarTodos() {
				Todos[] dtos = HttpExaUtils.invoke(URL + "/todos", Todos[].class);
				return Arrays.asList(dtos);
			}

		};
	}

	@Produces
	@ApplicationScoped
	public UsuarioService usuarioService() {

		return new UsuarioService() {

			
			@Override
			public List<Usuario> listarTodos() {
				Usuario[] dtos = HttpExaUtils.invoke(URL + "/usuarios", Usuario[].class);

				return Arrays.asList(dtos);
			}

			@Override
			public Address buscarId(Integer id) {
				// TODO Auto-generated method stub
				return HttpExaUtils.invoke(URL + "/address/" + id, Address.class);
			}

			@Override
			public Company buscarPorId(Integer id) {
				// TODO Auto-generated method stub
				return HttpExaUtils.invoke(URL + "/company/" + id, Company.class);
			}
		};
	}
}
