Realizado con java 1.8
Tomcat 8.5
Para que funcione correctamente es necesario copiar el driver jdbc de oracle 
en la carpeta lib del directorio de instalación de tomcat e importarlo en el build path.

SCRIPT BBDD: (También se encuentra en el directorio webapp del proyecto.)

create table cine (

director VARCHAR2(128),
titulo VARCHAR2(128),
fecha date,
id number

);

insert into cine(director,titulo,fecha,id) values('directorprueba','tituloprueba','15-10-2010',11);
insert into cine(director,titulo,fecha,id)values('fernando costa','titulo5','15-10-2010',5);
insert into cine(director,titulo,fecha,id)values('fernando costa','titulo4','15-10-2010',4);
insert into cine(director,titulo,fecha,id)values('fernando costa','titulo3','15-10-2010',3);
insert into cine(director,titulo,fecha,id)values('ayax','titulo2','15-10-2010',2);
insert into cine(director,titulo,fecha,id)values('prox','titulo1','15-10-2010',1);
insert into cine(director,titulo,fecha,id)values('delaossa','titulo6','15-10-2010',6);

create table usuarios (

usuario varchar2(20) PRIMARY KEY,
password varchar2(20)

);

insert into usuarios(usuario, password)values('root','root');
insert into usuarios(usuario, password)values('raul','raul');

