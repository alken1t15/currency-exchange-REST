create table currencies(
                           id serial primary key,
                           code varchar not null ,
                           full_name varchar not null ,
                           sign varchar not null
);


create table exchangeRates(
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