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

import com.distribuida.exa.dto.SingerDto;

@ApplicationScoped
public class ServicioSingerImpl implements ServicioSinger {

	@Inject private DataSource dataSource;
	
	private SingerDto toDto( ResultSet rs ) throws SQLException {
		SingerDto dto = new SingerDto();
		
		dto.setId( rs.getInt("id") );
		dto.setFirstName( rs.getString("first_name"));
		dto.setLastName( rs.getString("last_name"));
		dto.setBirthDate( rs.getDate("birth_date"));
		
		return dto;
	}
	
	@Override
	public List<SingerDto> listar() {
		
		String sql = "select * from singer";
		
		Connection con = null;
		
		List<SingerDto> ret = new ArrayList<>();
		
		try {
			con = dataSource.getConnection();

			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery( sql );
			
			while( rs.next() ) {
				SingerDto dto = toDto( rs );

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
	public SingerDto buscar( Integer id ) {
		
		String sql = "select * from singer where id=?";
		
		Connection con = null;
		
		SingerDto dto = null;
		
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
