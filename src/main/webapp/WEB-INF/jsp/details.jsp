<jsp:useBean id="task" scope="request" type="taskmanager.model.Task"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="/resources/js/lib/jquery-2.1.0.min.js"></script>
    <script src="/resources/js/main.js"></script>
</head>
<body>
<a href="/home">Back</a>
<form action="/message" method="post">
    <input type="hidden" name="taskId" value="${task.taskId}">
    <input type="text" placeholder="Enter new message" name="mBody" required>
    <input type="submit" value="Add message">
</form>
<table>
    <tr>
        <td>Task title: ${task.taskTitle}</td>
    </tr>
    <c:if test="${!task.details.isEmpty()}">
        <tr>
            <td>Task details: ${task.details}</td>
        </tr>
    </c:if>
    <c:if test="${!(task.dueDate == null)}">
        <tr>
            <td>Task dueDate: ${task.dueDate}</td>
        </tr>
    </c:if>
    <tr><td>Task from : ${task.listTasks.listName} </td></tr>
    <c:if test="${task.messagesValues != 0}">
        <tr><td>Task messages:</td></tr>
        <c:forEach items="${task.messages}" var="message">
            <tr>
                <td>${message.messageBody}</td>
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
