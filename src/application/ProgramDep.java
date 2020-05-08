package application;

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
		
		System.out.println("========= TEST 2: department insert =========");
		Department newDep = new Department(null, "Finances");
		ddao.insert(newDep);
		System.out.println("Inserted!");
		
		sc.close();

	}

}
