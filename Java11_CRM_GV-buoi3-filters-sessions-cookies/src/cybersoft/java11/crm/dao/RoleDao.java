package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java11.crm.config.MySqlConnection;
import cybersoft.java11.crm.model.Role;

public class RoleDao {
	
	public boolean kiemTraTrungLap(int id, String name, String description) throws SQLException {
		//Lấy ra danh sách roles từ database
		List<Role> roles = new LinkedList<Role>();
		//Mở kết nối đến database
		Connection connection = MySqlConnection.getConnection();
		try {
			String query = "SELECT * FROM role";
			//Tạo truy vấn đến database sử dụng PreparedStatement
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Role role = new Role();
				role.setId(result.getInt("id"));
				role.setName(result.getString("name"));
				role.setDescription(result.getString("description"));
				roles.add(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
					
		//Kiểm tra trùng lặp:
		for(Role role: roles) {
			if(role.getId() == id || role.getName().equals(name))
				return false;
		}
		
		return true;
	}
	
	
	public boolean themRole(int id, String name, String description) throws SQLException {
		//Mở kết nối đến database
		Connection connection = MySqlConnection.getConnection();
		try {
			String query = "INSERT INTO role(id, name, description) VALUES (?, ?, ?)";
			//Tạo truy vấn đến database sử dụng PreparedStatement
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, description);
			ResultSet result = statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			connection.close();
		}
		
		return true;
	}

	
	public boolean xoaRole(int id) throws SQLException {
		//Mở kết nối đến database
		Connection connection = MySqlConnection.getConnection();
		try {
			String query = "DELETE FROM role WHERE id = ?";
			//Tạo truy vấn đến database sử dụng PreparedStatement
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			connection.close();
		}
		
		return true;
	}

	

	public boolean capNhatRole(int id, String name, String description) throws SQLException{
		//Mở kết nối đến database
		Connection connection = MySqlConnection.getConnection();
		try {
			String query = "UPDATE role SET name = ?, description = ? WHERE id = ?";
			//Tạo truy vấn đến database sử dụng PreparedStatement
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, description);
			statement.setInt(3, id);
			ResultSet result = statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			connection.close();
		}
				
		return true;
	}	
	


}
