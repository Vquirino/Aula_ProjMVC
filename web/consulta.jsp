<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<strong>COTI - Informática</strong>
<hr size="1"/>

<table border="1" width="80%">
    <tr>
        <th>Código</th>
        <th>Nome do Produto</th>
        <th>Preço</th>
        <th>Quantidade</th>
        <th>Total</th>
    </tr>
    
    <c:forEach items="${dados}" var="p">
        <tr>
            <td>${p.codigo}</td>
            <td>${p.nome}</td>
            <td>${p.preco}</td>
            <td>${p.quantidade}</td>
            <td>${p.preco * p.quantidade}</td>
        </tr>
    </c:forEach>
</table>

<br/><br/>
<a href="index.jsp">Voltar ao menu inicial</a>