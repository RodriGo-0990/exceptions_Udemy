package model.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private int roomnumber;
	private Date checkin;
	private Date checkout;
	private Date now = new Date();

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
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkin = checkIn;
		this.checkout = checkOut;	
	}
	
	
	public boolean validacaoDeDatas() {
		if(!checkout.after(checkin)) {
			return false;
		}
		return true;
	}
	public boolean validacaoDeDataAtual() {
		if(checkin.before(now)) {
			return false;
		}
		
		return true;
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
