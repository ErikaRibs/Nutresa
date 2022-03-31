# Creando/Usando Base de datos
create database nutresa;
use nutresa;

#Creando tablas
create table pacientes(
ID_Paciente int(32) unsigned auto_increment,
Nombre_completo varchar(32) not null,
Genero varchar(32) not null,
Edad varchar(32) not null,
Contacto varchar(32) not null,
Actividad enum("Nada", "Deportes", "Pesas", "Crossfit") not null,
primary key(ID_Paciente)
);
create table medidas(
ID_Medida int(32) unsigned auto_increment,
ID_Paciente int(32) unsigned,
IMC varchar(32) not null,
IMM varchar(32) not null,
Peso varchar(32) not null,
Cintura varchar(32) not null,
Brazo varchar(32) not null,
Estatura varchar(32) not null,
primary key(ID_Medida,ID_Paciente),
constraint FK_PacienteMedida foreign key(ID_Paciente) references pacientes(ID_Paciente)
);
create table fechas( 
ID_Fecha int(32) unsigned auto_increment,
Fecha varchar(32) not null,
ID_Paciente int(32) unsigned,
ID_Medida int(32) unsigned,
citaNumero int(32),
primary key (ID_Fecha,ID_Paciente,ID_Medida),
constraint FK_PacienteFecha foreign key (ID_Paciente) references pacientes(ID_Paciente),
constraint FK_MedidaFecha foreign key (ID_Medida) references medidas(ID_Medida)
);

#Comandos miscelaneos
	#Pacientes
Select * From pacientes;
	#Medidas
select p.Nombre_completo,p.Genero,p.Edad,p.Actividad, m.IMC, m.IMM, m.Peso, m.Cintura,m.Brazo,m.Estatura from medidas as m,pacientes as p where p.ID_Paciente = m.ID_Paciente AND p.ID_Paciente = 2;

#Este de abajo trae los valores del paciente por id pero son todos los datos de medidas con respecto a el
select p.Nombre_completo,p.Genero,p.Edad,p.Actividad, m.IMC, m.IMM, m.Peso, m.Cintura,m.Brazo,m.Estatura from medidas as m,pacientes as p where p.ID_Paciente = m.ID_Paciente AND p.ID_Paciente = 2 and m.ID_Medida = 4;
#Valores de un paciente sin medidas
select Nombre_completo,Genero,Edad from  pacientes where ID_Paciente = 2;
    #Fechas
select citaNumero, ID_Medida from fechas where ID_Paciente =1 order by citaNumero desc limit 1; #La ultima
select citaNumero, ID_Medida from fechas where ID_Paciente =2 order by citaNumero desc; #Todas las citas y el id de cita de X paciente

select * from fechas;
select * from medidas;

select * from fechas where ID_Paciente = 2 order by citaNumero desc;

select ID_Medida from medidas order by ID_Medida desc limit 1; #Trae el ultimo valor de medida

select m.ID_Medida, m.ID_Paciente from medidas as m where m.ID_Paciente = 2; #Trae todas las ID de medidas con respecto a un Paciente Id

select * from medidas where ID_Paciente = 2; #Trae todos los datos con respecto al paciente ID


select m.ID_Medida, f.Fecha 
from medidas as m,  fechas as f where m.ID_Medida = 2 and m.ID_Medida = f.ID_Medida order by f.citaNumero DESC; #Trae el ultimo de: el id de medida y su fecha. Con respecto a paciente id
