/**
 * Created by employee on 11/24/16.
 */
function deleteTask(taskId) {
    $.ajax({
        async: false,
        type: "DELETE",
        url: "/task?taskId=" + taskId
    })
}

function deleteTaskList(id) {
    $.ajax({
        async: false,
        type: "DELETE",
        url: "/taskList?listId=" + id
    })
}

function deleteMessage(messageId, taskId) {
    $.ajax({
        async: false,
        type: "DELETE",
        url: "/message?messageId=" + messageId + "&taskId=" + taskId
    })
}

function switchStatusTask(taskId, status) {
    $.ajax({
        async: false,
        type: "PUT",
        url: "/task/" + taskId + "/status/" + status
    })
}

function viewTaskListEdit(id) {
    document.getElementById('linkList' + id).style.display = 'none';
    document.getElementById('editIcon' + id).style.display = 'none';
    document.getElementById('editList' + id).style.display = 'block';
    document.getElementById('saveIcon' + id).style.display = 'block';
}

function saveTaskList(id) {
    document.getElementById('editIcon' + id).style.display = 'block';
    document.getElementById('saveIcon' + id).style.display = 'none';
    var link = document.getElementById('linkList' + id);
    var input = document.getElementById('editList' + id);
    input.style.display = 'none';
    link.style.display = 'block';

    document.getElementById('linkListValue' + id).value = input.value;

    $.ajax({
        async: false,
        type: "PATCH",
        url: "/taskList?listId=" + id + "&listName=" + input.value
    });
}