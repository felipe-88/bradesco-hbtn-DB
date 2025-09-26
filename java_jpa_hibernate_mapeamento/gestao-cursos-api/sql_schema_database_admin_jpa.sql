CREATE TABLE Endereco (id  integer, bairro varchar(255), cep integer, cidade varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), primary key (id))

CREATE TABLE Professor (id  integer, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id))

CREATE TABLE Aluno (id  integer, email varchar(255), matricula varchar(255), nascimento date, nomeCompleto varchar(255), endereco_id bigint, primary key (id))

CREATE TABLE Telefone (id  integer, DDD varchar(255), numero varchar(255), aluno_id bigint, primary key (id))

CREATE TABLE Curso (id  integer, nome varchar(255), sigla varchar(255), professor_id bigint, primary key (id))

CREATE TABLE aluno_curso (aluno_id bigint not null, curso_id bigint not null, primary key (aluno_id, curso_id))

CREATE TABLE MaterialCurso (id  integer, url varchar(255), curso_id bigint, primary key (id))

