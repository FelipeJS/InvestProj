package br.com.financas.domain;

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
		@NamedQuery(name = "Usuario.listar", 
				query = "SELECT cliente FROM Usuario cliente"),
		@NamedQuery(name = "Usuario.buscarPorCodigo", 
				query = "SELECT cliente FROM Usuario cliente WHERE cliente.codigo = :codigo"),
		@NamedQuery(name = "Usuario.autenticar", 
				query = "SELECT cliente FROM Usuario cliente "
						+ "WHERE cliente.email = :email AND cliente.senha = :senha") 
})
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int codigo;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 45, nullable = false)
	private String email;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	
}
