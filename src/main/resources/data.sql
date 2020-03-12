
insert into ROLE (id, authority) values (nextval('role_seq'), 'PATIENT');
insert into ROLE (id, authority) values (nextval('role_seq'), 'DOCTOR');
insert into ROLE (id, authority) values (nextval('role_seq'), 'RECEPTIONIST');
insert into ROLE (id, authority) values (nextval('role_seq'), 'ADMIN');


insert into ADDRESS (id, street, house_Number, post_Code, city, country)values (nextval('address_seq'), 'Tonowska', '11', '88400', 'Zerniki', 'Polen');
insert into ADDRESS (id, street, house_Number, post_Code, city, country) values (nextval('address_seq'), 'Gdańska', '12', '20300', 'Bydgoszcz', 'Polen');
insert into ADDRESS (id, street, house_Number, post_Code, city, country) values (nextval('address_seq'), 'Katowicka', '11', '30400', 'Gniezno', 'Polen');

insert into PII (id_Number, phone_Number, email_Address) values ('80121289900', '+48600435690', 'jurek.molenda@wp.pl');
insert into PII (id_Number, phone_Number, email_Address) values ('60111282930', '+48543678982', 'grzegorz.waliszewski@wp.pl');
insert into PII (id_Number, phone_Number, email_Address) values ('50021289930', '+48793456765', 'zygmunt.wiburski@wp.pl');


insert into PATIENT (username, password, first_Name, last_Name, role_id, address_id, pii_id_Number)
 values ('juras', '123', 'Jerzy', 'Molenda', 1, 1, '80121289900');
insert into PATIENT (username, password, first_Name, last_Name, role_id, address_id, pii_id_Number)
values ('grek', 'yty', 'Grzegorz', 'Waliszewski', 1, 2, '60111282930');
insert into PATIENT (username, password, first_Name, last_Name, role_id, address_id, pii_id_Number)
values ('zyga', 'warw', 'Zygmunt', 'Wiburski', 1, 3, '50021289930');

commit;