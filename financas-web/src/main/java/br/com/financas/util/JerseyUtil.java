package br.com.financas.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class JerseyUtil extends ResourceConfig{
	public JerseyUtil(){
		packages("br.com.financas.service");
	}
}
