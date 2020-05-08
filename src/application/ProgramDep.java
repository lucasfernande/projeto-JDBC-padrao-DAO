package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class ProgramDep {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDAO ddao = DAOFactory.createDepartmentDAO();
		
		System.out.println("========= TEST 1: department findById =========");
		Department dep = ddao.findById(2);
		System.out.println(dep);
		
		System.out.println("\n========= TEST 3: department update =========");
		Department depart = ddao.findById(3);
		depart.setName("Misc");
		ddao.update(depart);
		
		System.out.println("Updated!");
		
		System.out.println("\n========= TEST 4: department findAll =========");
		List<Department> deps = ddao.findAll();
		
		for (Department departs : deps) {
			System.out.println(departs);
		}
		
		System.out.println("\n========== TEST 5: department delete ==========");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		ddao.deleteById(id);
		
		System.out.println("Deleted");
		
		sc.close();

	}

}
