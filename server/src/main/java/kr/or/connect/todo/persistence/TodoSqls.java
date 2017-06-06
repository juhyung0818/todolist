package kr.or.connect.todo.persistence;

public class TodoSqls {
	//전체 할 일 리스트
	static final String SELECT_TODO_LIST =
			"SELECT * FROM todo ORDER BY id DESC";
	//할 일 필터링
	static final String SELECT_TODO_LIST_BY_COMPLETED =
			"SELECT * FROM todo WHERE completed= :completed ORDER BY id DESC";
	//할 일 가져오기
	static final String SELECT_TODO_BY_ID =
			"SELECT * FROM todo WHERE id= :id ";
	
	//할 일 등록
	static final String INSERT_TODO =
			"INSERT INTO todo(todo) VALUES(:todo)";
	//할 일 완료하기
	static final String UPDATE_COMPLETED_BY_ID =
			"UPDATE todo SET completed = 1 WHERE id= :id";
	//할 일 삭제
	static final String DELETE_BY_ID =
			"DELETE FROM todo WHERE id= :id";
	//완료한 일 모두 삭제
	static final String DELETE_COMPLETED_TODO =
			"DELETE FROM todo WHERE completed= 1";
	//해야할 일 전체 갯수
	static final String COUNT_COMPLETED_TODO =
			"SELECT count(*) FROM todo WHERE completed= 0";
}