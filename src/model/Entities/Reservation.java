package model.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.Exeptions.ReservationExceptions;



public class Reservation {
	
	private int roomnumber;
	private Date checkin;
	private Date checkout;
	

	public Reservation(int roomnumber, Date checkin, Date checkout) {
		this.roomnumber = roomnumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}


	public int getRoomnumber() {
		return roomnumber;
	}


	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}


	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut)throws ReservationExceptions {
		Date now = new Date();
		if(!checkout.after(checkin)) {
			throw new ReservationExceptions("Datas inválidas: a data de Check-In deve vir antes do Check-Out.");
		}if(checkin.before(now) || checkOut.before(now)) {
			throw new ReservationExceptions("Datas inválidas: datas devem ser futuras.");
		}
	}

	@Override
	public String toString() {
		return "Reservation: " + "\n" +
				"Room Number: " + roomnumber + "\n" +
				"Check-in: " + sdf.format(checkin) + "\n" +
				"Check-out: " + sdf.format(checkout) + "\n" +
				"duration: " + duration() + " nights" +"\n"+
				"--------------"+"\n";
	}
	
	
	
	
	

}
