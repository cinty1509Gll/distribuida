package com.distribuida.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.distribuida.dto.Todos;

@Dependent
public class TodosServiceImpl implements TodosService{

	@Inject
	private SessionFactory em;
	
	@Override
	public List<Todos> listarTodos() {
		List<Todos> todos;
		Session s= em.openSession();
		todos= s.createQuery("SELECT u FROM todo u", Todos.class).list();
		return todos;
	}

}
