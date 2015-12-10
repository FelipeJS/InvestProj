package br.com.financas.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "movimentacao")
@NamedQueries({
		@NamedQuery(name = "Movimentacao.listar", query = "SELECT movimentacao FROM Movimentacao movimentacao"
				+ " WHERE movimentacao.codigoUsuario = :codigoUsuario"),
		@NamedQuery(name = "Movimentacao.buscarPorCodigo", query = "SELECT movimentacao FROM Movimentacao movimentacao"
				+ " WHERE movimentacao.codigo = :codigo AND movimentacao.codigoUsuario = :codigoUsuario") })
public class Movimentacao implements Serializable {
	@Id
	private int codigo;

	@Id
	private int codigoUsuario;

	@Column(length = 45, nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Double valor;

	private String data;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Movimentacao [codigo=" + codigo + ", codigoUsuario=" + codigoUsuario + ", descricao=" + descricao
				+ ", valor=" + valor + ", data=" + data + "]";
	}

}
