create table if not exists comunication_service.comunication(
   id serial4 NOT NULL,
   created_at timestamp NULL,
   nome text NULL,
   email text NULL,
   telefone text NULL,
   mensagem text NULL,
   tipo_comunicacao text NULL,
   created_at timestamp NULL,
   updated_at timestamp NULL,
   CONSTRAINT comunication_pk PRIMARY KEY (id)
);