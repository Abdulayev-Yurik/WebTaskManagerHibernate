<jsp:useBean id="task" scope="request" type="taskmanager.model.Task"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" type="image/ico" href="/resources/img/favicon-tasks.ico"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="/resources/js/lib/jquery-2.1.0.min.js"></script>
    <script src="/resources/js/main.js"></script>
    <script src="/resources/js/details_task.js"></script>
</head>
<body>
<a href="/home">Back</a>
<form action="/message" method="post">
    <input type="hidden" name="taskId" value="${task.taskId}">
    <input type="text" placeholder="Enter new message" name="mBody" required>
    <input type="submit" value="Add message">
</form>
<input type="submit" id="config_btn" value="Edit inf" onclick="viewEditTask(${task.taskId})">
<input type="submit" value="Save inf" onclick="saveEditedTask(${task.taskId})">
<table class="taskListPage card-1">
    <tr></tr>
    <tr></tr>
    <tr><h2>Task Details</h2></tr>
    <tr>
        <td><label>Task title:</label></td>
        <td>
            <input type="text" id="viewT" value="${task.taskTitle}" size="${task.taskTitle.length()}"
                   style="border: none; background: none">
            <input type="text" id="editT"
                   value="${task.taskTitle}" style="display: none">
        </td>
    </tr>
    <c:if test="${!task.details.isEmpty()}">
        <tr>
            <td><label>Task details:</label></td>
            <td>
                <input type="button" id="viewD" value="${task.details}"
                       style="border: none; background: none">
                <input type="text" id="editD"
                       value="${task.details}" style="display: none">
            </td>
        </tr>
    </c:if>
    <c:if test="${!(task.dueDate == null)}">
        <tr>
            <td><label>Task deadLine:</label></td>
            <td>
                <input type="button" id="viewDate" value="${task.dueDate}"
                       style="border: none; background: none">
                <input type="date" id="editDate"
                       value="${task.dueDate}" style="display: none">
            </td>
        </tr>
    </c:if>
    <tr>
        <td><label>Task from : </label></td><td>${task.listTasks.listName} </td>
    </tr>
    <c:if test="${task.messagesValues != 0}">
        <tr>
            <td><label>Task messages:</label></td>
        </tr>
        <c:forEach items="${task.messages}" var="message">
            <tr>
                <td>
                    <input type="button" id="msgView${message.id}" value="${message.messageBody}"
                           style="border: none; background: none">
                    <input type="text" id="msgEdit${message.id}"
                           onkeydown="if (event.keyCode == 13) saveMessage(${message.id})"
                           value="${message.messageBody}"
                           style="display: none">
                </td>

                <td>
                    <i id="editIcon${message.id}" class="fa fa-pencil-square-o" style="color: orange"
                       onclick="viewEditMessage(${message.id})"
                       aria-hidden="true"></i>

                    <i id="saveIcon${message.id}" class="fa fa-floppy-o" style="color: green; display: none"
                       onclick="saveMessage(${message.id})"
                       aria-hidden="true"></i>
                </td>
                <td>
                    <a href="" onclick="deleteMessage(${message.id}, ${task.taskId})">
                        <i class="material-icons" style="color: red; font-size:20px">delete_forever</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
