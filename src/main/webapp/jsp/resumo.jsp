<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resumo Financeiro</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Resumo Financeiro</h1>
        
        <div class="resumo-cards">
            <div class="card receita">
                <h3>Total de Receitas</h3>
                <p class="valor">R$ <bean:write name="gerenciador" property="totalReceitas" format="#,##0.00"/></p>
            </div>
            
            <div class="card despesa">
                <h3>Total de Despesas</h3>
                <p class="valor">R$ <bean:write name="gerenciador" property="totalDespesas" format="#,##0.00"/></p>
            </div>
            
            <div class="card saldo">
                <h3>Saldo Final</h3>
                <p class="valor">R$ <bean:write name="gerenciador" property="saldo" format="#,##0.00"/></p>
            </div>
        </div>
        
        <a href="index.jsp" class="btn btn-secondary">Voltar</a>
    </div>
</body>
</html>