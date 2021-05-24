# Integration Lead Test

### SQL Script
> DROP TABLE IF EXISTS usuario;

> Create table usuario (
"id_usuario" serial not null ,
"nombre_usuario" varchar not null,
"email_usuario" varchar not null,
"contrasena_usuario" varchar not null,
"es_activo" boolean default true,
"creacion_usuario" date );

> Create table telefono ( id);
##Acceso : 
### http://localhost:8080/api/h2-console
> ~/data/db