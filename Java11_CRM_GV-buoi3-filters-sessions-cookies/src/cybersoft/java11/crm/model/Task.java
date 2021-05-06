package cybersoft.java11.crm.model;

import java.sql.Date;

public class Task {
	private int id;
	private String name;
	private String description;
	private Date startDate;
	private Date dueDate;
	private User assignee;
	private Project project;
	private Status status;
	
	public Task(int id, String name, String description, Date start_date, Date due_date) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = start_date;
		this.dueDate = due_date;
	}
	
	public Task() {
		this.id = -1;
		this.name = "";
		this.description = "";
		this.startDate = new Date(-1);
		this.dueDate = new Date(-1);
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

	public Date getStart_date() {
		return startDate;
	}

	public void setStart_date(Date start_date) {
		this.startDate = start_date;
	}

	public Date getDue_date() {
		return dueDate;
	}

	public void setDue_date(Date due_date) {
		this.dueDate = due_date;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
