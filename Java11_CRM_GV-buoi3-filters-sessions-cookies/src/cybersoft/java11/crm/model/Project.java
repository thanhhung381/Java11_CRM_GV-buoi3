package cybersoft.java11.crm.model;

import java.sql.Date;

public class Project {
	private int id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private User createdByUser;
	
	public Project(int id, String name, String description, Date startDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Project() {
		this.id = -1;
		this.name = "";
		this.description = "";
		this.startDate = new Date(-1);
		this.endDate = new Date(-1);
	}
}
