<jsp:useBean id="taskLists" scope="request" type="java.util.List<taskmanager.model.TaskList>"/>
<jsp:useBean id="taskActiveList" scope="request" type="java.util.List<taskmanager.model.Task>"/>
<jsp:useBean id="taskDoneList" scope="request" type="java.util.List<taskmanager.model.Task>"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" type="image/ico" href="/resources/img/favicon-tasks.ico"/>
    <title>Task manager InCamp</title>

    <link rel="stylesheet" href="/resources/css/style.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <meta name="viewport" content="width=device-width" />
    <script src="/resources/js/lib/jquery-2.1.0.min.js"></script>
    <script src="/resources/js/main.js"></script>
</head>
<body>
<div class="page">
    <select name="listId" onchange="window.location = '/home/' + this.value;">
        <option value="0">All Tasks</option>
        <c:forEach items="${taskLists}" var="taskList">
            <option value="${taskList.id}"
                    <c:if test="${taskList.id == listId}">selected</c:if> >${taskList.listName}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Add Task" onclick="window.location='/task'">
    <input type="submit" value="Task Lists" onclick="window.location='/taskList'"><br>
    <c:if test="${taskActiveList.size() != 0}">
        <div class="activeList card-1">
            <table>
                <tr></tr>
                <tr></tr>
                <tr><h2>Active Tasks</h2></tr>
                <c:forEach items="${taskActiveList}" var="task">
                    <tr>
                        <td>
                                ${task.taskTitle}
                        </td>
                        <c:if test="${task.status}">
                            <td title="close task">
                                <a href="" onclick="switchStatusTask(${task.taskId}, ${task.status})">
                                    <i class="material-icons" style="font-size:20px; color: orange">done_all</i>
                                </a>
                            </td>
                        </c:if>
                        <td>
                            <a href="/task/details/${task.taskId}">
                                <i class="material-icons" style="color: green; font-size:14px">announcement</i>
                                    ${task.messagesValues}</a>
                        </td>
                        <td>
                            <a href="" onclick="deleteTask(${task.taskId})">
                                <i class="material-icons" style="color: red; font-size:20px">delete_forever</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
    <c:if test="${taskDoneList.size() != 0}">
        <div class="doneList card-1">
            <table>
                <tr></tr>
                <tr></tr>
                <tr><h2>Done Tasks</h2></tr>
                <c:forEach items="${taskDoneList}" var="task">
                    <tr>
                        <td>
                                ${task.taskTitle}
                        </td>
                        <c:if test="${!task.status}">
                            <td title="reopen task">
                                <a href="" onclick="switchStatusTask(${task.taskId}, ${task.status})">
                                    <i class="material-icons"
                                       style="font-size:20px; color: orange">add_to_queue</i>
                                </a>
                            </td>
                        </c:if>
                        <td>
                            <a href="/task/details/${task.taskId}">
                                <i class="material-icons" style="color: green; font-size:14px">announcement</i>
                                    ${task.messagesValues}</a>
                        </td>
                        <td>
                            <a href="" onclick="deleteTask(${task.taskId})">
                                <i class="material-icons" style="color: red; font-size:20px">delete_forever</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
