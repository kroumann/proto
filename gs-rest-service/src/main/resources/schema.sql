-- schema.sql
use protodb;
-- get_constraints_drop
-- alter table sales_orders drop foreign key fk_session_sales_order ;

-- get_permissions_drop

-- get_view_drop

SET FOREIGN_KEY_CHECKS=0;
-- get_schema_drop
drop table if exists category;
drop table if exists users;
drop table if exists authority;
drop table if exists user_authority;
drop table if exists product_images;
drop table if exists product_groups;
drop table if exists products;
drop table if exists order_items;
drop table if exists roles;
drop table if exists user_roles;
drop table if exists categories;

drop table if exists tags;
drop table if exists sales_orders;
drop table if exists coupons;
drop table if exists product_tags;
drop table if exists cc_transactions;
drop table if exists sessions;
drop table if exists product_statuses;
drop table if exists product_categories;
drop table if exists order_products;

-- get_smallpackage_pre_sql

-- get_schema_create
create table users (
   id             int(11) NOT NULL AUTO_INCREMENT      ,
   username      varchar(255)             not null     ,
   password      varchar(255)             not null     ,
   first_name    varchar(255)             not null     ,
   last_name     varchar(255)             not null     ,
   email         varchar(255)             not null     ,
   phone_number  varchar(255)             not null     ,
   enabled      bool                      default true,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint uk_users unique key (id, username, email)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table authority (
   id          int(11) NOT NULL AUTO_INCREMENT,
   name        varchar(255)             not null,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_roles primary key (id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table user_authority (
   user_id       integer                  not null,
   authority_id  integer                  not null,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_user_authority primary key (user_id, authority_id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table categories (
   id          int(11) NOT NULL AUTO_INCREMENT,
   name        varchar(255)             not null,
   description  text                            ,
   imagepath   varchar(255)                     ,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_categories primary key (id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table products (
   id                int(11) NOT NULL AUTO_INCREMENT        ,
   sku               varchar(255)             not null      ,
   name              varchar(255)             not null      ,
   description       text                                   ,
   product_status_id integer                  not null      ,
   regular_price     numeric                   default 0    ,
   discount_price    numeric                   default 0    ,
   quantity          integer                   default 0    ,
   taxable           bool                      default false,
   imagepath         text                                   ,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_products primary key (id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table tags (
   id          int(11) NOT NULL AUTO_INCREMENT,
   name        varchar(255)             not null,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_tags primary key (id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table sales_orders (
   id          int(11)   NOT NULL AUTO_INCREMENT,
   order_date  date                     not null,
   total       numeric                  not null,
   coupon_id   integer                          ,
   session_id  varchar(255)             not null,
   user_id     integer                  not null,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_sales_orders primary key (id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table coupons (
   id          int(11) NOT NULL AUTO_INCREMENT        ,
   code        varchar(255)             not null      ,
   description text                                   ,
   active      bool                      default true ,
   value       numeric                                ,
   multiple    bool                      default false,
   start_date  timestamp default current_timestamp    ,
   end_date    timestamp default current_timestamp    ,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_coupons primary key (id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table product_tags (
   product_id  integer                  not null,
   tag_id      integer                  not null,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_product_tags primary key (product_id,tag_id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table cc_transactions (
   id                 int(11) NOT NULL AUTO_INCREMENT  ,
   code               varchar(255)                     ,
   order_id           integer                  not null,
   transdate          timestamp default current_timestamp,
   processor          varchar(255)             not null,
   processor_trans_id varchar(255)             not null,
   amount             numeric                  not null,
   cc_num             varchar(255)                     ,
   cc_type            varchar(255)                     ,
   response           text                             ,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_cc_transactions primary key (id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table sessions (
   id          varchar(255)             not null,
   data        text                             ,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_sessions primary key (id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table product_statuses (
   id          serial                   not null,
   name        varchar(255)             not null,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_product_statuses primary key (id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table product_categories (
   category_id integer                  not null,
   product_id  integer                  not null,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_product_categories primary key (category_id,product_id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;
create table order_products (
   id          int(11) NOT NULL AUTO_INCREMENT  ,
   order_id    integer                          ,
   sku         varchar(255)             not null,
   name        varchar(255)             not null,
   description text                             ,
   price       numeric                  not null,
   quantity    integer                  not null,
   subtotal    numeric                  not null,
   updated_at  timestamp default current_timestamp on update current_timestamp,
   constraint pk_order_products primary key (id)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- get_view_create

-- get_permissions_create

-- get_inserts

-- get_smallpackage_post_sql

-- get_associations_create
alter table sales_orders add constraint fk_session_sales_order
    foreign key (session_id)
    references sessions (id) ;

