package kr.or.connect.todo.domain;

import java.util.Date;

public class TodoVo {

	private int id;
	private String todo;
	private int completed;
	private Date date;
	
	public TodoVo() {}
	
	public TodoVo(int id, String todo, int completed, Date date) {
		super();
		this.id = id;
		this.todo = todo;
		this.completed = completed;
		this.date = date;
	}


	/* getters, setters */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
