package application;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	      
		
		SellerDAO sdao = DAOFactory.createSellerDAO();
		
		Seller sel = sdao.findById(3);
		
		System.out.println(sel);
	}
}
