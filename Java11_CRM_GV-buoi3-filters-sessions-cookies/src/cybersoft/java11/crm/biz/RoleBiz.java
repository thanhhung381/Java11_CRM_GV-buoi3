package cybersoft.java11.crm.biz;

import cybersoft.java11.crm.dao.AuthDao;
import cybersoft.java11.crm.dao.RoleDao;
import cybersoft.java11.crm.model.Role;

public class RoleBiz {
	//properties
	private RoleDao dao;
	
	//constructors:
	public RoleBiz() {
		dao = new RoleDao();
	}
	
	//methods:
	public boolean themRole(int id, String name, String description) {
		//Kiểm tra đã có id và name chưa?
		Role role = new Role();
		role.setId(id);
		role.setName(name);
		role.setDescription(description);
		if(!role.kiemTraHopLe())
			return false;
		
		//Kiểm tra trùng lặp trong danh sách role
		if(!dao.kiemTraTrungLap(id, name, description))
			return false;
		
		//Thêm role vào database
		return dao.themRole(id, name, description);
	}
	
	
	
	
	
}
