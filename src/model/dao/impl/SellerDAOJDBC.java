package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDAOJDBC implements SellerDAO{
    
	private Connection conn;
	
	public SellerDAOJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		
	    try {
	    	ps = conn.prepareStatement(
	    			"SELECT seller.*,department.Name as DepName "
	    			+ "FROM seller INNER JOIN department "
	    			+ "ON seller.DepartmentId = department.Id "
	    			+ "WHERE seller.Id = ?");
	    	
	    	ps.setInt(1, id);
	    	rs = ps.executeQuery();
	    	
	    	if (rs.next()) {
	    		
	    		Department dep = instantiateDep(rs);
	    		Seller obj = instantiateSeller(rs, dep);
	    		
	    		return obj;
	    	}
	    	return null;
	    	
	    }
	    catch (SQLException e){
	    	throw new DbException(e.getMessage());
	    }
	    finally {
	    	DB.closeStatement(ps);
	    	DB.closeResultSet(rs);
	    }
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setDepart(dep);
		
		return obj;
	}

	private Department instantiateDep(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
