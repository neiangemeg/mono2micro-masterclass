-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

create sequence travelorder_sequence start with 1 increment by 1;
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));

create sequence flight_sequence start with 1 increment by 1;
INSERT INTO Flight(id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),1,'GRU','MEX');
INSERT INTO Flight(id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),2,'GRU','XXX');
INSERT INTO Flight(id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),3,'GRU','YYY');
INSERT INTO Flight(id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),4,'GRU','UUU');
INSERT INTO Flight(id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),5,'GRU','KKK');

 create sequence hotel_sequence start with 1 increment by 1;
 INSERT INTO Hotel(id,travelOrderid,nights) VALUES (nextval('hotel_sequence'),1,5);
 INSERT INTO Hotel(id,travelOrderid,nights) VALUES (nextval('hotel_sequence'),2,2);
 INSERT INTO Hotel(id,travelOrderid,nights) VALUES (nextval('hotel_sequence'),3,3);
 INSERT INTO Hotel(id,travelOrderid,nights) VALUES (nextval('hotel_sequence'),4,10);
 INSERT INTO Hotel(id,travelOrderid,nights) VALUES (nextval('hotel_sequence'),5,30);

