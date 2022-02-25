package model.services;

public class TaxPayment {
	public double cobrarTaxa(Double valor) { 
		if(valor < 100) {
			valor = valor * 0.2;
		}else {
			valor = valor * 0.15;
		}
		return valor;
	}
}
