INSERT INTO utente(id, username, password, saldo)
    VALUES 
        (default, 'cliente','cliente',50.0),
        (default, 'venditore','venditore',250.0),
        (default, 'rana88','rana88',50.0),
        (default, 'ser72','ser72',250.0),
        (default, 'pollo00','pollo00',50.0);
INSERT INTO cliente(id, id_utente) VALUES (default, 1),(default, 3),(default, 4);
INSERT INTO venditore(id, id_utente) VALUES (default, 2),(default, 5);
INSERT INTO oggetto(id, nome, url, descrizione, pezzi, prezzo, id_venditore)
    VALUES
        (default, 'Paraurti anteriore Fiat 500', 'img/img_1.png', 'paraurti molto bello', 1, 100.0, 2),
        (default, 'Cera per auto Arexons', 'img/img_2.png', 'cera molto bella', 1, 22.50, 1),
        (default, 'Fanali anteriori Citroen C3', 'img/img_3.png', 'fanali molto belli', 1, 200.0, 1),
        (default, 'Marmitta sportiva Giulietta', 'img/img_4.png', 'marmitta molto bella', 1, 180.0, 1),        
        (default, 'Fanali posteriori Golf 6', 'img/img_5.png', 'fanali molto belli', 1, 280.0, 2);
        
