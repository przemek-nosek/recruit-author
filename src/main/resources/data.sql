INSERT INTO categories (id, category_name)
values (1, 'SCI-FI'),
       (2, 'COMEDY'),
       (3, 'HORROR'),
       (4, 'ROMANCE');

INSERT INTO books (id, isbn, title, category_id)
values (1, '44fa', 'Za oknem', 1),
       (2, 'gdcx', 'Behind the walls', 2),
       (3, '51vz', 'Bananowy chlopiec', 3),
       (4, 'faghj', 'Szklanki', 3),
       (5, '1gdg', 'Delikwent', 1),
       (6, 'dfhd3', 'Master', 2),
       (7, 'fd5s', 'Teacher', 4);

INSERT INTO authors (id, first_name, last_name)
values (1, 'Przemek', 'Nosek'),
       (2, 'Remigiusz', 'Mroz'),
       (3, 'Tom', 'Henks'),
       (4, 'Jeff', 'Sos'),
       (5, 'Andrew', 'Drew'),
       (6, 'Thomas', 'Philipson'),
       (7, 'John', 'White');

INSERT INTO authors_books(author_id, book_id)
values (1, 1),
       (2, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 4),
       (5, 5),
       (6, 6),
       (7, 7);


