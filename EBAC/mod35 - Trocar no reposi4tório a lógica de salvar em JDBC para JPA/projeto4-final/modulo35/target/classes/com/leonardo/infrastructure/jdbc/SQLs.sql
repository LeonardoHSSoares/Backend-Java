
-- script para criação de um cliente

SELECT * FROM tb_produto;


create table tb_venda(
	id bigint,
	codigo varchar(10) not null,
	id_cliente_fk bigint not null,
	valor_total numeric(10,2) not null,
	data_venda TIMESTAMPTZ not null,
	status_venda varchar(50) not null,
	constraint pk_id_venda primary key(id),
	constraint fk_id_cliente_venda foreign key(id_cliente_fk) references tb_cliente(id)
);

create table tb_produto_quantidade(
	id bigint,
	id_produto_fk bigint not null,
	id_venda_fk bigint not null,
	quantidade int not null,
	valor_total numeric(10,2) not null,
	constraint pk_id_prod_venda primary key(id),
	constraint fk_id_prod_venda foreign key(id_produto_fk) references tb_produto(id),
	constraint fk_id_prod_venda_venda foreign key(id_venda_fk) references tb_venda(id)
);

create sequence sq_cliente
start 1
increment 1
owned by tb_cliente.id;

create sequence sq_venda
start 1
increment 1
owned by tb_venda.id;

create sequence sq_produto_quantidade
start 1
increment 1
owned by tb_produto_quantidade.id;

ALTER TABLE TB_CLIENTE
ADD CONSTRAINT UK_CPF_CLIENTE UNIQUE (CPF);

ALTER TABLE TB_PRODUTO
ADD CONSTRAINT UK_CODIGO_PRODUTO UNIQUE (CODIGO);

ALTER TABLE TB_VENDA
ADD CONSTRAINT UK_CODIGO_VENDA UNIQUE (CODIGO);


SELECT V.ID AS ID_VENDA, V.CODIGO, V.ID_CLIENTE_FK, V.VALOR_TOTAL, V.DATA_VENDA, V.STATUS_VENDA,
C.ID AS ID_CLIENTE, C.NOME, C.CPF, C.TEL, C.ENDERECO, C.NUMERO, C.CIDADE, C.ESTADO,
P.ID AS ID_PROD_QTD, P.QUANTIDADE, P.VALOR_TOTAL AS PROD_QTD_VALOR_TOTAL
FROM TB_VENDA V
INNER JOIN TB_CLIENTE C ON V.ID_CLIENTE_FK = C.ID
INNER JOIN TB_PRODUTO_QUANTIDADE P ON P.ID_VENDA_FK = V.ID
WHERE V.CODIGO = 'A1';


SELECT PQ.ID, PQ.QUANTIDADE, PQ.VALOR_TOTAL,
P.ID AS ID_PRODUTO, P.CODIGO, P.NOME, P.DESCRICAO, P.VALOR
FROM TB_PRODUTO_QUANTIDADE PQ
INNER JOIN TB_PRODUTO P ON P.ID = PQ.ID_PRODUTO_FK;

DROP TABLE IF EXISTS tb_produto_quantidade CASCADE;
DROP SEQUENCE IF EXISTS sq_produto_quantidade CASCADE;

SELECT * FROM tb_venda;
DROP TABLE IF EXISTS tb_venda CASCADE;
DROP SEQUENCE IF EXISTS sq_venda CASCADE;
DROP TABLE IF EXISTS venda_produto CASCADE;



SELECT * FROM tb_produto;
DELETE FROM tb_produto;
DROP TABLE IF EXISTS tb_produto CASCADE;
DROP SEQUENCE IF EXISTS sq_produto CASCADE;

create table tb_produto(
	id BIGINT,
	codigo varchar(50) CONSTRAINT uk_codigo_produto UNIQUE not null,
	nome varchar(100) not null,
	descricao varchar(250) not null,
	preco numeric(10,2) not null,
	quantidade_estoque int,
	CONSTRAINT pk_id_produto primary key(id)
);

create sequence sq_produto
start 1
increment 1
owned by tb_produto.id;



SELECT * FROM tb_cliente;
DELETE FROM tb_cliente;

DROP TABLE IF EXISTS tb_cliente CASCADE;
DROP SEQUENCE IF EXISTS sq_cliente CASCADE;

CREATE TABLE tb_cliente (
    id BIGINT,
    nome VARCHAR(100) NOT NULL,
    cpf BIGINT NOT NULL CONSTRAINT uk_cpf_cliente UNIQUE,
    tel BIGINT,
    endereco VARCHAR(100),
    numero INTEGER,
    cidade VARCHAR(50),
    estado VARCHAR(2),
	email VARCHAR(50),
	CONSTRAINT pk_id_cliente PRIMARY KEY (id)
);

create sequence sq_cliente
start 1
increment 1
owned by tb_cliente.id;

create table tb_cliente (
	id bigint,
	nome varchar(50) not null,
	cpf bigint not null,
	tel bigint not null,
	endereco varchar(50) not null,
	numero bigint not null,
	cidade varchar(50) not null,
	estado varchar(50) not null,
	email varchar(50) not null,
	constraint pk_id_cliente primary key(id)
);

insert into tb_cliente (id, nome, cpf, tel, endereco, numero, cidade, estado, email)
values (nextval('sq_cliente'), 'Leonardo Soares', 12345678901, 11987654321, 'Rua A', 123, 'São Paulo', 'SP','email');
