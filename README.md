<h1>Price Whisper</h1>

<h2>OM. CORP - Integrantes do Grupo</h2>

<ul>
    <li><strong>Matheus Augusto Leite</strong> - RM99697</li>
    <li><strong>André Sant'Ana Boim</strong> - RM551575</li>
    <li><strong>Marcelo Hespanhol Dias</strong> - RM98251</li>
    <li><strong>Gustavo Imparato Chaves</strong> - RM551988</li>
    <li><strong>Gabriel Eringer de Oliveira</strong> - RM99632</li>
</ul>


<h2>Como Rodar a Aplicação</h2>

<ol>
    <li><strong>Pré-requisitos:</strong> Certifique-se de ter instalado o Java JDK 11 ou superior e um banco de dados compatível com a aplicação.</li>
    <li>Clone o repositório para sua máquina local usando o comando:
        <pre><code>git clone &lt;link-do-repositorio&gt;</code></pre>
    </li>
    <li>Acesse o diretório do projeto:
        <pre><code>cd price-whisper</code></pre>
    </li>
    <li>Configure as variáveis de ambiente ou arquivos de configuração conforme necessário para seu ambiente de desenvolvimento.</li>
    <li>Compile e execute a aplicação:
        <pre><code>mvn spring-boot:run</code></pre>
    </li>
</ol>

<h2>Importar Testes no Postman</h2>
<p>Para importar testes no Postman, siga estas etapas:</p>

<ol>
    <li><strong>Abra o Postman:</strong> Inicie o aplicativo Postman no seu computador.</li>
    <li><strong>Vá para a aba "Collections":</strong> No painel esquerdo, encontre e clique em "Collections" para ver as coleções existentes.</li>
    <li><strong>Inicie o processo de importação:</strong> Na parte superior do painel "Collections", clique no botão "Import".</li>
    <li><strong>Selecione o arquivo:</strong> Clique em "Upload Files" para selecionar o arquivo de teste que você deseja importar. Certifique-se de que o arquivo esteja em um formato compatível, como JSON ou coleção Postman.</li>
    <li><strong>Complete a importação:</strong> Depois de selecionar o arquivo, clique em "Import" para iniciar a importação.</li>
    <li><strong>Verifique as coleções:</strong> Após a importação, suas coleções de testes estarão disponíveis na aba "Collections" à esquerda. Você pode agora visualizar e executar os testes importados.</li>
</ol>


<h2>Imagem dos Diagramas</h2>

![Diagrama de Classes](https://github.com/mthaugusto/price-whisper/blob/main/documentacao/Diagrama%20de%20Entidades.png)


![DER](https://github.com/mthaugusto/price-whisper/blob/main/documentacao/DER.png)


<h2>Vídeo de Apresentação</h2>

<a>https://youtu.be/eISb8jnswdg</a>

<h2>Documentação da API</h2>

<h3>Categorias</h3>

<ul>
    <li><strong>GET /categorias</strong>: Retorna uma lista de todas as categorias.</li>
    <li><strong>GET /categorias/{id}</strong>: Retorna uma categoria específica pelo ID.</li>
    <li><strong>POST /categorias</strong>: Cria uma nova categoria com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
    "nome": "Nome da Categoria",
    "descricao": "Descrição da Categoria"
}
</code></pre>
        </li>
    </ul>
</ul>

<h3>Marcas</h3>

<ul>
    <li><strong>GET /marcas</strong>: Retorna uma lista de todas as marcas.</li>
    <li><strong>GET /marcas/{id}</strong>: Retorna uma marca específica pelo ID.</li>
    <li><strong>POST /marcas</strong>: Cria uma nova marca com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
	"nome": "Marca Y",
	"descricao": "Descrição da Marca Y"
}</code></pre>
        </li>
    </ul>
</ul>

<h3>Modelos</h3>

<ul>
    <li><strong>GET /modelos</strong>: Retorna uma lista de todos os modelos.</li>
    <li><strong>GET /modelos/{id}</strong>: Retorna um modelo específico pelo ID.</li>
    <li><strong>POST /modelos</strong>: Cria um novo modelo com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
  "nome": "Modelo Z",
  "descricao": "Descrição do Modelo Z",
  "marcaId": 1  
}</code></pre>
        </li>
    </ul>
</ul>

<h3>Produtos</h3>

<ul>
    <li><strong>GET /produtos</strong>: Retorna uma lista de todos os produtos.</li>
    <li><strong>GET /produtos/{id}</strong>: Retorna um produto específico pelo ID.</li>
    <li><strong>POST /produtos</strong>: Cria um novo produto com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
  "nome": "Tênis de Corrida",
  "descricao": "Tênis confortável para corrida",
  "precoCusto": 80.50,
  "precoVenda": 120.00,
  "precoMinimo": 100.00,
  "estoque": 50,
  "modeloId": 4,
  "categoriaId": 1
}</code></pre>
        </li>
    </ul>
</ul>

<h3>Histórico de Vendas</h3>

<ul>
    <li><strong>GET /carrinho</strong>: Retorna uma lista de todo o histórico de vendas.</li>
    <li><strong>GET /carrinho/{id}</strong>: Retorna um histórico de vendas específico pelo ID.</li>
    <li><strong>POST /carrinho</strong>: Cria um novo registro de histórico de vendas com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
  "produtoId": 1, 
  "dataVenda": "2023-04-14", 
  "precoVenda": 22.00,
  "quantidadeVendida": 10
}</code></pre>
        </li>
    </ul>
</ul>

<p>Para informações mais detalhadas sobre os endpoints, consulte a documentação de código ou use ferramentas de API como Postman para explorar a API.</p>
