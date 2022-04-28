CREATE TABLE employee (
  id BIGSERIAL PRIMARY KEY,
  name varchar(255) not null,
  salary INTEGER not null,
  birthday date
);

-- INSERT INTO employee VALUES("Alexandre Pinto",1200,"2001-07-22");
-- INSERT INTO employee VALUES("João Almeida",7750,"1997-04-27");
-- INSERT INTO employee VALUES("Cristiano Ronaldo",950500,"1985-02-05");