# Board_Project

#### 게시판 CRUD를 구현하는 프로젝트
- Framework: SpringBoot 2.7.2
- Build Tool: Gradle
- ORM: JPA
- database: MYSQL
- Template Engine: Thymeleaf
- IDE : Intellij

---

게시판 프로젝트를 하며 제작 과정과 고민, 문제점, 개선 과정을 블로깅한다.
- [velog](https://velog.io/@serendipity-dev?tag=%EA%B2%8C%EC%8B%9C%ED%8C%90)

#### 2022.08.14 ~ 

---

### 구현 기능 목록
- 회원 기능
    - 회원가입
    	- 아이디, 패스워드, 이름, 나이
    - 로그인
    	- 아이디, 패스워드
- 게시판 기능
    - 게시판 기능은 **게시글 조회와 상세 조회를 제외**하고 모두 **로그인한 유저만 가능**
    - 게시글 등록
    	- 유저가 제목, 내용 작성
    - 게시글 조회
    	- 번호, 제목, 작성자(아이디), 작성 날짜
    - 게시글 상세 조회
    	- 제목, 작성자(아이디), 내용, 작성 날짜
    - 게시글 내용 수정
    - 게시글 삭제

#### 로그인 기능 구현 방법 및 추가 기능 구현
- **로그인은 세션을 사용**해 간단하게 구현할 것이다.
- 사용자의 **로그인 인증 체크는 스프링 인터셉터**를 사용해 구현할 것이다.
- 추가적인 기능은 나중에 구현할 예정이다.
    - 예시
    	- 해당 게시글 작성자만 수정, 삭제 가능
       - 게시글 제목 검색 필터
       - 댓글 기능
