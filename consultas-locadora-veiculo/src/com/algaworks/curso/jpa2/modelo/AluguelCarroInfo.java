package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;

public class AluguelCarroInfo {
	
	private Carro carro;
	private Long totalAlugueis;
	private BigDecimal valorMaximo;
	private BigDecimal valorMedio;
	private BigDecimal valorTotal;
	
	public AluguelCarroInfo(Carro carro, Long totalAlugueis, Number valorMaximo, Number valorMedio, Number valorTotal) {
		this.carro = carro;
		this.totalAlugueis = totalAlugueis;
		this.valorMaximo = BigDecimal.valueOf(valorMaximo.doubleValue());
		this.valorMedio = BigDecimal.valueOf(valorMedio.doubleValue());;
		this.valorTotal = BigDecimal.valueOf(valorTotal.doubleValue());;
	}
	
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Long getTotalAlugueis() {
		return totalAlugueis;
	}
	public void setTotalAlugueis(Long totalAlugueis) {
		this.totalAlugueis = totalAlugueis;
	}
	public BigDecimal getValorMaximo() {
		return valorMaximo;
	}
	public void setValorMaximo(BigDecimal valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	public BigDecimal getValorMedio() {
		return valorMedio;
	}
	public void setValorMedio(BigDecimal valorMedio) {
		this.valorMedio = valorMedio;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
