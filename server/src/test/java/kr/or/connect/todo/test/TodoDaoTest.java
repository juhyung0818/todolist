package kr.or.connect.todo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;
import kr.or.connect.todo.TodoApplication;
import kr.or.connect.todo.domain.TodoVo;
import kr.or.connect.todo.persistence.TodoDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TodoApplication.class)
public class TodoDaoTest extends TestCase{

	@Autowired
	private TodoDao dao;

	@Before
	public void insertTestCase(){

	}
	
	@Test
	public void testSelectOne() {
	
		String content = "content";
		int id = dao.insertTodo(content);
		TodoVo todo = dao.selectTodoById(id);
		
		assertEquals(todo.getTodo(), content);
		
	}
}
