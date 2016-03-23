<strong>COTI Informática</strong>
<hr size="1"/>


<form name="f" method="post" action="ManterEstoque?cmd=cadastrar">

    Nome do Produto: <br/>
    <input type="text" name="nome"/>
    <br/><br/>

    Preço: <br/>
    <input type="text" name="preco" size="5"/>
    <br/><br/>

    Quantidade: <br/>
    <input type="text" name="quantidade" size="5"/>
    <br/><br/>

    <input type="submit" value="Cadastrar Produto"/>
    <input type="reset" value="Apagar"/>

</form>
<h4> ${mensagem} </h4>

<a href="index.jsp">Voltar para o menu inicial.</a>