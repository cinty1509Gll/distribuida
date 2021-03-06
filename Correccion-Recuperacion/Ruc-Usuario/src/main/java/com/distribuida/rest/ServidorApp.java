package com.distribuida.rest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

@ApplicationScoped
@ApplicationPath(value="/")
public class ServidorApp extends Application {
	
	public final static String APP_NAME = "users";
	
	@Inject
	@ConfigProperty(name = "server.port", defaultValue = "7001")
	private Integer puerto;
	
	@Inject
	@ConfigProperty(name="consul.server", defaultValue = "localhost")
	private String consulHost;

	@Inject
	@ConfigProperty(name="consul.port", defaultValue = "8500")
	private Integer consulPort;
	
	private String ID = UUID.randomUUID().toString( );

	//JDK11
	@Override
    public Set<Class<?>> getClasses() {
        return Set.of(
                UsuariosRest.class
        );
    }
	
	
	private String getIP( ) {
		try {
			return Inet4Address.getLocalHost().getHostAddress( );
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return "127.0.0.1";
	}
	
	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		
		ConsulClient client = new ConsulClient( consulHost, consulPort );
		
		NewService s = new NewService();
		
		s.setName( APP_NAME );
		s.setId( ID );
		s.setAddress( getIP() );
		s.setPort( puerto );
		
		NewService.Check check = new NewService.Check();
		
		check.setMethod( "GET" );
		check.setHttp( "http://" + getIP() + ":" + puerto + "/ping" );
		check.setInterval( "10s" );
		check.setDeregisterCriticalServiceAfter( "20s" );

		s.setCheck( check );
		
		client.agentServiceRegister(s);
	}
	
	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object dest) {
		ConsulClient client = new ConsulClient( consulHost, consulPort );
		client.agentServiceDeregister( ID );
	}
}