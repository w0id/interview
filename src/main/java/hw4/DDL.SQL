-- public.film definition

-- Drop table

-- DROP TABLE film;

CREATE TABLE film (
                      id int8 NOT NULL DEFAULT nextval('durations_id_seq'::regclass),
                      title varchar NULL,
                      duration interval minute NULL,
                      CONSTRAINT film_pk PRIMARY KEY (id)
);


-- public.prices definition

-- Drop table

-- DROP TABLE prices;

CREATE TABLE prices (
                        id bigserial NOT NULL,
                        price int8 NULL,
                        seq_start time NULL,
                        CONSTRAINT prices_pk PRIMARY KEY (id)
);


-- public.film_show definition

-- Drop table

-- DROP TABLE film_show;

CREATE TABLE film_show (
                           id bigserial NOT NULL,
                           show_date date NOT NULL,
                           starts_at time NOT NULL,
                           ends_at time NOT NULL,
                           film int8 NOT NULL,
                           price int8 NOT NULL,
                           CONSTRAINT film_show_pk PRIMARY KEY (id),
                           CONSTRAINT film_fk FOREIGN KEY (film) REFERENCES film(id) ON DELETE CASCADE ON UPDATE CASCADE,
                           CONSTRAINT price_fk FOREIGN KEY (price) REFERENCES prices(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- public.tickets definition

-- Drop table

-- DROP TABLE tickets;

CREATE TABLE tickets (
                         id bigserial NOT NULL,
                         "number" text NOT NULL DEFAULT 'T'::text || lpad(nextval('tickets_number_seq'::regclass)::character varying::text, 8, '0'::text),
                         "show" int8 NOT NULL,
                         CONSTRAINT tickets_number_check CHECK ((number ~ '^T[0-9]+$'::text)),
                         CONSTRAINT tickets_fk FOREIGN KEY ("show") REFERENCES film_show(id) ON DELETE CASCADE ON UPDATE CASCADE
);

--Процедура для добавления сеансов в таблицу film_show
create or replace procedure add_show(show_date date, sat time, film_id int8)
language plpgsql
as $$
begin
insert into film_show (show_date, starts_at, ends_at, film, price)
select
    show_date,
    sat,
    sat + f.duration,
    f.id,
    (
        select p.id
        from prices p
        where p.seq_start <= sat
        order by p.price desc
        limit 1
    )
from film f
where f.id = film_id;
end;$$;