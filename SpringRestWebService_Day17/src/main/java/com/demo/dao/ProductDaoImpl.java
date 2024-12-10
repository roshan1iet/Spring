package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	//@Override
	public List<Product> findAllProducts() {
		return jdbcTemplate.query("select * from product",(rs,rownum)->{
			 Product p=new Product();
			 p.setPid(rs.getInt(1));
			 p.setPname(rs.getString(2));
			 p.setQty(rs.getInt(3));
			 p.setPrice(rs.getDouble(4));
			 p.setLdt(rs.getDate(5).toLocalDate());
			 p.setCid(rs.getInt(6));
			 return p;
				});
	}

	//@Override
	public boolean saveProduct(Product p) {
		int n=jdbcTemplate.update("insert into product values(?,?,?,?,?,?)",
				new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getLdt(),p.getCid()});
		return n>0;
	}

	//@Override
	@SuppressWarnings("deprecation")
	public Product findById(int pid) {
		try {
		return jdbcTemplate.queryForObject("select * from product where pid=?",new Object[] {pid},(rs,rownum)->{
			 Product p=new Product();
			 p.setPid(rs.getInt(1));
			 p.setPname(rs.getString(2));
			 p.setQty(rs.getInt(3));
			 p.setPrice(rs.getDouble(4));
			 p.setLdt(rs.getDate(5).toLocalDate());
			 p.setCid(rs.getInt(6));
			 return p;
				});
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	//@Override
	public boolean modifyProduct(Product p) {
		int n=jdbcTemplate.update("update product set pname=?,qty=?,price=?,expdate=?,cid=? where pid=?",
				new Object[] {p.getPname(),p.getQty(),p.getPrice(),p.getLdt(),p.getCid(),p.getPid()});
		return n>0;
	}

	//@Override
	public boolean removeById(int pid) {
		int n= jdbcTemplate.update("delete from product where pid=?",new
				Object[] {pid});
		return n>0;
	}

	public List<Product> findByCategory(int cid) {
		return jdbcTemplate.query("select * from product where cid=?",new Object[] {cid},(rs,rownum)->{
			 Product p=new Product();
			 p.setPid(rs.getInt(1));
			 p.setPname(rs.getString(2));
			 p.setQty(rs.getInt(3));
			 p.setPrice(rs.getDouble(4));
			 p.setLdt(rs.getDate(5).toLocalDate());
			 p.setCid(rs.getInt(6));
			 return p;
				});
	}

}
