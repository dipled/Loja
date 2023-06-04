
CREATE TABLE desenvolvedores
(
	id serial,
	nome varchar(50),
	telefone varchar(24),
	endereco varchar(24),
	cnpj varchar(14) unique,
	primary key (id)
);

CREATE TABLE jogos
(
	id serial,
	desenvolvedor integer,
	titulo varchar(50) unique,
	descricao varchar(300),
	preco float,
	desconto float,
	ano integer,
	primary key(id),
	foreign key(desenvolvedor) references desenvolvedores(id)
);
CREATE TABLE usuarios
(
	id serial,
	nome varchar(20),
	email varchar(50) unique,
	senha varchar(20),
	primary key (id)
);
CREATE TABLE biblioteca
(
	user_id integer references usuarios(id),
	jogo_id integer references jogos(id),
	primary key (user_id,jogo_id)
);
CREATE TABLE avaliacoes
(
	avaliacao varchar(250),
	user_id integer references usuarios(id),
	jogo_id integer references jogos(id),
	nota float,
	primary key (user_id,jogo_id)
)