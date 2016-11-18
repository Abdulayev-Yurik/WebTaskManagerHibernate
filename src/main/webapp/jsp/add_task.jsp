<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../css/mystyle.css">
</head>
<body>
<a href="/home">Back</a>
<form action="/newTask">
    <input type="text" name="title" placeholder="Add your task" required>
    <input type="text" name="dueDate" maxlength="10" placeholder="Add due date '2016-12-14'" required><br>
    <textarea name="details" placeholder="Enter details"></textarea><br>
    Enter List : <select name="listId">
    <c:forEach items="${lists}" var="list">
        <option value="${list.id}">${list.listName}</option>
    </c:forEach>
    </select><br>

    <input type="submit" value="Add Task"><br>
</form>

</body>
</html>
