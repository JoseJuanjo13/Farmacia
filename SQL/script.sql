insert into descuentointeres(idDescInt,tipo,cantidad) values (1, 'Descuento 1000', 1000.0);
insert into descuentointeres(idDescInt,tipo,cantidad) values (2, 'Descuento 3000', 3000.0);
insert into descuentointeres(idDescInt,tipo,cantidad) values (3, 'Descuento 5000', 5000.0);
insert into descuentointeres(idDescInt,tipo,cantidad) values (4, 'Descuento 10000', 10000.0);
insert into descuentointeres(idDescInt,tipo,cantidad) values (5, 'Descuento 15000', 15000.0);

insert into presentacion(idPresentacion,nombrePresentacion) values(1, 'Tableta');
insert into presentacion(idPresentacion,nombrePresentacion) values(2, 'Pastillas');
insert into presentacion(idPresentacion,nombrePresentacion) values(3, 'Capsula');
insert into presentacion(idPresentacion,nombrePresentacion) values(4, 'Pildoras');
insert into presentacion(idPresentacion,nombrePresentacion) values(5, 'Jarabe');
insert into presentacion(idPresentacion,nombrePresentacion) values(6, 'Granulados');
insert into presentacion(idPresentacion,nombrePresentacion) values(7, 'Pomada');
insert into presentacion(idPresentacion,nombrePresentacion) values(8, 'Inyectable');

insert into tipoproveedor(idTipoProveedor,tipoProveedor) values (1,  'Servicios');
insert into tipoproveedor(idTipoProveedor,tipoProveedor) values (2,  'Bienes');
insert into tipoproveedor(idTipoProveedor,tipoProveedor) values (3,  'Recursos');
insert into tipoproveedor(idTipoProveedor,tipoProveedor) values (4,  'Especifico');

insert into ciudad(idciudad,nombre) values (1, 'Armenia');
insert into ciudad(idciudad,nombre) values (2, 'Pereira');
insert into ciudad(idciudad,nombre) values (3, 'Cali');
insert into ciudad(idciudad,nombre) values (4, 'Bogota');

insert into producto(id_producto,nombre,precio,cantidad,idDescInt,idPresentacion,fechaVencimiento)
values ('00125','Acetaminofen', 5000.0, 20, 1, 1, '2023-11-11');
insert into producto(id_producto,nombre,precio,cantidad,idDescInt,idPresentacion,fechaVencimiento)
values ('00126','Simvastatina', 6000.0, 20, 1, 1, '2023-12-11');
insert into producto(id_producto,nombre,precio,cantidad,idDescInt,idPresentacion,fechaVencimiento)
values ('00127','Aspirina', 4000.0, 20, 1, 3, '2023-11-11');
insert into producto(id_producto,nombre,precio,cantidad,idDescInt,idPresentacion,fechaVencimiento)
values ('00128','Omeprazol', 3500.0, 20, 1, 1, '2023-11-11');
insert into producto(id_producto,nombre,precio,cantidad,idDescInt,idPresentacion,fechaVencimiento)
values ('00129','Lexotiroxina sódica', 7000.0, 20, 1, 1, '2023-11-11');
insert into producto(id_producto,nombre,precio,cantidad,idDescInt,idPresentacion,fechaVencimiento)
values ('00130','Ramipril', 6000.0, 20, 1, 1, '2023-11-11');
insert into producto(id_producto,nombre,precio,cantidad,idDescInt,idPresentacion,fechaVencimiento)
values ('00131','Amlodipina', 5000.0, 20, 1, 1, '2023-11-11');
insert into producto(id_producto,nombre,precio,cantidad,idDescInt,idPresentacion,fechaVencimiento)
values ('00132','Atorvastatina', 9000.0, 20, 1, 1, '2023-11-11');
insert into producto(id_producto,nombre,precio,cantidad,idDescInt,idPresentacion,fechaVencimiento)
values ('00133','Salbutamol', 8500.0, 20, 1, 1, '2023-11-11');
insert into producto(id_producto,nombre,precio,cantidad,idDescInt,idPresentacion,fechaVencimiento)
values ('00134','Lansoprazol', 10000.0, 20, 1, 1, '2023-11-11');


insert into cliente(cedula,nombre,apellido,direccion,correo,telefono,ciudad,depto)
values ('1094913900','rodrigo','perea','calle 7#14', 'rodrigo@gmail.com', '32258896', 'armenia', 'quindio');
insert into cliente(cedula,nombre,apellido,direccion,correo,telefono,ciudad,depto)
values ('1094913901','maria','gonzales','calle 7#15', 'maria@gmail.com', '32258897', 'armenia', 'quindio');
insert into cliente(cedula,nombre,apellido,direccion,correo,telefono,ciudad,depto)
values ('1094913902','fernando','correa','calle 7#16', 'fernando@gmail.com', '32258898', 'armenia', 'quindio');
insert into cliente(cedula,nombre,apellido,direccion,correo,telefono,ciudad,depto)
values ('1094913903','sandra','ordoñez','calle 8#14', 'sandra@gmail.com', '32258899', 'armenia', 'quindio');
insert into cliente(cedula,nombre,apellido,direccion,correo,telefono,ciudad,depto)
values ('1094913904','jose','orjuela','calle 1#14', 'jose@gmail.com', '32258900', 'armenia', 'quindio');
insert into cliente(cedula,nombre,apellido,direccion,correo,telefono,ciudad,depto)
values ('1094913905','andres','quiñonez','calle 2#14', 'andres@gmail.com', '32258901', 'armenia', 'quindio');
insert into cliente(cedula,nombre,apellido,direccion,correo,telefono,ciudad,depto)
values ('1094913906','diego','castro','calle 3#18', 'diego@gmail.com', '32258902', 'armenia', 'quindio');
insert into cliente(cedula,nombre,apellido,direccion,correo,telefono,ciudad,depto)
values ('1094913907','jesus','molina','calle 5#19', 'jesus@gmail.com', '32258902', 'armenia', 'quindio');
insert into cliente(cedula,nombre,apellido,direccion,correo,telefono,ciudad,depto)
values ('1094913908','mariana','becerra','calle 6#13', 'mariana@gmail.com', '32258903', 'armenia', 'quindio');
insert into cliente(cedula,nombre,apellido,direccion,correo,telefono,ciudad,depto)
values ('1094913909','felipe','santon','calle 7#12', 'felipe@gmail.com', '32258904', 'armenia', 'quindio');


insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000235', 'Allergan', 3);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000236', 'Biogen de Colombia S.A', 3);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000237', 'Boehringer Ingelheim S.A', 3);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000238', 'Bristol-Myers Squibb de Colombia S.A', 3);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000239', 'Gen-Far', 3);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000240', 'Laboratorios Medihealth', 3);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000241', 'Laboratorios Novafarma', 3);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000242', 'Pfizer', 3);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000243', 'Claro', 1);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000244', 'Servicio especializado', 2);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000245', 'Tecnico mantenimiento', 2);
insert into proveedor(nit,nombre_empresa,idTipoProveedor) values ('000246', 'Unipharma', 3);

insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (1,'sucursal allergan','7455233','000235',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (2,'sucursal Biogen','7455234','000236',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (3,'sucursal Boehringer','7455235','000237',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (4,'sucursal Bristol-Myers','7455236','000238',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (5,'sucursal Gen-Far','7455237','000239',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (6,'sucursal Medihealth','7455238','000240',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (7,'sucursal Novafarma','7455240','000241',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (8,'sucursal Pfizer','7455241','000242',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (9,'sucursal Claro','7455242','000242',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (10,'sucursal Instalacion','7455243','000244',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (11,'sucursal mantenimiento','7455244','000245',1);
insert into sucursal(idsucursal,nombre,telefono,nitProveedor,idCiudad) values (12,'sucursal Unipharma','7455245','000246',1);

insert into empleado(cedula,nombre,apellido,direccion,telefono,tipo) values (1094999900,'Maria', 'perea', 'barrio 1', '3148997100','aux');
insert into empleado(cedula,nombre,apellido,direccion,telefono,tipo) values (1094999901,'Alejandro', 'garcia', 'barrio 2', '3148997101','bod');

insert into tipousuario(id_tipo_usuario,tipo_usuario,id_empleado) values (1, 'administrador', 1094999900);
insert into tipousuario(id_tipo_usuario,tipo_usuario,id_empleado) values (2, 'bodega', 1094999901);
