CREATE DATABASE haebeop;

USE haebeop;

CREATE TABLE test(num INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(100) NOT NULL);

INSERT INTO test VALUES (DEFAULT, '테스트제목1');
INSERT INTO test VALUES (DEFAULT, '테스트제목2');
INSERT INTO test VALUES (DEFAULT, '테스트제목3');
INSERT INTO test VALUES (DEFAULT, '테스트제목4');
INSERT INTO test VALUES (DEFAULT, '테스트제목5');

SELECT * from test;

COMMIT;

DESC test;

-- 회원(아이디,비밀번호,이름,이메일,전화번호,주소1,주소2,우편번호,가입일,
-- 생년월일,회원포인트,방문횟수)
CREATE TABLE member(
    id VARCHAR(20) PRIMARY KEY, pw VARCHAR(350) NOT NULL,
    name VARCHAR(50) NOT NULL, email VARCHAR(150),
    tel VARCHAR(20), addr1 VARCHAR(200),
    addr2 VARCHAR(200), postcode VARCHAR(20),
    regdate DATETIME DEFAULT CURRENT_TIME,
	 birth DATE DEFAULT CURRENT_DATE,
    pt INT DEFAULT 0,
    visited INT DEFAULT 0
);

-- 핵심 기능 : 공지사항, 자료실, 회원, 자유게시판, 강의별 댓글, 교재와 시범강의
-- 부가 기능 : 파일업로드, 채팅 및 쪽지, 타계정 또는 SNS로 로그인, 수강평, 달력,
-- 가입시 축하 이메일 보내기, 비밀번호 변경시 이메일 보내기, 온라인 평가,
-- 진도관리, 학습 스케줄러, 나의 강의실 등

-- 공지사항(순번, 제목, 내용, 작성일, 읽은횟수)

-- 자료실(순번, 제목, 내용, 자료파일1, 자료파일2, 자료파일3, 작성일, 작성자, 읽은 횟수)

-- 과목(과목코드, 과목명, 과목단가)

-- 강의(강의코드, 강의명, 강의동영상파일, 과목코드, 교재코드, 강사코드, 수강인원) 

-- 수강(수강코드, 강의코드, 학생아이디, 수강총시간, 수강완료여부)

-- 강사(강사코드, 강사명, 연락처, 이메일)

-- 교재(교재코드, 교재명, 교재목차, 출판사, 출판일, 저자, 가격, 교재파일, 기타메모)

-- 강의배정이란? 
-- 과목, 강사, 교재 정보를 강의 테이블에 등록하는 행위로 
-- 하나의 과목당 여러 강의를 모두 등록해야한다.

-- 수강 신청이란? 강의 정보를 보고, 학생이 수강신청을 하는 행위를 말하며,
-- 학생별로 모든 강의정보가 등록되어야 하며, 만약 수강신청시 수강인원이
-- 초과될 경우 수강신청을 할 수 없다.


