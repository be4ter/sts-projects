# gmail auth with gsmtp

### 목차
  - [**기술**](#기술)
  - [**준비**](#준비)
  - [**구현**](#구현)
  - [**후기**](#후기)

### 기술
  back-end
    언어/프레임워크 : java/spring boot 2  
    데이터베이스 : AWS RDS (Mysql)  
    WS/WAS : Apache Tomcat  
    서버 : 로컬환경  
    형상관리 : -  
    
   front-end    
    HTML  
[**목차로**](#목차)


### 준비
  1. admin 역할을 부여할 계정의 보안 단계 하락  
    [구글 보안 엑세스](https://support.google.com/accounts/answer/6010255?hl=ko)  
  2. admin 역할을 부여할 계정의 2단계 인증  
    [2단계 인증 사용](https://support.google.com/accounts/answer/185839?co=GENIE.Platform%3DDesktop&hl=ko)  
  3. gmail app password 발급 받기  
    [app password](https://support.google.com/mail/answer/185833?hl=ko)  
    2번째 탭  
[**목차로**](#목차)  

### 구현  
  1. ![로그인 화면](https://user-images.githubusercontent.com/41373848/44618124-f69a1580-a8aa-11e8-9532-042fcd0affe5.png)  
     요구사항에 맞게 회원정보를 입력한다.  
  2. ![회원 가입 실패](https://user-images.githubusercontent.com/41373848/44618139-2ea15880-a8ab-11e8-9c26-f7cabed14a4b.png)  
      회원가입 정보가 일치하지 않으면 exception 내용을 서버에 알리면 실패 페이지로 넘어간다.  
  3. ![회원 가입 성공](https://user-images.githubusercontent.com/41373848/44618152-66100500-a8ab-11e8-9072-1d163920d2b7.png)  
     성공 페이지로 넘어가면 입력했던 email주소로 메일이 발송된다.  
     ![gmail](https://user-images.githubusercontent.com/41373848/44618152-66100500-a8ab-11e8-9072-1d163920d2b7.png)  
     ![contents](https://user-images.githubusercontent.com/41373848/44618153-67d9c880-a8ab-11e8-84f4-2d78d21cc164.png)  
      ![인증 성공](https://user-images.githubusercontent.com/41373848/44618158-77591180-a8ab-11e8-8870-5a60eadfc300.png)  
  4.  위 링크를 누르기 전에 로그인을 하면 아직 db에서는 인증된 회원이 아니기 때문에 로그인 실패 화면을 나타낸다.  
      ![로그인 실패](https://user-images.githubusercontent.com/41373848/44618156-7627e480-a8ab-11e8-8243-161ef45f0349.png)  
  5. ![로그인](https://user-images.githubusercontent.com/41373848/44618159-7aec9880-a8ab-11e8-8a47-b5cb0e9a4ba5.png)  
  6.  ![유저 정보](https://user-images.githubusercontent.com/41373848/44618160-7c1dc580-a8ab-11e8-89ba-8fb41cce27f4.png)    
[**목차로**](#목차)  

### 후기
  내가 원하는 결과물을 얻었다.   
  이런 방법으로 아이디 패스워드를 잊어버렸을때 사용할 수 있을거 같다.
  기능을 개발하고 정리하려고 하니깐 리팩토링 해야할 부분이 너무 많이 눈에 띈다.  
  [**목차로**](#목차)

  
  
  
