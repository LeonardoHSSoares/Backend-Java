# EBAC - Mod39: Servidores de Aplicação

Este projeto é uma aplicação web desenvolvida em Java, utilizando o padrão de diretórios de aplicações Java EE/Jakarta EE. Ele faz parte do módulo 39 do curso Especialista Backend Java da EBAC.

## Estrutura do Projeto

```
webapp/
├── pom.xml
├── src/
│   └── main/
│       ├── webapp/
│       │   └── WEB-INF/
│       │       └── web.xml
│       └── webcontent/
│           ├── index.jsp
│           ├── css/
│           │   ├── estilo.css
│           │   ├── reset.css
│           │   └── responsivo.css
│           ├── images/
│           │   ├── one-piece-logo.png
│           │   ├── personagem-monkey-d-luffy.png
│           │   ├── personagem-nami.png
│           │   ├── personagem-roronoa-zoro.png
│           │   ├── personagem-sanji.png
│           │   ├── personagem-tony-chopper.png
│           │   ├── tripulacao-nami.png
│           │   ├── tripulacao-sanji.png
│           │   └── tripulacao-zoro.png
│           └── js/
│               └── interacao.js
└── target/
    ├── webapp.war
    ├── maven-archiver/
    │   └── pom.properties
    └── webapp/
        ├── META-INF/
        └── WEB-INF/
            ├── web.xml
            └── classes/
```

## Descrição

A aplicação simula um site temático do anime One Piece, com uma página principal (`index.jsp`) que apresenta imagens dos personagens, estilos personalizados e interações via JavaScript. O projeto utiliza Maven para gerenciamento de dependências e empacotamento.

### Principais Arquivos
- **pom.xml**: Arquivo de configuração do Maven.
- **web.xml**: Arquivo de configuração do servlet container (Tomcat, Jetty, etc).
- **index.jsp**: Página principal da aplicação.
- **css/**: Estilos para layout, reset e responsividade.
- **images/**: Imagens dos personagens e logos do site.
- **js/interacao.js**: Scripts para interação na página.

## Como Executar

1. **Pré-requisitos:**
   - Java JDK 8 ou superior
   - Maven
   - Servidor de aplicação compatível (Tomcat recomendado)

2. **Build do projeto:**
   ```bash
   mvn clean package
   ```
   O arquivo `webapp.war` será gerado na pasta `target/`.

3. **Deploy:**
   - Copie o arquivo `webapp.war` para o diretório `webapps` do Tomcat.
   - Inicie o Tomcat e acesse `http://localhost:8080/webapp`.

## Funcionalidades
- Página inicial com imagens dos personagens de One Piece
- Estilos responsivos para diferentes dispositivos
- Interações básicas via JavaScript

## Estrutura do web.xml
O arquivo `web.xml` define o nome da aplicação e a página de boas-vindas:
```xml
<web-app>
  <display-name>Tarefa Modulo 39 (Especialista Backend Java)</display-name>
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```

## Autor
Leonardo H. S. Soares

