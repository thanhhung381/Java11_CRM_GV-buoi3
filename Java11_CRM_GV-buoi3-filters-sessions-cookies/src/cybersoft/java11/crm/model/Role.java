package cybersoft.java11.crm.model;

public class Role {
	private int id;
	private String name;
	private String description;
	
	public Role(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Role() {
		this.id = -1;
		this.name = "";
		this.description = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	//methods:
	public boolean kiemTraHopLe() {
		if(Integer.toString(id) == null || Integer.toString(id).equals("")) 
			return false;
		if(name == null || name.equals(""))
			return false;
		
		return true;
	}
}
