package br.com.financas.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Conta {
	@Column(nullable = false)
	private Double saldo;

	@Column(nullable = false)
	private int contadorMovimentacao;

	public void somarSaldo(Double valor) {
		this.saldo += valor;
	}
	
	public void subtrairSaldo(Double valor) {
		this.saldo -= valor;
	}
	
	public void contarMovimentacao() {
		this.contadorMovimentacao += 1;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public int getContadorMovimentacao() {
		return contadorMovimentacao;
	}

	public void setContadorMovimentacao(int contadorMovimentacao) {
		this.contadorMovimentacao = contadorMovimentacao;
	}

	@Override
	public String toString() {
		return "Conta [saldo=" + saldo + ", contadorMovimentacao=" + contadorMovimentacao + "]";
	}

}
