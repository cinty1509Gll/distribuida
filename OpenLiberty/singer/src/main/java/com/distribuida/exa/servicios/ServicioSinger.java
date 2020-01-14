package com.distribuida.exa.servicios;

import java.util.List;

import com.distribuida.exa.dto.SingerDto;

public interface ServicioSinger {
	
	public List<SingerDto> listar( );
	public SingerDto buscar( Integer id );

}
