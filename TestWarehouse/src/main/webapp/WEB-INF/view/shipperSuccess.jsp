<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">

    <div class="badge-success well well-small">
        <span class="label label-success"><h4>Поставка совершена успешно!</h4></span>
    </div> 

    <div class="well well-large">
        <div>
            <form action="addShipperInfo.htm" method="post">
                <div>                            
                    <strong>Дата:  </strong><input type="text" name="date" id="datepicker" style="width: 85px"
                                                   placeholder="Дата" required />

                    <strong>Поставщик:  </strong>
                    <select name="shipper" style="width: 125px" required >
                        <option></option>
                        <c:forEach items="${shipper}" var="shipper">
                            <option><c:out value="${shipper.shipper}"/></option>                         
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
                    <table class="table table-bordered" border="3" width="2" cellspacing="2" cellpadding="2" >
                        <thead>
                            <tr>
                                <th>Товар</th>
                                <th>Количество</th>
                                <th>Цена за шт.</th>
                                <th>Сумма(расчетная)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="count" value="1" scope="page" />
                            <c:forEach begin="1" end="${rowAmount}" step="1">
                                <tr>
                                    <td>
                                        <label for="product${count}"></label>
                                        <input type="text" name="product${count}" placeholder="Продукт" required />
                                    </td>
                                    <td>
                                        <label for="amount${count}"></label>
                                        <input type="text" name="amount${count}" name="msg" placeholder="Кол-во" required pattern="^[ 0-9]+$" />
                                    </td>
                                    <td>
                                        <label for="price${count}"></label>
                                        <input type="text" name="price${count}" name="msg" placeholder="Цена" required pattern="\d+(\.\d{2})?" />
                                    </td>
                                    <td>
                                        <label for="amountToBePaid${count}"></label>
                                        <input type="text" name="amountToBePaid${count}" placeholder="Итог" required pattern="\d+(\.\d{2})?"  />
                                    </td>
                                </tr>
                                <c:set var="count" value="${count + 1}" scope="page"/>

                            </c:forEach>
                        </tbody>
                    </table>

                </div>

                <input class="btn btn-success" type="submit" name="" value="Сделать поставку" />
            </form>
        </div>
        <form action="shipper.htm" method="post">
            <input class="btn btn-success" type="submit" name="" value="Добавить строку" />
            <input type="hidden" name="addRow"  value="${rowAmount+1}">
            <input type="hidden" name="total"  value="${count}">
        </form>             
    </div>    
</div>
