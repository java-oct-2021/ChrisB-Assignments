<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="books">
        <tr>
            <td><c:out value="${books.title}"/></td>
            <td><c:out value="${books.description}"/></td>
            <td><c:out value="${books.language}"/></td>
            <td><c:out value="${books.numberOfPages}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/books/new">New Book</a>

