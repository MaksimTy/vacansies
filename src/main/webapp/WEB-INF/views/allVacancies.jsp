<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All vacancies</title>
    <link rel="stylesheet" href="<c:url value="/res/style.css"/>" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row">
        <div>
            <form>
                <div class="form-group">
                    <input class="form-control form-control" type="text" placeholder="Company">
                    <input class="form-control" type="text" placeholder="vacancy">
                    <input class="form-control form-control" type="date" placeholder="from">
                    <input class="form-control form-control" type="date" placeholder="to">
                    <button type="submit" class="btn btn-primary">Filter</button>
                </div>
            </form>
        </div>
        <h1>All vacancies</h1>
        <table class="table-sm table-hover">
            <tr>
                <th scope="col">id</th>
                <th scope="col">company</th>
                <th scope="col">vacancy</th>
                <th scope="col">request date</th>
                <th scope="col">response date</th>
                <th scope="col">response</th>
            </tr>
            <c:forEach var="vacancy" items="${vacancies}">
                <c:url value="/edit/${vacancy.id}" var="url"/>
                <tr onclick="location.href='${url}'">
                    <td scope="row">${vacancy.id}</td>
                    <td>${vacancy.company}</td>
                    <td>${vacancy.vacancy}</td>
                    <td>${vacancy.requestDate}</td>
                    <td>${vacancy.responseDate}</td>
                    <td>${vacancy.answer}</td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="6">
                    <c:url value="/add" var="add"/>
                    <p><a href="${add}">add vacancy</a></p>
                    <c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">
                        <c:url value="/" var="url">
                            <c:param name="page" value="${i.index}"/>
                        </c:url>
                        <a href="${url}">${i.index}</a>
                    </c:forEach>
                </td>
            </tr>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">10</a></li>
                <li class="page-item"><a class="page-link" href="#">11</a></li>
                <li class="page-item"><a class="page-link" href="#">12</a></li>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </nav>

    </div>
</div>

</body>
</html>
