CREATE TABLE MEMBER(
	MID VARCHAR(50) PRIMARY KEY,
	MPW VARCHAR(20) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	ROLE VARCHAR(10) NOT NULL
);

INSERT INTO MEMBER VALUES('admin','1234','������','ADMIN');

SELECT * FROM BOARD;