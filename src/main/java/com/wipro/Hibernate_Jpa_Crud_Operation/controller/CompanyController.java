package com.wipro.Hibernate_Jpa_Crud_Operation.controller;

import java.util.Scanner;

import com.wipro.Hibernate_Jpa_Crud_Operation.dao.CompanyDao;
import com.wipro.Hibernate_Jpa_Crud_Operation.dto.Company;
import com.wipro.Hibernate_Jpa_Crud_Operation.service.CompanyService;
@SuppressWarnings("resources")
public class CompanyController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CompanyService service=new CompanyService();
		CompanyDao dao=new CompanyDao();
		
//		Company comp=new Company(101, "Irfan", "mirfan916152@gmail.com", "Bihar", 5000);
//		
//		service.saveCompanyService(comp);
		
		while(true) {
			System.out.println("Enter your option....");
			System.out.println("1.INSERT\n2.GETBYID\n3.DELETE\n4.UPDATE\n5.DISPLAY\n6.DeleteByJPQL\n7.UpdateByJPQL");
			int key=sc.nextInt();
			switch(key) {
			
			case 1:{
				System.out.println("Enter Company Id");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Company name");
				String name =sc.nextLine();
				System.out.println("Enter Company address");
				String address=sc.nextLine();
				System.out.println("Enter number of Employee in Company");
				int noOfCompany=sc.nextInt();
				
				Company company = new Company(id, name, name, address, noOfCompany);
				
				service.saveCompanyService(company);
//				Company company=new Company(98765, "TCS", "tcs-ion@tcs.com", "Bihar", 5000);
//				service.saveCompanyService(company);
			}
			break;
			
			case 2:{
				
				System.out.println("Enter company id to display");
				int id=sc.nextInt();
				Company company=service.getCompanyByIdService(id);
				
				if(company!=null) {
					System.out.println(company);
					
				}
				else {
					System.out.println("Id not found...");
				}
			}
			break;
			
			case 3:{
				System.out.println("Enter company id to delete");
				int id=sc.nextInt();
				boolean b=service.deleteCompanyByIdService(id);
				if(b) {
					System.out.println("data deleted");
					
				}
				else {
					System.out.println("Id not found...");
				}
			}
			break;
			
			case 4:{
				System.out.println("Enter company id to update company name");
				int id=sc.nextInt();
				System.out.println("Enter new Company name");
				String name=sc.nextLine();
				name+=sc.nextLine();
				Company comp=service.updateCompanyByIdService(id, name);
				if(comp!=null) {
					System.out.println("Data updated");
				}else {
					System.out.println("Id not found!......");
				}
				
			}
			break; 
			
			case 5:{
				
				for(Company company:service.getAllCompanyDetailsService()) {
					System.out.println(company);
				}
				
			}
			break;
			case 6:{
				
			
					System.out.println("Enter company id to delete");
					int id =sc.nextInt();
					int a=dao.deleteCompanyByIdJPQLDao(id);
					System.out.println(a);
				
				
			}
			break;
			
			case 7:{
				System.out.println("Enter company id to update company name");
				int id=sc.nextInt();
				System.out.println("Enter new Company name");
				String name=sc.nextLine();
				name+=sc.nextLine();
				int a=dao.updateCompanyNameByJPQLDao(id, name);
				System.out.println(a);
				
				
			}
			break;
			
			}
		}
	}

}
