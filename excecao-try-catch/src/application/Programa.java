package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exception.DomainException;

public class Programa {

	public static void main(String[] args)  {
			
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reserva reservation = new Reserva(roomNumber, checkin, checkout);
			
			System.out.println("Reservation: " + reservation.toString());
			
			System.out.println("\nEnter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date newCheckin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date newCheckout = sdf.parse(sc.next());
			
			reservation.updateDates(newCheckin, newCheckout);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		sc.close();
	}
}