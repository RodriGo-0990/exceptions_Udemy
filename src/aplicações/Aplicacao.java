package aplicações;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Entities.Reservation;
import model.Exeptions.ReservationExceptions;

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
			System.out.println("\n" + reservation + "-------------");
		}catch (ParseException e) {
			System.out.println("[ERRO] Formato inválido");
		}catch (ReservationExceptions e) {
			System.out.println("[ERRO]" + e.getMessage());
		}catch (InputMismatchException e) {
			System.out.println("[ERRO] Formato inválido");
		}
		
		System.out.println("\n"+"---------FIM----------");
		
		
		sc.close();
	}

}
