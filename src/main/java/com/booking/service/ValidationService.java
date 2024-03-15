package com.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.models.*;

public class ValidationService {
	public static Scanner scan = new Scanner(System.in);

    public static Customer validateCustomerId(List<Person> personList, Scanner scan){
    	Customer result = null; 
    	String input;
    	String regex = "^[A-Za-z]+-[0-9]{2}$";
    	boolean isValid = false;
    	
    	do {
    		System.out.print("Masukkan ID Customer : ");
    		input = scan.nextLine();
    		if(input.matches(regex)) {
    			for(Person person : personList) {
    				if(person instanceof Customer) {
    					Customer customer = (Customer) person;
    					if(input.equalsIgnoreCase(customer.getId())) {
    						result = customer;
    						isValid = true;
    						break;
    						
    					}
    				}
    			}
    		}
    		if(!isValid) {
    			System.out.println("Customer yang dicari tidak tersedia");
    		}
    	}while(!isValid);
    	
    	return result;
    }
    
    public static Employee validateEmployeeId(List<Person> personList, Scanner scan){
    	Employee result = null;
    	String input;
    	String regex = "^[A-Za-z]+-[0-9]{2}$";
    	boolean isValid = false;
    	
    	do {
    		System.out.print("Masukkan ID Emplloyee : ");
    		input = scan.nextLine();
    		if(input.matches(regex)) {
    			for(Person person : personList) {
    				if(person instanceof Employee) {
    					Employee employee = (Employee) person;
    					if(input.equalsIgnoreCase(employee.getId())) {
    						result = employee;
    						isValid = true;
    						break;
    						
    					}
    				}
    			}
    		}
    		if(!isValid) {
    			System.out.println("Employee yang dicari tidak tersedia");
    		}
    	}while(!isValid);
    	
    	return result;
    }
    
    public static List<Service> validateServiceId(List<Service> serviceList, Scanner scan) {
    	List<Service> result = new ArrayList<>();
    	String input, pilihan;
    	String regex = "^[A-Za-z]+-[0-9]{2}$";
    	String regexPilihan = "[YT]";
    	boolean isValid = false, isFound, isAlreadySelected, isAgain;
    	
    	do {
    		isFound = false;
    		isAlreadySelected = false;
    		isAgain = false;
    		System.out.print("Masukkan ID Service : ");
    		input = scan.nextLine();
    		if(input.matches(regex)) {
    			for(Service service : serviceList) {
    				if(input.equalsIgnoreCase(service.getServiceId())) {
    					isFound = true;
    					if(result.contains(service)) {
    						isAlreadySelected = true;
    						break;
    					}else {
    						result.add(service);
        					break;
    					}
    				}
    			}
    			
    			if(!isFound) {
        			System.out.println("Service yang dicari tidak tersedia");
        		}else if(isAlreadySelected) {
        			System.out.println("Service telah dipilih sebelumnya");
        		}else {
        			do {
        				System.out.print("ingin pilih service yg lain? (Y/T) : ");
                		pilihan = scan.nextLine().toUpperCase();
                		if(pilihan.matches(regexPilihan)) {
                			if(pilihan.equalsIgnoreCase("T")) {
                				isValid = true;
                				break;
                			}
                		}else {
                			System.out.println("Masukkan pilihan Y / T");
                			isAgain = true;
                		}
        			}while(isAgain);
        		}
    		}
    	}while(!isValid);
    	
    	return result;
    }
    
    public static Reservation validationReservationId(List<Reservation> reservationList, Scanner scan) {
    	Reservation result = null;
    	String input;
    	String regex = "^[A-Za-z]+-[0-9]{2}$";
    	boolean isValid = false;
    	
    	do {
    		System.out.print("Masukkan ID Reservation : ");
    		input = scan.nextLine();
    		if(input.matches(regex)) {
    			for(Reservation reservation : reservationList) {
    				if(reservation.getWorkstage().equalsIgnoreCase("In Process")) {
    					if(input.equalsIgnoreCase(reservation.getReservationId())) {
    						result = reservation;
    						isValid = true;
    						break;
    						
    					}
    				}
    			}
    		}
    		
    		if(!isValid) {
    			System.out.println("Resevation yang dicari tidak tersedia");
    		}
    	}while(!isValid);
    	
    	return result;
    }
    
    public static String validationWorkstage(Scanner scan) {
    	String input, result = "";
    	String regex = "Finish|Cancel";
    	boolean isValid = false;
    	
    	do {
    		System.out.print("Selesaikan Reservasi : ");
    		input = scan.nextLine();
    		if(input.matches(regex)) {
    			result = input;
				isValid = true;
				break;
    		}
    		if(!isValid) {
    			System.out.println("Selesaikan Resevasi dengan Finish / Cancel");
    		}
    	}while(!isValid);
    	
    	return result;
    }
}
