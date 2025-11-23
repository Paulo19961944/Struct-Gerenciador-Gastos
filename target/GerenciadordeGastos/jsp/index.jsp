<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gerenciador Financeiro</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Gerenciador Financeiro Pessoal</h1>
        
        <div class="menu">
            <a href="${pageContext.request.contextPath}/jsp/adicionar-transacao.jsp">Adicionar Transação</a>
            <a href="${pageContext.request.contextPath}/jsp/listar-transacoes.jsp">Ver Todas as Transações</a>
            <a href="${pageContext.request.contextPath}/jsp/resumo.jsp">Resumo Financeiro</a>
        </div>
        
        <div class="resumo-rapido">
            <h2>Resumo Rápido</h2>
            <c:set var="gerenciador" value="${sessionScope.gerenciador}" />
            <c:if test="${not empty gerenciador}">
                <p>Saldo Atual: R$ <fmt:formatNumber value="${gerenciador.saldo}" pattern="#,##0.00"/></p>
            </c:if>
            <c:if test="${empty gerenciador}">
                <p>Bem-vindo! Use o menu acima para começar a gerenciar suas finanças.</p>
            </c:if>
        </div>
    </div>
</body>
</html>