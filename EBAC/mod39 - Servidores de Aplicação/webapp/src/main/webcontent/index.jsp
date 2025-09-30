<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>One Piece - JSP</title>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/responsivo.css">
</head>
<body>
    <header>
        <h1>One Piece</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">Início</a></li>
                <li><a href="personagens.jsp">Personagens</a></li>
                <li><a href="contato.jsp">Contato</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section id="intro">
            <h2>Bem-vindo ao mundo de One Piece!</h2>
            <p>Explore os mares com a tripulação dos Chapéus de Palha.</p>
            <button id="btnMostrar">Mostrar Tripulação</button>
            <ul id="lista"></ul>
        </section>
    </main>

    <footer>
        <p>© 2025 - Projeto One Piece JSP</p>
    </footer>

    <script src="js/interacao.js"></script>
</body>
</html>
