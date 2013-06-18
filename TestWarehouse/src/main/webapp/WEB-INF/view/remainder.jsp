<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="well well-large">
        <h4 class="help-block" >Документ «Остатки»</h4>
    </div>
</div>

<div class="container">
    <div class="well well-large">
        <form action="remainder.htm" method="post">
            <strong>Дата:  </strong><input type="text" name="date" id="datepicker" style="width: 85px"
                                           placeholder="Дата" required />
            <div>
                <input class="btn btn-inverse btn-small" type="submit" value="Просмотреть «Остатки»"/>
            </div>
        </form>  
        <div>
            <table class="table table-bordered" border="2">
                <thead>
                    <tr>
                        <th></th>
                <c:forEach items="${warehouse}" var="warehouse">
                    <th><c:out value="${warehouse.warehouse}"/></th>
                </c:forEach>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${remainder}" var="remainder">  
                    <tr>
                        <th><c:out value="${remainder.product}"/></th>
                    <td>
                    <c:choose>
                        <c:when test="${remainder.amountWH1>0}">
                            <c:out value="${remainder.priceWH1}"/> грн.<br>
                            <c:out value="${remainder.amountWH1}"/> шт.
                        </c:when>
                        <c:otherwise>
                            --
                        </c:otherwise>
                    </c:choose>
                    </td>
                    <td>
                    <c:choose>
                        <c:when test="${remainder.amountWH2>0}">
                            <c:out value="${remainder.priceWH2}"/> грн.<br>
                            <c:out value="${remainder.amountWH2}"/> шт.
                        </c:when>
                        <c:otherwise>
                            --
                        </c:otherwise>
                    </c:choose>
                    </td>
                    <td>
                    <c:choose>
                        <c:when test="${remainder.amountWH3>0}">
                            <c:out value="${remainder.priceWH3}"/> грн.<br>
                            <c:out value="${remainder.amountWH3}"/> шт.
                        </c:when>
                        <c:otherwise>
                            --
                        </c:otherwise>
                    </c:choose>
                    </td>
                    <td>
                    <c:choose>
                        <c:when test="${remainder.amountWH4>0}">
                            <c:out value="${remainder.priceWH4}"/> грн.<br>
                            <c:out value="${remainder.amountWH4}"/> шт.
                        </c:when>
                        <c:otherwise>
                            --
                        </c:otherwise>
                    </c:choose>
                    </td>
                    <td>
                    <c:choose>
                        <c:when test="${remainder.amountWH5>0}">
                            <c:out value="${remainder.priceWH5}"/> грн.<br>
                            <c:out value="${remainder.amountWH5}"/> шт.
                        </c:when>
                        <c:otherwise>
                            --
                        </c:otherwise>
                    </c:choose>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>