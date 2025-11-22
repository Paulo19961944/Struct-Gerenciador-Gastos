<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gerenciador Financeiro</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Gerenciador Financeiro Pessoal</h1>
        
        <div class="menu">
            <a href="adicionar-transacao.jsp">Adicionar Transação</a>
            <a href="listar-transacoes.jsp">Ver Todas as Transações</a>
            <a href="resumo.jsp">Resumo Financeiro</a>
        </div>
        
        <div class="resumo-rapido">
            <h2>Resumo Rápido</h2>
            <c:set var="gerenciador" value="${sessionScope.gerenciador}" />
            <c:if test="${not empty gerenciador}">
                <p>Saldo Atual: R$ <fmt:formatNumber value="${gerenciador.saldo}" pattern="#,##0.00"/></p>
            </c:if>
        </div>
    </div>
</body>
</html>