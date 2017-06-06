package kr.or.connect.todo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.todo.domain.TodoVo;
import kr.or.connect.todo.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	private TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping
	public List<TodoVo> listTodo(){
		return todoService.getTodoList();
	}
	
	@GetMapping("/active")
	public List<TodoVo> listActiveTodo(){
		return todoService.getTodoList(0);
	}
	
	@GetMapping("/completed")
	public List<TodoVo> listCompletedTodo(){
		return todoService.getTodoList(1);
	}

	@PostMapping
	public TodoVo createTodo(@RequestBody TodoVo todoVo) {
		return todoService.createTodo(todoVo.getTodo());
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void modifyByCompleted(@PathVariable Integer id){
		todoService.modifyCompletedById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeTodo(@PathVariable Integer id) {
		todoService.removeTodo(id);
	}
	
	@DeleteMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeCompletedTodo() {
		todoService.removeCompletedTodo();
	}

	@GetMapping("/count/{completed}")
	public int getCountByCompleted(@PathVariable Integer completed){
		return todoService.getCountByCompleted(completed);
	}
}
