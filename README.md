# **Gerenciador de Gastos Pessoais**

Um sistema web para controle financeiro pessoal desenvolvido em **Java Struts 1.3**, permitindo o gerenciamento de receitas, despesas e acompanhamento do saldo financeiro.

## **Tecnologias Utilizadas**

- **Backend**: Java 11, Struts 1.3
- **Frontend**: JSP, JSTL, HTML, CSS
- **Build Tool**: Maven
- **Servidor**: Jakarta EE / Java EE
- **Persistencia**: Sessao HTTP (em memoria)

## **Funcionalidades**

- **Cadastro de Transacoes** - Adicionar receitas e despesas
- **Listagem de Transacoes** - Visualizar todas as transacoes cadastradas
- **Remocao de Transacoes** - Excluir transacoes indesejadas
- **Calculo Automatico** - Saldo, total de receitas e despesas
- **Categorizacao** - Organizar gastos por categorias
- **Resumo Financeiro** - Visao geral da situacao financeira

## **Estrutura do Projeto**

text

```
GerenciadordeGastos/
├── src/main/java/com/gerenciador/
│   ├── action/
│   │   └── GerenciadorAction.java
│   ├── form/
│   │   └── TransacaoForm.java
│   └── model/
│       ├── Transacao.java
│       └── GerenciadorFinanceiro.java
├── src/main/webapp/
│   ├── WEB-INF/
│   │   ├── struts-config.xml
│   │   └── web.xml
│   ├── css/
│   │   └── styles.css
│   ├── jsp/
│   │   ├── index.jsp
│   │   ├── adicionar-transacao.jsp
│   │   ├── listar-transacoes.jsp
│   │   └── resumo.jsp
│   └── index.jsp
└── pom.xml
```

## **Configuracao e Execucao**

### **Pre-requisitos**

- Java 11 ou superior
- Apache Maven 3.6+
- Servidor de Aplicacao (WildFly, Tomcat, GlassFish)
- Docker (para subir o banco Postgres via docker-compose)

### **Instalacao**

1. **Clone o repositorio**
    
    ```
    git clone https://github.com/Paulo19961944/Struct-Gerenciador-Gastos
    cd Struct-Gerenciador-Gastos
    ```
    
2. **Compile o projeto**
    
    ```
    mvn clean compile
    ```
    
3. **Empacote para deploy**
    
    ```
    mvn clean package
    ```
    
4. **Deploy no servidor**
    - Copie o arquivo `target/GerenciadordeGastos.war` para o diretorio de deploy do seu servidor

### **Banco de Dados com Docker**

Um container PostgreSQL pronto para uso esta definido no arquivo `docker-compose.yml` na raiz do projeto.

1. Suba o banco de dados:

   ```bash
   docker compose up -d
   ```

   O container expoe a porta `5432`, cria a base `gerenciador_gastos` e utiliza usuario/senha `postgres`.
2. O `persistence.xml` conecta diretamente via JDBC ao Postgres (RESOURCE_LOCAL) usando URL `jdbc:postgresql://localhost:5432/gerenciador_gastos` e usuario/senha `postgres`. Basta manter o container ativo na porta `5432` antes do deploy no WildFly.

### **Desenvolvimento**

Para desenvolvimento no NetBeans:

1. Abra o projeto no NetBeans
2. Configure o servidor de aplicacao
3. Execute o projeto (F6)

## **Como Usar**

1. **Pagina Inicial**: Visualize o resumo rapido do saldo
2. **Adicionar Transacao**:
    - Preencha descricao, valor, tipo (Receita/Despesa), categoria e data
    - Clique em "Adicionar Transacao"
3. **Listar Transacoes**:
    - Veja todas as transacoes cadastradas
    - Remova transacoes clicando no botao "Remover"
4. **Resumo Financeiro**:
    - Visualize totais de receitas, despesas e saldo final

## **Modelo de Dados**

### **Transacao**

- `id`: Identificador unico
- `descricao`: Descricao da transacao
- `valor`: Valor monetario
- `tipo`: "RECEITA" ou "DESPESA"
- `data`: Data da transacao
- `categoria`: Categoria personalizada

## **Configuracoes**

### **struts-config.xml**

Configuracao das actions e forms do Struts:


```
<action path="/gerenciador"type="com.gerenciador.action.GerenciadorAction"name="transacaoForm"scope="request"><forward name="success" path="/listar-transacoes.jsp"/></action>
```

### **web.xml**

Configuracao do servlet do Struts e mapeamentos.

## **Personalizacao**

### **Adicionar Novas Categorias**

Modifique o select em `adicionar-transacao.jsp`:


```
<html:select property="categoria">
    <html:option value="Alimentacao">Alimentacao</html:option>
    <html:option value="Transporte">Transporte</html:option>
    <html:option value="Moradia">Moradia</html:option>
    <!-- Adicione novas categorias aqui -->
</html:select>
```

### **Estilizacao**

Edite o arquivo `css/styles.css` para personalizar a aparencia.

## **Licenca**

Este projeto e de uso educacional e pode ser modificado conforme necessario.

## **Contribuicoes**

Contribuicoes sao bem-vindas! Sinta-se a vontade para:

- Reportar issues
- Sugerir novas funcionalidades
- Enviar pull requests

## **Suporte**

Em caso de duvidas ou problemas:

1. Verifique se todas as dependencias estao corretamente configuradas
2. Confirme que o servidor suporta Java EE
3. Verifique os logs do servidor para detalhes de erro

---

**Desenvolvido usando Java Struts 1.3**
