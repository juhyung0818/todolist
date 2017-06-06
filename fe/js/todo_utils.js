
function create(){
	let enter = 13;
	if(event.keyCode == enter){
		var todo = $('.new-todo').val();
		if($.trim(todo) != 0){
			create_todo(todo, create_todo_view);
			get_count_todo(draw_todo_count_view);
		}
	}
}

function list_filter() {
	var hash = location.hash.replace('#','');
	get_list(hash, draw_list);

	hash = hash.replace('/','');
	$("#list-").attr('class', '');
	$("#list-active").attr('class', '');
	$("#list-completed").attr('class', '');

	$("#list-" + hash).attr('class', 'selected');
	get_count_todo(draw_todo_count_view);
	history.replaceState({}, '', window.location.href.substring(0, window.location.href.indexOf('#')))
}

function is_active_list_now() {
	return $("#list-active").attr('class') == 'selected';
}

function is_completed_list_now() {
	return $("#list-completed").attr('class') == 'selected';
}

function delete_completed_todo_by_condition() {
	if (is_active_list_now()){
		// do nothing
	} else if(is_completed_list_now()){
		delete_all_todo_view();
	} else {
		list_filter(); 
	}
}

function complete_todo_by_condition(view){
	if(is_active_list_now()){
		delete_todo_view(view);
	} else{
		list_filter();
	}

	get_count_todo(draw_todo_count_view);
}