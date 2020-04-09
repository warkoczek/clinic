
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

insert into ROOM (id, door_Number, floor_Number) values (nextval('room_Seq'), '1', '1');
insert into ROOM (id, door_Number, floor_Number) values (nextval('room_Seq'), '2', '1');
insert into ROOM (id, door_Number, floor_Number) values (nextval('room_Seq'), '3', '2');
insert into ROOM (id, door_Number, floor_Number) values (nextval('room_Seq'), '4', '2');


insert into PATIENT (username, password, first_Name, last_Name, role_id, address_id, pii_id_Number)
 values ('juras', '123', 'Jerzy', 'Molenda', 1, 1, '80121289900');
insert into PATIENT (username, password, first_Name, last_Name, role_id, address_id, pii_id_Number)
values ('grek', 'yty', 'Grzegorz', 'Waliszewski', 1, 2, '60111282930');
insert into PATIENT (username, password, first_Name, last_Name, role_id, address_id, pii_id_Number)
values ('zyga', 'warw', 'Zygmunt', 'Wiburski', 1, 3, '50021289930');


insert into DOCTOR (username, password, first_Name, last_Name, role_id,specialization, address_id, pii_id_Number, room_id)
values ('bogi', 'ttt', 'Bogdan', 'Górski', 2, 'PEDIATRICIAN', 4, '40061289930',1);
insert into DOCTOR (username, password, first_Name, last_Name, role_id,specialization, address_id, pii_id_Number, room_id)
values ('olek', 'eee', 'Aleksander', 'Witucki', 2, 'LARYNGOLOGIST',5, '32031289930',2);
insert into DOCTOR (username, password, first_Name, last_Name, role_id,specialization, address_id, pii_id_Number, room_id)
 values ('krys', 'tot', 'Krzysztof', 'Kolecki', 2,'UROLOGIST', 6, '50041189930',3);
insert into DOCTOR (username, password, first_Name, last_Name, role_id,specialization, address_id, pii_id_Number, room_id)
values ('mario', 'mmmww', 'Karol', 'Uginski', 2,'UROLOGIST', 7, '79041189930',4);

insert into PRESCRIPTION (id, Issue_Date, Expiry_Date, prescription_Type, patient_username, doctor_username, description) values (nextval('prescription_Seq'), '2020-02-03', '2020-08-03', 'ONGOING', 'zyga', 'mario', 'take Ibuprofen pain killer twice a day');
insert into PRESCRIPTION (id, Issue_Date, Expiry_Date, prescription_Type, patient_username, doctor_username, description) values (nextval('prescription_Seq'), '2020-02-27', '2020-08-27', 'DISPOSABLE', 'grek', 'krys', 'prostate');
insert into PRESCRIPTION (id, Issue_Date, Expiry_Date, prescription_Type, patient_username, doctor_username, description) values (nextval('prescription_Seq'), '2020-01-02', '2020-03-24', 'DISPOSABLE', 'grek', 'krys', 'cold');
insert into PRESCRIPTION (id, Issue_Date, Expiry_Date, prescription_Type, patient_username, doctor_username, description) values (nextval('prescription_Seq'), '2020-01-02', '2020-04-24', 'DISPOSABLE', 'juras', 'olek', 'sore throat');


insert into APPOINTMENT (id, patient_username, doctor_username, appointment_Date, room_id, description) values (nextval('appointment_Seq'), 'zyga', 'mario', '2020-03-21 15:30:00',4,  'prostate control');
insert into APPOINTMENT (id, patient_username, doctor_username, appointment_Date, room_id, description) values (nextval('appointment_Seq'), 'grek', 'krys', '2020-03-21 15:00:00',3,  'prostate');

insert into APPOINTMENT (id, doctor_username, appointment_Date, room_id) values (nextval('appointment_Seq'), 'olek', '2020-06-04 14:00:00', 2);
insert into APPOINTMENT (id, doctor_username, appointment_Date, room_id) values (nextval('appointment_Seq'), 'olek', '2020-06-04 14:30:00', 2);
insert into APPOINTMENT (id, doctor_username, appointment_Date, room_id) values (nextval('appointment_Seq'), 'olek', '2020-06-04 15:00:00', 2);
insert into APPOINTMENT (id, doctor_username, appointment_Date, room_id) values (nextval('appointment_Seq'), 'olek', '2020-06-04 15:30:00', 2);

insert into APPOINTMENT (id, doctor_username, appointment_Date, room_id) values (nextval('appointment_Seq'), 'bogi', '2020-07-22 16:30:00', 1);
insert into APPOINTMENT (id, doctor_username, appointment_Date, room_id) values (nextval('appointment_Seq'), 'bogi', '2020-07-22 13:30:00', 1);


commit;
