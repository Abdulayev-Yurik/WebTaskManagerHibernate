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
        async:false,
        type: "DELETE",
        url: "/taskList?listId=" + id
    })
}

function deleteMessage(messageId, taskId) {
    $.ajax({
        async:false,
        type: "DELETE",
        url: "/message?messageId=" + messageId + "&taskId=" + taskId
    })
}

function switchStatusTask(taskId, status) {
    $.ajax({
        async:false,
        type: "PUT",
        url: "/task/switch?taskId=" + taskId + "&active=" + status
    })
}