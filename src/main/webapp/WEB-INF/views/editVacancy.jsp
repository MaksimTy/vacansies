<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty vacancy.id}">
        <c:set value="Add vacancy" var="title"/>
        <c:url value="/add" var="var"/>
        <c:set value="success" var="color"/>
    </c:if>
    <c:if test="${!empty vacancy.id}">
        <c:set value="Edit vacancy" var="title"/>
        <c:url value="/edit" var="var"/>
        <c:set value="warning" var="color"/>
    </c:if>
    <title>${title}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <c:url value="/res/style.css" var="style"/>
    <link rel="stylesheet" href="${style}" type="text/css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <h5 class="card-header text-white bg-${color}">${title}</h5>
                <div class="card-body">
                    <form action="${var}" method="post">
                        <c:if test="${!empty vacancy.id}">
                            <input type="hidden" name="id" value="${vacancy.id}">
                        </c:if>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="company">Company</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" name="company" id="company"
                                       value="${vacancy.company}" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="vacancy">Vacancy</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" name="vacancy" id="vacancy"
                                       value="${vacancy.vacancy}" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="mail">E-mail</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="email" name="mail" id="mail" value="${vacancy.mail}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="vacancyLink">Link</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" name="vacancyLink" id="vacancyLink"
                                       value="${vacancy.vacancyLink}"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="text">Description</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" rows="20" name="text"
                                          id="text">${vacancy.text}</textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="requestDate">Request date</label>
                            <div class="col-sm-3">
                                <input class="form-control" type="date" name="requestDate" id="requestDate"
                                       value="${vacancy.requestDate}" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="responseDate">Response date</label>
                            <div class="col-sm-3">
                                <input class="form-control" type="date" name="responseDate" id="responseDate"
                                       value="${vacancy.responseDate}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="answer">Response</label>
                            <div class="col-sm-3">
                                <input class="form-control" type="text" name="answer" id="answer"
                                       value="${vacancy.answer}">
                            </div>
                        </div>
                        <div class="btn-group" role="group" aria-label="basic">
                            <input type="submit" class="btn btn-${color}" value=" ${title}">
                            <a class="btn btn-primary" type="button" href="<c:url value="/"/>">To the list</a>
                            <c:if test="${!empty vacancy.id}">
                                <a class="btn btn-danger" type="button" href="<c:url value="/delete/${vacancy.id}"/>">Del</a>
                            </c:if>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>