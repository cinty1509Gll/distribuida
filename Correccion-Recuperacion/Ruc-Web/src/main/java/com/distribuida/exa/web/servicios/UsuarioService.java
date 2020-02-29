package com.distribuida.exa.web.servicios;

import java.util.List;

import com.distribuida.exa.web.dto.Address;
import com.distribuida.exa.web.dto.Company;
import com.distribuida.exa.web.dto.Usuario;

public interface UsuarioService {

	List<Usuario> listarTodos();
	
	Address buscarId(Integer id);
	
	Company buscarPorId(Integer id);
}
