## 헬스장 관리 프로그램

## 관리자
1. pt계획
2. 식단 내용 확인 
3. 전체회원 확인 기능(pt받는 사람 pt 안받는 사람 구분)

## 사용자
1. 출석확인
2. 식단 내용 게시
3. 질문사항 게시판

## 현재까지의 상황
MySQL과의 연동과 기본적인 세팅이 끝났고 로그인 시스템은 아직 만들어지지 않은상태입니다.
그래도 이제 충분히 기능 개발가능한 상태입니다. 기본적으로 강사님 세팅을 따라한게 많으니 참고바랍니다.
mybatis-config.xml보시면 아시겠지만 비밀번호 aA123456으로 설정되어있습니다.
workbench만드실때 비밀번호 똑같이 만드셔야되고 healthProject로 생성해주셔야합니다. 아이디는 root
이걸 똑같이 만들지 않으시면 저희 github 올리고 내릴때마다 각자 컴퓨터에 맞게 또 바꿔야하기때문에 세팅을 똑같이 해주는게 좋을것같습니다. 그리고 저번에 말씀드린것처럼 master브랜치는 건드시면 안됩니다.

mysql
CREATE TABLE `healthproject`. `member` (
   `memNo` int NOT NULL AUTO_INCREMENT,
   `memId` varchar(45) NOT NULL COMMENT '아이디',
   `memPw` varchar(60) NOT NULL COMMENT '비밀번호',
   `memNm` varchar(45) NOT NULL COMMENT '회원명',
   `email` varchar(60) DEFAULT NULL COMMENT '이메일',
   `mobile` varchar(11) DEFAULT NULL COMMENT '휴대전화',
   `regDt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `modDt` datetime DEFAULT NULL,
   PRIMARY KEY (`memNo`),
   UNIQUE KEY `memId_UNIQUE` (`memId`)
 );
 
 
 혹시라도 실행중에 원인모를 오류가 생기거나 왜 있는지 모르겠는 파일을 발견시 조장(성우석)한테 물어봐주세요.
 <%@> <-- 이게 오류나거나 apache <-- 오류가 생길경우 build path의 문제일가능성이 큽니다.
 
 MemberMapper에 register update delete를 만들어놨습니다. MemberTest에서 실행하셔서 workbench에 연동되는지까지 확인하시면되겠습니다. 
 