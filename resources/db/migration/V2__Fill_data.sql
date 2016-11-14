INSERT INTO USER (NAME, LOGIN, PASSWORD, SALT) VALUES
 ('John Doe', 'jdoe', '619a9bcf712dbab1bcca7c382995b3c7','6f9ubuvhvn4o6d80j7pv0hj0ej'), 
 ('Jane Row', 'jrow', '42d4b64eb3135f034136333447cba7','7aigdj7mu7fioqsi7agvtd5jb2');
 
INSERT INTO ROLE (NAME, RESOURCE, USER_ID) VALUES
('READ','a',1), 
('WRITE','a.b',1), 
('EXECUTE','a.b.c',2), 
('EXECUTE','a.bc',1);