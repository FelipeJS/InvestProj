package br.com.financas.test;

import br.com.financas.dao.UsuarioDAO;
import br.com.financas.domain.Conta;
import br.com.financas.domain.Usuario;

public class UsuarioDAOTest {

	public Usuario salvar() {
		Usuario usuario = new Usuario();
		Conta conta = new Conta();

		usuario.setNome("Usuario Teste3");
		usuario.setEmail("emailteste3@gmail.com");
		usuario.setSenha("SenhaTeste3");
		conta.setSaldo(0.0);
		conta.setContadorMovimentacao(0);
		usuario.setConta(conta);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		return usuario;
	}

	public void buscarPorCodigo(int codigoTeste) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println(usuarioDAO.buscarPorCodigo(codigoTeste));
	}

	public void excluir(Usuario usuarioTeste) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuarioTeste);
	}

	public void editar(Usuario usuarioTeste) {
		usuarioTeste.setNome("Usuario Editado Teste");
		usuarioTeste.setEmail("emailtesteeditado@gmail.com");
		usuarioTeste.setSenha("SenhaTesteEditada");

		Conta conta = usuarioTeste.getConta();
		conta.somarSaldo(100.00);
		usuarioTeste.setConta(conta);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.editar(usuarioTeste);
	}

	public void autenticar(String usuarioEmail, String usuarioSenha) {
		Usuario usuario = new Usuario();

		usuario.setEmail(usuarioEmail);
		usuario.setSenha(usuarioSenha);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println(usuarioDAO.autenticar(usuario));
	}
}
