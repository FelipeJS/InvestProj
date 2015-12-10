package br.com.financas.test;

import org.junit.Test;

import br.com.financas.domain.Movimentacao;
import br.com.financas.domain.Usuario;

public class RodarTestes {

	@Test
	public void rodarTestes() {
		UsuarioDAOTest usuarioTest = new UsuarioDAOTest();
		MovimentacaoDAOTest movimentacaoTest = new MovimentacaoDAOTest();

		try {
			System.out.println("Iniciando o teste salvar USUARIO...");
			Usuario usuarioTeste = usuarioTest.salvar();
			System.out.println("Teste salvar USUARIO finalizado...\n\n");

			System.out.println("Iniciando o teste salvar MOVIMENTACAO...");
			Movimentacao movimentacaoTeste = movimentacaoTest.salvar(usuarioTeste);
			System.out.println("Teste salvar MOVIMENTACAO finalizado...\n\n");

			System.out.println("Iniciando o teste listar USUARIO...");
			usuarioTest.buscarPorCodigo(usuarioTeste.getCodigo());
			System.out.println("Teste listar USUARIO finalizado...\n\n");

			System.out.println("Iniciando o teste buscar MOVIMENTACAO...");
			movimentacaoTest.buscarPorCodigo(movimentacaoTeste.getCodigo(), usuarioTeste.getCodigo());
			System.out.println("Teste buscar MOVIMENTACAO finalizado...\n\n");

			System.out.println("Iniciando o teste editar MOVIMENTACAO...");
			movimentacaoTeste.setDescricao("Nova Descricao de Teste");
			movimentacaoTeste.setValor(500.00);
			movimentacaoTest.editar(movimentacaoTeste);
			System.out.println("Teste editar MOVIMENTACAO finalizado...\n\n");

			System.out.println("Iniciando o teste listar USUARIO...");
			usuarioTest.buscarPorCodigo(usuarioTeste.getCodigo());
			System.out.println("Teste listar USUARIO finalizado...\n\n");

			System.out.println("Iniciando o teste buscar MOVIMENTACAO...");
			movimentacaoTest.buscarPorCodigo(movimentacaoTeste.getCodigo(), usuarioTeste.getCodigo());
			System.out.println("Teste buscar MOVIMENTACAO finalizado...\n\n");

			System.out.println("Iniciando o teste salvar MOVIMENTACAO...");
			movimentacaoTest.salvar(usuarioTeste);
			System.out.println("Teste salvar MOVIMENTACAO finalizado...\n\n");

			System.out.println("Iniciando o teste listar USUARIO...");
			usuarioTest.buscarPorCodigo(usuarioTeste.getCodigo());
			System.out.println("Teste listar USUARIO finalizado...\n\n");

			System.out.println("Iniciando o teste buscar MOVIMENTACAO...");
			movimentacaoTest.buscarPorCodigo(movimentacaoTeste.getCodigo(), usuarioTeste.getCodigo());
			System.out.println("Teste buscar MOVIMENTACAO finalizado...\n\n");

//			System.out.println("Iniciando o teste listar MOVIMENTACAO...");
//			movimentacaoTest.listar(usuarioTeste.getCodigo());
//			System.out.println("Teste listar MOVIMENTACAO finalizado...\n\n");

			//
			// System.out.println("Iniciando o teste autenticar...");
			// usuarioTest.autenticar(usuarioTeste.getEmail(),
			// usuarioTeste.getSenha());
			// System.out.println("Teste autenticar finalizado...\n\n");
			//
			// System.out.println("Iniciando o teste editar...");
			// usuarioTest.editar(usuarioTeste);
			// usuarioTest.buscarPorCodigo(usuarioTeste.getCodigo());
			// System.out.println("Teste editar finalizado...\n\n");
			//
			// System.out.println("Iniciando o teste excluir...");
			// usuarioTest.excluir(usuarioTeste);
			// System.out.println("Teste excluir finalizado...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
