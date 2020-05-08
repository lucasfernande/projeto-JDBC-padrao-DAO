package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		SellerDAO sdao = DAOFactory.createSellerDAO();

		System.out.println("========== TEST 1: seller findById ==========");
		Seller seller = sdao.findById(3);
		System.out.println(seller);

		System.out.println("\n========== TEST 2: seller findByDepartment ==========");
		Department depart = new Department(2, null);
		List<Seller> list = sdao.findByDep(depart);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n========== TEST 3: seller findAll ==========");
		list = sdao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n========== TEST 4: seller insert ==========");
		Seller newSel = new Seller(null, "Chris Brownie", "brownie12@gmail.com", new Date(), 1950.00, depart);
		sdao.insert(newSel);
		System.out.println("Inserted! New id = " + newSel.getId());
		
		System.out.println("\n========== TEST 5: seller update ==========");
		seller = sdao.findById(1);
		seller.setName("Daniel Wayne");
		sdao.update(seller);
		
		System.out.println("Update completed");
		
		System.out.println("\n========== TEST 6: seller delete ==========");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sdao.deleteById(id);
		
		System.out.println("Deleted");
				
		sc.close();		
	}
}
