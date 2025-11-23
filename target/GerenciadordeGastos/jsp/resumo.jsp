<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resumo Financeiro</title>
    <link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Resumo Financeiro</h1>
        
        <c:set var="gerenciador" value="${sessionScope.gerenciador}" />
        
        <div class="resumo-cards">
            <div class="card receita">
                <h3>Total de Receitas</h3>
                <p class="valor">R$ <fmt:formatNumber value="${gerenciador.totalReceitas}" pattern="#,##0.00"/></p>
            </div>
            
            <div class="card despesa">
                <h3>Total de Despesas</h3>
                <p class="valor">R$ <fmt:formatNumber value="${gerenciador.totalDespesas}" pattern="#,##0.00"/></p>
            </div>
            
            <div class="card saldo">
                <h3>Saldo Final</h3>
                <p class="valor">R$ <fmt:formatNumber value="${gerenciador.saldo}" pattern="#,##0.00"/></p>
            </div>
        </div>
        
        <a href="index.jsp" class="btn btn-secondary">Voltar</a>
    </div>
</body>
</html>