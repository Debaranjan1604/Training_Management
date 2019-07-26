<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isErrorPage = "true" %>

<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<%
        session.invalidate();
        response.sendRedirect("/");
    %>
		