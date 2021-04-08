drop table if exists userbreweries cascade;
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

CREATE TABLE beers (
beer_id serial PRIMARY KEY,
obdb_id character varying(255) not null,
beer_name character varying(255) not null,
description character varying(255) default null,
image character varying(255) default null,
abv character varying(255) default null,
beer_type character varying(255) default null,
constraint fk_obdb_id foreign key (obdb_id) references userbreweries(obdb_id)
);