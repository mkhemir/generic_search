DROP TABLE IF EXISTS Device;

CREATE TABLE Device (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  categorie VARCHAR(250) NOT NULL,
  code NUMERIC NOT NULL,
  owner VARCHAR(250) DEFAULT NULL
);

INSERT INTO Device (categorie, code, owner) VALUES
  ('Aliko', 40, 'Billionaire Industrialist'),
  ('Bill', 450, 'Billionaire Tech Entrepreneur'),
  ('Will', 870, 'Billionaire Tech DIRECTION'),
  ('Folrunsho', 61, 'Billionaire Oil Magnate');