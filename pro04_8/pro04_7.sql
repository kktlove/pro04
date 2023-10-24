SHOW TABLES;

-- 자료파일(attach) - UUID, UploadPath, filename, filetype, bno

CREATE TABLE attach(uuid VARCHAR(100),
uploadpath VARCHAR(100),
filename VARCHAR(200),
filetype VARCHAR(10) DEFAULT 'txt' COMMENT '파일 확장자',
bno INT);

DESC attach;

SELECT * FROM attach;

CREATE TABLE fileboard(num INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(200),
	content VARCHAR(2000),
	author VARCHAR(20),
	ip VARCHAR(100),
	readcount INT DEFAULT 0,
	regdate DATETIME DEFAULT CURRENT_TIMESTAMP,
	reref INT DEFAULT 0,
	rerev INT DEFAULT 0,
	reseq INT DEFAULT 0
);

insert into fileboard values (DEFAULT, '테스트1', '테스트1내용', 'ADMIN', '127.0.0.1', default, default, default, default, DEFAULT);

SELECT * FROM fileboard;