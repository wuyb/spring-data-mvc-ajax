function renderTodo(todo) {
    $('<li/>', { id: todo.id }).appendTo('#todos');
    $('<label class="checkbox" id="todo-' + todo.id + '">').appendTo('#todos > #' + todo.id);
    $('<input id="todo-' + todo.id + '" type="checkbox"'
            + (todo.completed ? ' checked' : '')
            + '/>').appendTo('#todo-' + todo.id);
    $('<span class="' + (todo.completed ? 'todo-text todo-completed' : 'todo-text') + '">'
            + todo.text + '</span>').appendTo('#todo-' + todo.id);
    $('<a href="#" id="delete-todo-' + todo.id + '"/>').appendTo('#todo-' + todo.id);
    $('<i class="icon-remove"></i>').appendTo('#delete-todo-' + todo.id);

    // attach onclick event on the checkboxes, it posts a JSON request to update the status of the item
    $('#todo-' + todo.id).click(
        function(event) {
            $.ajax({ url: '/todo/' + todo.id, type: 'PUT', contentType : 'application/json',
                data: JSON.stringify({ id:todo.id, text:todo.text, completed:event.target.checked }),
                success: function() {
                    // change the class of item
                    $('#todo-' + todo.id + ' > span').attr('class',
                        (event.target.checked ? 'todo-text todo-completed' : 'todo-text'));
                }
            });
        }
    );

    // attach onclick event on the delete link
    $('#delete-todo-' + todo.id).click(
        function() {
            $.ajax({ url: '/todo/' + todo.id, type: 'DELETE',
                success: function() {
                    $('#todos > #' + todo.id).remove();
                }
            });
            return false;
        }
    );

}

$(document).ready(function() {

    // read the existing list from server when the page is loaded
    $.getJSON('/todo/', function(data) {
        // render the list of items in the #todos list (hello.jsp)
        $.each(data, function(i, todo) { renderTodo(todo); });
    });

    // attach submit event to the form
    $('#create-todo-form').submit(function(){
        $.post($(this).attr('action'), $(this).serialize(),
            function(todo) { renderTodo(todo);  $('#create-todo-text').val(''); }, 'json');
        return false;
    });
});