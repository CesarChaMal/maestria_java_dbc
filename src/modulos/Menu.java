package modulos;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;

import connection.ConnectionDB;
import dao.UsersDAO;
import dto.UsersDTO;

/**
 * Servlet implementation class Menu
 */
public class Menu extends HttpServlet {
	
	private ConnectionDB manager = null;
	private HttpSession sesion;	
	
    public Menu() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "firmaUsuario.jsp";
		UsersDTO usuario = null;
		UsersDAO usuariosDAO = new UsersDAO();
		ArrayList personas = null;
		sesion = request.getSession();
		sesion.setMaxInactiveInterval(1800000);
		
		Connection con = null; 
		try {
			con = this.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		String user = request.getParameter("txtUsuario");
		String pass = request.getParameter("passwd");
		
		
		usuario = usuariosDAO.loginUsuario(con, user, pass);

		if(usuario != null){
			forward = "menu.jsp";
			sesion.setAttribute("usuario",usuario);
		} else {
			request.setAttribute("Error","Error");
		}
		
		manager.closeConnection();
		manager = null;
		con = null;
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	public Connection getConnection() throws Exception {
		this.manager = new ConnectionDB(Constans.RDBMS_MYSQL, Constans.SERVER, Constans.PORT_MYSQL, Constans.DATABASE, Constans.USER, Constans.PASSWORD);
        Connection connection = null;
        connection = this.manager.getConnection();
		return connection;
	}
	
}
