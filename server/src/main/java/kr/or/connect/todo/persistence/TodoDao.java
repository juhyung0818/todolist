package kr.or.connect.todo.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.todo.domain.TodoVo;

@Repository
public class TodoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<TodoVo> rowMapper = BeanPropertyRowMapper.newInstance(TodoVo.class);


	public TodoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("todo")
				.usingGeneratedKeyColumns("id")
				.usingColumns("todo");
	}
	
	
	public List<TodoVo> selectTodoList(){
		return jdbc.query(TodoSqls.SELECT_TODO_LIST, rowMapper);
	}
	
	public List<TodoVo> selectTodoListByCompleted(Integer completed){
		Map<String, Object> param = new HashMap<>();
		param.put("completed", completed);
		return jdbc.query(TodoSqls.SELECT_TODO_LIST_BY_COMPLETED, param, rowMapper);
	}
	
	public TodoVo selectTodoById(Integer id){
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		return jdbc.queryForObject(TodoSqls.SELECT_TODO_BY_ID, param, rowMapper);
	}
	
	public int insertTodo(String todo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("todo", todo);
		return insertAction.executeAndReturnKey(param).intValue();
	}
	
	public void updateCompletedById(Integer id){
		Map<String, ?> param = Collections.singletonMap("id", id);
		jdbc.update(TodoSqls.UPDATE_COMPLETED_BY_ID, param);
	}

	public void deleteTodo(Integer id){
		Map<String, ?> param = Collections.singletonMap("id", id);
		jdbc.update(TodoSqls.DELETE_BY_ID, param);
	}
	
	public void deleteCompletedTodo(){
		int completed = 1;
		Map<String, ?> param = Collections.singletonMap("completed", completed);
		jdbc.update(TodoSqls.DELETE_COMPLETED_TODO, param);
	}
	
	public int selectCountByCompleted(Integer completed) {
		Map<String, Object> params = new HashMap<>();
		params.put("completed", completed);
		return jdbc.queryForObject(TodoSqls.COUNT_COMPLETED_TODO, params, Integer.class);
	} 
}
