package aplicações;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Entities.Reservation;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("MAKE YOUR RESERVATION!!!"+"\n"+"--------------------"+"\n");
		System.out.print("Room Number: ");
		int roomnumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy) : ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy) : ");
		Date checkout = sdf.parse(sc.next());
		Reservation reservation = new Reservation(roomnumber, checkin, checkout);
		
		if(reservation.validacaoDeDatas() && reservation.validacaoDeDataAtual()) {
		System.out.println("\n" + reservation +"\n" +"-------------");
		}else {
			System.out.println("erro: datas inválidas.");
		}
		
		System.out.println("Update Reservations..."+"\n"+"\n");
		System.out.print("Check-in date (dd/MM/yyyy) : ");
		checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy) : ");
		checkout = sdf.parse(sc.next());		
		reservation.updateDates(checkin, checkout);
		if(reservation.validacaoDeDatas() && reservation.validacaoDeDataAtual()) {
			System.out.println("\n" + reservation + "---------FIM----------");
		}
		else {
			System.out.println("erro: datas inválidas.");
		}
		System.out.println("\n"+"---------FIM----------");
		
		
		sc.close();
	}

}
