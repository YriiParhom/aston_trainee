CREATE TABLE customer
(
    id      bigserial primary key,
    name    varchar(100) not null,
    surname varchar(100) not null
);

CREATE TABLE orders
(
    id          bigserial primary key,
    name        varchar(100) not null,
    price       decimal(8, 2),
    date        date not null ,
    customer_id int not null ,
    foreign key (customer_id) references customer
);

CREATE TABLE promo
(
    id          bigserial primary key,
    name        varchar(100) not null,
    description varchar(255) not null

);

CREATE TABLE customer_promo
(
    customer_id int not null,
    promo_id    int not null,
    primary key (customer_id, promo_id),
    foreign key (customer_id) references customer,
    foreign key (promo_id) references promo
);
