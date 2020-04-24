# Git branch

## 1. branch 관련 명령어

> Git 브랜치를 위해 root-commit을 발생시키고 진행하세요.

1. 브랜치 생성

    ```bash
    (master) $ git branch {브랜치명}
    ```

2. 브랜치 이동

    ```bash
    (master) $ git checkout {브랜치명}
    ```

3. 브랜치 생성 및 이동

    ```bash
    (master) $ git checkout -b {브랜치명}
    ```

4. 브랜치 삭제

    ```bash
    (master) $ git branch -d {브랜치명}
    ```

5. 브랜치 목록

    ```bash
    (master) $ git branch
    ```

6. 브랜치 병합

    ```bash
    (master) $ git merge {브랜치명}
    ```

	* master 브랜치에서 {브랜치명}을 병합

## 2. branch 병합 시나리오

> branch 관련된 명령어는 간단하다.
>
> 다양한 시나리오 속에서 어떤 상황인지 파악하고 자유롭게 활용할 수 있어야 한다.

### 상황 1. fast-foward

> fast-foward는 feature 브랜치 생성된 이후 master 브랜치에 변경 사항이 없는 상황

1. feature/test branch 생성 및 이동

   ```bash
   $ git checkout -b feature/test
   Switched to a new branch 'feature/test'
   ```

2. 작업 완료 후 commit

   ```bash
   (feature/test)$ touch test.txt
   $ git add .
   $ git commit -m 'Complete test'
   ```


3. master 이동

   ```bash
   (feature/test)$ git checkout master
   Switched to branch 'master'
   (master)$
   ```


4. master에 병합

   ```bash
   $ git merge feature/test
   Updating a639300..c4bb878
   Fast-forward
    test.txt | 0
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 test.txt
   ```


5. 결과 -> fast-foward (단순히 HEAD를 이동)

   ```bash
   $ git log --oneline
   c4bb878 (HEAD -> master, feature/test) Complete test
   a639300 Complete menu
   cc6c4d7 Init
   ```

6. branch 삭제

   ```bash
   $ git branch -d feature/test
   Deleted branch feature/test (was c4bb878).
   ```

   

---

### 상황 2. merge commit

> 서로 다른 이력(commit)을 병합(merge)하는 과정에서 **다른 파일이 수정**되어 있는 상황
>
> git이 auto merging을 진행하고, **commit이 발생된다.**

1. feature/signout branch 생성 및 이동

   ```bash
   $ git checkout -b feature/signout
   Switched to a new branch 'feature/signout'
   ```

2. 작업 완료 후 commit

   ```bash
   $ touch signout.txt
   $ git add .
   $ git commit -m 'Complete signout'
   [feature/signout ea1cd55] Complete signout
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 signout.txt
   ```

3. master 이동

   ```bash
   $ git checkout master
   Switched to branch 'master'
   ```

4. *master에 추가 commit 이 발생시키기!!*

   * **다른 파일을 수정 혹은 생성하세요!**

   * ```bash
     $ touch hotfix.txt
     $ git add .
     $ git commit -m 'Hotfix'
     ```

5. master에 병합

   ```bash
   (master) $git merge feature/signout
   Merge made by the 'recursive' strategy.
    signout.txt | 0
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 signout.txt
   ```

6. 결과 -> 자동으로 *merge commit 발생*

   * vim 편집기 화면이 나타납니다.
   
   * 자동으로 작성된 커밋 메시지를 확인하고, `esc`를 누른 후 `:wq`를 입력하여 저장 및 종료를 합니다.
      * `w` : write
      * `q` : quit
      
   * 커밋이  확인 해봅시다.
   
      ```bash
      $ git log --oneline
      6e98c02 (HEAD -> master) Merge branch 'feature/signout'
      f70b91b Hotfix
      ea1cd55 (feature/signout) Complete signout
      c4bb878 Complete test
      a639300 Complete menu
      cc6c4d7 Init
      ```
   
7. 그래프 확인하기

   ```bash
   $ git log --oneline --graph
   *   6e98c02 (HEAD -> master) Merge branch 'feature/signout'
   |\
   | * ea1cd55 (feature/signout) Complete signout
   * | f70b91b Hotfix
   |/
   * c4bb878 Complete test
   * a639300 Complete menu
   * cc6c4d7 Init
   ```

8. branch 삭제

   ```bash
   $ git branch -d feature/signout
   Deleted branch feature/signout (was ea1cd55).
   ```

---

### 상황 3. merge commit 충돌

> 서로 다른 이력(commit)을 병합(merge)하는 과정에서 **같은 파일의 동일한 부분이 수정**되어 있는 상황
>
> git이 auto merging을 하지 못하고, 충돌 메시지가 뜬다.
>
> 해당 파일의 위치에 표준형식에 따라 표시 해준다.
>
> 원하는 형태의 코드로 직접 수정을 하고 직접 commit을 발생 시켜야 한다.

1. feature/board branch 생성 및 이동

   ```bash
   $ git checkout -b feature/board
   Switched to a new branch 'feature/board'
   ```

2. 작업 완료 후 commit

   ```bash
   $ touch board.txt
   # README파일 변경
   $ git add .
   $ git commit -m 'Complete board & update README.md'
   [feature/board dbc8355] Complete board & update README.md
    2 files changed, 3 insertions(+)
    create mode 100644 board.txt
   ```


3. master 이동

   ```bash
   $ git checkout master
   Switched to branch 'master'
   ```


4. *master에 추가 commit 이 발생시키기!!*

   * **동일 파일을 수정 혹은 생성하세요!**
   
  ```bash
     # README 수정
     $ git add .
     $ git commit -m 'Update README.md'
     ```
   
5. master에 병합

   ```bash
   $ git merge feature/board
   Auto-merging README.md
   CONFLICT (content): Merge conflict in README.md
   Automatic merge failed; fix conflicts and then commit the result.
   ```


6. 결과 -> *merge conflict발생*

   > git status 명령어로 충돌 파일을 확인할 수 있음.
   
   ```bash
   student@M150111 MINGW64 ~/Desktop/branch (master|MERGING)
   $ git status
   On branch master
   You have unmerged paths.
     (fix conflicts and run "git commit")
     (use "git merge --abort" to abort the merge)
   
   Changes to be committed:
           new file:   board.txt
   ## Unmerged path가 가르키는 파일이 충돌난 파일
   Unmerged paths:
     (use "git add <file>..." to mark resolution)
           both modified:   README.md
   ```


7. 충돌 확인 및 해결

   - 해당 파일 원하는 대로 수정
   
     ```
     <<<<<<< HEAD
     * 마스터 작업
     =============
     * 보드 작업
     >>>>>>> feature/board
     ```
   
   - 수정 완료 후 add


8. merge commit 진행

    ```bash
    $ git commit
    ```

   * vim 편집기 화면이 나타납니다.
   
   * 자동으로 작성된 커밋 메시지를 확인하고, `esc`를 누른 후 `:wq`를 입력하여 저장 및 종료를 합니다.
      * `w` : write
      * `q` : quit
      
   * 커밋이  확인 해봅시다.
   
9. 그래프 확인하기

    ```bash
   $ git log --oneline --graph
   *   70b8cf2 (HEAD -> master) Merge branch 'feature/board'
   |\
   | * dbc8355 (feature/board) Complete board & update README.md
   * | d568ee0 Update README.md
   |/
   *   6e98c02 Merge branch 'feature/signout'
   |\
   | * ea1cd55 Complete signout
   * | f70b91b Hotfix
   |/
   * c4bb878 Complete test
   * a639300 Complete menu
   * cc6c4d7 Init
    ```


10. branch 삭제

    ```bash
    $ git branch -d feature/board
    Deleted branch feature/board (was dbc8355).
    ```

# Git Stash

> 작업 내역을 임시 저장 할 수 있음.

## 기본 명령어

```bash
# 1. stash 공간에 작업내역 저장
$ git stash
Saved working directory and index state WIP on master

# 2. stash list 보기
$ git stash list
stash@{0}: WIP on master: a8cd8e9 Init

# 3. 임시 공간 내용 가져오기
$ git stash pop
```

## 예시

- 로컬에서 작업하고 있던 중, `pull` 을 받아서 원격 저장소에 새로운 내용을 반영 해야 하는 경우

```bash
$ git pull origin master
From https://github.com/edutak/big-iot-1001
 * branch            master     -> FETCH_HEAD
error: Your local changes to the following files woule:
        README.md
# 1. 커밋하거나 => 버전으로 남겨도 되는 경우
# 2. stash => 작업 중일 때
Please commit your changes or stash them before you merge
Aborting
Updating a8cd8e9..00d69a4
```

- 해결 방법

  ```bash
  $ git stash
  $ git pull origin master
  From https://github.com/edutak/big-iot-1001
   * branch            master     -> FETCH_HEAD
  Updating a8cd8e9..00d69a4
  Fast-forward
   README.md | 112 ++++++++++++++++++++++++++++++++++++--
   1 file changed, 104 insertions(+), 8 deletions(-)
  # 만약 동일 파일 수정이 있으면, conflict를 발생시킨다.
  $ git stash pop
  Auto-merging README.md
  CONFLICT (content): Merge conflict in README.md
  The stash entry is kept in case you need it again.
  ```

# Reset vs revert

## 1. reset

- 특정 버전으로 되돌아가는 작업

  ```
  $ git reset {커밋해시코드}
  ```

  - `reset` 명령어의 결과는 다음과 같다.

    ```
    $ git log --oneline
    275a7e2 ddd
    00d69a4 (origin/master) Update README.md
    $ git reset 00d69a4
    $ git log --oneline
    00d69a4 (origin/master) Update README.md
    ```

  - `reset` 옵션

    - 기본 : 이전 이력의 변경 사항을 WD에 보관
    - `--hard` : 이전 이력의 변경 사항은 모두 삭제. **주의**

## 2. revert

- 특정 시점을 되돌렸다는 커밋을 발생 시킴.

  ```
  $ git log --oneline
  275a7e2 ddd
  00d69a4 (origin/master) Update README.md
  $ git revert 275a7e2
  $ git log --oneline
  bca6426 (HEAD -> master) Revert "ddd"
  275a7e2 ddd
  00d69a4 (origin/master) Update README.md
  ```

