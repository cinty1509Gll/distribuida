package com.distribuida.exa.web.actions;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.exa.web.dto.Address;
import com.distribuida.exa.web.dto.Company;
import com.distribuida.exa.web.dto.Usuario;
import com.distribuida.exa.web.servicios.UsuarioService;

import lombok.Getter;

@SessionScoped @Named("usuarioAction")
public class UsuarioAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject private UsuarioService servicio;
	
	@Getter private List<Usuario> usuarios;
	@Getter private Address addressSeleccionado;
	@Getter private Company companySeleccionado;
	
	public String iniciar( ) {
		
		usuarios = servicio.listarTodos();
		
		return "usuarios";
	}
	
	public String detalleAddress( Address dto ) {
		
		addressSeleccionado = servicio.buscarId( dto.getId( ) );
		
		return "address";
	}
	
public String detalleCompany( Company dto ) {
		
		companySeleccionado = servicio.buscarPorId( dto.getId( ) );
		
		return "company";
	}
}
