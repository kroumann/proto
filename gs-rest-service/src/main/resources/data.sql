-- data.sql

-- the password hash is generated by BCrypt Calculator Generator(https://www.dailycred.com/article/bcrypt-calculator)
INSERT INTO users (id, username, password, first_name, last_name, email, phone_number, enabled, updated_at) VALUES (1, 'user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'mamady', 'kroum', 'user@example.com', '+1234567890', true, FROM_UNIXTIME(1515753818));
INSERT INTO users (id, username, password, first_name, last_name, email, phone_number, enabled, updated_at) VALUES (2, 'admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'sory', 'kroum', 'admin@example.com', '+0987654321', true, FROM_UNIXTIME(1518259418));

INSERT INTO AUTHORITY (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (id, name) VALUES (2, 'ROLE_EMPL');
INSERT INTO AUTHORITY (id, name) VALUES (3, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 3);


--categories table insertion
-- INSERT INTO categories(name, description, imageurl) VALUES ("Téléphones", "Téléphones portables haut de gamme", "https://gdurl.com/Rv11");
-- INSERT INTO categories(name, description, imageurl) VALUES ("Tablettes", "Tablettes les plus recherchées sur le marché, appareils hauts de gamme", "https://gdurl.com/nRRN");
-- INSERT INTO categories(name, description, imageurl) VALUES ("Services et Reparations", "Services proposés par notre centre agrée par les plus grands fabricants du monde.", "https://gdurl.com/PwJM");
-- INSERT INTO categories(name, description, imageurl) VALUES ("Imprimantes et Consommables", "Imprimantes multifonctions et consommables associés", "https://gdurl.com/pgWP");
-- INSERT INTO categories(name, description, imageurl) VALUES ("Composants", "Composants matériels pour mise à niveau et amélioration de performances de vos ordinateurs.", "https://gdurl.com/krU5");
-- INSERT INTO categories(name, description, imageurl) VALUES ("Écrans ou moniteurs d\'ordinateurs", "Écrans de PC bureautiques pour tous les goûts (jeux, développement, design...)", "https://gdurl.com/OHfy");
-- INSERT INTO categories(name, description, imageurl) VALUES ("Les mini ordinateurs", "PC avec un budget sur mesure et entièrement adapter à vos besoins", "https://gdurl.com/NedR");
-- INSERT INTO categories(name, description, imageurl) VALUES ("Logiciels et Outils", "Logiciels et outils pour faciliter vos travaux de développement et études", "https://gdurl.com/hlB9");
-- INSERT INTO categories(name, description, imageurl) VALUES ("Ordinateurs Portables", "Ordinateurs portables pré-configurer pour toutes sortes d\'utilisation", "https://gdurl.com/jwbQ");
-- INSERT INTO categories(name, description, imageurl) VALUES ("Ordinateurs Bureautiques", "Catégories des Ordinateurs bureautiques pour les entreprises et utilisateurs en quête de puissance", "https://gdurl.com/dnOg");
-- INSERT INTO categories(name, description, imageurl) VALUES ("Télévisions", "TV et Smart TV dernière génération de toutes les tailles et de resolutions", "https://gdurl.com/qivw");
