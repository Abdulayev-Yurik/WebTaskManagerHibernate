<%--<jsp:useBean id="taskLists" scope="request" type="java.util.List<model.TaskList>"/>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<a href="/home">Back</a>
<form action="/newList">
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
                <td><a href="/home?listId=${taskList.id}">${taskList.listName}</a></td>
                <td><a href="/deleteList?listId=${taskList.id}">
                        <i class="material-icons" style="color: red; font-size:20px">delete_forever</i>
                    </a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
