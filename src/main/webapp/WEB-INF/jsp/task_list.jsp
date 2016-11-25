<%--<jsp:useBean id="taskLists" scope="request" type="java.util.List<model.TaskList>"/>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="/resources/js/lib/jquery-2.1.0.min.js"></script>
    <script src="/resources/js/main.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<a href="/home">Back</a>
<form action="/taskList" method="post">
    <input type="text" name="title" placeholder="List name" required><br>
    <input type="submit" value="Add List"><br>
</form>
<div class="activeList card-1">
    <table>
        <tr></tr>
        <tr></tr>
        <tr><h2>Task Lists</h2></tr>
        <c:forEach items="${taskLists}" var="taskList">
            <tr>
                <td><a id="linkList${taskList.id}" href="/home/${taskList.id}">
                    <input id="linkListValue${taskList.id}" type="button" value="${taskList.listName}" style="background: none; border: none">
                </a>

                    <input id="editList${taskList.id}" type="text" value="${taskList.listName}"
                           style="display: none"></td>
                <td>
                    <i id="editIcon${taskList.id}" class="fa fa-pencil-square-o" style="color: orange"
                       onclick="viewTaskListEdit(${taskList.id})"
                       aria-hidden="true"></i>

                    <i id="saveIcon${taskList.id}" class="fa fa-floppy-o" style="color: green; display: none"
                       onclick="saveTaskList(${taskList.id})"
                       aria-hidden="true"></i>
                </td>
                <td><a href="" onclick="deleteTaskList(${taskList.id})">
                    <i class="material-icons" style="color: red; font-size:20px">delete_forever</i>
                </a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
