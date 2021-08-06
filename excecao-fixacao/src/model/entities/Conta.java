package model.entities;

import model.exception.SaqueException;

public class Conta {
	
	private Integer numero;
	private String nome;
	private Double valorTotal;
	private Double limiteSaque;
	
	public Conta() {
		super();
	}
	
	public Conta(Integer numero, String nome, Double valorTotal, Double limiteSaque) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.valorTotal = valorTotal;
		this.limiteSaque = limiteSaque;
	}
	
	public void deposito(Double quantia) {
		this.valorTotal += quantia;
	}
	
	public void saque(Double quantia) {
		if (limiteSaque < quantia) {
			throw new SaqueException("A quantidade requerida excedeu o limite de saque.");
		}
		if (quantia > valorTotal) {
			throw new SaqueException("Saude insuficiente.");
		}
		
		this.valorTotal -= quantia;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public Double getValorTotal() {
		return valorTotal;
	}
}
