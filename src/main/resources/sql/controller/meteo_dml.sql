INSERT INTO user (id_user, username, first_name, last_name, lang) VALUES
    (1, 'TotoDu62', 'Tanguy', 'Ozano', 'fr'),
    (2, 'Tozano', 'Tanguy', 'Ozano', 'fr');

INSERT INTO selection (id_selection, location_surname, city_name, state_code, country_code, lon, lat, min_max_temp, humidity, pressure, cloud, id_user) VALUES
    (1, 'Test 1', null, null, null,  23, 45, false, false, false, false, 1),
    (2, 'Test 2', null, null, null,  49, 3, false, false, false, false, 1),
    (3, 'Maison', null, null, null,  50.418391, 3.177521, false, false, false, false, 2),
    (4, 'Ecole', 'Arras', null, null,  50.418391, 3.177521, false, false, false, false, 2),
    (5, 'Boulot', 'Lille', null, null,  50.418391, 3.177521, false, false, false, false, 2);
