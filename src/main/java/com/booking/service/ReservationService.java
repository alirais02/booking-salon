package com.booking.service;

import java.util.List;

import com.booking.models.*;

public class ReservationService {
	private static int lastOrderId = 0;
    public static void createReservation(){
    	PrintService.showAllCustomer(MenuService.personList);
    	Customer customer = ValidationService.validateCustomerId(MenuService.personList, MenuService.input);
    	System.out.println();
    	PrintService.showAllEmployee(MenuService.personList);
    	Employee employee = ValidationService.validateEmployeeId(MenuService.personList, MenuService.input);
    	System.out.println();
    	PrintService.printAllServices(MenuService.serviceList);
    	List<Service> service = ValidationService.validateServiceId(MenuService.serviceList, MenuService.input);
    	
    	String workstage = "In Process";
    	
    	lastOrderId++;
		String reservationId = String.format("Rsv-%02d", lastOrderId);
		
		Reservation reservation = new Reservation(reservationId, customer, employee, service, workstage);
		MenuService.reservationList.add(reservation);
		System.out.println("Resevation berhasil dibuat");
		System.out.printf("Total Booking : Rp%.0f\n", reservation.getReservationPrice());
    }

    public static void editReservationWorkstage(){
    	
    	PrintService.showRecentReservation(MenuService.reservationList);
    	
        Reservation reservation = ValidationService.validationReservationId(MenuService.reservationList, MenuService.input);
        
        String workstage = ValidationService.validationWorkstage(MenuService.input);
        
        reservation.setWorkstage(workstage);
        
        System.out.println("Reservasi dengan Id "+reservation.getReservationId()+" Sudah "+workstage);
    }

    // Silahkan tambahkan function lain, dan ubah function diatas sesuai kebutuhan
}
