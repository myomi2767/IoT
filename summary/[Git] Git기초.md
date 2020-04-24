# Git

> Git은 분산형버전관리시스템(DVCS)이다.
>
> 소스코드 형상 관리 도구로써, 작성되는 코드의 이력을 관리한다.

## 0. 기본설정

아래의 설정은 이력 작성자(author)를 설정하는 것으로, 컴퓨터에서 최초에 한번만 설정하면 된다.

```bash
$ git config --global user.name edutak <<<본인 github 계정
$ git config --global user.email e@gmail.com << 본인 github 가입 이메일로 변경
```

## 1. 로컬 저장소(repository) 활용

### 1. 저장소 초기화

```bash
$ git init
Initialized empty Git repository in C:/Users/student/Desktop/TiL/.git/
(master) $
```

* (master) 는 현재 있는 브랜치 위치를 뜻하며, .git 폴더가 생성된다.
* 해당 폴더를 삭제하게 되면 모든 .git과 관련된 이력이 삭제된다.

### 2. `add`

이력을 확정하기 위해서는 `add` 명령어를 통하여 staging area 에 `stage` 시킨다.

```bash
$ git add .                # 현재 디렉토리를 stage
$ git add README.md		   # 특정 파일을 stage
$ git add images/		   # 특정 폴더를 stage
```



`add`를 한 이후에는 항상 `status` 명령어를 통해 원하는 대로 되었는지 확인한다.

```bash
$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   git.md
        new file:   "images/\354\235\264\353\257\270\354\247\200.jpg"
        new file:   markdown.md

```



###  3. `commit`

`git`은 `commit`을 통해 이력을 남긴다. 커밋 시에는 항상 메시지를 통해 해당 이력의 정보를 나타내야 한다.

```bash
$ git commit -m 'Init'
[master (root-commit) 9ef8df6] Init
 3 files changed, 91 insertions(+)
 create mode 100644 git.md
 create mode 100644 "images/\354\235\264\353\257\270\354\247\200.jpg"
 create mode 100644 markdown.md

```

커밋 목록은 아래의 명령어를 통해 확인 가능하다.

```bash
$ git log
commit 9ef8df622ba6e5b37ea03b0768d49c496c668146 (HEAD -> master)
Author: Myomi-Yoo <myomi0618@gmail.com>
Date:   Thu Dec 5 16:52:55 2019 +0900

    Init

```

## 2. 원격 저장소(remote repository) 활용

> 원격 저장소는 다양한 서비스를 통해 제공 받을 수 있다.
>
> github, gitlab, bitbucket

### 1. 원격 저장소 등록

```bash
$ git remote add origin https~
```

원격 저장소(remote)를 origin이라는 이름으로 해당 url로 설정한다.

등록된 원격 저장소는 아래의 명령어로 확인할 수 있다.

등록은 한번만 실행하면 된다.

```bash
$ git remote -v
origin  https://github.com/Myomi-Yoo/TIL.git (fetch)
origin  https://github.com/Myomi-Yoo/TIL.git (push)
```

### 2. 원격 저장소 push

```bash
$ git push origin master
Enumerating objects: 9, done.
Counting objects: 100% (9/9), done.
Delta compression using up to 4 threads
Compressing objects: 100% (7/7), done.
Writing objects: 100% (9/9), 81.77 KiB | 13.63 MiB/s, done.
Total 9 (delta 0), reused 0 (delta 0)
To https://github.com/Myomi-Yoo/TIL.git
 * [new branch]      master -> master
Branch 'master' set up to track remote branch 'master' from 'origin'.

```

origin 원격 저장소에 `push`하게 되며, github에서 확인할 수 있다.

이후 작업과정에서는 `add`->`commit`으로 이력을 남기고 `push`로 업로드 하면 된다.