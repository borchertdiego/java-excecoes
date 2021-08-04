package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reserva {

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {
	}
	
	public Reserva(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public long duration() {
	//	Faz a diferen�a entre a data final e a inicial em milisegundos
	//	e depois converte para dias usando a fun��o TimeUnit
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates.");
		}
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out must be after check-in date");
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Date getCheckin() {
		return checkin;
	}
	
	public Date getCheckout() {
		return checkout;
	}
	
	@Override
	public String toString() {
		return "Room "
			 + roomNumber
			 + ", check-in: "
			 + sdf.format(checkin)
			 + ", check-out: "
			 + sdf.format(checkout)
			 + ", "
			 + TimeUnit.DAYS.toDays(duration())
			 + " nights";
	}
}