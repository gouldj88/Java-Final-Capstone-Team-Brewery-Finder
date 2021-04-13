drop table if exists userbreweries cascade;
drop table if exists userbrewerydetails cascade;
drop table if exists beers cascade; 


CREATE TABLE userbreweries
(
obdb_id character varying(255) primary key unique,
name character varying(255),
brewery_type character varying(255),
street character varying(255),
address_2 character varying(255),
address_3 character varying(255),
city character varying(255),
state character varying(255),
county_province character varying(255),
postal_code character varying(255),
website_url character varying(255),
phone character varying(12),
created_at date,
updated_at date,
country character varying(255),
longitude character varying(255),
latitude character varying(255),
tags character varying(255),
username character varying(30)
);

CREATE TABLE userbrewerydetails
(
obdb_id character varying(255) primary key unique,
history character varying(255) not null,
image_url character varying(255) not null,
hour_open character varying(255) not null,
hour_closed character varying(255) not null,
open_sun boolean default false not null,
open_mon boolean default false not null,
open_tue boolean default false not null,
open_wed boolean default false not null,
open_thu boolean default false not null,
open_fri boolean default false not null,
open_sat boolean default false not null,
constraint fk_obdb_id foreign key (obdb_id) references userbreweries(obdb_id)

);


CREATE TABLE beers (
beer_id serial PRIMARY KEY,
obdb_id character varying(255) not null,
beer_name character varying(255) not null,
brewery character varying(255) not null,
description character varying(255) default null,
image character varying(255) default null,
abv character varying(255) default null,
beer_type character varying(255) default null,
active character varying(1) not null,
constraint fk_obdb_id foreign key (obdb_id) references userbreweries(obdb_id)
);

insert into userbreweries (obdb_id, name, street, city, state, postal_code, website_url, phone, username) values ('jeffs-tavern-and-brewhouse', 'Jeff''s Tavern & Brewhouse', '1 Cedar Point Drive', 'Sandusky', 'Ohio', '44870', null, '4405551234', 'tester');
insert into userbreweries (obdb_id, name, street, city, state, postal_code, website_url, phone, username) values ('pub-louis', 'Pub Louis', '1250 Pacific Ave #101', 'Tacoma', 'Washington', '98402', null, '4405551234', 'tester');
insert into userbreweries (obdb_id, name, street, city, state, postal_code, website_url, phone, username) values ('briannas-wing-and-dance', 'Brianna''s Wings & Dancehall', '300 Parkside Ave', 'Buffalo', 'New York', '14214', null, '4405551234', 'tester');

insert into beers (obdb_id, beer_name, brewery, description, image, abv, beer_type, active) values ('jeffs-tavern-and-brewhouse', 'Blue Moon', 'Blue Moon Brewing', 'It''s a smooth and tasty belgian ale.', 'https://www.bluemoonbrewingcompany.com/sites/bluemoon/files/2018-05/OurBeers.png', '7%', 'Belgian Ale', 'Y');

insert into userbrewerydetails (obdb_id, history, image_url, hour_open, hour_closed, open_sun, open_mon, open_tue, open_wed, open_thu, open_fri, open_sat) values ('jeffs-tavern', 'Jeff''s Tavern has been a Sandusky staple for over a century. Come try the tasty Woodstock Express cocktail. Or the Corkscrew, if you''re into pain.', 'https://meltbarandgrilled.com/wp-content/gallery/gallery-location-melt-cedar-point/MELT_LOCATION_CEDAR_POINT_004.jpg', '11:00 AM', '11:00 PM', true, false, false, true, true, true, true);