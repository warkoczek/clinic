
insert into ROLE (id, authority) values (nextval('role_seq'), 'PATIENT');
insert into ROLE (id, authority) values (nextval('role_seq'), 'DOCTOR');
insert into ROLE (id, authority) values (nextval('role_seq'), 'RECEPTIONIST');
insert into ROLE (id, authority) values (nextval('role_seq'), 'ADMIN');


insert into ADDRESS (id, street, house_Number, post_Code, city, country)values (nextval('address_seq'), 'Tonowska', '11', '88400', 'Zerniki', 'Polen');
insert into ADDRESS (id, street, house_Number, post_Code, city, country) values (nextval('address_seq'), 'Gdańska', '12', '20300', 'Bydgoszcz', 'Polen');
insert into ADDRESS (id, street, house_Number, post_Code, city, country) values (nextval('address_seq'), 'Katowicka', '11', '30400', 'Gniezno', 'Polen');

insert into ADDRESS (id, street, house_Number, post_Code, city, country) values (nextval('address_seq'), 'Wirusowa', '4', '30567', 'Leszno', 'Polen');
insert into ADDRESS (id, street, house_Number, post_Code, city, country) values (nextval('address_seq'), 'Schtrasse', '2', '33400', 'Hamburg', 'Deutschland');
insert into ADDRESS (id, street, house_Number, post_Code, city, country) values (nextval('address_seq'), 'Poznańska', '11', '30400', 'Katowice', 'Polen');
insert into ADDRESS (id, street, house_Number, post_Code, city, country) values (nextval('address_seq'), 'Orzechowa', '5', '88560', 'Wroclaw', 'Polen');

insert into PII (id_Number, phone_Number, email_Address) values ('80121289900', '+48600435690', 'jurek.molenda@wp.pl');
insert into PII (id_Number, phone_Number, email_Address) values ('60111282930', '+48543678982', 'grzegorz.waliszewski@wp.pl');
insert into PII (id_Number, phone_Number, email_Address) values ('50021289930', '+48793456765', 'zygmunt.wiburski@wp.pl');

insert into PII (id_Number, phone_Number, email_Address) values ('40061289930', '+48793456761', 'ffff.wi@wp.pl');
insert into PII (id_Number, phone_Number, email_Address) values ('32031289930', '+48793456763', 'zygmunt.oooi@wp.pl');
insert into PII (id_Number, phone_Number, email_Address) values ('50041189930', '+48793456764', 'munt.wmmm@wp.pl');
insert into PII (id_Number, phone_Number, email_Address) values ('79041189930', '+48793456740', 'karol.ugin@wp.pl');


insert into PATIENT (username, password, first_Name, last_Name, role_id, address_id, pii_id_Number)
 values ('juras', '123', 'Jerzy', 'Molenda', 1, 1, '80121289900');
insert into PATIENT (username, password, first_Name, last_Name, role_id, address_id, pii_id_Number)
values ('grek', 'yty', 'Grzegorz', 'Waliszewski', 1, 2, '60111282930');
insert into PATIENT (username, password, first_Name, last_Name, role_id, address_id, pii_id_Number)
values ('zyga', 'warw', 'Zygmunt', 'Wiburski', 1, 3, '50021289930');


insert into DOCTOR (username, password, first_Name, last_Name, role_id,specialization, address_id, pii_id_Number)
values ('bogi', 'ttt', 'Bogdan', 'Górski', 2, 'PEDIATRICIAN', 4, '40061289930');
insert into DOCTOR (username, password, first_Name, last_Name, role_id,specialization, address_id, pii_id_Number)
values ('olek', 'eee', 'Aleksander', 'Witucki', 2, 'LARYNGOLOGIST',5, '32031289930');
insert into DOCTOR (username, password, first_Name, last_Name, role_id,specialization, address_id, pii_id_Number)
 values ('krys', 'tot', 'Krzysztof', 'Kolecki', 2,'UROLOGIST', 6, '50041189930');
insert into DOCTOR (username, password, first_Name, last_Name, role_id,specialization, address_id, pii_id_Number)
values ('mario', 'mmmww', 'Karol', 'Uginski', 2,'UROLOGIST', 7, '79041189930');

insert into APPOINTMENT (id, patient_username, doctor_username, appointment_Date, description) values (nextval('appointment_Seq'), 'zyga', 'mario', '2020-04-04 15:30:00', 'prostate control');
insert into APPOINTMENT (id, patient_username, doctor_username, appointment_Date, description) values (nextval('appointment_Seq'), 'grek', 'krys', '2020-05-04 15:00:00', 'prostate');

insert into APPOINTMENT (id, doctor_username, appointment_Date) values (nextval('appointment_Seq'), 'olek', '2020-06-04 14:00:00');
insert into APPOINTMENT (id, doctor_username, appointment_Date) values (nextval('appointment_Seq'), 'olek', '2020-06-04 14:30:00');
insert into APPOINTMENT (id, doctor_username, appointment_Date) values (nextval('appointment_Seq'), 'olek', '2020-06-04 15:00:00');
insert into APPOINTMENT (id, doctor_username, appointment_Date) values (nextval('appointment_Seq'), 'olek', '2020-06-04 15:30:00');

insert into APPOINTMENT (id, doctor_username, appointment_Date) values (nextval('appointment_Seq'), 'bogi', '2020-07-22 16:30:00');
insert into APPOINTMENT (id, doctor_username, appointment_Date) values (nextval('appointment_Seq'), 'bogi', '2020-07-22 13:30:00');



commit;