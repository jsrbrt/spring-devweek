<h1>Restaurante API</h1>
<p>API para expor um CRUD de um dominínio de Restaurante</p>
<p align="center">
<a href="https://docs.google.com/presentation/d/11rOmP1u7nwYv5mL4ovmquYMZWktPwIiJ/edit?usp=sharing&ouid=101340348592910912358&rtpof=true&sd=true">Slides dia 3</a>  
<a href="https://docs.google.com/presentation/d/162KrAjBivpN4GKzPVwv7y-JcIPUnN1_h/edit?usp=sharing&ouid=101340348592910912358&rtpof=true&sd=true">Slides dia 4</a>
</p>

<img src="https://i.imgur.com/pfubmkj.png" alt="Restaurante API Swagger UI">

<h3>Features</h3>

- [x] Cadastrar restaurantes no banco de dados<br>
- [x] Visualizar todos os restaurantes do banco de dados<br>
- [x] Visualizar um restaurante específico já salvo no banco de dados<br>
- [x] Atualizar um restaurante já salvo no banco de dados<br>
- [x] Deletar um restaurante já salvo no banco de dados<br>
- [x] Cadastrar produtos no banco de dados<br>
- [x] Visualizar todos os produtos do banco de dados<br>
- [x] Visualizar um produto específico já salvo no banco de dados<br>
- [x] Atualizar um produto já salvo no banco de dados<br>
- [x] Deletar um produto já salvo no banco de dados<br>

<h3>Para você fazer:</h3>
<ol>
	<li>Incluir uma query SQL no arquivo <strong>data.sql</strong> para a persistência de alguns produtos no banco de dados em memória H2</li>
	<li>Criar a interface <code>ProdutoService</code> para o <strong>CRUD</strong> de Produtos</li>
	<li>Criar a classe <code>RestauranteServiceImpl</code> para implementar a interface criada no tópico anterior</li>
	<li>Criar a classe DTO <code>ProdutoDto</code></li>
	<li>Criar a classe <code>ProdutoResource</code> com as anotação do <strong>Swagger</strong></li>
	<li>Criar a interface <code>ProdutoRepository</code></li>
	<li>Implementar os métodos da classe de servico <code>ProdutoServiceImpl</code></li>
	<li>Testar no <strong>Swagger UI</strong></li>
</ol>

<h3>Ferramentas Utilizadas</h3>

<table>
<tr>
	<th>Ferramenta</th>
	<th>Versão</th>
</tr>
<tr>
	<td>Java JDK</td>
	<td>17</td>
</tr>
<tr>
	<td>Git</td>
	<td>2.**</td>
</tr>
<tr>
	<td>Gradle</td>
	<td>7.**</td>
</tr>
<tr>
	<td>Postman</td>
	<td>9.**</td>
</tr>
</table>

<h3>Tecnologias Utilizadas</h3>

<table>
<tr>
	<th>Dependência</th>
	<th>Versão</th>
</tr>
<tr>
	<td>spring initialzr</td>
	<td><a href="https://start.spring.io/">https://start.spring.io/</a></td>
</tr>
<tr>
	<td>spring-boot-starter-web</td>
	<td>2.7.3</td>
</tr>
<tr>
	<td>spring-boot-starter-data-jpa</td>
	<td>2.7.3</td>
</tr>
<tr>
	<td>lombok</td>
	<td>1.18.24</td>
</tr>
<tr>
	<td>springfox-boot-starter</td>
	<td>3.0.0</td>
</tr>
<tr>
	<td>h2</td>
	<td>2.1.214</td>
</tr>
</table>
