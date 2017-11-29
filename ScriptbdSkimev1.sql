#drop database SkimeV1;

create database SkimeV1;
use SkimeV1;

create table Usuario(idUsuario int(6) not null auto_increment primary key, idAvatar int(6), Nombre varchar (65), 
Nickname varchar(20), Email varchar(40), Contraseña varchar(25), Edad int(3), IngresoFijo float(10), IngresoPeriodo int(4), ProgresoTotal float(10), AhorroTotal float(10) );

create table Avatar(idAvatar int(6) not null auto_increment primary key, idTipoAnimal int(6), Monedas int (10));
create table TipoAnimal (idTipoAnimal int(6) not null auto_increment primary key, NombreAnimal varchar (30), URLImgAnimal varchar(65));
create table Item (idItem int(6) not null auto_increment primary key, NombreItem varchar (30), URLImgItem varchar (65), Costo float (10));
create table AvatarItem (idAvatarItem int(6) not null auto_increment primary key, idItem int(6), idAvatar int(6));
create table Lista(idLista int(6) not null auto_increment primary key, NombreLista varchar (65), ProgresoLista float(10));
create table Elemento(idElemento int(6) not null auto_increment primary key, idLista int(6), NombreElemento varchar(65), FechaInit datetime, FechaEnd datetime, CostoElemento float(10), Monto float(10), ProgresoElemento float(10));
create table MetaColectiva(idMetaColectiva int(6) not null auto_increment primary key, NombreMeta varchar(65), DescripcionMeta varchar (280), CostoMeta float(10), MontoMeta float(10), ProgresoMeta float(10));
create table MetaUsuario(idMetaUsuario int(6) not null auto_increment primary key, idMetaColectiva int(6), idUsuario int(6), MontoMetaUsuario float(10));
create table Amigos(idAmigos int(6) not null auto_increment primary key, idAmigo1 int(6), idAmigo2 int(6));

alter table Usuario add foreign key (idAvatar) references Avatar(idAvatar);
alter table Avatar add foreign key (idTipoAnimal) references TipoAnimal(idTipoAnimal) ;
alter table AvatarItem add foreign key (idItem) references Item(idItem);
alter table AvatarItem add foreign key (idAvatar) references Avatar(idAvatar);
alter table Elemento add foreign key (idLista) references Lista(idLista);
alter table MetaUsuario add foreign key (idMetaColectiva) references MetaColectiva(idMetaColectiva);
alter table MetaUsuario add foreign key (idUsuario) references Usuario(idUsuario);
alter table Amigos add foreign key (idAmigo1) references Usuario(idUsuario);
alter table Amigos add foreign key (idAmigo2) references Usuario(idUsuario);

alter table Lista add idUsuario int(6);
alter table Lista add foreign key(idUsuario) references Usuario(idUsuario);

