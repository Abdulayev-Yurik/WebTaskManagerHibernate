/**
 * Created by employee on 11/25/16.
 */

function viewEditMessage(id) {
    document.getElementById('msgView' + id).style.display = 'none';
    document.getElementById('msgEdit' + id).style.display = 'block';
    document.getElementById('editIcon' + id).style.display = 'none';
    document.getElementById('saveIcon' + id).style.display = 'block';
}

function saveMessage(id) {
    var view = document.getElementById('msgView' + id);
    var editor = document.getElementById('msgEdit' + id);
    document.getElementById('editIcon' + id).style.display = 'block';
    document.getElementById('saveIcon' + id).style.display = 'none';
    editor.style.display = 'none';
    view.style.display = 'block';

    view.value = editor.value;

    $.ajax({
        async: false,
        type: "PATCH",
        url: "/message?id="+ id + "&msg=" + editor.value
    })
}

function viewEditTask() {
    document.getElementById("viewT").style.display = 'none';
    document.getElementById("editT").style.display = 'block';
    document.getElementById("viewD").style.display = 'none';
    document.getElementById("editD").style.display = 'block';
    document.getElementById("viewDate").style.display = 'none';
    document.getElementById("editDate").style.display = 'block';

    document.getElementById('config_btn').value = "Save inf"
}

function saveEditedTask(id) {
    var title = document.getElementById("viewT");
    var editedTitle = document.getElementById("editT");
    var details = document.getElementById("viewD");
    var editedDetails = document.getElementById("editD");
    var dueDate = document.getElementById("viewDate");
    var editedDate = document.getElementById("editDate");
    document.getElementById('config_btn').value = "Save inf";

    title.style.display = 'block';
    details.style.display = 'block';
    dueDate.style.display = 'block';
    editedDate.style.display = 'none';
    editedTitle.style.display = 'none';
    editedDetails.style.display = 'none';

    title.value = editedTitle.value;
    details.value = editedDetails.value;
    dueDate.value = editedDate.value;

    $.ajax({
        async: false,
        type: "PATCH",
        url: "/task?id="+ id + "&title=" + editedTitle.value + "&details=" +
        editedDetails.value + "&date=" + editedDate.value
    })


}