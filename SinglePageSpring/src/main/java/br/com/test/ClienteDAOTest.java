package br.com.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dao.ClienteDAO;
import br.com.domain.Cliente;

public class ClienteDAOTest {
	@Ignore
	@Test
	public void salvar() {
		Cliente cliente = new Cliente();
		cliente.setNome("Felipe");
		cliente.setLogin("felipe");
		cliente.setSenha("123");
		cliente.setCpf("03389422");

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
	}

	@Ignore
	@Test
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		System.out.println(clienteDAO.listar());
	}

	@Ignore
	@Test
	public void buscarPorCodigo() {
		ClienteDAO clienteDAO = new ClienteDAO();
		System.out.println(clienteDAO.buscarPorCodigo(1));
	}
	
	@Ignore
	@Test
	public void excluir() {
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setNome("Felipe");
		cliente.setLogin("felipe");
		cliente.setSenha("123");
		cliente.setCpf("03389422");

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.excluir(cliente);
	}
	
	@Ignore
	@Test
	public void editar() {
		Cliente cliente = new Cliente();
		cliente.setCodigo(2);
		cliente.setNome("Ronaldo");
		cliente.setLogin("felipe");
		cliente.setSenha("123");
		cliente.setCpf("03389422");

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
	}
	
	
	@Test
	public void autenticar() {
		Cliente cliente = new Cliente();;
		cliente.setLogin("felipejs");
		cliente.setSenha("22222222");

		ClienteDAO clienteDAO = new ClienteDAO();
		System.out.println(clienteDAO.autenticar(cliente)); 
	}
}
