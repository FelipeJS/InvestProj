package br.com.financas.test;

import br.com.financas.dao.MovimentacaoDAO;
import br.com.financas.dao.UsuarioDAO;
import br.com.financas.domain.Conta;
import br.com.financas.domain.Movimentacao;
import br.com.financas.domain.Usuario;

public class MovimentacaoDAOTest {

	public Movimentacao salvar(Usuario usuario) {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setCodigoUsuario(usuario.getCodigo());
		movimentacao.setDescricao("Movimentacao Teste");
		movimentacao.setData("10/12/2015");
		movimentacao.setValor(200.00);

		Conta conta = usuario.getConta();
		conta.somarSaldo(movimentacao.getValor());
		conta.contarMovimentacao();
		usuario.setConta(conta);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.editar(usuario);

		movimentacao.setCodigo(usuario.getConta().getContadorMovimentacao());

		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		movimentacaoDAO.salvar(movimentacao);

		return movimentacao;
	}

	public void listar(int codigoUsuario) {
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		System.out.println(movimentacaoDAO.listar(codigoUsuario));
	}

	public void buscarPorCodigo(int codigoMov, int codigoUsuario) {
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		System.out.println(movimentacaoDAO.buscarPorCodigo(codigoMov, codigoUsuario));
	}

	public void excluir(Usuario usuarioTeste) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuarioTeste);
	}

	public void editar(Movimentacao movimentacaoNova) {
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		Movimentacao movimentacao = movimentacaoDAO.buscarPorCodigo(movimentacaoNova.getCodigo(),
				movimentacaoNova.getCodigoUsuario());

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(movimentacaoNova.getCodigoUsuario());

		Conta conta = usuario.getConta();
		Double ajuste = movimentacaoNova.getValor() - movimentacao.getValor();
		conta.somarSaldo(ajuste);
		usuario.setConta(conta);
		usuarioDAO.editar(usuario);

		movimentacao.setDescricao(movimentacaoNova.getDescricao());
		movimentacao.setData(movimentacaoNova.getData());
		movimentacao.setValor(movimentacaoNova.getValor());
		movimentacaoDAO.editar(movimentacao);
	}
}
