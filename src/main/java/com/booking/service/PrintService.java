package com.booking.service;

import java.util.List;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;

public class PrintService {
    public static void printMenu(String title, String[] menuArr){
        int num = 1;
        System.out.println(title);
        for (int i = 0; i < menuArr.length; i++) {
            if (i == (menuArr.length - 1)) {   
                num = 0;
            }
            System.out.println(num + ". " + menuArr[i]);   
            num++;
        }
        System.out.printf("Choose an Option : ");
    }

    public static String printServices(List<Service> serviceList){
        String result = "";
        // Bisa disesuaikan kembali
        for (Service service : serviceList) {
            result += service.getServiceName() + ", ";
        }
        return result;
    }
    
    public static void printAllServices(List<Service> serviceList) {
    	int num = 1;
    	
    	System.out.printf("| %-5s | %-15s | %-25s | %-25s | \n", "No.", "ID Service", "Nama Service", "Harga");
        System.out.println("+========================================================================================================+");
    	for(Service service : serviceList) {
    		System.out.printf("| %-5s | %-15s | %-25s | %-25s | \n", num, service.getServiceId(), service.getServiceName(), 
    				service.getPrice());
    		num++;
    	}
    }

    // Function yang dibuat hanya sebgai contoh bisa disesuaikan kembali
    public static void showRecentReservation(List<Reservation> reservationList){
        int num = 1;
        System.out.printf("| %-5s | %-10s | %-15s | %-50s | %-15s | %-10s | %-10s |\n",
                "No.", "ID", "Nama Customer", "Service", "Biaya Service", "Pegawai", "Workstage");
        System.out.println("+=======================================================================================================================================+");
        for (Reservation reservation : reservationList) {
            if (reservation.getWorkstage().equalsIgnoreCase("Waiting") || reservation.getWorkstage().equalsIgnoreCase("In process")) {
                System.out.printf("| %-5s | %-10s | %-15s | %-50s | %-15s | %-10s | %-10s |\n",
                num, reservation.getReservationId(), reservation.getCustomer().getName(), printServices(reservation.getServices()), ((int)reservation.getReservationPrice()), reservation.getEmployee().getName(), reservation.getWorkstage());
                num++;
            }
        }
    }

    public static void showAllCustomer(List<Person> personList){
    	int num = 1;
    	System.out.printf("| %-5s | %-15s | %-15s | %-15s | %-15s | %-15s | \n", "No.", "ID", "Nama Customer", "Alamat", "Membership", "Uang");
        System.out.println("+========================================================================================================+");
        for(Person person : personList) {
        	if(person instanceof Customer) {
        		Customer customer = (Customer) person;
            	System.out.printf("| %-5s | %-15s | %-15s | %-15s | %-15s | %-15s | \n", num, customer.getId(), customer.getName(), customer.getAddress(), 
            			customer.getMember().getMembershipName(), ((int) customer.getWallet()));
            	num++;
        	}
        }

    }

    public static void showAllEmployee(List<Person> personList){
    	int num = 1;
    	System.out.printf("| %-5s | %-15s | %-15s | %-15s | %-15s | \n", "No.", "ID", "Nama Customer", "Alamat", "Pengalaman");
        System.out.println("+========================================================================================================+");
        for(Person person : personList) {
        	if(person instanceof Employee) {
        		Employee employee = (Employee) person;
            	System.out.printf("| %-5s | %-15s | %-15s | %-15s | %-15s | \n", num, employee.getId(), employee.getName(), employee.getAddress(), 
            			employee.getExperience());
            	num++;
        	}
        	
        }
    }

    public static void showHistoryReservation(List<Reservation> reservationList){
        int num = 1; double total = 0;
    	System.out.printf("| %-5s | %-10s | %-15s | %-50s | %-15s | %-10s | \n", "No.", "ID", "Nama Customer", "Service", "Total Biaya", "Workstage");
        System.out.println("+=======================================================================================================================+");
        for(Reservation reservation : reservationList) {
        	if(reservation.getWorkstage().equalsIgnoreCase("Cancel") || reservation.getWorkstage().equalsIgnoreCase("Finish")) {
        		System.out.printf("| %-5s | %-10s | %-15s | %-50s | %-15s | %-10s | \n", num, reservation.getReservationId(), reservation.getCustomer().getName(), 
        				printServices(reservation.getServices()), ((int)reservation.getReservationPrice()), reservation.getWorkstage());
            	num++;
            	if(reservation.getWorkstage().equalsIgnoreCase("Finish")) {
            		total += (int) reservation.getReservationPrice();
            	}
        	}
        }
        
        System.out.printf("| %-5s | %-10s  %-15s  %-50s   | %-15s | %-10s | \n", num, " ", " ", "Total Keuntungan", (int)total, " ");
    }
}
