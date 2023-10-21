--
-- PostgreSQL database dump
--

-- Dumped from database version 15.4 (Debian 15.4-1.pgdg120+1)
-- Dumped by pg_dump version 15.4 (Debian 15.4-1.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: insert_into_item(); Type: FUNCTION; Schema: public; Owner: coffee
--

CREATE FUNCTION public.insert_into_item() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    INSERT INTO item (item_id) VALUES (NEW.item_id);
    RETURN NEW;
END;
$$;


ALTER FUNCTION public.insert_into_item() OWNER TO coffee;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: coffee; Type: TABLE; Schema: public; Owner: coffee
--

CREATE TABLE public.coffee (
    coffee_description character varying(255),
    coffee_image character varying(255),
    coffee_name character varying(255),
    coffee_price integer,
    item_id integer NOT NULL
);


ALTER TABLE public.coffee OWNER TO coffee;

--
-- Name: coffee_id_sequence; Type: SEQUENCE; Schema: public; Owner: coffee
--

CREATE SEQUENCE public.coffee_id_sequence
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.coffee_id_sequence OWNER TO coffee;

--
-- Name: food; Type: TABLE; Schema: public; Owner: coffee
--

CREATE TABLE public.food (
    food_description character varying(255),
    food_image character varying(255),
    food_name character varying(255),
    food_price integer,
    item_id integer NOT NULL
);


ALTER TABLE public.food OWNER TO coffee;

--
-- Name: food_id_sequence; Type: SEQUENCE; Schema: public; Owner: coffee
--

CREATE SEQUENCE public.food_id_sequence
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.food_id_sequence OWNER TO coffee;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: coffee
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO coffee;

--
-- Name: item; Type: TABLE; Schema: public; Owner: coffee
--

CREATE TABLE public.item (
    item_id integer NOT NULL
);


ALTER TABLE public.item OWNER TO coffee;

--
-- Name: item_id_sequence; Type: SEQUENCE; Schema: public; Owner: coffee
--

CREATE SEQUENCE public.item_id_sequence
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.item_id_sequence OWNER TO coffee;

--
-- Name: item_tags; Type: TABLE; Schema: public; Owner: coffee
--

CREATE TABLE public.item_tags (
    tag_id integer NOT NULL,
    item_id integer NOT NULL
);


ALTER TABLE public.item_tags OWNER TO coffee;

--
-- Name: position_id_sequence; Type: SEQUENCE; Schema: public; Owner: coffee
--

CREATE SEQUENCE public.position_id_sequence
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.position_id_sequence OWNER TO coffee;

--
-- Name: tag; Type: TABLE; Schema: public; Owner: coffee
--

CREATE TABLE public.tag (
    tag_id integer NOT NULL,
    tag_name character varying(255)
);


ALTER TABLE public.tag OWNER TO coffee;

--
-- Name: tag_id_sequence; Type: SEQUENCE; Schema: public; Owner: coffee
--

CREATE SEQUENCE public.tag_id_sequence
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tag_id_sequence OWNER TO coffee;

--
-- Data for Name: coffee; Type: TABLE DATA; Schema: public; Owner: coffee
--

COPY public.coffee (coffee_description, coffee_image, coffee_name, coffee_price, item_id) FROM stdin;
Кофейный напиток с молоком и каплями эспрессо	https://disk.yandex.ru/i/rNUgHbM71zDRVg	Latte	220	1
\.


--
-- Data for Name: food; Type: TABLE DATA; Schema: public; Owner: coffee
--

COPY public.food (food_description, food_image, food_name, food_price, item_id) FROM stdin;
Французская булка	https://a.d-cd.net/f164efu-960.jpg	Круассан	200	51
\.


--
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: coffee
--

COPY public.item (item_id) FROM stdin;
1
51
\.


--
-- Data for Name: item_tags; Type: TABLE DATA; Schema: public; Owner: coffee
--

COPY public.item_tags (tag_id, item_id) FROM stdin;
1	1
51	1
101	51
\.


--
-- Data for Name: tag; Type: TABLE DATA; Schema: public; Owner: coffee
--

COPY public.tag (tag_id, tag_name) FROM stdin;
1	Кофе
51	Молоко
101	Выпечка
\.


--
-- Name: coffee_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: coffee
--

SELECT pg_catalog.setval('public.coffee_id_sequence', 1, true);


--
-- Name: food_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: coffee
--

SELECT pg_catalog.setval('public.food_id_sequence', 1, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: coffee
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: item_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: coffee
--

SELECT pg_catalog.setval('public.item_id_sequence', 51, true);


--
-- Name: position_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: coffee
--

SELECT pg_catalog.setval('public.position_id_sequence', 1, false);


--
-- Name: tag_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: coffee
--

SELECT pg_catalog.setval('public.tag_id_sequence', 101, true);


--
-- Name: coffee coffee_pkey; Type: CONSTRAINT; Schema: public; Owner: coffee
--

ALTER TABLE ONLY public.coffee
    ADD CONSTRAINT coffee_pkey PRIMARY KEY (item_id);


--
-- Name: food food_pkey; Type: CONSTRAINT; Schema: public; Owner: coffee
--

ALTER TABLE ONLY public.food
    ADD CONSTRAINT food_pkey PRIMARY KEY (item_id);


--
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: coffee
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (item_id);


--
-- Name: item_tags item_tags_pkey; Type: CONSTRAINT; Schema: public; Owner: coffee
--

ALTER TABLE ONLY public.item_tags
    ADD CONSTRAINT item_tags_pkey PRIMARY KEY (tag_id, item_id);


--
-- Name: tag tag_pkey; Type: CONSTRAINT; Schema: public; Owner: coffee
--

ALTER TABLE ONLY public.tag
    ADD CONSTRAINT tag_pkey PRIMARY KEY (tag_id);


--
-- Name: coffee trigger_insert_into_item_coffee; Type: TRIGGER; Schema: public; Owner: coffee
--

CREATE TRIGGER trigger_insert_into_item_coffee BEFORE INSERT ON public.coffee FOR EACH ROW EXECUTE FUNCTION public.insert_into_item();


--
-- Name: food trigger_insert_into_item_food; Type: TRIGGER; Schema: public; Owner: coffee
--

CREATE TRIGGER trigger_insert_into_item_food BEFORE INSERT ON public.food FOR EACH ROW EXECUTE FUNCTION public.insert_into_item();


--
-- Name: item_tags fk75ptahlsbki27lwu49p1akgs9; Type: FK CONSTRAINT; Schema: public; Owner: coffee
--

ALTER TABLE ONLY public.item_tags
    ADD CONSTRAINT fk75ptahlsbki27lwu49p1akgs9 FOREIGN KEY (tag_id) REFERENCES public.tag(tag_id);


--
-- Name: food fkgw9gw7sxmirs8u5hdgqu5pvdy; Type: FK CONSTRAINT; Schema: public; Owner: coffee
--

ALTER TABLE ONLY public.food
    ADD CONSTRAINT fkgw9gw7sxmirs8u5hdgqu5pvdy FOREIGN KEY (item_id) REFERENCES public.item(item_id);


--
-- Name: coffee fkpvi0t3y3tf6o6i4r6sv6hcjqw; Type: FK CONSTRAINT; Schema: public; Owner: coffee
--

ALTER TABLE ONLY public.coffee
    ADD CONSTRAINT fkpvi0t3y3tf6o6i4r6sv6hcjqw FOREIGN KEY (item_id) REFERENCES public.item(item_id);


--
-- Name: item_tags fkqcgrj6cbn2o4nwhhh6s31o6el; Type: FK CONSTRAINT; Schema: public; Owner: coffee
--

ALTER TABLE ONLY public.item_tags
    ADD CONSTRAINT fkqcgrj6cbn2o4nwhhh6s31o6el FOREIGN KEY (item_id) REFERENCES public.item(item_id);


--
-- PostgreSQL database dump complete
--

