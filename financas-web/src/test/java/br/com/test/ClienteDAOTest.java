package br.com.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.financas.dao.UsuarioDAO;
import br.com.financas.domain.Usuario;

public class ClienteDAOTest {
	@Ignore
	@Test
	public void salvar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe Campos");
		usuario.setEmail("tecnologiagrave@gmail.com");
		usuario.setSenha("12345");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}

	@Ignore
	@Test
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println(usuarioDAO.listar());
	}

	@Ignore
	@Test
	public void buscarPorCodigo() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println(usuarioDAO.buscarPorCodigo(1));
	}
	
	@Ignore
	@Test
	public void excluir() {
		Usuario usuario = new Usuario();
		usuario.setCodigo(1);
		usuario.setNome("Felipe");
		usuario.setEmail("felipe");
		usuario.setSenha("123");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);
	}
	
	@Ignore
	@Test
	public void editar() {
		Usuario usuario = new Usuario();
		usuario.setCodigo(2);
		usuario.setNome("Ronaldo");
		usuario.setEmail("felipe");
		usuario.setSenha("123");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.editar(usuario);
	}
	
	@Test
	public void autenticar() {
		Usuario usuario = new Usuario();;
		usuario.setEmail("tecnologiagrave@gmail.com");
		usuario.setSenha("12345");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println(usuarioDAO.autenticar(usuario)); 
	}
}
