create database if not exists entity_dto_demo;

drop table direccion;
drop table telefono;
drop table persona;

use entity_dto_demo;

	create table if not exists persona(
		id int auto_increment primary key,
		email varchar(255) not null,
		nombre varchar(100) not null,
		apellido varchar(100) not null,
		dpi varchar(100) not null,
        descripcion varchar(2000) null
	);

	create table if not exists direccion(
		id int auto_increment primary key,
		id_persona int not null,
		direccion_completa varchar(100) not null,
		codigo_postal varchar(50) null
	);

	create table if not exists telefono(
		id int auto_increment primary key,
		id_persona int not null,
		numero varchar(100) not null,
		tipo varchar(50) null
	);


start transaction;

	set @idPersona = 0;

	insert into persona(email, nombre, apellido, dpi, descripcion)
    values('cfulanito@mail.com', 'Cosme', 'Fulanito', '1234-56789-0101', 'Descripcion de cosme fulanito');
    set @idPersona = last_insert_id();
		insert into direccion(id_persona, direccion_completa, codigo_postal)
        values(@idPersona, 'Av reforma z10, Guatemala Ciudad', '01010');
        insert into telefono(id_persona, numero, tipo)
        values(@idPersona, '555-123456', 'celular');

	insert into persona(email, nombre, apellido, dpi, descripcion)
    values('pperez@mail.com', 'Pedro', 'Perez', '4321-98765-0101', 'Descripcion de Pedro Perez');
    set @idPersona = last_insert_id();
		insert into direccion(id_persona, direccion_completa, codigo_postal)
        values(@idPersona, 'Zona 21, Guatemala Ciudad', '01010');
		insert into direccion(id_persona, direccion_completa, codigo_postal)
        values(@idPersona, '19 calle z1, Guatemala Ciudad', '01010');
        insert into telefono(id_persona, numero, tipo)
        values(@idPersona, '555-654321', 'celular');

	insert into persona(email, nombre, apellido, dpi, descripcion)
    values('fvargas@mail.com', 'Fransisco', 'Vargas', '9876-54321-0101', 'Descripcion de Fransisco Vargas');
    set @idPersona = last_insert_id();
		insert into direccion(id_persona, direccion_completa, codigo_postal)
        values(@idPersona, '18 calle 5-46 z9, Guatemala Ciudad', '01010');
        insert into telefono(id_persona, numero, tipo)
        values(@idPersona, '555-147258', 'celular');
        insert into telefono(id_persona, numero, tipo)
        values(@idPersona, '222-147258', 'oficina');

-- commit; -- rollback;

use entity_dto_demo;

select *
from persona; -- where id = 2;
select *
from direccion; -- where id_persona = 2;
select *
from telefono; -- where id_persona = 2;

/*
-- pruebas con el api --

// prueba para que truene por longitud de nombre
//"nombre": "abcdefghijklmnopqrstuvwxyz-abcdefghijklmnopqrstuvwxyz-abcdefghijklmnopqrstuvwxyz-abcdefghijklmnopqrstuvwxyz",

//insert
{
    "email": "lvasquez@mail.com",
    "nombre": "Luis",
    "apellido": "Vasquez",
    "dpi": "4444-55555-0101",
    "descripcion": "Descripcion de Luis Vasquez",
    "direcciones": [
        {
            "direccionCompleta": "18av 10-11 zona 1",
            "codigoPostal": "01010"
        },
        {
            "direccionCompleta": "Av reforma 6-75 z10",
            "codigoPostal": "01010"
        }
    ],
    "telefonos": [
        {
            "numero": "444-44440",
            "tipo": "celular"
        },
        {
            "numero": "444-44441",
            "tipo": "hogar"
        }
    ]
}

//update
{
    "id": 4,
    "email": "lvasquez@mail.com",
    "nombre": "Luis Gabriel",
    "apellido": "Vasquez Escobar",
    "dpi": "1234-67890-0101",
    "telefonos": [
        {
            "id": 5,
            "numero": "555-55550",
            "tipo": "celular/movil"
        },
        {
            "id": 6,
            "numero": "666-66661",
            "tipo": "hogar/oficina"
        }
    ]
}





*/


