
function get_count_todo(callback) {
	$.ajax({
		type:'get',
		url:'/api/todos/count/0',
		dataType:'text',
		success:function(result) {
			callback(result);
		}
	});
}

function get_list(filter, callback) {
	$.ajax({
		type:'get',
		url:'/api/todos' + filter,
		dataType:'json',
		success:function(result) {
			callback(result);
		}
	});
}

function create_todo(todo, callback){
	$.ajax({
		type:'post',
		url:'/api/todos',
		headers: { 
			"Content-Type": "application/json"},
		dataType:'json',
		data: JSON.stringify({todo:todo}),
		success:function(result){
			callback(result);
		}
	});
}

function complete_todo(id, view) {
	$.ajax({
		type:'put',
		url:'/api/todos/' + id,
		dataType:'text', 
		success:function(result){
			complete_todo_by_condition(view)
	}});
}

function delete_todo(view, id, callback) { 
	$.ajax({
		type:'delete',
		url:'/api/todos/' + id,
		dataType:'text', 
		success:function() {
			callback(view, id);
		}
	});
}

function delete_completed_todo(callback){
	$.ajax({
		type:'delete',
		url:'/api/todos/',
		dataType:'text', 
		success:function(result){
			callback(result);
	}});
}