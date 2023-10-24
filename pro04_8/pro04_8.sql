USE haebeop;

-- 교재(교재코드, 교재명, 교재목차, 교재설명, 출판사, 출판일, 저자, 가격, 교재파일, 기타메모)
CREATE TABLE book(bookno INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(200),
fcover VARCHAR(200),
bcover VARCHAR(200),
bpic VARCHAR(200),
blist VARCHAR(2500),
bcoment VARCHAR(2000),
pubcom VARCHAR(50),
pubdate DATE,
author VARCHAR(100),
price INT,
pfile VARCHAR(100),
memo VARCHAR(2000),
amount INT DEFAULT 0,
regdate DATETIME DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM book;

DROP TABLE book;

COMMIT;

CREATE TABLE inventory(ino INT PRIMARY KEY AUTO_INCREMENT,	-- 입고번호
pno INT NOT NULL,	-- 제품번호
ptype INT,	-- 제품종류
title VARCHAR(200),	-- 제품명
cost INT,	-- 원가
amount INT,	-- 수량
regdate DATETIME DEFAULT CURRENT_TIMESTAMP);	-- 등록일

INSERT INTO inventory VALUES (DEFAULT, 1, 1, '해법 예비중학 영어 신입생(2023)', 6000, 10, default);

SELECT * FROM inventory;

CREATE TABLE sales(sno INT PRIMARY KEY AUTO_INCREMENT, -- 결제번호
pno INT NOT NULL,	-- 제품번호
ptype INT,	-- 제품종류
title VARCHAR(200),	-- 구매제품명
price INT,	-- 가격
amount INT,	-- 구매수량
money INT,	-- 결제금액
id VARCHAR(20),	-- 구매자 아이디
stype VARCHAR(50) DEFAULT	'credit',	-- 결제수단
scom VARCHAR(50) DEFAULT 'samsung',		-- 결제해당기관(카드사/은행사)
snum VARCHAR(50) DEFAULT '0000-0000-0000-0000',	-- 결재계좌및카드번호
spass VARCHAR(5) DEFAULT 'nopay',				-- 결제상태
sdate DATETIME DEFAULT CURRENT_TIMESTAMP	-- 결제일
);

INSERT INTO sales VALUES (DEFAULT, 1, 1, '해법 예비중학 영어 신입생(2023)', 10000, 2, 20000, 'kim1004', 'credit', '삼성카드', '457973007124705', 'payok', DEFAULT);

SELECT * FROM sales;

DROP TABLE sales;

CREATE TABLE carry(cno INT PRIMARY KEY AUTO_INCREMENT,	-- 배송번호
sno INT,	-- 결제번호
ctype INT,	-- 배송종류
ccom VARCHAR(50),	-- 배송사
cman VARCHAR(50),	-- 배송담당자
ctel VARCHAR(50),	-- 배송담당자 연락처
ccode VARCHAR(50),	-- 배송코드
cstat INT,	-- 배송상태
id VARCHAR(20),	-- 고객아이디
tel VARCHAR(20),	-- 받는 사람 연락처
addr1 VARCHAR(200),	-- 받는 사람 기본주소
addr2 VARCHAR(200),	-- 받는 사람 상세주소
postcode VARCHAR(20),	-- 우편번호
cmemo VARCHAR(200), -- 배송시 요청사항
psati FLOAT(5, 1),	-- 제품만족도
csati FLOAT(5, 1),	-- 배송만족도
saticom VARCHAR(1000),		-- 기타 하고 싶은 말
sdate DATE,		-- 출발일
edate DATE 		-- 도착일
);


DROP TABLE carry;

DESC member;


-- 과목(과목코드, 과목명, 과목단가)
CREATE TABLE course(cno INT PRIMARY KEY AUTO_INCREMENT, 
cname VARCHAR(200),
cprice INT);

-- 강의(강의코드, 강의명, 강의동영상파일, 과목코드, 교재코드, 강사코드, 수강인원) 
CREATE TABLE lecture(lno INT PRIMARY KEY AUTO_INCREMENT,
lname VARCHAR(200),
lmov VARCHAR(300),
cno INT,
bookno INT, 
lcode INT,
lmt INT DEFAULT 100,
ltime TIME);


-- 수강(수강코드, 강의코드, 학생아이디, 수강총시간, 수강완료여부)
CREATE TABLE study(sno INT PRIMARY KEY AUTO_INCREMENT,
lno INT,
id VARCHAR(20),
total TIME,
complete VARCHAR(5));

-- 강사(강사코드, 강사명, 연락처, 이메일)
CREATE TABLE lector(lcode INT PRIMARY KEY AUTO_INCREMENT,
lname VARCHAR(200),
tel VARCHAR(20),
email VARCHAR(100));


-- 강의배정이란? 
-- 과목, 강사, 교재 정보를 강의 테이블에 등록하는 행위로 
-- 하나의 과목당 여러 강의를 모두 등록해야한다.

-- 수강 신청이란? 강의 정보를 보고, 학생이 수강신청을 하는 행위를 말하며,
-- 학생별로 모든 강의정보가 등록되어야 하며, 만약 수강신청시 수강인원이
-- 초과될 경우 수강신청을 할 수 없다.