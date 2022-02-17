package aplicações;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.Entities.Reservation;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		
		try {
			System.out.print("MAKE YOUR RESERVATION!!!"+"\n"+"--------------------"+"\n");
			System.out.print("Room Number: ");
			int roomnumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy) : ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) : ");
			Date checkout = sdf.parse(sc.next());
			Reservation reservation = new Reservation(roomnumber, checkin, checkout);
			reservation.updateDates(checkin, checkout);
			System.out.println("\n" + reservation +"\n" +"-------------");
			System.out.println("Update Reservations..."+"\n"+"\n");
			System.out.print("Check-in date (dd/MM/yyyy) : ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) : ");
			checkout = sdf.parse(sc.next());		
			reservation.updateDates(checkin, checkout);
			System.out.println("\n" + reservation + "---------FIM----------");
		}catch (ParseException e) {
			System.out.println("[ERRO] Formato inválido");
		}catch (IllegalArgumentException e) {
			System.out.println("[ERRO]" + e.getMessage());
		}
		
		System.out.println("\n"+"---------FIM----------");
		
		
		sc.close();
	}

}
