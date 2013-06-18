<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">

    <div class="badge-important well well-small">
        <span class="label label-important"><h4>Внимание!</h4></span>                 
        <p><span class="label label-important">К сожалению <c:out value="${selectedDate}"/> на <c:out value="${selectedWarehouse}"/>, покупатель <c:out value="${selectedCustomer}"/> не производил закупок!</span></p>

    </div>

    <div class="well well-large">
        <h4 class="help-block" >Документ «Расход»</h4>
    </div>
</div>
<div class="container">
    <div class="well well-large">
        <div>
            <form action="expense.htm" method="post">
                <div>
                    <strong>Дата:  </strong><input type="text" name="date" id="datepicker" style="width: 85px"
                                                   placeholder="Дата" required />

                    <strong>Покупатель:  </strong>
                    <select name="customer" style="width: 125px" required >
                        <option></option>
                        <c:forEach items="${customer}" var="customer">
                            <option><c:out value="${customer.customer}"/></option>
                        </c:forEach>
                    </select>

                    <strong>Склад:  </strong>
                    <select name="warehouse" style="width: 125px" required >
                        <option></option>
                        <c:forEach items="${warehouse}" var="warehouse">
                            <option><c:out value="${warehouse.warehouse}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <input class="btn btn-inverse btn-small" type="submit" value="Просмотреть «Расход»"/>
                </div>
            </form>
        </div>

    </div>
</div>    