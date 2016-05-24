CREATE TABLE utente (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    saldo DOUBLE NOT NULL
);
CREATE TABLE cliente (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    id_utente INTEGER,
    FOREIGN KEY (id_utente) REFERENCES utente(id)
);
CREATE TABLE venditore (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    id_utente INTEGER,
    FOREIGN KEY (id_utente) REFERENCES utente(id)
);
CREATE TABLE oggetto (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(128) NOT NULL,
    url VARCHAR(128) NOT NULL,
    descrizione VARCHAR(128),
    pezzi INT NOT NULL,
    prezzo DOUBLE NOT NULL,
    id_venditore INTEGER,
    FOREIGN KEY (id_venditore) REFERENCES venditore(id)
);