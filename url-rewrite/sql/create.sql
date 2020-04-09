CREATE TABLE exemplo1
(
  id serial NOT NULL,
  nome character varying(100) NOT NULL,
  email character varying(100),
  CONSTRAINT exemplo1_pkey PRIMARY KEY (id)
)