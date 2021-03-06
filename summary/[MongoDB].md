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


## 5. find

```mongodb
db.컬렉션명.find(조건, 조회할 필드에 대한 명시)
```

 * `db.컬렉션명.find({})`와 동일 : {}안에 아무것도 없으면 전체 데이터 조회

 * 조건, 조회할 필드에 대한 명시 모두 json

 * 조회할 필드의 정보 명시
   * 형식:{필드명:1..} : 화면에 표시하고 싶은 필드
   * ​         {필드명:0} : 명시한 필드가 조회되지 않도록 처리

### 1) 조건

* `$lt: <`
* `$gt: >`
* `$lte: <=`
* `$gte: >=`

> ex) addr이 인천인 데이터 : id, name, dept, addr
>
> ```mongodb
> db.score.find({addr:"인천"},{id:1,name:1,dept:1,addr:1})
> db.score.find({addr:"인천"},{id:1,name:1,dept:1,addr:1,_id:0})
> ```
>
> ex) score 컬렉션에서 java가 90점 이상인 document조회(id, name, dept, java만 출력)
>
> ```mongodb
> db.score.find({java:{$gte:90}},{id:1,name:1,dept:1,java:1,_id:0})
> ```

* `$or` : 여러 필드를 이용해서 같이 비교 가능
* `$and` : and연산
* `$in` : 하나의 필드에서만 비교
* `$nin` : not in, $in으로 정의한 조건을 제외한 document를 조회


>ex) dept가 인사이거나 addr이 인천인 데이터 조회
>
>```mongodb
>db.score.find({$or:[{dept:"인사"},{addr:"인천"}]})
>```
>
>ex) id가 song, kang, hong인 데이터 조회
>
>```mongodb
>db.score.find({$or:[{id:"song"},{id:"kang"},{id:"hong"}]})
>db.score.find({id:{$in:["song","hong","kang"]}})
>```
>
>ex) id가 song, kang, hong이 아닌 데이터 조회
>
>```mongodb
>db.score.find({id:{$nin:["song","hong","kang"]}})
>```

### 2) 조회메소드

* `findOne()` : 첫 번째 document만 리턴
* `find()` : 모든 document리턴
* `count()` : 행의 갯수를 리턴
* `sort({필드명:sort옵션})` : 정렬
  * 1 => 오름차순
  * -1 => 내림차순
* `limit(숫자)` : 숫자만큼의 document만 조회
* `skip(숫자)` :  숫자만큼의 document를 skip하고 조회

### 3)  정규표현식을 적용

```mongodb
db.컬렉션명.find({조건필드명:/정규표현식/옵션})
```

* 기호
  * `|` : or
  * `^` : ^뒤의 문자로 시작하는지 체크
  * `[]` : 영문자 하나는 한 글자를 의미하고 []로 묶으면 여러글자를 표현
    * [a-i] : a에서 i까지의 모든 영문자
* 옵션
  * `i` : 대소문자 구분없이 조회 가능

>ex) id가 kim과 park인 document조회
>
>```mongodb
>db.score.find({id:/kim|park/})
>db.score.find({id:/kim|park/i})
>```
>
>ex) id가 k로 시작하는 document조회
>
>```mongodb
>db.score.find({id:/^k/})
>```
>
>ex) [a-i]까지 영문이 있는 id를 조회
>
>```mongodb
>db.score.find({id:/[a-i]/})
>```
>
>ex) id가 k-p로 시작하는 document 조회
>
>```mongodb
>db.score.find({id:/^[k-p]/})
>```
>
>ex) id에 a와 i가 있는 document조회
>
>```mongodb
>db.score.find({id:/[ai]/})
>```

## 6. mongodb에 저장된 데이터 삭제하기 - remove()

> 조건을 정의하는 방법은 find()나 update()와 동일

```mongodb
db.score.remove({servlet:{$lt:80}})
```

## 7. Agreegation

> * group by와 동일개념
>
> * 간단한 집계를 구하는 경우 mapreduce를 적용하는 것보다 간단하게 작업
>
> * Pipeline을 내부에서 구현
>   * 한 연산의 결과가 또 다른 연산의 input데이터로 활용
>   * https://docs.mongodb.com/v3.6/aggregation/#aggregation-pipeline 그림참조

### 1) 명령어(RDBMS와 비교)

* `$match` : where절, having절

  ```mongodb
  $match:{필드명:{연산자:조건값}}
                -------------
                  비교연산 or 조건이 여러개
  ```

* `$group` : group by

  ```mongodb
  $group:{_id:그룹으로 표시할 필드명, 연산결과를 저장할 필드명:{연산함수: 값}}
  															  ---
                                                                 숫자나 필드 참조
  ```

* `$sort` : order by

* `$avg` : avg그룹함수

* `$sum` : sum그룹함수

* `$max` : max그룹함수

#### (1) 형식

```mongodb
db.컬렉션명.aggregate(aggregate명령어를 정의)
                    --------------------
                     여러가지를 적용해야 하는 경우 배열
```

> ex)  addr별 인원수
>
> ```mongodb
> db.exam.aggregate([{$group:{_id:"$addr",num:{$sum:1}}}])
> ```
>
> ex)dept별 인원수
>
> ```mongodb
> db.exam.aggregate([{$group:{_id:"$dept",num:{$sum:1}}}])
> ```
>
> ex)dept별 java점수의 평균 단, addr이 인천인 데이터만 작업 $match를 추가
>
> ```mongodb
> db.exam.aggregate([{$match:{addr:"인천"}},
> 				   {$group:{_id:"$dept",평균:{$avg:"$java"}}
> 				  }])
> ```
>
> ex)addr별 servlet합계
>
> ```mongodb
> db.exam.aggregate([{$group:{_id:"$addr",서블릿합계:{$sum:"$servlet"}}}])
> ```
>
> 