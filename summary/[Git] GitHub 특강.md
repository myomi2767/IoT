# GitHub 특강

>| 내용                                            | 주소                                                         |
>| ----------------------------------------------- | ------------------------------------------------------------ |
>| 개발자 기술 면접                                | [링크](https://github.com/JaeYeopHan/Interview_Question_for_Beginner) |
>| 주니어 개발자 채용 정보                         | [링크](https://github.com/jojoldu/junior-recruit-scheduler)  |
>| 원격 근무 회사                                  | [링크](https://github.com/milooy/remote-or-flexible-work-company-in-korea) |
>| 좋은 git commit 메시지를 위한 영어 사전         | [링크](https://blog.ull.im/engineering/2019/03/10/logs-on-git.html) |
>| 백엔드 개발자를 꿈꾸는 학생개발자에게           | [링크](https://d2.naver.com/news/3435170)                    |
>| 좋은 git 커밋 메시지를 작성하기 위한 7가지 약속 | [링크](https://meetup.toast.com/posts/106)                   |
>| git 책                                          | [링크](https://git-scm.com/book/ko/v2)                       |
>| 마크다운 이모지                                 | [링크](https://gist.github.com/rxaviers/7360908)             |
>| fontawesome                                     |                                                              |
>|                                                 |                                                              |

## Git

> **DVCS(분산형버전관리시스템)** 

### Git 구성요소

- WD(Working Directory)
- Staging Area
- Commits

## Git status를 통해 정리하기

### CLI 기초 명령어

```bash
# list (파일목록)
$ ls
# change directory(디렉토리 변경)
$ cd
# 빈 파일 생성
$ touch <파일명>
```

### 상황

#### 1. `add`

```bash
$ touch a.txt
$ git status
On branch master

No commits yet
# 트래킹X, 새로 생성된 파일,
Untracked files:
  # 커밋을 하기 위한 곳에 포힘시키려면
  # Staging area로 이동시키려면, git add
  (use "git add <file>..." to include in what will be committed)
        a.txt
# WD O, Staging area X
nothing added to commit but untracked files present (use "git add" to track)
```

```bash
$ git add a.txt
$ git status
On branch master

No commits yet
# 커밋될 변경사항들(staging area O)
Changes to be committed:
  # unstage를 위해서 활용할 명령어(add 취소)
  (use "git rm --cached <file>..." to unstage)
        new file:   a.txt
```

#### 2. `commit`

``` bash
$ git commit -m 'Create a.txt'
[master (root-commit) 7b4b8a3] Create a.txt
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 a.txt
 
$ git status
On branch master
nothing to commit, working tree clean
```

- 커밋내역 확인

  ```bash
  $ git log
  commit 7b4b8a36c27867e236d59b3344e40234756f5635 (HEAD -> master)
  Author: Myomi-Yoo <myomi0618@gmail.com>
  Date:   Thu Apr 23 10:35:51 2020 +0900
  
      Create a.txt
      
  $ git log --oneline
  7b4b8a3 (HEAD -> master) Create a.txt
  ```

  - `git log --oneline` : 한줄로 로그 보기

#### 3. 추가 파일 변경 상태

```bash
$ touch b.txt
$ git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   a.txt

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        b.txt

no changes added to commit (use "git add" and/or "git commit -a")
```

* Untracked 파일은  `git rm --cached <file>`
* 기존 관리되던 파일은 `git restore <file>`

```bash
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   a.txt
        new file:   b.txt
```

#### 4. 커밋 메세지 변경

> **주의!!** 커밋메시지 변경 시 해시값 자체가 변경되어, 이미 원격저장소에 push한 이력에 대해서는 메시지 변경을 하면 안된다.

```bash
$ git commit --amend
```

* `vim`텍스트 편집기가 실행된다.
  * `i` : 편집 모드
  * `esc` : 편집 모드를 종료하고, 명령 모드에서 저장
    * `:wq` : wirte + quit

```bash
$ git commit --amend
[master f8efb54] a.txt 추가
 Date: Thu Apr 23 10:46:49 2020 +0900
 1 file changed, 13 insertions(+)
```

##### 4-1. 특정 파일을 빼놓고 커밋 했을 때

```bash
$ git add <omit_file>
$ git commit --amend
```

* 빠뜨린 파일을 add한 이후에 `commit --amend`를 하면, 해당 파일까지 포함하여 재커밋이 이뤄진다.

#### 5. 작업 내용을 이전 버전으로 되돌리기

- a.k.a 작업하던 내용 버리기

```bash
$ git status
On branch master
Changes not staged for commit:
  # WD변경사항을 버리기 위해서는 restore
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   a.txt

no changes added to commit (use "git add" and/or "git commit -a")
```

```bash
$ git restore a.txt
$ git status
On branch master
nothing to commit, working tree clean
```

#### 6. 특정 파일/폴더 삭제 커밋

> 해당 명령어는 실제 파일이 삭제되는 것은 아니지만, git에서 삭제되었다라는 이력을 남기는 것

```bash
$ git rm --cached b.txt
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        deleted:    b.txt

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        b.txt
# 주의!! 해당 파일이 물리적으로 삭제 된것은 아니다.
```

- 일반적으로는 `.gitignore`와 함께 활용한다.
  1. `.gitignore`에 해당 파일 등록
  2. `git rm --cached`를 통해 삭제 커밋
     - 이렇게 작업을 하면, 실제 파일은 삭제되지 않지만 이후로 git으로 전혀 관리되지 않는다.

## Gitignore(.gitignore)

- git으로 관리하고 싶지 않는 파일을 등록하여 활용할 수 있다.
- 일반적으로 프로젝트 환경(IDE, OS 등)에 관련된 정보나 추가적으로 공개되면 안되는 데이터 파일등을 설정한다.
- 일반 프로젝트 환경에 대한 정보는 우선 [gitignore.io](http://gitignore.io)에서 프로젝트 시작할 때마다 정의하는 습관을 가지자.

```bash
# 특정 파일
secret.csv
# 특정 폴더
idea/
# 특정 확장자
*.csv
# 특정 폴더에서 특정 파일 빼고
!idea/a.txt
```

## 원격 저장소 활용 명령어

1.  `git remote -v` : 원격 저장소 목록 조회
2.  `git remote rm {원격저장소이름}` : 원격 저장소 설정 삭제
3. `git remote add origin {URL}` : 원격 저장소 설정

## Github Pages

### 정적 사이트 생성기(generator)

> .md ==> HTML/CSS, JS

- jekyll(ruby)
  - 오래되고, 자료 많고
- gatsby(js, react + graphql)
  - 최신, 근데 유명해서 자료 많음