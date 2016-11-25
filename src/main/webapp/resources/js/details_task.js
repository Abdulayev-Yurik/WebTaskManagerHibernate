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