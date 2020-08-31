-- CREATE DATABASE distribution;

-- Table: public.mail

-- DROP TABLE public.mail;

CREATE TABLE public.mail
(
    id integer NOT NULL DEFAULT nextval('mail_id_seq'::regclass),
    company character varying(100) COLLATE pg_catalog."default" NOT NULL,
    vacancy character varying(100) COLLATE pg_catalog."default" NOT NULL,
    mail character varying(100) COLLATE pg_catalog."default" NOT NULL,
    mail_date date,
    text character varying(2000) COLLATE pg_catalog."default",
    answer character varying(20) COLLATE pg_catalog."default",
    vacancy_linc character varying(200) COLLATE pg_catalog."default",
    answer_date date,
    CONSTRAINT mail_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.mail
    OWNER to postgres;

CREATE SEQUENCE hibernate_sequence START 1;