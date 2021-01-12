package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Product;
import Beans.User;
import Dao.ProductDAO;
import DB.ConnectionSql;

// test kn
//PrintWriter out = response.getWriter();
//out.println(DBConnection.CreateConnection());

//@WebServlet("/PhoneController")
public class PhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Connection conn = ConnectionSql.CreateConnection();
	public PhoneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("a");
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertProduct(request, response);
			break;
		case "/delete":
			deleteProduct(request, response);
			break;
		case "/edit":
			showEditProduct(request, response);
			break;
		case "/update":
			updateProduct(request, response);
			break;
		case "/list2":
			list2Product(request, response);
			break;
		case "/login":
			loginProduct(request, response);
			break;

		default:
			listProduct(request, response);
			break;
		}

	}

	// hiển thị bảng new
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
		try {

			RequestDispatcher rd = request.getRequestDispatcher("new.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// thêm sản phẩm
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection conn = ConnectionSql.CreateConnection();
			String title = request.getParameter("title");
			String img = request.getParameter("img");
			float pricenew = Float.parseFloat(request.getParameter("pricenew"));
			float priceold = Float.parseFloat(request.getParameter("priceold"));
			String name = request.getParameter("name");
			String info = request.getParameter("info");

			Product product = new Product(title, img, pricenew, priceold, name, info);
			ProductDAO.insretProduct(conn, product);
			List<Product> listProduct = ProductDAO.getAllProduct(conn);// getAll lay list tu sql
			request.setAttribute("listProduct", listProduct); // #
			RequestDispatcher rd = request.getRequestDispatcher("list_product.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Delete
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection conn = ConnectionSql.CreateConnection(); // connect
			int id = Integer.parseInt(request.getParameter("id")); // lấy id từ người dùng
			Product product = new Product(id); // tạo đối tượng product (id)
			ProductDAO.deleteProduct(conn, product); //
			RequestDispatcher rd = request.getRequestDispatcher("list2");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// hiển thị sau khi Edit
	private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectionSql.CreateConnection();
			int id = Integer.parseInt(request.getParameter("id"));
			Product existProduct = ProductDAO.getIdproduct(conn, id); // truyen qua new
			request.setAttribute("product", existProduct);
			RequestDispatcher rd = request.getRequestDispatcher("new.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// Update
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection conn = ConnectionSql.CreateConnection();
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String img = request.getParameter("img");
			float pricenew = Float.parseFloat(request.getParameter("pricenew"));
			float priceold = Float.parseFloat(request.getParameter("priceold"));
			String name = request.getParameter("name");
			String info = request.getParameter("info");

			Product product = new Product(id, title, img, pricenew, priceold, name, info);
			ProductDAO.updateProduct(conn, product);
			List<Product> listProduct = ProductDAO.getAllProduct(conn);// getAll lay list tu sql
			request.setAttribute("listProduct", listProduct); // #
			RequestDispatcher rd = request.getRequestDispatcher("list_product.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void list2Product(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {

			Connection conn = ConnectionSql.CreateConnection();
			List<Product> listProduct = ProductDAO.getAllProduct(conn);// getAll lay list tu sql
			request.setAttribute("listProduct", listProduct); // truyen doi tuong qua jsp gg

			RequestDispatcher rd = request.getRequestDispatcher("list_product.jsp");// gg
			rd.forward(request, response); // gg
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// hàm login
	private void loginProduct(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("username"); // gg
		String pass = request.getParameter("password"); // gg

		User user1 = new User(name, pass);

		Connection conn = ConnectionSql.CreateConnection();

		if (ProductDAO.DisplayUser(conn, user1) == true) {
			try {
				List<Product> listProduct = ProductDAO.getAllProduct(conn);// lay list tu sql
				request.setAttribute("listProduct", listProduct);
				RequestDispatcher rd = request.getRequestDispatcher("list2");
				rd.forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			try {
				request.setAttribute("msg1", "Đăng nhập thất bại!!");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
//danh sách sản 

	private void listProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectionSql.CreateConnection();
			
			List<Product> listProduct = ProductDAO.getAllProduct(conn);// getAll lay list tu sql
			request.setAttribute("listProduct", listProduct); // truyen doi tuong qua jsp

			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			System.out.print("b");
			rd.forward(request, response);
			System.out.print("c");
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
