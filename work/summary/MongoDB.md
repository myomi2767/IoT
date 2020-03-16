# MongoDB

> * noSQL
> * 비정형데이터(스키마가 없다)
> * JSON형태
> * 문서기반으로 `join`이 불가

## 용어

* `collection` : 테이블
* `document` : 레코드
* `field` : 컬럼
* `_id` : 기본키

## 1. Collection

> rdbms에서 테이블
>
> 관계형 데이터베이스처럼 스키마를 정의하지 않는다.

### 1) 종류

* `capped collection` : 고정 사이즈 주고 생성하는 컬렉션
  * 미리 저장한 저장공간이 모두 사용이 되면 맨 처음에 저장된 데이터가 삭제되고 공간으로 활용
* `non capped collection` : 일반적인 컬렉션

### 2) collection 관리

* [생성]
  * `db.createCollection("컬렉션명")` -> 일반collection

  * `db.createCollection("컬렉션명",{옵션list})`

    => 각각의 옵션을 설정해서 작업(json)
  
* [삭제]
  
  * `db.컬렉션명.drop()`
  
* [컬렉션명 변경]

  * `db.컬렉션명.renameCollection("변경할컬렉션명")`

## 2. insert

### 1) 구문

```mongodb
db.컬렉션명.insert({데이터...})
db.컬렉션명.insertOne({데이터...})
db.컬렉션명.insertMany({데이터...})
```

* document(관계형 db에서 레코드 레코드개념)에 대한 정보는 json의 형식으로 작성

* mongodb에서 documnet를 삽입하면 자동으로 _id가 생성 - 기본키의 생성

  ```mongodb
  "_id" : ObjectId("5e6ee7dc4711c081ee6500a1")
                    -------------------------
                    현재 timestamp + machine Id + mongodb프로세스id + 순차번호
                    												 --------
                    												 추가될 때마다 증가
  ```

## 3. update

> * document수정
> * 조건을 적용해서 수정하기 위한 코드도 json으로 구현

### 1) update를 위한 명령어

* `$set` : 해당필드의 값을 변경(업데이트를 하기 위한 명령어)
  * none capped collection인 경우 업데이트할 필드가 없는 경우 추가한다.
* `$inc` : 해당필드의 저장된 숫자의 값을 증가
* `$unset` : 원하는 필드를 삭제할 수 있다.
* 업데이트 옵션
  * `multi` => true를 추가하지 않으면 조건에 만족하는 document 중 첫번째 document만 update

### 2) 구문

```mongodb
db.컬렉션명.update({조건필드:값},//sql의 update문 where절
                  {$set:{수정할필드:수정값}},//set절
                  {update와 관련된 옵션:옵션값})
```

## 4. 배열 관리

```mongodb
db.score.update({id:"jang"},{$set:
			{info:
				{city:["서울","안양"],
				 movie:["겨울왕국2","극한직업","쉬리"]
				 }
			}})
```

### 1) 배열에서 사용할 수 있는 명령어

* `$addToSet` : 배열의 요소를 추가

  * 없는 경우에만 값을 추가
  * 중복을 체그

  ```mongodb
  db.score.update({id:"jang"},{$addToSet:{"info.city":"인천"}})
  ```

* `$push` : 배열의 요소를 추가

  * 중복을 허용

  ```mongodb
  db.score.update({id:"jang"},{$push:{"info.city":"천안"}})
  ```

* `$pop` : 배열에서 요소를 제거할 때 사용

  * 1이면 마지막 요소를 제거, -1이면 첫 번째 요소를 제거

  ```mongodb
  db.score.update({id:"jang"},{$pop:{"info.city":1}})
  ```

* `$each` : addToSet이나 push에서 사용할 수 있다.

  * 여러 개를 배열에 추가할 때 사용

  ```mongodb
  db.score.update({id:"jang"},{$push:{"info.city":{$each:["천안","가평","군산"]}}})
  ```

* `$sort` : 정렬(1:오름차순, -1:내림차순)

  ```mongodb
  db.score.update({id:"jang"},{$push:
  		{"info.city":
  				{$each:["천안","가평","군산"],
  				 $sort:1
  				}
  		}})
  ```

* `$pull` : 배열에서 조건에 만족하는 요소를 제거(조건 한 개)

  ```mongodb
  db.score.update({id:"jang"},{$pull:{"info.city":"천안"}})
  ```

* `$pullAll` : 배열에서 조건에 만족하는 요소를 제거(조건을 여러개)

  ```mongodb
  db.score.update({id:"jang"},{$pullAll:{"info.city":["가평","군산"]}})
  ```

  



