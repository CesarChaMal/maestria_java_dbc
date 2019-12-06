package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.UsersDTO;

public class UsersDAO {

	public UsersDAO() {
	}
	
    public List listaUsuarios(Connection con)  {	        
        List listUsuarios = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT id,userName,password,firstName,lastName,enabled FROM users";
        listUsuarios = new ArrayList();
        try {
        	stm = con.createStatement();
        	rs = stm.executeQuery(sql);
        	while (rs.next()) {
        		listUsuarios.add(
        				new UsersDTO (rs.getInt("id"),
        								rs.getString("userName"),
        								rs.getString("password"),
        								rs.getString("firstName"),
        								rs.getString("lastName"),
        								rs.getBoolean("enabled")
        								)
        				);
        	}
        }catch(SQLException e){
        	e.printStackTrace();}
        return listUsuarios;
    }
    
	public UsersDTO buscaUsuario(Connection con, int id) {
		UsersDTO usuario = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT id,userName,password,firstName,lastName,enabled FROM users WHERE id = " + id;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				usuario = new UsersDTO();
				usuario.setId(rs.getInt("id"));
				usuario.setUserName(rs.getString("userName"));
				usuario.setPassword(rs.getString("password"));
				usuario.setFirstName(rs.getString("firstName"));
				usuario.setLastName(rs.getString("lastName"));
				usuario.setEnabled(rs.getBoolean("enabled"));
			}
		}catch(SQLException e){
			e.printStackTrace(); }	
		return usuario;
	}
	
	public UsersDTO loginUsuario(Connection con, String user, String pass) {
		UsersDTO usuario = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT id,userName,password,firstName,lastName,enabled FROM users WHERE userName = '" + user + "' and password = '" + pass + "'";
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				usuario = new UsersDTO();
				usuario.setId(rs.getInt("id"));
				usuario.setUserName(rs.getString("userName"));
				usuario.setPassword(rs.getString("password"));
				usuario.setFirstName(rs.getString("firstName"));
				usuario.setLastName(rs.getString("lastName"));
				usuario.setEnabled(rs.getBoolean("enabled"));
			}
		}catch(SQLException e){
			e.printStackTrace(); }	
		return usuario;
	}
	
	public void modificaUsuario(Connection con,UsersDTO user) {
		PreparedStatement stm = null;
		String sql = "update users set userName = ?, firstName = ?,lastName = ? where id = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, user.getUserName());
			stm.setString(2, user.getFirstName());
			stm.setString(3, user.getLastName());
			stm.setInt(4, user.getId());
			stm.executeUpdate(sql);
		}catch(SQLException e){e.printStackTrace();}
	}
	
	public void eliminaUsuario(Connection con, int id) throws SQLException{
		PreparedStatement stm = null;
		String sql="delete from users where id = ? ";
		stm = con.prepareStatement(sql);
		stm.setInt(1, id);
		stm.executeUpdate(sql);
	}
	
	public void insertaUsuario(Connection con, UsersDTO usuario) throws SQLException{
		PreparedStatement stm = null;
		String sql="Insert into users(id, userName, password, firstName, lastName, enabled) values(?,?,?,?,?,1)";
		stm = con.prepareStatement(sql);
		stm.setInt(1, usuario.getId());
		stm.setString(2, usuario.getUserName());
		stm.setString(3, usuario.getPassword());
		stm.setString(4, usuario.getFirstName());
		stm.setString(5, usuario.getLastName());
		stm.executeUpdate(sql);
	}

}
