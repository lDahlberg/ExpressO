--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2016-02-26 14:51:41

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 185 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2055 (class 0 OID 0)
-- Dependencies: 185
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 22611)
-- Name: allergen; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE allergen (
    allergenid integer NOT NULL,
    name character varying(255)
);


ALTER TABLE allergen OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 22609)
-- Name: allergen_allergenid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE allergen_allergenid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE allergen_allergenid_seq OWNER TO postgres;

--
-- TOC entry 2056 (class 0 OID 0)
-- Dependencies: 172
-- Name: allergen_allergenid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE allergen_allergenid_seq OWNED BY allergen.allergenid;


--
-- TOC entry 175 (class 1259 OID 22619)
-- Name: bakedgood; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bakedgood (
    bakedgoodid integer NOT NULL,
    cost double precision,
    name character varying(255),
    allergenid integer,
    categoryid integer,
    vendorid integer
);


ALTER TABLE bakedgood OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 22617)
-- Name: bakedgood_bakedgoodid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE bakedgood_bakedgoodid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bakedgood_bakedgoodid_seq OWNER TO postgres;

--
-- TOC entry 2057 (class 0 OID 0)
-- Dependencies: 174
-- Name: bakedgood_bakedgoodid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE bakedgood_bakedgoodid_seq OWNED BY bakedgood.bakedgoodid;


--
-- TOC entry 177 (class 1259 OID 22627)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE category (
    categoryid integer NOT NULL,
    name character varying(255)
);


ALTER TABLE category OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 22625)
-- Name: category_categoryid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE category_categoryid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE category_categoryid_seq OWNER TO postgres;

--
-- TOC entry 2058 (class 0 OID 0)
-- Dependencies: 176
-- Name: category_categoryid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE category_categoryid_seq OWNED BY category.categoryid;


--
-- TOC entry 179 (class 1259 OID 22635)
-- Name: ingredient; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ingredient (
    ingredientid integer NOT NULL,
    cost double precision,
    measure double precision,
    name character varying(255)
);


ALTER TABLE ingredient OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 22633)
-- Name: ingredient_ingredientid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ingredient_ingredientid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ingredient_ingredientid_seq OWNER TO postgres;

--
-- TOC entry 2059 (class 0 OID 0)
-- Dependencies: 178
-- Name: ingredient_ingredientid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ingredient_ingredientid_seq OWNED BY ingredient.ingredientid;


--
-- TOC entry 181 (class 1259 OID 22643)
-- Name: recipe; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recipe (
    recipeid integer NOT NULL,
    instructions character varying(255),
    name character varying(255)
);


ALTER TABLE recipe OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 22652)
-- Name: recipe_ingredient; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recipe_ingredient (
    recipe_recipeid integer NOT NULL,
    ingredient_ingredientid integer NOT NULL
);


ALTER TABLE recipe_ingredient OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 22641)
-- Name: recipe_recipeid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE recipe_recipeid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE recipe_recipeid_seq OWNER TO postgres;

--
-- TOC entry 2060 (class 0 OID 0)
-- Dependencies: 180
-- Name: recipe_recipeid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE recipe_recipeid_seq OWNED BY recipe.recipeid;


--
-- TOC entry 184 (class 1259 OID 22657)
-- Name: vendor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE vendor (
    vendorid integer NOT NULL,
    name character varying(255)
);


ALTER TABLE vendor OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 22655)
-- Name: vendor_vendorid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE vendor_vendorid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vendor_vendorid_seq OWNER TO postgres;

--
-- TOC entry 2061 (class 0 OID 0)
-- Dependencies: 183
-- Name: vendor_vendorid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE vendor_vendorid_seq OWNED BY vendor.vendorid;


--
-- TOC entry 1916 (class 2604 OID 22614)
-- Name: allergenid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY allergen ALTER COLUMN allergenid SET DEFAULT nextval('allergen_allergenid_seq'::regclass);


--
-- TOC entry 1917 (class 2604 OID 22622)
-- Name: bakedgoodid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bakedgood ALTER COLUMN bakedgoodid SET DEFAULT nextval('bakedgood_bakedgoodid_seq'::regclass);


--
-- TOC entry 1918 (class 2604 OID 22630)
-- Name: categoryid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY category ALTER COLUMN categoryid SET DEFAULT nextval('category_categoryid_seq'::regclass);


--
-- TOC entry 1919 (class 2604 OID 22638)
-- Name: ingredientid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingredient ALTER COLUMN ingredientid SET DEFAULT nextval('ingredient_ingredientid_seq'::regclass);


--
-- TOC entry 1920 (class 2604 OID 22646)
-- Name: recipeid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recipe ALTER COLUMN recipeid SET DEFAULT nextval('recipe_recipeid_seq'::regclass);


--
-- TOC entry 1921 (class 2604 OID 22660)
-- Name: vendorid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vendor ALTER COLUMN vendorid SET DEFAULT nextval('vendor_vendorid_seq'::regclass);


--
-- TOC entry 1923 (class 2606 OID 22616)
-- Name: allergen_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY allergen
    ADD CONSTRAINT allergen_pkey PRIMARY KEY (allergenid);


--
-- TOC entry 1925 (class 2606 OID 22624)
-- Name: bakedgood_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bakedgood
    ADD CONSTRAINT bakedgood_pkey PRIMARY KEY (bakedgoodid);


--
-- TOC entry 1927 (class 2606 OID 22632)
-- Name: category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey PRIMARY KEY (categoryid);


--
-- TOC entry 1929 (class 2606 OID 22640)
-- Name: ingredient_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ingredient
    ADD CONSTRAINT ingredient_pkey PRIMARY KEY (ingredientid);


--
-- TOC entry 1931 (class 2606 OID 22651)
-- Name: recipe_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recipe
    ADD CONSTRAINT recipe_pkey PRIMARY KEY (recipeid);


--
-- TOC entry 1933 (class 2606 OID 22662)
-- Name: vendor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY vendor
    ADD CONSTRAINT vendor_pkey PRIMARY KEY (vendorid);


--
-- TOC entry 1934 (class 2606 OID 22663)
-- Name: fk47cbajfwwhpdp5iassx5av9i1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bakedgood
    ADD CONSTRAINT fk47cbajfwwhpdp5iassx5av9i1 FOREIGN KEY (allergenid) REFERENCES allergen(allergenid);


--
-- TOC entry 1935 (class 2606 OID 22668)
-- Name: fkcv2wcx1sakk0dg6c48lmok1c1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bakedgood
    ADD CONSTRAINT fkcv2wcx1sakk0dg6c48lmok1c1 FOREIGN KEY (categoryid) REFERENCES category(categoryid);


--
-- TOC entry 1937 (class 2606 OID 22678)
-- Name: fkk1as29xq7mh62e1b6uaerhqo1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recipe_ingredient
    ADD CONSTRAINT fkk1as29xq7mh62e1b6uaerhqo1 FOREIGN KEY (ingredient_ingredientid) REFERENCES ingredient(ingredientid);


--
-- TOC entry 1936 (class 2606 OID 22673)
-- Name: fkrja50xaws5hor5fqfgdsudibe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bakedgood
    ADD CONSTRAINT fkrja50xaws5hor5fqfgdsudibe FOREIGN KEY (vendorid) REFERENCES vendor(vendorid);


--
-- TOC entry 1938 (class 2606 OID 22683)
-- Name: fktcgvbhkbxbk9d1htxwv642o0k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recipe_ingredient
    ADD CONSTRAINT fktcgvbhkbxbk9d1htxwv642o0k FOREIGN KEY (recipe_recipeid) REFERENCES recipe(recipeid);


--
-- TOC entry 2054 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-02-26 14:51:42

--
-- PostgreSQL database dump complete
--

