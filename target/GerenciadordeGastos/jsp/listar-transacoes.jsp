<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Transações</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Lista de Transações</h1>
        
        <c:set var="gerenciador" value="${sessionScope.gerenciador}" />
        <c:set var="transacoes" value="${gerenciador.transacoes}" />
        
        <c:if test="${empty transacoes}">
            <p>Nenhuma transação cadastrada.</p>
        </c:if>
        
        <c:if test="${not empty transacoes}">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Descrição</th>
                        <th>Valor</th>
                        <th>Tipo</th>
                        <th>Categoria</th>
                        <th>Data</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="transacao" items="${transacoes}">
                        <tr>
                            <td>${transacao.id}</td>
                            <td>${transacao.descricao}</td>
                            <td>R$ <fmt:formatNumber value="${transacao.valor}" pattern="#,##0.00"/></td>
                            <td>
                                <span class="${transacao.tipo}">${transacao.tipo}</span>
                            </td>
                            <td>${transacao.categoria}</td>
                            <td>${transacao.data}</td>
                            <td>
                                <a href="transacao?action=remover&id=${transacao.id}" 
                                   class="btn btn-danger" 
                                   onclick="return confirm('Tem certeza que deseja remover esta transação?')">
                                    Remover
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <a href="index.jsp" class="btn btn-secondary">Voltar</a>
    </div>
</body>
</html>