package br.com.financas.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;

import br.com.financas.dao.MovimentacaoDAO;
import br.com.financas.dao.UsuarioDAO;
import br.com.financas.domain.Conta;
import br.com.financas.domain.Movimentacao;
import br.com.financas.domain.Usuario;

//http://localhost:8888/rest/movimentacao GET POST PUT DELETE 
@Path("movimentacao")
public class MovimentacaoService {

	@GET
	public String listar(@Context HttpServletRequest req) {
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		AutenticacaoService login = new AutenticacaoService();
		List<Movimentacao> movimentacoes;

		try {
			HttpSession sessao = req.getSession();
			if (login.verificarAutenticacao(sessao)) {
				int idUsuario = (int) sessao.getAttribute("idLogado");
				movimentacoes = movimentacaoDAO.listar(idUsuario);
			} else {
				return "";
			}
		} catch (Exception e) {
			movimentacoes = null;
		}

		Gson gson = new Gson();
		String json = gson.toJson(movimentacoes);

		return json;
	}

	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") int codigo, @Context HttpServletRequest req) {
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		AutenticacaoService login = new AutenticacaoService();
		Movimentacao movimentacao;

		try {
			HttpSession sessao = req.getSession();
			if (login.verificarAutenticacao(sessao)) {
				int idUsuario = (int) sessao.getAttribute("idLogado");
				movimentacao = movimentacaoDAO.buscarPorCodigo(codigo, idUsuario);
			} else {
				movimentacao = null;
			}
		} catch (Exception e) {
			movimentacao = null;
		}

		Gson gson = new Gson();
		String json = gson.toJson(movimentacao);

		return json;
	}

	@POST
	public int salvar(String json, @Context HttpServletRequest req) {
		Gson gson = new Gson();
		Movimentacao movimentacao = gson.fromJson(json, Movimentacao.class);
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		AutenticacaoService login = new AutenticacaoService();
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		try {
			HttpSession sessao = req.getSession();
			if (login.verificarAutenticacao(sessao)) {
				int idUsuario = (int) sessao.getAttribute("idLogado");
				Usuario usuario = usuarioDAO.buscarPorCodigo(idUsuario);

				Conta conta = usuario.getConta();
				conta.somarSaldo(movimentacao.getValor());
				conta.contarMovimentacao();
				usuario.setConta(conta);
				usuarioDAO.editar(usuario);

				movimentacao.setCodigoUsuario(usuario.getCodigo());
				movimentacao.setCodigo(usuario.getConta().getContadorMovimentacao());
				movimentacaoDAO.salvar(movimentacao);

				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@PUT
	public int editar(String json, @Context HttpServletRequest req) {
		Gson gson = new Gson();
		Movimentacao movimentacao = gson.fromJson(json, Movimentacao.class);
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		AutenticacaoService login = new AutenticacaoService();
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		try {
			HttpSession sessao = req.getSession();
			if (login.verificarAutenticacao(sessao)) {
				int idUsuario = (int) sessao.getAttribute("idLogado");
				Usuario usuario = usuarioDAO.buscarPorCodigo(idUsuario);
				Movimentacao movimentacaoVelha = movimentacaoDAO.buscarPorCodigo(movimentacao.getCodigo(), idUsuario);

				Double valorAjuste = movimentacao.getValor() - movimentacaoVelha.getValor();
				Conta conta = usuario.getConta();
				conta.somarSaldo(valorAjuste);
				usuario.setConta(conta);
				usuarioDAO.editar(usuario);

				movimentacao.setCodigoUsuario(usuario.getCodigo());
				movimentacaoDAO.editar(movimentacao);

				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			return -1;
		}
	}

	@DELETE
	public int excluir(String json, @Context HttpServletRequest req) {
		Gson gson = new Gson();
		Movimentacao movimentacao = gson.fromJson(json, Movimentacao.class);
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		AutenticacaoService login = new AutenticacaoService();
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		try {
			HttpSession sessao = req.getSession();
			if (login.verificarAutenticacao(sessao)) {
				int idUsuario = (int) sessao.getAttribute("idLogado");
				movimentacao = movimentacaoDAO.buscarPorCodigo(movimentacao.getCodigo(), idUsuario);
				Usuario usuario = usuarioDAO.buscarPorCodigo(idUsuario);

				Conta conta = usuario.getConta();
				conta.subtrairSaldo(movimentacao.getValor());
				usuario.setConta(conta);

				movimentacaoDAO.excluir(movimentacao);
				usuarioDAO.editar(usuario);

				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return -1;
		}
	}
}
