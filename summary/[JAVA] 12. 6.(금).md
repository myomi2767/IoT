# 12. 6.(금)

## 1. Application

* java라는 인터프리터를 이용하여 실행하는 방법

## 2. 변수

> 데이터타입_변수명 = 초기화 작업

* 기본형
  * 문자(char)
  * 숫자
    * 정수(byte, short, int, long)
    * 실수(float, double)
  * boolean
* 참조형
  * API에 포함된 클래스
  * 내가 만든 클래스
  * 배열

```java
// 변수의 예시
int i = 100;
boolean b = false;
String str = new String("java");

```

## 3. 기본형 리터럴

## 4. 연산자

## 5. 제어구문

* 순차형

* 선택형

  * 조건문

    > 들여쓰기는 필수!!!!

    * `if`

      ```java
      if(/*조건문(true or false)*/){
          // 조건이 만족할 때 실행할 명령문
      }else{
          
      }
      ```

    * `switch`

* 순환형

  * 반복문

    * `for`

      ```java
      for(int i=1;i<=5;i++){
       // 초기값   조건  증감식
          //반복해서 실행할 명령문
      }
      ```

      

    * `while`

    * `do` - `while`

## 6. 배열

1. 배열의 선언 : `int[] arr;`
2. 배열의 생성 : `myarr = new int[10]`
3. 배열의 초기화 : `myarr[1] = 100;`