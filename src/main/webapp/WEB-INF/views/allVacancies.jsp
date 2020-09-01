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
        <div class="col-sm">
            <div>
                <form action="/filter" method="post">
                    <div class="form-group">
                        <input class="form-control form-control mt-2" type="text" placeholder="Company" name="company"
                               id="company" value="${company}">
                        <input class="form-control mt-2" type="text" placeholder="Vacancy" name="vacancy"
                               id="vacancy" value="${vacancy}">

                        <div class="row">
                            <div class="col-sm-3">
                                <label class="filter-label col-form-label mt-2">Request date</label>
                            </div>
                            <div class="col-sm-3">
                                <input class="form-control form-control mt-2" type="date" placeholder="from"
                                       name="request_from"
                                       id="request_from" value="${request_from}">
                                <input class="form-control form-control mt-2" type="date" placeholder="to"
                                       name="request_to"
                                       id="request_to" value="${request_to}">
                            </div>
                            <div class="col-sm-3">
                                <label class="filter-label col-form-label mt-2">Response date</label>
                            </div>
                            <div class="col-sm-3">
                                <input class="form-control form-control mt-2" type="date" placeholder="from"
                                       name="response_from"
                                       id="response_from" value="${response_from}">
                                <input class="form-control form-control mt-2" type="date" placeholder="to"
                                       name="response_to"
                                       id="response_to" value="${response_to}">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Filter</button>
                    </div>
                </form>
            </div>
            <div>
                <h1>All vacancies</h1>
            </div>
            <div>
                <c:url value="/add" var="add"/>
                <a class="btn btn-primary" type="button" href="${add}">add vacancy</a>
            </div>
            <div class="justify-content-center">
                <table class="table-sm table-hover p-2 bd-highlight">
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
                </table>
            </div>
            <div>
                <nav aria-label="navigation">
                    <ul class="pagination justify-content-center">
                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                        <c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">

                                <c:url value="/" var="url">
                                    <c:param name="page" value="${i.index}"/>
                                </c:url>

                            <li class="page-item"><a class="page-link" href="${url}">${i.index}</a></li>
                        </c:forEach>
                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>

</body>
</html>
