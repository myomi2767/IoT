# jQuery

## 1. DOM

* 선택자
* DOM관련 메소드

## 2. Ajax

## 3. Effect

## 4. jQuery UI

- jquery.com접속하기

# Servlet

> 서블릿은 클라이언트 페이지에서 발생하는 클라이언트의 요청을 처리하기 위한 기술
>
> 클라이언트로부터 요청이 전달되면 서버에서 실행되며 DB연동이나 서버의 자원을 액세스하여 만들어진 결과를 클라이언트로 응답한다.
>
> 클라이언트의 요청을 인식하고 실행되도록 하기 위해서는 서블릿은 정해진 규칙대로 작성이 되어야 하고 서버가 서블릿을 찾아서 실행할 수 있도록 **<u>정해진 위치</u>**에 작성되어야 한다.
>
> ​																	  ㄴ 표준화된 폴더 구조안에 있는 classes폴더(서브릿디렉토리)
>
> 

## ① Servlet 작성규칙

1. 표준화 된 폴더 구조 안에서 서블릿 디렉토리에 저장되어야 된다.

   * classes폴더

   * `C:\IoT\work\webwork\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps \serverweb\WEB-INF\classes`에 작성되어야 한다.

     => 이 위체 서블릿 클래스가 없으면 못 찾는다.

2. public클래스로 작성해야 한다.

   > * 서버가 찾아서 실행해야 하므로 

3. 서블릿클래스를 상속해야 한다.

   > * 서버가 우리가 작성한 서블릿 클래스를 찾아서 생성하고 호출하기 위해서는 서버가 인식할 수 있는(서버가 사용할 수 있는) 타입어야 하므로 서버에 등록된 타입으로 서블릿 클래스를 작성한다.
   >
   > Servlet(인터페이스)
   >
   > ​			^
   >
   > ​			|
   >
   > ​	GenericServlet		----------------- 일반적인 내용을 담고 있는 서블릿
   >
   > ​			^
   >
   > ​			|
   >
   > ​	HttpServlet 			 ----------------- http프로토콜에 특화된 내용을 담고 있는 서블릿
   >
   > ​			^
   >
   > ​			|
   >
   > ​	MyServlet				 ----------------- 내가 하고 싶은 일을 담고 있는 서블릿(개발자가 만드는 서블릿)

   ​	

4.  서버가 호출하는 메소드를 오버라이딩 해야 한다.

   > * 서블릿 클래스는 일반 클래스를 사용하는 방법처럼 객체생성해서 사용하는 클래스가 아니다.
   >
   > * 서블릿이 호출되면 서버가 서블릿 객체를 생성하고 적절한 시점에 따라 메소드를 자동으로 호출한다. 즉, 서블릿의 **<u>Lifecycle</u>**을 서버가 관리한다.
   >
   >   ​						ㄴ 객체를 생성하고 소멸하는 것
   >
   > * 서버가 적절한 시점에 따라 자동으로 메소드를 호출할 때 원하는 작업을 처리하기 위해서는 서버가 호출하는 메소드를 오버라이딩해서 내가 원하는 내용을 기술해야 한다.

   * [오버라이딩할 메소드]

     * `init` : 서블릿이 초기화될때 호출

     * `service` : 클라이언트가 요청을 하면 호출되는 메소드

       ​				=> 클라이언트의 요청을 처리할 수 있는 내용을 기술

       ​					(ex) 로그인,  게시판목록보기, 회원가입....) 

     * `doGet` : `service`와 동일하게 동작하며 클라이언트가 **get방식**으로 요청하는 경우에만 호출

     * `doPost` : `service`와 동일하게 동작하며 클라이언트가 **post방식**으로 요청하는 경우에만 호출

     * `destroy` : 서블릿 객체가 소멸될 때 (메모리에서 해제될 때) 호출

5. 서블릿을 등록

   > * 서버가 서블릿을 찾아서 실행할 수 있도록 서블릿을 <u>**web.xml**</u>에 등록
   >
   >   ​																							ㄴ 서블릿에 대한 내용을 등록하는 설정파일

   1)  서블릿 등록

   ​	=> 사용할 서블릿이 어떤 클래스인지 정의

   ```xml
   <servlet>
     		<servlet-name>서블릿의 이름(alias)</servlet-name>
    		<servlet-class>실제 사용할 서블릿 클래스(패키지포함)</servlet-class>
   </servlet>
   ```

   ​	ex) basic패키지에 작성한 FirstServlet을 first라는 이름으로 등록

   ```xml
   <servlet>
     		<servlet-name>first</servlet-name>
    		<servlet-class>basic.FirstServlet</servlet-class>
   </servlet>
   ```

   

   2) 서블릿매핑

   ​	=> 서블릿을 어떤 url로 요청할지 등록

   ```xml
   <servlet-mapping>
   		<servlet-name>미리등록한 서블릿의 이름</servlet-name>
     		<url-pattern>요청url(반드시 /나 .으로 시작)</url-pattern>
   </servlet-mapping>
   ```

   ​	ex) 위에서 등록한 first서블릿을 /first.multi로 요청

   ```xml
   <servlet-mapping>
     		<servlet-name>first</servlet-name>
     		<url-pattern>/first.multi</url-pattern>
   </servlet-mapping>
   ```

## ② Servlet 요청 방법

1.  get방식으로 요청

   1) 주소표시줄에 입력하고 요청

   ​	=> 테스트용으로 사용

   ```html
   http://70.12.115.63:8088/serverweb/first.multi
                        ---------- ------------
                        server.xml    	web.xml에 등록한
   					에 등록한 path   	요청 path
   					보통은 context명  	<url-pattern>에 등록
   ```

   ex) GuGuServlet작성하기

   ​		=> 콘솔에 7단 출력하기

   ​			서블릿명 : gugu

   ​			요청url : /gugu.html

   ​			FirstServlet과 동일한 방법으로 요청하고 .java와 실행화면캡쳐 제출

   2) 하이퍼링크를 클릭

   ```html
   <a href="http://서버ip:port/contextpath/서블릿url">하이퍼링크</a>
   <a href="/contextpath/서블릿url">하이퍼링크</a> 
   ```

   3) `<form>`태크에서 method속성을 "get"으로 설정하고 submit버튼 선택

   ​	=> action속성에 설정한다.

   ​	=> form태그를 정의하면서 method속성을 생략하면 get방식으로 요청

   ```html
   <form method="get" action="/contextpath/서블릿요청url">
       <input type="submit" value="전송"/>
   </form>
   ```

   

2. post방식으로 요청


## ③ 클라이언트가 전달하는 요청 메시지에서 클라이언트의 입력 정보 추출하기

1.  요청

   [요청객체]

   ServletRequest

   ​			^

   ​			|

   HttpServletRequest

   > 클라이언트가 요청 메시지를 서버로 전달하면 여러 가지 클라이언트의 정보가(클라이언트가 입력한 데이터, 쿠키, 세션정보, 클라이언트의 ip, port....) 서버로 전달된다.
   >
   > 서버는 이 데이터를 가지고 요청객체(요청객체를 만들면서 전달받은 데이터를 요청객체에 셋팅하는 작업을 수행한다.)를 생성한다.
   >
   > http프로토콜에 특화된 내용은 => HttpServletRequest에서 찾는다.
   >
   > 일반적인 내용 => ServletRequest
   
2.   요청정보 추출

    ```html
    ~~~~/serverweb/login.do?id=lee&pass=1234
    						-- ---
    				  파라미터명  파라미터value
    ```

    1.  getParameter

        > ServletRequest의 메소드로 메소드를 호출하며 전달한 name에 대한 value를 리턴
        >
        > 리턴값 : String으로 <u>**파라미터의 값**</u>
        >
        > ​									ㄴ 주소표지술에 직접 넘긴 value =의 오른쪽에 있는 문자열 
        >
        > ​										 form태그를 이용해서 사용자가 직접 입력한 값
        >
        > 매개변수 : String으로 <u>**파라미터 이름**</u>
        >
        > ​										ㄴ 주소표시줄에 직접 넘긴 name으로 =의 왼쪽에 있는 문자열
        >
        > ​											  양식태그를 정의할 때 name속성에 정의한 값
        >
        > ```html
        > 					<input type="text" name="id">
        > 											 --- 파라미터 명
        > ```
        >
        > 

    2.  getParameterValues

        > ServletRequest의 메소드로 파라미터명이 같은 모든 value를 모아서 String[]로 리턴
        >
        > * CheckBox, List에서 복수 개 선택, 임의로 동일한 이름을 정의해서 넘긴 데이터
        > * 리턴타입 : String[]로 파라미터의 값들
        > * 매개변수 : String으로 파라미터명을 정의

## ④ DB연동



