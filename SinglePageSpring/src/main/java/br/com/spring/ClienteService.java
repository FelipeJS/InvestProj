package br.com.spring;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/listar")
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
	
	@RequestMapping("/editar")
	public @ResponseBody Cliente editar(String cadUsuario) {
		String word[] = cadUsuario.split("\\$");

		Cliente cliente = new Cliente();
		cliente.setCodigo(Integer.parseInt(word[0]));
		cliente.setNome(word[1]);
		cliente.setCpf(word[2]);
		cliente.setLogin(word[3]);
		cliente.setSenha(word[4]);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
		return cliente;
	}
	
	@RequestMapping("/buscarPorCodigo")
	public @ResponseBody Cliente buscarPorCodigo(String idCliente) {
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		cliente = clienteDAO.buscarPorCodigo(Integer.parseInt(idCliente));
		return cliente;
	}
	
	@RequestMapping("/autenticar")
	public @ResponseBody Cliente autenticar(String loginSenha) {
		String word[] = loginSenha.split("\\$");
		Cliente cliente = new Cliente();;
		cliente.setLogin(word[0]);
		cliente.setSenha(word[1]);

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente autenticado = clienteDAO.autenticar(cliente); 
		
		return autenticado;
	}

}
