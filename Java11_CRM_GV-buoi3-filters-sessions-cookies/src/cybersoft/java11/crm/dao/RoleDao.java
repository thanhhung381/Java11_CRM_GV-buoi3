package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java11.crm.config.MySqlConnection;
import cybersoft.java11.crm.model.Role;

public class RoleDao {
	
	public boolean kiemTraTrungLap(int id, String name, String description) {
		//Lấy ra danh sách roles từ database
		List<Role> roles = new LinkedList<Role>();
		try {
			//Mở kết nối đến database
			Connection connection = MySqlConnection.getConnection();
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
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		//Kiểm tra trùng lặp:
		for(Role role: roles) {
			if(role.getId() == id || role.getName().equals(name))
				return false;
		}
		
		return true;
	}
	
	
	public boolean themRole(int id, String name, String description) {
		try {
			//Mở kết nối đến database
			Connection connection = MySqlConnection.getConnection();
			String query = "INSERT INTO role(id, name, description) VALUES (?, ?, ?)";
			//Tạo truy vấn đến database sử dụng PreparedStatement
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(1, name);
			statement.setString(1, description);
			ResultSet result = statement.executeQuery();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


}
