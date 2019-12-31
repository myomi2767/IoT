# 12. 30.(월) & 12. 31.(화)

## 1. Web

> 전반적으로 모든 것을 알고 있어야 한다.

### Client단 

* html
* CSS
* javascript
* jQuery

### WAS(Web Application Server)

* Tomcat
* Web logic
* JEUS

### 서버기술 Application

* php
* Servlet&jsp

## 2. Web 요청 방식

```
http://127.0.0.1:8088/context명/요청할web application
----  ---------  ----  -------
프로     웹서버    port   기본context는 생략(root)
토콜     ip       ㄴ(web의 기본port 80은 생략가능)
```

## 3. Context

> 정적, 표준화된 폴더를 가지고 있다.

* jsp, html, js, css, image
* `WEB-INF`
  * `web.xml` : 설정파일
  * `lib` : 라이브러리
  * `classes` : 자파파일, 서블릿, DAO, DTO, 로직

### 4. 서버인식위치

> C:\IoT\work\webwork\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\clientweb\WEB-INF