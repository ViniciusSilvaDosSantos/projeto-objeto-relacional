-- Table: public.pessoa_telefones

-- DROP TABLE IF EXISTS public.pessoa_telefones;

CREATE TABLE IF NOT EXISTS public.pessoa_telefones
(
    pessoa_id bigint NOT NULL,
    telefones character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT fkaiot7ivu39es4brlm05it7jlm FOREIGN KEY (pessoa_id)
        REFERENCES public.pessoa (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pessoa_telefones
    OWNER to postgres;