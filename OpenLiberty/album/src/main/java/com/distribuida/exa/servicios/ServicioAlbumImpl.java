package com.distribuida.exa.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.exa.dto.AlbumDto;



@ApplicationScoped
public class ServicioAlbumImpl implements ServicioAlbum {

	@Inject private DataSource dataSource;
	
	private AlbumDto toDto( ResultSet rs ) throws SQLException {
		AlbumDto dto = new AlbumDto();
		
		dto.setId( rs.getInt("id") );
		dto.setReleaseDate( rs.getDate("release_date"));
		dto.setSingerId( rs.getInt("singer_id"));
		dto.setTitle( rs.getString("title"));
		
		return dto;
	}
	
	@Override
	public List<AlbumDto> listar() {
		
		String sql = "select * from album";
		
		Connection con = null;
		
		List<AlbumDto> ret = new ArrayList<>();
		
		try {
			con = dataSource.getConnection();

			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery( sql );
			
			while( rs.next() ) {
				AlbumDto dto = toDto( rs );
				
				ret.add( dto );
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}
	
	@Override
	public AlbumDto buscar( Integer id ) {
		
		String sql = "select * from album where id=?";
		
		Connection con = null;
		
		AlbumDto dto = null;
		
		try {
			con = dataSource.getConnection();

			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt( 1, id );
			
			ResultSet rs = stmt.executeQuery( );
			
			while( rs.next() ) {
				
				dto = toDto( rs );
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

}
