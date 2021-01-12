package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Beans.Product;
import Beans.User;

public class ProductDAO  {
	public static List<Product> getAllProduct(Connection conn) {
		// khoi tao mot list bang cach tao moi Arraylist
		List<Product> listProduct = new ArrayList<>();

		String sql = "select * from product";
		try {
			PreparedStatement pst = conn.prepareStatement(sql); // thuc thi lenh Sql
			ResultSet rs = pst.executeQuery(); // Kien Tra Su thay doi cua "google"
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String img = rs.getString("img");
				float pricenew = rs.getFloat("pricenew");
				float priceold = rs.getFloat("priceold");
				String name = rs.getString("name");
				String info = rs.getString("info");

				Product product = new Product(id, title, img, pricenew, priceold, name, info);
				listProduct.add(product);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listProduct;
	}

	// get id of product sá»­ dá»¥ng khi update
	public static Product getIdproduct(Connection conn, int id) {
		Product product = null;
		String sql = "select * from product where id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String img = rs.getString("img");
				float pricenew = rs.getFloat("pricenew");
				float priceold = rs.getFloat("priceold");
				String name = rs.getString("name");
				String info = rs.getString("info");
				product = new Product(id, title, img, pricenew, priceold, name, info);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	// delete thá»±c hiÃªn lá»‡nh qua Sql
	public static boolean deleteProduct(Connection conn, Product product) {
		String sql = "delete from product where id = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql); // truy suáº¥t ra
			pst.setInt(1, product.getId());
			if (pst.executeUpdate() > 0) // náº¿u cÃ³ thÃ¬ Ä‘Ãºng vÃ  tráº£ vá»� controller sÃ i thÃ¬ ko xÃ³a Ä‘Æ°á»£c
				return true;
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// update/ edit
	public static boolean updateProduct(Connection conn, Product product) {
		String sql = "update mobile.product set title = ?, img = ?, pricenew = ?, priceold = ?,name = ?, info =? where id = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, product.getTitle());
			pst.setString(2, product.getImg());
			pst.setFloat(3, product.getPricenew());
			pst.setFloat(4, product.getPriceold());
			pst.setString(5, product.getName());
			pst.setString(6, product.getInfo());
			pst.setInt(7, product.getId());

			if (pst.executeUpdate() > 0)
				return true;
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// new
	public static boolean insretProduct(Connection conn, Product product) {
		boolean rowInserted = false;
		String sql = "insert into product(title, img, pricenew, priceold, name, info) values (?,?,?,?,?,?) ";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, product.getTitle());
			pst.setString(2, product.getImg());
			pst.setFloat(3, product.getPricenew());
			pst.setFloat(4, product.getPriceold());
			pst.setString(5, product.getName());
			pst.setString(6, product.getInfo());

			if (pst.executeUpdate() > 0)
				rowInserted = true;
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowInserted;
	}

	// check login
	public static boolean DisplayUser(Connection conn, User us) {

		String sql = "select * from users where username = ? and password = ?";
		try {
			// truyen truy van sql cho doi tuong PreparedStatement-------------
			PreparedStatement ptmt = conn.prepareStatement(sql); // gg
			ptmt.setString(1, us.getUsername());
			ptmt.setString(2, us.getPassword());

			ResultSet rs = ptmt.executeQuery(); // gg
			if (rs.next()) {
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
		}
		return false;
	}
}
