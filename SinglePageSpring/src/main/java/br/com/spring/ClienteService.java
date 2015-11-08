package br.com.spring;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dao.ClienteDAO;
import br.com.domain.Cliente;

@Controller
public class ClienteService {

	@RequestMapping("/salvar")
	public @ResponseBody Cliente salvar(String cadUsuario) {
		String word[] = cadUsuario.split("\\$");

		Cliente cliente = new Cliente();
		cliente.setNome(word[0]);
		cliente.setCpf(word[1]);
		cliente.setLogin(word[2]);
		cliente.setSenha(word[3]);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		return cliente;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody ArrayList<Cliente> listar() {
		ArrayList<Cliente> list = new ArrayList<>();
		ClienteDAO clienteDAO = new ClienteDAO();

		list = clienteDAO.listar();
		return list;
	}

	@RequestMapping("/apagar")
	public @ResponseBody String apagar(String usuario) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente clienteMontado = new Cliente();
		
		int codigo = Integer.parseInt(usuario);
		clienteMontado = clienteDAO.buscarPorCodigo(codigo);
		clienteDAO.excluir(clienteMontado);

		return "Usuario apagado com sucesso";
	}

}
