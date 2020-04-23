# LINUX

> * root => 프롬프트 #
> * 일반계정 => 프롬프트 $

## 디렉토리

* home(홈디렉토리) 
  * 특정 계정으로 로그인 했을 때 자동으로 위치하는 폴더
  * 모든 계정은 홈디렉토리를 갖고 있다.
  * 기본설정은 홈디렉토리명이 계정명과 동일
  * root의 홈디렉토리명 root폴더

## 명령어



* `ifconfig` : ip확인
* `hostnamectl`
* `systemctl` list-units --type=service
* `systemctl` disable firewalld

## 빅데이터플랫폼 구축 설정 순서

### 1. VMware 설치

### 2. 머신생성 - CentOS7

### 3. 머신 복제

> ip확인

### 4. 머신4대 클러스터링

* 방화벽해제

* hostname변경

* DNS설정

  * hosts파일 등록

  * 네트워크 프로레스를 restart

  * 설정확인 - 설정을 성공 완료했는지 확인

  * 4 대에 모두 적용되도록 hadoop01머신에서 hadoop02, hadoop03, hadoop04에 직접 접속

    ```linux
    [원격 서버로 copy]
    scp copy할파일(위치까지 명시) copy받을서버의 위치
    scp 	/etc/hosts	root@hadoop02:/etc/hosts
    ---     ---------   -------------------------
    명령어    copy할파일   target서버의 위치와 파일명
    
    [원격 서버에 실행명령]
    ssh 서버 "실행할명령문"
    	----
    	ip, 도메인
    
    ```

  * 암호화된 통신을 위해서 공개키생성 후 배포