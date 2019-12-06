package modulos;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ConnectionDB;
import dao.UsersDAO;
import dto.UsersDTO;

/**
 * Servlet implementation class RoadDotCom
 */
public class RoadDotCom extends HttpServlet {
	private ConnectionDB manager = null;
	private HttpSession session;	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoadDotCom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "roaddotcom.jsp";
		UsersDTO usuario = null;
		session = request.getSession();

		Connection con = null; 
		try {
			con = this.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		usuario = (UsersDTO) session.getAttribute("usuario");
		if(usuario == null){
			forward = "menu.jsp";
			request.setAttribute("Error","Error");
		}
		
		manager.closeConnection();
		manager = null;
		con = null;
		
		//forward
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
		//sendRedirect
		//response.sendRedirect(forward);
	}

	public Connection getConnection() throws Exception {
		this.manager = new ConnectionDB(Constans.RDBMS_MYSQL, Constans.SERVER, Constans.PORT_MYSQL, Constans.DATABASE, Constans.USER, Constans.PASSWORD);
        Connection connection = null;
        connection = this.manager.getConnection();
		return connection;
	}

}
