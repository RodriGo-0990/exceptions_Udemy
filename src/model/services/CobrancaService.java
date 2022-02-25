package model.services;

import model.Entities.Cobranca;
import model.Entities.Reservation;

public class CobrancaService {
	private final Double PerHOUR = 5.0;
	private final Double PerDAYS = 15.0;
	private TaxPayment taxServices;
	
	public CobrancaService( TaxPayment tax) {
		this.taxServices = tax;
	}
	public Double getPerHOUR() {
		return PerHOUR;
	}
	public Double getPerDAYS() {
		return PerDAYS;
	}
	public TaxPayment getTaxServices() {
		return taxServices;
	}
	public void setTaxServices(TaxPayment taxServices) {
		this.taxServices = taxServices;
	}

	public void cobrarValorTotal(Reservation reserva) {
		Double basicPayment = 0.0;
		Double tax = 0.0;
		if(reserva.durationHours() <= 12.0){
			
			basicPayment = cobrarHora(reserva);
		}
		
		else{ 
			basicPayment = cobrarDiaria(reserva);
			tax = taxServices.cobrarTaxa(basicPayment);	
		}
		
		reserva.setCobranca(new Cobranca(basicPayment, tax));
	}
	
	
	protected Double cobrarHora(Reservation reserva) {
		Double valor =  Long.valueOf(reserva.durationHours()).doubleValue() * PerHOUR; 	
		return valor;
	}
	
	protected Double cobrarDiaria(Reservation reserva) {
		Double valor = Long.valueOf(reserva.duration()).doubleValue() * PerDAYS;
		return valor;
	}
	
	protected Double cobrarDiariaComTaxa(Reservation reserva) {	
		Double valor = Long.valueOf(reserva.duration()).doubleValue() * PerDAYS;
		return valor += taxServices.cobrarTaxa(valor);
	}
		
}