insert into module(id, name) values(0, 'catalog');

insert into country(name, region_name, postal_name, region_field, addr_formatter) 
	values('Canada', 'LL_PROVINCE', 'LL_POSTAL_CODE', 'short_name', 'get_us_address');
	
-- Canada Provinces
insert into region(name, short_name, country_id) values('Ontario', 'ON', 1);
insert into region(name, short_name, country_id) values('Quebec', 'QC', 1);

insert into city(name, region_id) values('London', 1);

insert into field_category(name, module_id, is_system) values('LL_COMPANY', 0, 'Y');
insert into field_category(name, module_id, is_system) values('LL_PERSON', 0, 'Y');

insert into field(name, field_category_id, is_system) values('LL_SITE', 1, 'Y');
insert into field(name, field_category_id, is_system) values('LL_PHONE', 1, 'Y');
insert into field(name, field_category_id, is_system) values('LL_EMAIL', 1, 'Y');
insert into field(name, field_category_id, is_system) values('LL_ADDRESS', 1, 'Y');
insert into field(name, field_category_id, is_system) values('LL_FAX', 1, 'Y');
insert into field(name, field_category_id, is_system) values('LL_NOTES', 1, 'Y');

insert into field(name, field_category_id, is_system) values('LL_CELL_PHONE', 2, 'Y');
insert into field(name, field_category_id, is_system) values('LL_HOME_PHONE', 2, 'Y');
insert into field(name, field_category_id, is_system) values('LL_EMAIL', 2, 'Y');
insert into field(name, field_category_id, is_system) values('LL_ADDRESS', 2, 'Y');
insert into field(name, field_category_id, is_system) values('LL_NOTES', 2, 'Y');

insert into bfile_category (name, is_system) values('LL_GENERAL', 'Y');
insert into bfile_category (name, is_system) values('LL_LOGO', 'Y');

-- Custom data
insert into address(line_1, zip, city_id) values('Here we are', 'ABC123', 1);

insert into entity(module_id, name, field_cat_id) values(0, 'Example', 1);
insert into entity_field(entity_id, field_id, value) values(1, 1, 'http://www.example.com/');
insert into entity_field(entity_id, field_id, value) values(1, 2, '1-888-1234567');
insert into entity_field(entity_id, field_id, value) values(1, 3, 'info@example.com');
insert into entity_field(entity_id, field_id, value) values(1, 4, '1');
