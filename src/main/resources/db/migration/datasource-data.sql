


-- Insert all classe to db

insert into classe (codigo, descricao) 
    values 
        (default, "Iniciação"), (default, "1ª Classe"),(default, "2ª Classe"),
        (default, "3ª Classe"), (default, "4ª Classe"),
        (default, "5ª Classe"), (default, "6ª Classe"),
        (default, "7ª Classe"), (default, "8ª Classe"),
        (default, "9ª Classe"), (default, "10ª Classe"),
        (default, "11ª Classe"),(default, "12ª Classe"),
        (default, "13ª Classe"), (default, "1º Ano"), 
        (default, "2º Ano"), (default, "3º Ano"), (default, "4º Ano"),
        (default, "5º Ano"), (default, "6º Ano");

-- Insert all ciclo

insert into ciclo (codigo, descricao) 
    values 
        (default, "Iº Ciclo"), (default, "IIº Ciclo"), 
        (default, "Técnico Médio"), (default, "Bacharelado"), 
        (default, "Licenciatura"), (default, "Ph. D.");


--Insert all grau_acamemico

insert into grau(codigo, descricao)
	values
		(default, "Ensino Especial"),
		(default, "Ensino Primário"),
		(default, "Ensino Secundário"),
		(default, "Ensino Médio"),
		(default, "Ensino Superior");

insert into curso (codigo, descricao, ciclo_codigo) 
    values 
        (default, "Ciências Físicas e Biológicas", 2),
        (default, "Ciências Económicas e Jurídics", 2),
        (default, "Ciências Humanas", 2),
        (default, "Técnico de Informática", 3),
        (default, "Técnico de Enfermagem", 3),
        (default, "Técnico de Farmácia", 3);



    insert into `turma` (`codigo`, `descricao`, `sala`, `periodo`, `classe_codigo`, `curso_codigo`)
values
	(default, 'CFB19A', 3, "TARDE", 11, 1),
	(default, 'CFB19B', 8, "TARDE", 12, 1),
	(default, 'CFB19C', 3, "MANHA", 13, 1),
	(default, 'CEJ19A', 4, "TARDE", 11, 2),
	(default, 'CEJ19B', 9, "TARDE", 12, 2),
	(default, 'CEJ19C', 4, "MANHA", 13, 2),
	(default, 'TI19A', 5, "TARDE", 11, 3),
	(default, 'TI19B', 7, "TARDE", 12, 3),
	(default, 'TI19C', 5, "MANHA", 13, 3),	
	(default, 'TI19D', 5, "TARDE", 14, 3);

insert into `aluno` (`codigo`, `nome`, `estado_civil`, `morada`, `nacionalidade`, `sexo`, `classe_codigo`, `data_nascimento`, `turma_codigo`)
values
	(default, 'Jerameel João Gonga', 'SOLTEIRO', 'Rua Nova Samba', 'Angola', 'MASCULINO', 13, '1997-06-04 00:00:00', null),
	(default, "Marcos João Gonga", 'SOLTEIRO', 'Rua Nova Samba', 'Angola', 'MASCULINO', 13, '1997-06-04 00:00:00', null),
	(default, "Josemar Abel Joaquim", 'CASADO', 'Rua Nova Samba', 'Angola', 'MASCULINO', 13, '1997-06-04 00:00:00', null),
	(default, "Francisco Geraldo", 'SOLTEIRO', 'Rua Nova Samba', 'Angola', 'MASCULINO', 13, '1997-06-04 00:00:00', null),
	(default, "Isabel Francisco Goge", 'CASADO', 'Rua Nova Samba', 'Angola', 'MASCULINO', 13, '1997-06-04 00:00:00', null),
	(default, "João Dombo Goge", 'CASADO', 'Rua Nova Samba', 'Angola', 'MASCULINO', 13, '1997-06-04 00:00:00', null),
	(default, "Maria do Céu Isaac", 'SOLTEIRO', 'Rua Nova Samba', 'Angola', 'MASCULINO', 13, '1997-06-04 00:00:00', null),
	(default, "Marcos da Silva Ladjum", 'CASADO', 'Rua Nova Samba', 'Angola', 'MASCULINO', 13, '1997-06-04 00:00:00', null),
	(default, "Francisca do Espiírito Santo", 'SOLTEIRO', 'Rua Nova Samba', 'Angola', 'MASCULINO', 13, '1997-06-04 00:00:00', null),
	(default, "Nelson Afonso Agostinho", 'SOLTEIRO', 'Rua Nova Samba', 'Angola', 'MASCULINO', 13, '1997-06-04 00:00:00', null),
	(default, "Esperança Gonga", 'SOLTEIRO', 'Bairro Camuxiba, Rua do Bambuca', 'Angola', 'FEMENINO', 13, '1997-06-04 00:00:00', null);


--Insert classe binding in ciclo

insert into classe_ciclo (ciclo_codigo, classe_codigo) values 
 	(1, 1),(1, 2), (1, 3),(1, 4),(1, 5),(1, 6),(1, 7),
 	(2, 8),(2, 9), (2, 10),(3, 11),(3, 12),(3, 13),(3, 14),
 	(4, 15),(4, 16), (4, 17),(5, 18),(5, 19),(5, 20);


--Insert all ciclos binding in grau_academico

insert into ciclo_grau (grau_codigo, ciclo_codigo) 
	values (3,1),(3,2), (4,3), (5,4), (5,5), (5,6);

















