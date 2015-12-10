package br.com.financas.test;

import org.junit.Test;

import br.com.financas.util.HibernateUtil;

public class GerarTabelasTest {
	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
