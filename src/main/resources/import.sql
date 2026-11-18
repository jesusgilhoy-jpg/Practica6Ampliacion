-- Clientes
insert into cliente (nombre, apellidos, dni, telefono, email) values ('María', 'Gómez Ruiz', '11111111A', '611111111', 'maria.gomez@example.com');
insert into cliente (nombre, apellidos, dni, telefono, email) values ('Javier', 'Soler Martí', '22222222B', '622222222', 'javier.soler@example.com');
insert into cliente (nombre, apellidos, dni, telefono, email) values ('Lucía', 'Navarro Peris', '33333333C', '633333333', 'lucia.navarro@example.com');
insert into cliente (nombre, apellidos, dni, telefono, email) values ('Carlos', 'Ibáñez Pla', '44444444D', '644444444', 'carlos.ibanez@example.com');
insert into cliente (nombre, apellidos, dni, telefono, email) values ('Elena', 'Prats Vidal', '55555555E', '655555555', 'elena.prats@example.com');

-- Vehículos
insert into vehiculo (matricula, marca, modelo, anio_fabricacion, kilometraje) values ('1234ABC', 'Seat', 'Ibiza', 2018, 85000);
insert into vehiculo (matricula, marca, modelo, anio_fabricacion, kilometraje) values ('5678BCD', 'Renault', 'Clio', 2020, 42000);
insert into vehiculo (matricula, marca, modelo, anio_fabricacion, kilometraje) values ('9012CDE', 'Ford', 'Fiesta', 2016, 120000);
insert into vehiculo (matricula, marca, modelo, anio_fabricacion, kilometraje) values ('3456DEF', 'Toyota', 'Corolla', 2022, 15000);
insert into vehiculo (matricula, marca, modelo, anio_fabricacion, kilometraje) values ('7890EFG', 'Peugeot', '208', 2019, 60000);

-- Mecánicos
insert into mecanico (nombre, apellidos, especialidad, fecha_contratacion, anios_experiencia) values ('Pedro', 'Martín Castro', 'MOTOR', '2015-03-01', 12);
insert into mecanico (nombre, apellidos, especialidad, fecha_contratacion, anios_experiencia) values ('Sara', 'Domínguez León', 'ELECTRICIDAD', '2018-07-15', 8);
insert into mecanico (nombre, apellidos, especialidad, fecha_contratacion, anios_experiencia) values ('Iván', 'Cortés Molina', 'CHAPA', '2012-01-10', 15);
insert into mecanico (nombre, apellidos, especialidad, fecha_contratacion, anios_experiencia) values ('Nuria', 'Vidal Esteve', 'NEUMATICOS', '2020-09-01', 5);
insert into mecanico (nombre, apellidos, especialidad, fecha_contratacion, anios_experiencia) values ('Raúl', 'Ferrer Campos', 'MOTOR', '2017-11-20', 9);

-- Piezas
insert into pieza (nombre, codigo, precio, stock, disponible) values ('Filtro de aceite', 'FLT001', 12.50, 40, true);
insert into pieza (nombre, codigo, precio, stock, disponible) values ('Pastillas de freno', 'FRN002', 35.90, 25, true);
insert into pieza (nombre, codigo, precio, stock, disponible) values ('Batería 60Ah', 'BAT003', 89.99, 10, true);
insert into pieza (nombre, codigo, precio, stock, disponible) values ('Neumático 195/65R15', 'NEU004', 65.00, 16, true);
insert into pieza (nombre, codigo, precio, stock, disponible) values ('Correa de distribución', 'COR005', 48.75, 0, false);

-- Proveedores
insert into proveedor (nombre, cif, telefono, email, activo) values ('Recambios Levante SL', 'B12345678', '961111111', 'contacto@recambioslevante.com', true);
insert into proveedor (nombre, cif, telefono, email, activo) values ('AutoPiezas Valencia SA', 'A87654321', '961222222', NULL, true);
insert into proveedor (nombre, cif, telefono, email, activo) values ('Ibérica de Lubricantes SL', 'B11223344', '961333333', 'info@ibericalub.com', true);
insert into proveedor (nombre, cif, telefono, email, activo) values ('Neumáticos del Turia SL', 'B55667788', '961444444', NULL, false);
insert into proveedor (nombre, cif, telefono, email, activo) values ('Talleres Suministros CV SL', 'B99887766', '961555555', 'ventas@suministroscv.com', true);


-- Órdenes de reparación
insert into orden_reparacion (descripcion, fecha_entrada, estado, coste_estimado) values ('Cambio de aceite y filtros', '2026-01-10', 'FINALIZADA', 65.00);
insert into orden_reparacion (descripcion, fecha_entrada, estado, coste_estimado) values ('Revisión frenos delanteros', '2026-01-15', 'EN_PROCESO', 120.50);
insert into orden_reparacion (descripcion, fecha_entrada, estado, coste_estimado) values ('Sustitución batería', '2026-01-20', 'PENDIENTE', 95.00);
insert into orden_reparacion (descripcion, fecha_entrada, estado, coste_estimado) values ('Cambio de neumáticos', '2026-02-01', 'FINALIZADA', 260.00);
insert into orden_reparacion (descripcion, fecha_entrada, estado, coste_estimado) values ('Diagnóstico avería eléctrica', '2026-02-05', 'EN_PROCESO', 150.75);