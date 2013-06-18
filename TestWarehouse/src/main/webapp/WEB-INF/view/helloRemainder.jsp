<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="well well-large">
        <h4 class="help-block" >Документ «Остатки»</h4>
        <h5 class="help-block">Выберете дату, по которой нужно просчитать остатки</h5>
    </div>
</div>

<div class="container">
    <div class="well well-large">
        <form action="remainder.htm" method="post">
            <strong>Дата:  </strong><input type="text" name="date" id="datepicker" style="width: 85px"
                                           placeholder="Дата" required/>
            <div>
                <input class="btn btn-inverse btn-small" type="submit" value="Просмотреть «Остатки»"/>
            </div>
        </form>  
        <div>



        </div>
    </div>
</div>
