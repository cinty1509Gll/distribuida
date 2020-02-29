package com.distribuida.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.distribuida.conf.Usuario;
import com.distribuida.dto.UsuarioDto;

@Path("/")
@Produces("application/json")
@ApplicationScoped
@Transactional 
public class UsuariosRest {
	
	@PersistenceContext 
	private EntityManager em;
	
	@GET
	@Path("/usuarios")
	public List<UsuarioDto> findAll( ) {
		
		TypedQuery<Usuario> qry = em.createQuery( "select o from Usuario o order by o.id asc", Usuario.class );
		
		List<UsuarioDto> ret = qry.getResultList().stream()
			.map( s->{
				UsuarioDto dto = new UsuarioDto( );
				
				dto.setId( s.getId() );
				dto.setName( s.getName() );
				dto.setUsername( s.getUsername() );
				dto.setEmail( s.getEmail() );
				dto.setAddress( s.getAddress() );
				dto.setPhone( s.getPhone() );
				dto.setWebsite( s.getWebsite() );
				dto.setCompany(s.getCompany() );
				
				return dto;
			})
			.collect( Collectors.toList( ) );

		return ret;
	}
	
	@GET
	@Path("/usuarios/{id}")
	public UsuarioDto findById( @PathParam(value = "id") Integer id ) {
		
		TypedQuery<Usuario> qry = em.createQuery( "select o from Usuario o where o.id=:id", Usuario.class );
		
		qry.setParameter( "id", id );
		
		Usuario s = qry.getSingleResult( );
		
		UsuarioDto dto = new UsuarioDto();
		
		dto.setId( s.getId() );
		dto.setName( s.getName() );
		dto.setUsername( s.getUsername() );
		dto.setEmail( s.getEmail() );
		dto.setAddress( s.getAddress() );
		dto.setPhone( s.getPhone() );
		dto.setWebsite( s.getWebsite() );
		dto.setCompany(s.getCompany() );
		
		return dto;
	}
	
	@GET
	@Path(value="/ping")
	public String ping() {
		return "ok";
	}
}
