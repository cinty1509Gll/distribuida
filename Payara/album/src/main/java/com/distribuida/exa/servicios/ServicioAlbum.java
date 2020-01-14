package com.distribuida.exa.servicios;

import java.util.List;

import com.distribuida.exa.dto.AlbumDto;

public interface ServicioAlbum {
	
	public List<AlbumDto> listar( );
	public AlbumDto buscar( Integer id );

}
