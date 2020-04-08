# Android(안드로이드)

## 1. 안드로이드 특징(3.25.)

### 컴포넌트 기반

* **Activity**
* **Service**
* **ContentProvider**
* **BroadCastReceiver**

### 리소스의 외부화

* **문자열 이미지**
* **화면**
* **외부파일**
* **R, java**

## 2. View

* **`layout_width`** : view의 너비
* **`layout_height`** : view의 높이
* **`orientation`** : 배치방향
* **`id`** : 각 위젯을 식별할 수 있는 이름
  * btn
  * txt
* **`margin`** : 주위 여백
* **`padding`** : 내부 컨텐츠와 border사이의 간격
* **`layout_weight`** : 여백을 해당 view의 사이즈로 포함
* **`layout_gravity`** : parent내부에서 view의 정렬
* **`gravity`** : view 내부에서의 정렬

## 3. 사용자정의 Adapter 만들기(4.7.)

* 안드로이드에서 앱을 구성할 때 목록형식을 가장 많이 사용
* 사용자정의로 디자인한 뷰를 목록으로 사용하고 싶은 경우
* 안드로이드 내부에서 제공하는 Adapter로 표현하고 싶은 내용을 모두 표현할 수 없다.(이벤트연결, 각 목록의 구성을 다르게 생성)

### [구성요소]

* Adapter를 이용해서 출력할 데이터를 저장하는 객체(DTO)

* 사용자정의 Adapter

  1. 안드로이드에서 제공하는 Adapter클래스를 상속

     - 리스트뷰를 만들 때 필요한 정보를 저장할 수 있도록 멤버변수 정의

       (Context, row디자인 리소스, 데이터)

  2. 생성자 정의

     - 상속받고 있는 ArrayAdapter의 생성자 호출

  3. ArrayAdapter에 정의되어 있는 메소드를 오버라이딩

     - `getView` : 리스트뷰의 한 항목이 만들어질 때마다 호출

       => 전달된 리소스를 이용해서 뷰를 생성(LayoutInflator)

       => 한 row를 구성하는 뷰를 찾아서 데이터와 연결

  4. getView메소드에서 성능개선을 위한 코드를 작성

     - 한 번 생성한 View를 재사용
     - findViewById는 한번만 찾아오기

  5. `ViewHolder`객체를 생성

     - row를 구성하는 뷰를 한 번 findViewById하기
     - row에 대한 구성 View를 멤버변수로 선언
     - 생성자에서 findViewById처리를 구현
     - 최초로 뷰를 만들때(row에 대한 뷰) 이 객체를 생성해서 활용

  6. row를 구성하는 뷰에 상태값을 저장하기

     - 각 뷰의 이벤트를 통해 저장
     - 각 뷰의 상태값을 저장할 수 있도록 객체
       -  상태값을 저장한 객체를 자료 구조에 저장
       - 

     - 

* Adapter를 통해 만들어진 리스트뷰를 보여줄 액티비티

  * main layout필요

## 4. Intent(4.8.)

### [기본실행]

  1. 인텐트 객체를 생성하고 실행할 액티비티의 정보와 데이터를 셋팅
     - 값 : `putExtra`메소드를 이용
     - 객체
  2. 안드로이드 OS에 인텐트객체넘기며 의뢰
    - `startActivity` : 액티비티 실행
  3. 인텐트에 설정되어 있는 액티비티 호춫
  4. 호출된 액티비티에서는 안드로이드OS가 넘겨준 인텐트를 가져오기
  5. 인텐트에 셋팅된 데이터를 꺼내서 활용



