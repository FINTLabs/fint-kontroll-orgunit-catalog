create table public.org_unit (id int8 generated by default as identity, manager_ref varchar(255), name varchar(255), organisation_unit_id varchar(255), parent_ref varchar(255), resource_id varchar(255), short_name varchar(255), primary key (id));
create table org_unit_children_ref (org_unit_id int8 not null, children_ref varchar(255));
alter table if exists org_unit_children_ref add constraint FKql36nq6uathi09wv7oj07v2x2 foreign key (org_unit_id) references public.org_unit;
INSERT INTO public.org_unit VALUES (1, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1022]', 'OKO System- og fellestjenester', '35', '30', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/35', 'OKO SYSFEL');
INSERT INTO public.org_unit VALUES (2, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1039]', 'DIGIT Lokasjonssupport sone Fylkeshus', '1178', '50', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/1178', 'DIGIT FYLKESHUS');
INSERT INTO public.org_unit VALUES (3, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1402]', 'INFRA Avdeling for mobilitet og samfunn', '85', '8', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/85', 'INFRA MOBSAM');
INSERT INTO public.org_unit VALUES (4, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1037]', 'DIGIT Lokasjonssupport', '50', '37', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/50', 'DIGIT SUPPORT');
INSERT INTO public.org_unit VALUES (5, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1198]', 'VGMIDT Administrasjon', '195', '194', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/195', 'VGMIDT ADM');
INSERT INTO public.org_unit VALUES (6, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1085]', 'DIGIT Fagtjenester', '47', '38', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/47', 'DIGIT FAGTJ');
INSERT INTO public.org_unit VALUES (7, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1228]', 'VGMIDT Realfag', '204', '194', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/204', 'VGMIDT REAL');
INSERT INTO public.org_unit VALUES (8, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1312]', 'VGSTOR Administrasjon', '205', '198', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/205', 'VGSTOR ADMIN');
INSERT INTO public.org_unit VALUES (9, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1108]', 'DIGIT Arbeidsflate', '1163', '38', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/1163', 'DIGIT ARBFL');
INSERT INTO public.org_unit VALUES (10, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1001]', 'Vår fylkeskommune', '1', '1', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/1', 'VFK');
INSERT INTO public.org_unit VALUES (11, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1350]', 'VGSTOR Tekno', '218', '198', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/218', 'VGSTOR TEKNO');
INSERT INTO public.org_unit VALUES (12, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1027]', 'DIGIT Digitaliseringsavdeling', '36', '5', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/36', 'DIGIT');
INSERT INTO public.org_unit VALUES (13, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1382]', 'INFRA Samferdsel', '8', '1', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/8', 'INFRA');
INSERT INTO public.org_unit VALUES (14, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1182]', 'KOMP Fag- og yrkesopplæring', '161', '151', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/161', 'KOMP FYOPPL');
INSERT INTO public.org_unit VALUES (15, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1123]', 'KOMP Utdanning og kompetanse', '6', '1', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/6', 'KOMP');
INSERT INTO public.org_unit VALUES (16, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1017]', 'OKO Regnskapsseksjon', '30', '26', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/30', 'OKO REGN');
INSERT INTO public.org_unit VALUES (17, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1417]', 'INFRA Mobilitetsseksjon', '93', '85', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/93', 'INFRA MOBILITET');
INSERT INTO public.org_unit VALUES (18, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1113]', 'DIGIT Tjenesteforvaltning', '40', '36', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/40', 'DIGIT TJFORV');
INSERT INTO public.org_unit VALUES (19, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1383]', 'INFRA Fagavdeling', '84', '8', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/84', 'INFRA FAGAVD');
INSERT INTO public.org_unit VALUES (20, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1002]', 'FAK Finans og administrasjon', '5', '1', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/5', 'FAK');
INSERT INTO public.org_unit VALUES (21, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1270]', 'VGMIDT Språk/Økonomi', '207', '194', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/207', 'VGMIDT SPROK');
INSERT INTO public.org_unit VALUES (22, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1080]', 'DIGIT Basistjenester', '46', '38', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/46', 'DIGIT BASIS');
INSERT INTO public.org_unit VALUES (23, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1078]', 'DIGIT Teknologiseksjon', '38', '36', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/38', 'DIGIT TEKN');
INSERT INTO public.org_unit VALUES (24, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1125]', 'KOMP Forvaltningsutvikling', '150', '6', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/150', 'KOMP FORVUTV');
INSERT INTO public.org_unit VALUES (25, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1005]', 'OKO Økonomiavdeling', '26', '5', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/26', 'OKO');
INSERT INTO public.org_unit VALUES (26, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1095]', 'DIGIT Plattform og Kommunikasjon', '48', '38', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/48', 'DIGIT KOMM');
INSERT INTO public.org_unit VALUES (27, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1007]', 'OKO Budsjett- og finansseksjon', '27', '26', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/27', 'OKO BUDFIN');
INSERT INTO public.org_unit VALUES (28, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1388]', 'INFRA Vei- og geofag', '89', '84', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/89', 'INFRA VEIGEO');
INSERT INTO public.org_unit VALUES (29, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1145]', 'KOMP Statistikk, analyse, system og administrativ støtte', '157', '150', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/157', 'KOMP ANALYSE');
INSERT INTO public.org_unit VALUES (30, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1064]', 'DIGIT Lokasjonssupport sone 2', '1120', '50', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/1120', 'DIGIT LOKSONE2');
INSERT INTO public.org_unit VALUES (31, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1192]', 'VGMIDT Midtbyen videregående skole', '194', '153', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/194', 'VGMIDT');
INSERT INTO public.org_unit VALUES (32, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1307]', 'VGSTOR Storskog videregående skole', '198', '153', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/198', 'VGSTOR');
INSERT INTO public.org_unit VALUES (33, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1049]', 'DIGIT Lokasjonssupport sone 1', '1119', '50', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/1119', 'DIGIT LOKSONE1');
INSERT INTO public.org_unit VALUES (34, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1335]', 'VGSTOR Entreprenørskap', '211', '198', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/211', 'VGSTOR ENTRE');
INSERT INTO public.org_unit VALUES (35, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1405]', 'INFRA Fremtidens transporter', '92', '85', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/92', 'INFRA FREMTRA');
INSERT INTO public.org_unit VALUES (36, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1159]', 'KOMP Kompetanseutvikling', '151', '6', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/151', 'KOMP KOMPUTV');
INSERT INTO public.org_unit VALUES (37, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1031]', 'DIGIT Serviceseksjon', '37', '36', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/37', 'DIGIT SERVSEK');
INSERT INTO public.org_unit VALUES (38, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1191]', 'KOMP Område sørvest', '153', '6', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/153', 'KOMP SORVEST');
INSERT INTO public.org_unit_children_ref VALUES (3, '92');
INSERT INTO public.org_unit_children_ref VALUES (3, '93');
INSERT INTO public.org_unit_children_ref VALUES (4, '1178');
INSERT INTO public.org_unit_children_ref VALUES (4, '1119');
INSERT INTO public.org_unit_children_ref VALUES (4, '1120');
INSERT INTO public.org_unit_children_ref VALUES (10, '5');
INSERT INTO public.org_unit_children_ref VALUES (10, '6');
INSERT INTO public.org_unit_children_ref VALUES (10, '8');
INSERT INTO public.org_unit_children_ref VALUES (12, '37');
INSERT INTO public.org_unit_children_ref VALUES (12, '38');
INSERT INTO public.org_unit_children_ref VALUES (12, '40');
INSERT INTO public.org_unit_children_ref VALUES (13, '84');
INSERT INTO public.org_unit_children_ref VALUES (13, '85');
INSERT INTO public.org_unit_children_ref VALUES (15, '150');
INSERT INTO public.org_unit_children_ref VALUES (15, '151');
INSERT INTO public.org_unit_children_ref VALUES (15, '153');
INSERT INTO public.org_unit_children_ref VALUES (16, '35');
INSERT INTO public.org_unit_children_ref VALUES (19, '89');
INSERT INTO public.org_unit_children_ref VALUES (20, '26');
INSERT INTO public.org_unit_children_ref VALUES (20, '36');
INSERT INTO public.org_unit_children_ref VALUES (23, '46');
INSERT INTO public.org_unit_children_ref VALUES (23, '47');
INSERT INTO public.org_unit_children_ref VALUES (23, '48');
INSERT INTO public.org_unit_children_ref VALUES (23, '1163');
INSERT INTO public.org_unit_children_ref VALUES (24, '157');
INSERT INTO public.org_unit_children_ref VALUES (25, '27');
INSERT INTO public.org_unit_children_ref VALUES (25, '30');
INSERT INTO public.org_unit_children_ref VALUES (31, '195');
INSERT INTO public.org_unit_children_ref VALUES (31, '204');
INSERT INTO public.org_unit_children_ref VALUES (31, '207');
INSERT INTO public.org_unit_children_ref VALUES (32, '205');
INSERT INTO public.org_unit_children_ref VALUES (32, '211');
INSERT INTO public.org_unit_children_ref VALUES (32, '218');
INSERT INTO public.org_unit_children_ref VALUES (36, '161');
INSERT INTO public.org_unit_children_ref VALUES (37, '50');
INSERT INTO public.org_unit_children_ref VALUES (38, '194');
INSERT INTO public.org_unit_children_ref VALUES (38, '198');
create table public.org_unit (id int8 generated by default as identity, manager_ref varchar(255), name varchar(255), organisation_unit_id varchar(255), parent_ref varchar(255), resource_id varchar(255), short_name varchar(255), primary key (id));
create table org_unit_children_ref (org_unit_id int8 not null, children_ref varchar(255));
alter table if exists org_unit_children_ref add constraint FKql36nq6uathi09wv7oj07v2x2 foreign key (org_unit_id) references public.org_unit;
INSERT INTO public.org_unit VALUES (1, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1022]', 'OKO System- og fellestjenester', '35', '30', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/35', 'OKO SYSFEL');
INSERT INTO public.org_unit VALUES (2, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1039]', 'DIGIT Lokasjonssupport sone Fylkeshus', '1178', '50', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/1178', 'DIGIT FYLKESHUS');
INSERT INTO public.org_unit VALUES (3, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1402]', 'INFRA Avdeling for mobilitet og samfunn', '85', '8', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/85', 'INFRA MOBSAM');
INSERT INTO public.org_unit VALUES (4, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1037]', 'DIGIT Lokasjonssupport', '50', '37', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/50', 'DIGIT SUPPORT');
INSERT INTO public.org_unit VALUES (5, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1198]', 'VGMIDT Administrasjon', '195', '194', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/195', 'VGMIDT ADM');
INSERT INTO public.org_unit VALUES (6, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1085]', 'DIGIT Fagtjenester', '47', '38', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/47', 'DIGIT FAGTJ');
INSERT INTO public.org_unit VALUES (7, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1228]', 'VGMIDT Realfag', '204', '194', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/204', 'VGMIDT REAL');
INSERT INTO public.org_unit VALUES (8, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1312]', 'VGSTOR Administrasjon', '205', '198', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/205', 'VGSTOR ADMIN');
INSERT INTO public.org_unit VALUES (9, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1108]', 'DIGIT Arbeidsflate', '1163', '38', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/1163', 'DIGIT ARBFL');
INSERT INTO public.org_unit VALUES (10, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1001]', 'Vår fylkeskommune', '1', '1', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/1', 'VFK');
INSERT INTO public.org_unit VALUES (11, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1350]', 'VGSTOR Tekno', '218', '198', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/218', 'VGSTOR TEKNO');
INSERT INTO public.org_unit VALUES (12, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1027]', 'DIGIT Digitaliseringsavdeling', '36', '5', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/36', 'DIGIT');
INSERT INTO public.org_unit VALUES (13, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1382]', 'INFRA Samferdsel', '8', '1', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/8', 'INFRA');
INSERT INTO public.org_unit VALUES (14, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1182]', 'KOMP Fag- og yrkesopplæring', '161', '151', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/161', 'KOMP FYOPPL');
INSERT INTO public.org_unit VALUES (15, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1123]', 'KOMP Utdanning og kompetanse', '6', '1', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/6', 'KOMP');
INSERT INTO public.org_unit VALUES (16, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1017]', 'OKO Regnskapsseksjon', '30', '26', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/30', 'OKO REGN');
INSERT INTO public.org_unit VALUES (17, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1417]', 'INFRA Mobilitetsseksjon', '93', '85', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/93', 'INFRA MOBILITET');
INSERT INTO public.org_unit VALUES (18, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1113]', 'DIGIT Tjenesteforvaltning', '40', '36', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/40', 'DIGIT TJFORV');
INSERT INTO public.org_unit VALUES (19, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1383]', 'INFRA Fagavdeling', '84', '8', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/84', 'INFRA FAGAVD');
INSERT INTO public.org_unit VALUES (20, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1002]', 'FAK Finans og administrasjon', '5', '1', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/5', 'FAK');
INSERT INTO public.org_unit VALUES (21, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1270]', 'VGMIDT Språk/Økonomi', '207', '194', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/207', 'VGMIDT SPROK');
INSERT INTO public.org_unit VALUES (22, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1080]', 'DIGIT Basistjenester', '46', '38', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/46', 'DIGIT BASIS');
INSERT INTO public.org_unit VALUES (23, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1078]', 'DIGIT Teknologiseksjon', '38', '36', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/38', 'DIGIT TEKN');
INSERT INTO public.org_unit VALUES (24, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1125]', 'KOMP Forvaltningsutvikling', '150', '6', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/150', 'KOMP FORVUTV');
INSERT INTO public.org_unit VALUES (25, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1005]', 'OKO Økonomiavdeling', '26', '5', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/26', 'OKO');
INSERT INTO public.org_unit VALUES (26, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1095]', 'DIGIT Plattform og Kommunikasjon', '48', '38', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/48', 'DIGIT KOMM');
INSERT INTO public.org_unit VALUES (27, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1007]', 'OKO Budsjett- og finansseksjon', '27', '26', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/27', 'OKO BUDFIN');
INSERT INTO public.org_unit VALUES (28, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1388]', 'INFRA Vei- og geofag', '89', '84', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/89', 'INFRA VEIGEO');
INSERT INTO public.org_unit VALUES (29, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1145]', 'KOMP Statistikk, analyse, system og administrativ støtte', '157', '150', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/157', 'KOMP ANALYSE');
INSERT INTO public.org_unit VALUES (30, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1064]', 'DIGIT Lokasjonssupport sone 2', '1120', '50', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/1120', 'DIGIT LOKSONE2');
INSERT INTO public.org_unit VALUES (31, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1192]', 'VGMIDT Midtbyen videregående skole', '194', '153', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/194', 'VGMIDT');
INSERT INTO public.org_unit VALUES (32, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1307]', 'VGSTOR Storskog videregående skole', '198', '153', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/198', 'VGSTOR');
INSERT INTO public.org_unit VALUES (33, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1049]', 'DIGIT Lokasjonssupport sone 1', '1119', '50', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/1119', 'DIGIT LOKSONE1');
INSERT INTO public.org_unit VALUES (34, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1335]', 'VGSTOR Entreprenørskap', '211', '198', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/211', 'VGSTOR ENTRE');
INSERT INTO public.org_unit VALUES (35, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1405]', 'INFRA Fremtidens transporter', '92', '85', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/92', 'INFRA FREMTRA');
INSERT INTO public.org_unit VALUES (36, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1159]', 'KOMP Kompetanseutvikling', '151', '6', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/151', 'KOMP KOMPUTV');
INSERT INTO public.org_unit VALUES (37, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1031]', 'DIGIT Serviceseksjon', '37', '36', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/37', 'DIGIT SERVSEK');
INSERT INTO public.org_unit VALUES (38, '[https://beta.felleskomponent.no/administrasjon/personal/personalressurs/ansattnummer/1191]', 'KOMP Område sørvest', '153', '6', 'https://beta.felleskomponent.no/administrasjon/organisasjon/organisasjonselement/organisasjonsid/153', 'KOMP SORVEST');
INSERT INTO public.org_unit_children_ref VALUES (3, '92');
INSERT INTO public.org_unit_children_ref VALUES (3, '93');
INSERT INTO public.org_unit_children_ref VALUES (4, '1178');
INSERT INTO public.org_unit_children_ref VALUES (4, '1119');
INSERT INTO public.org_unit_children_ref VALUES (4, '1120');
INSERT INTO public.org_unit_children_ref VALUES (10, '5');
INSERT INTO public.org_unit_children_ref VALUES (10, '6');
INSERT INTO public.org_unit_children_ref VALUES (10, '8');
INSERT INTO public.org_unit_children_ref VALUES (12, '37');
INSERT INTO public.org_unit_children_ref VALUES (12, '38');
INSERT INTO public.org_unit_children_ref VALUES (12, '40');
INSERT INTO public.org_unit_children_ref VALUES (13, '84');
INSERT INTO public.org_unit_children_ref VALUES (13, '85');
INSERT INTO public.org_unit_children_ref VALUES (15, '150');
INSERT INTO public.org_unit_children_ref VALUES (15, '151');
INSERT INTO public.org_unit_children_ref VALUES (15, '153');
INSERT INTO public.org_unit_children_ref VALUES (16, '35');
INSERT INTO public.org_unit_children_ref VALUES (19, '89');
INSERT INTO public.org_unit_children_ref VALUES (20, '26');
INSERT INTO public.org_unit_children_ref VALUES (20, '36');
INSERT INTO public.org_unit_children_ref VALUES (23, '46');
INSERT INTO public.org_unit_children_ref VALUES (23, '47');
INSERT INTO public.org_unit_children_ref VALUES (23, '48');
INSERT INTO public.org_unit_children_ref VALUES (23, '1163');
INSERT INTO public.org_unit_children_ref VALUES (24, '157');
INSERT INTO public.org_unit_children_ref VALUES (25, '27');
INSERT INTO public.org_unit_children_ref VALUES (25, '30');
INSERT INTO public.org_unit_children_ref VALUES (31, '195');
INSERT INTO public.org_unit_children_ref VALUES (31, '204');
INSERT INTO public.org_unit_children_ref VALUES (31, '207');
INSERT INTO public.org_unit_children_ref VALUES (32, '205');
INSERT INTO public.org_unit_children_ref VALUES (32, '211');
INSERT INTO public.org_unit_children_ref VALUES (32, '218');
INSERT INTO public.org_unit_children_ref VALUES (36, '161');
INSERT INTO public.org_unit_children_ref VALUES (37, '50');
INSERT INTO public.org_unit_children_ref VALUES (38, '194');
INSERT INTO public.org_unit_children_ref VALUES (38, '198');
