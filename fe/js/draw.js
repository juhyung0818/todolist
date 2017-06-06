function draw_todo_count_view(result) {
	$('#count').text(result)
}

function draw_list(todos) {
	var str = '';
		for(var index in todos) {
			if(todos[index].completed == 0) {
				str += make_active_todo(todos[index]);
			} else {
				str += make_completed_todo(todos[index]);
			}
		}
	$('#list').html(str);
}

function make_active_todo(todo) {
	return '<li>' +
			'<div class="view" id ="' + todo.id + '">' +
				'<input class="toggle" type="checkbox">' +
				'<label>' + todo.todo + '</label>' +
				'<button class="destroy"></button>' +
			'</div>' +
			'<input class="edit" value="Rule the web">' +
		'</li>'
}

function make_completed_todo(todo) {
	return '<li class="completed">' +
		'<div class="view" id ="' + todo.id + '">' +
				'<input class="toggle" type="checkbox" checked>' +
				'<label>' + todo.todo + '</label>' +
				'<button class="destroy"></button>' +
			'</div>' +
			'<input class="edit" value="Create a TodoMVC template">' +
		'</li>';
}

function create_todo_view(todo){
	if($("#list-completed").attr('class') != 'selected'){
		$('#list').html(make_active_todo(todo) + $('#list').html());
	}
	$('.new-todo').val("");
}

function delete_todo_view(view) {
	view.parent("li").remove();
}

function delete_all_todo_view(){
	$('#list').html('');
}