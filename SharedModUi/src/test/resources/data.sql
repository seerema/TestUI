insert into module(id, name) values(0, 'catalog');
insert into module(id, name) values(1, 'task');
insert into module(id, name) values(2, 'crm');

insert into user(name) values('user1');

insert into status(name, module_id, is_system) values('LL_NEW_F', 1, 'Y');
insert into status(name, module_id, is_system) values('LL_STARTED', 1, 'Y');
insert into status(name, module_id, is_system) values('LL_ON_HOLD', 1, 'Y');
insert into status(name, module_id, is_system) values('LL_COMPLETED', 1, 'Y');
insert into status(name, module_id, is_system) values('LL_CANCEL', 1, 'Y');

insert into status(name, module_id, is_system) values('LL_LEAD', 2, 'Y');
insert into status(name, module_id, is_system) values('LL_CUSTOMER', 2, 'Y');
insert into status(name, module_id, is_system) values('LL_INACTIVE', 2, 'Y');

insert into field_category(name, module_id, is_system) values('LL_REGULAR', 1, 'Y');
insert into field_category(name, module_id, is_system) values('LL_CRM', 1, 'Y');

insert into field_category(name, module_id, is_system) values('LL_COMPANY', 2, 'Y');
insert into field_category(name, module_id, is_system) values('LL_PERSON', 2, 'Y');
insert into field_category(name, module_id, is_system) values('LL_OTHER', 2, 'Y');

insert into field(name, field_category_id, is_system) values('LL_NOTES', 1, 'Y');
insert into field(name, field_category_id, is_system) values('LL_DUE_DATE', 1, 'Y');
insert into field(name, field_category_id, is_system) values('LL_NOTES', 2, 'Y');
insert into field(name, field_category_id, is_system) values('LL_DUE_DATE', 2, 'Y');
insert into field(name, field_category_id, is_system) values('LL_CRM_ID', 2, 'Y');

insert into field(name, field_category_id, is_system) values('LL_WEB_SITE', 3, 'Y');
insert into field(name, field_category_id, is_system) values('LL_PHONE', 3, 'Y');
insert into field(name, field_category_id, is_system) values('LL_EMAIL', 3, 'Y');
insert into field(name, field_category_id, is_system) values('LL_ADDRESS', 3, 'Y');
insert into field(name, field_category_id) values('LL_FAX', 3);
insert into field(name, field_category_id) values('LL_SKYPE_ID', 3);

insert into field(name, field_category_id, is_system) values('LL_CELL_PHONE', 4, 'Y');
insert into field(name, field_category_id, is_system) values('LL_EMAIL', 4, 'Y');
insert into field(name, field_category_id, is_system) values('LL_ADDRESS', 4, 'Y');
insert into field(name, field_category_id) values('LL_SKYPE_ID', 4);

insert into field(name, field_category_id, is_system) values('LL_PHONE', 5, 'Y');
insert into field(name, field_category_id, is_system) values('LL_EMAIL', 5, 'Y');
insert into field(name, field_category_id) values('LL_SKYPE_ID', 5);

insert into entity(module_id, name, field_cat_id) values(1, 'TO-DO', 1);
insert into entity_ex(id, entity_id, user_id, status_id) values(1, 1, 1, 1);
insert into entity_field(entity_id, field_id, value) values(1, 1, 'Sample TO_DO task');
insert into entity_status_history(entity_id, status_id, user_id, created) values(1, 1, 1, current_timestamp);
insert into entity_user_history(entity_id, owner_id, user_id, created) values(1, 1, 1, current_timestamp);

insert into entity(module_id, name, field_cat_id) values(2, 'Temp', 3);
insert into entity_ex(id, entity_id, user_id, status_id) values(2, 2, 1, 6);
insert into entity_field(entity_id, field_id, value) values(2, 6, 'http://www.example.com/');
insert into entity_field(entity_id, field_id, value) values(2, 7, '1-888-1234567');
insert into entity_status_history(entity_id, status_id, user_id, created) values(2, 6, 1, current_timestamp);
insert into entity_user_history(entity_id, owner_id, user_id, created) values(2, 1, 1, current_timestamp);

