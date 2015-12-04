package br.com.test;

import org.junit.Test;

import br.com.util.HibernateUtil;

public class GerarTabelasTest {

	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
