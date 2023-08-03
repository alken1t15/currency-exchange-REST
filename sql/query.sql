create table currencies(
                           id serial primary key,
                           code varchar not null ,
                           full_name varchar not null ,
                           sign varchar not null
);


create table exchange_rates(
                              id serial primary key,
                              base_currency_id int references currencies(id) not null ,
                              target_currency_id int references currencies(id) not null ,
                              rate decimal(6) not null
);

insert into currencies (code, full_name, sign) VALUES ('AUD','Australian dollar','A$');
insert into currencies (code, full_name, sign) VALUES ('EUR','Euro','€');
insert into currencies (code, full_name, sign) VALUES ('USD','US Dollar','$');
insert into currencies (code, full_name, sign) VALUES ('KZT','Tenge','₸');
insert into currencies (code, full_name, sign) VALUES ('RUB','Russian Ruble','₽');
insert into currencies (code, full_name, sign) VALUES ('CNY','Yuan Renminbi','¥');
insert into currencies (code, full_name, sign) VALUES ('JPY','Yen','¥');


insert into exchange_rates (base_currency_id, target_currency_id, rate) VALUES (2,3,1.1);
insert into exchange_rates (base_currency_id, target_currency_id, rate) VALUES (2,4,489.44);
insert into exchange_rates (base_currency_id, target_currency_id, rate) VALUES (3,4,446.07);
insert into exchange_rates (base_currency_id, target_currency_id, rate) VALUES (2,5,91.78);
insert into exchange_rates (base_currency_id, target_currency_id, rate) VALUES (3,5,100.7);
insert into exchange_rates (base_currency_id, target_currency_id, rate) VALUES (5,4,4.86);



select e from exchange_rates e join Currencies  c on  c.id = e.base_currency_id join currencies c2 on c2.id = e.target_currency_id where c.id=(select c.id from Currencies c where c.code = 'USD') and c2.id= (select c.id from Currencies c where c.code = 'RUB');

select e from exchange_rates e join Currencies  c on  c.id = e.base_currency_id join Currencies c2 on c2.id = e.target_currency_id where c.id=(select c.id from Currencies c where c.code = 'USD') and c2.id= (select c.id from Currencies c where c.code = 'EUR')