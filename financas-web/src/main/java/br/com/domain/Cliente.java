package br.com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@NamedQueries({
		@NamedQuery(name = "Cliente.listar", 
				query = "SELECT cliente FROM Cliente cliente"),
		@NamedQuery(name = "Cliente.buscarPorCodigo", 
				query = "SELECT cliente FROM Cliente cliente WHERE cliente.codigo = :codigo"),
		@NamedQuery(name = "Cliente.autenticar", 
				query = "SELECT cliente FROM Cliente cliente "
						+ "WHERE cliente.login = :login AND cliente.senha = :senha") 
})
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int codigo;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 11, nullable = false, unique = true)
	private String cpf;
	
	@Column(length = 45, nullable = false)
	private String login;
	
	@Column(length = 45, nullable = false)
	private String senha;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", login=" + login + ", senha=" + senha
				+ "]";
	}
}
