package kr.or.connect.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.todo.domain.TodoVo;
import kr.or.connect.todo.persistence.TodoDao;

@Service
public class TodoService {
	
	private TodoDao todoDao;
	
	@Autowired
	public TodoService(TodoDao todoDao) {
		this.todoDao = todoDao;
	}
	
	public List<TodoVo> getTodoList(){
		return todoDao.selectTodoList();
	}
	
	public List<TodoVo> getTodoList(int completed){
		return todoDao.selectTodoListByCompleted(completed);
	}
	
	public TodoVo createTodo(String todo){
		int id = todoDao.insertTodo(todo);
		return todoDao.selectTodoById(id);
	}
	
	public void modifyCompletedById(Integer id){
		todoDao.updateCompletedById(id);
	}
	
	public void removeTodo(Integer id){
		todoDao.deleteTodo(id);
	}
	
	public void removeCompletedTodo(){
		todoDao.deleteCompletedTodo();
	}
	
	public int getCountByCompleted(Integer completed) {
		return todoDao.selectCountByCompleted(completed);
	} 
	
	
}
