package application;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	      
		SellerDAO sdao = DAOFactory.createSellerDAO();
		System.out.println("========== TESTE 1: seller findById ===========");
		Seller sel = sdao.findById(8);
		
		System.out.println(sel);
	}
}
