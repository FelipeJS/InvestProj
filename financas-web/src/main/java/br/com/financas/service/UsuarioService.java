package br.com.financas.service;

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

import br.com.financas.dao.UsuarioDAO;
import br.com.financas.domain.Usuario;

//http://localhost:8888/rest/usuario GET POST PUT DELETE 
@Path("usuario")
public class UsuarioService {

	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") int codigo, @Context HttpServletRequest req) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		AutenticacaoService login = new AutenticacaoService();
		Usuario usuario;

		try {
			HttpSession sessao = req.getSession();
			if (login.verificarAutenticacao(sessao)) {
				usuario = usuarioDAO.buscarPorCodigo(codigo);
			} else {
				usuario = null;
			}
		} catch (Exception e) {
			usuario = null;
		}

		Gson gson = new Gson();
		String json = gson.toJson(usuario);

		return json;
	}

	@POST
	public int salvar(String json, @Context HttpServletRequest req) {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		AutenticacaoService login = new AutenticacaoService();

		try {
			HttpSession sessao = req.getSession();
			if (login.verificarAutenticacao(sessao)) {
				usuarioDAO.salvar(usuario);
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return -1;
		}
	}

	@PUT
	public int editar(String json, @Context HttpServletRequest req) {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		AutenticacaoService login = new AutenticacaoService();

		try {
			HttpSession sessao = req.getSession();
			if (login.verificarAutenticacao(sessao)) {
				usuarioDAO.editar(usuario);
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
		Usuario usuario = gson.fromJson(json, Usuario.class);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		AutenticacaoService login = new AutenticacaoService();

		try {
			HttpSession sessao = req.getSession();
			if (login.verificarAutenticacao(sessao)) {
				usuario = usuarioDAO.buscarPorCodigo(usuario.getCodigo());
				usuarioDAO.excluir(usuario);
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return -1;
		}
	}
}
