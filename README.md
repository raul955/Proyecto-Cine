Cine con servlets y jsp:
Realizado con java 1.8
Tomcat 8.5
mySQL
------------------------
Cine Spring Boot:
java 11
tomcat 8.5
mySQL
------------------------
Cine SpringMVC4
java 11
tomcat 8.5
mySQL
------------------------

SCRIPT BBDD: (También se encuentra en el directorio webapp del proyecto.)

create table cine (

director VARCHAR2(128),
titulo VARCHAR2(128),
fecha date,
id number,
descripcion VARCHAR(500),
imagen longblob

);

insert into cine(director,titulo,fecha,id,descripción,imagen) values('directorprueba','tituloprueba','15-10-2010',11,'disco independiente','url');
insert into cine(director,titulo,fecha,id,descripción,imagen)values('fernando costa','titulo5','15-10-2010',5,'disco independiente','url');
insert into cine(director,titulo,fecha,id,descripción,imagen)values('fernando costa','titulo4','15-10-2010',4,'disco independiente','url');
insert into cine(director,titulo,fecha,id,descripción,imagen)values('fernando costa','titulo3','15-10-2010',3,'disco independiente','url');
insert into cine(director,titulo,fecha,id,descripción,imagen)values('ayax','titulo2','15-10-2010',2,'disco independiente','url');
insert into cine(director,titulo,fecha,id,descripción,imagen)values('prox','titulo1','15-10-2010',1,'disco independiente','url');
insert into cine(director,titulo,fecha,id,descripción,imagen)values('delaossa','titulo6','15-10-2010',6,'disco independiente','url');

create table usuarios (

usuario varchar(20) PRIMARY KEY,
password varchar(20)

);

insert into usuarios(usuario, password)values('root','root');
insert into usuarios(usuario, password)values('raul','raul');


