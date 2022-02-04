-- public.app_user definition

CREATE TABLE public.app_user (
	id varchar(255) NOT NULL,
	app_user_role varchar(255) NULL,
	email varchar(255) NULL,
	enabled bool NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	"locked" bool NULL,
	"password" varchar(255) NULL,
	CONSTRAINT app_user_pkey PRIMARY KEY (id)
);


-- public.tb_employee definition


CREATE TABLE public.tb_employee (
	id uuid NOT NULL,
	birth_date date NULL,
	department varchar(255) NULL,
	email varchar(255) NULL,
	"name" varchar(255) NULL,
	salary int8 NULL,
	CONSTRAINT tb_employee_pkey PRIMARY KEY (id)
);


-- public.confirmation_token definition


CREATE TABLE public.confirmation_token (
	id varchar(255) NOT NULL,
	confirmed_at timestamp NULL,
	created_at timestamp NOT NULL,
	expires_at timestamp NOT NULL,
	"token" varchar(255) NOT NULL,
	app_user_id varchar(255) NOT NULL,
	CONSTRAINT confirmation_token_pkey PRIMARY KEY (id),
	CONSTRAINT fko9fl25wqyh7w7mnfkdqen1rcm FOREIGN KEY (app_user_id) REFERENCES public.app_user(id)
);