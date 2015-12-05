package br.com.financas.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;

import br.com.financas.dao.UsuarioDAO;
import br.com.financas.domain.Usuario;

//http://localhost:8888/rest/login POST
@Path("login")
public class AutenticacaoService {

	@POST
	public int autenticar(String json, @Context HttpServletRequest req) {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		try {
			HttpSession sessao = req.getSession(true);
			Usuario autenticado = usuarioDAO.autenticar(usuario);
			if (autenticado != null) {
				sessao.setAttribute("idLogado", autenticado.getCodigo());
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	public boolean verificarAutenticacao(HttpSession sessao) {
		if (sessao.getAttribute("idLogado") != null) {
			return true;
		} else {
			return false;
		}
	}

}
