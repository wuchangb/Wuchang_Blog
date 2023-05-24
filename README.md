# :bust_in_silhouette: 개인 블로그 프로젝트: WUCHANG BLOG
> 회원가입, 로그인/로그아웃, 글쓰기, 회원정보 수정, 프로필사진 변경 기능의 백엔드 SSR 블로그 프로젝트 입니다.

### 회원가입
---
<p align="center">
<img width="1000" alt="회원가입" src="https://github.com/wuchangb/Wuchang_Blog/assets/104978780/ff26b59c-1dbb-4bf1-93d6-0f1cfe62e5fc">
</p>
<br>

### 로그인
---
<p align="center">
<img width="1000" alt="로그인" src="https://github.com/wuchangb/Wuchang_Blog/assets/104978780/cb89784d-ab6f-4ae0-a771-af6d0cf862a5">
</p>
<br>

### 글쓰기
---
<p align="center">
<img width="1000" alt="글쓰기" src="https://github.com/wuchangb/Wuchang_Blog/assets/104978780/b0180db8-f787-4425-b672-b97d12a0faa0">
</p>
<br>

### 프로필사진경변경
---
<p align="center">
<img width="1000" alt="프로필사진 변경" src="https://github.com/wuchangb/Wuchang_Blog/assets/104978780/a710b4d5-c265-4576-9efa-1f653919c1f5">
</p>
<br>

## :paperclip:개발 기간
2023.04 ~ 2023.05
</br>
</br>

## :computer: 개발 환경
### Languages and Tools
- Language : `java 11`
- Build Tool : `gradle`
- Framework : `spring-boot 2.7.11`
- Database : `mariaDB`
- Storage : `S3`
- CI/CD : `github action`, `code deploy`, `IAM`
- Server : `aws EC2`

## 시스템도구성도
<img width="800" alt="시스템 구성도" src="https://github.com/wuchangb/Wuchang_Blog/assets/104978780/fe376b63-7412-45ba-bebe-38f539eeaed4">
</br>


## 1. 기술스택
- JDK 11
- Springboot 2.X 버전
- JPA
- H2 인메모리 디비 - 방언 MySQL
- JSP
- Security
- AJAX
- JSoup
- 부트스트랩
## 2. 요구사항
> HTTP 메서드를 POST와 GET만 사용한다.
#### 요구사항 1단계
- 회원가입  -완
- 로그인(시큐리티) -완
- 글쓰기(섬머노트) -완
- 게시글 목록보기(Lazy전략 - N+1 -> 복습) (완)
- 게시글 상세보기(데이터 뿌리기) (완)
- 썸네일 등록하기(Jsoup) (완)
#### 요구사항 2단계
- 아이디 중복확인 (완)
- 비밀번호 동일체크 (완)
- 프론트 유효성 검사 (완)
- 백엔드 유효성 검사 (AOP 등록) (완)
- 글로벌 Exception 처리 (완)
- Script 응답 설정 (완)

#### 요구사항 3단계
- 회원 프로필 사진 등록 (완)
- 회원정보 보기 (완)
- 게시글 삭제 (완)
- 회원정보 수정 (완)

#### 요구사항 4단계
- 검색 (완)
- 
#### 요구사항 5단계  (개인 프로젝트)
- 게시글 수정
- 로그인 아이디 기억하기
- 에러 로그 테이블 관리
- Love 테이블 생성
- Reply 테이블 생성
- 연관관계 설정
- 댓글쓰기
- 댓글삭제
- 좋아요 하기
- 좋아요 보기
- 남은 기능 추가하기 (각자 알아서)
-  보완하고 싶은것 추가하기 (각자 알아서)
- jenkins 연동
