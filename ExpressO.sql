--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2016-02-26 14:37:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2049 (class 0 OID 22611)
-- Dependencies: 173
-- Data for Name: allergen; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY allergen (allergenid, name) FROM stdin;
1	None
2	Milk
3	Peanuts
4	Eggs
5	Tree Nuts
6	Soy
7	Wheat
\.


--
-- TOC entry 2065 (class 0 OID 0)
-- Dependencies: 172
-- Name: allergen_allergenid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('allergen_allergenid_seq', 7, true);


--
-- TOC entry 2053 (class 0 OID 22627)
-- Dependencies: 177
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY category (categoryid, name) FROM stdin;
1	Cookie
2	Doughnut
3	Cake
4	Scone
5	Biscotti
6	Bagel
7	General Pastry
\.


--
-- TOC entry 2060 (class 0 OID 22657)
-- Dependencies: 184
-- Data for Name: vendor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY vendor (vendorid, name) FROM stdin;
1	Hinkleman Bagels
2	Spielman Bagels
3	Pips Donuts
4	Voodoo Donuts
5	Pax Patiserrie
6	Kens Artisan Bakery
7	La Provence
8	Grand Central Bakery
\.


--
-- TOC entry 2051 (class 0 OID 22619)
-- Dependencies: 175
-- Data for Name: bakedgood; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bakedgood (bakedgoodid, cost, name, allergenid, categoryid, vendorid) FROM stdin;
1	3	Bacon Maple Bar	1	2	4
2	3.5	Everything Bagel Without Cheese	7	6	2
\.


--
-- TOC entry 2066 (class 0 OID 0)
-- Dependencies: 174
-- Name: bakedgood_bakedgoodid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('bakedgood_bakedgoodid_seq', 6, true);


--
-- TOC entry 2067 (class 0 OID 0)
-- Dependencies: 176
-- Name: category_categoryid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('category_categoryid_seq', 7, true);


--
-- TOC entry 2055 (class 0 OID 22635)
-- Dependencies: 179
-- Data for Name: ingredient; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ingredient (ingredientid, cost, measure, name) FROM stdin;
2	0.5	10	Small Milk
3	1.5	3	Double Shot Espresso
1	0.75	1	Caramel Syrup
4	5	6	Quad Shot
7	0.5	20	Large Milk
8	0.25	1	Chocolate Syrup
\.


--
-- TOC entry 2068 (class 0 OID 0)
-- Dependencies: 178
-- Name: ingredient_ingredientid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ingredient_ingredientid_seq', 28, true);


--
-- TOC entry 2057 (class 0 OID 22643)
-- Dependencies: 181
-- Data for Name: recipe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY recipe (recipeid, instructions, name) FROM stdin;
1	Use small cup, add requisite ingredients below.	Small Caramel Latte
3	Same as small caramel latte, only with chocolate syrup.	Small Chocolate Latte
2	Requires purchase of large. 4 shots of espresso in this one.	Caramel Latte Quad Shot
\.


--
-- TOC entry 2058 (class 0 OID 22652)
-- Dependencies: 182
-- Data for Name: recipe_ingredient; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY recipe_ingredient (recipe_recipeid, ingredient_ingredientid) FROM stdin;
1	2
1	3
1	1
1	4
3	2
3	3
3	4
3	8
2	1
2	3
2	7
\.


--
-- TOC entry 2069 (class 0 OID 0)
-- Dependencies: 180
-- Name: recipe_recipeid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recipe_recipeid_seq', 6, true);


--
-- TOC entry 2070 (class 0 OID 0)
-- Dependencies: 183
-- Name: vendor_vendorid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('vendor_vendorid_seq', 8, true);


-- Completed on 2016-02-26 14:37:29

--
-- PostgreSQL database dump complete
--

