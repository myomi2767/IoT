# flume

> 데이터를 추출하기 위해 사용되는 프로그램
>
> 시스템로그, 웹서버의 로그, 클릭로그, 보안로그.. 비정형 데이터를 HDFS에 적재하기 위해 사용하는 프로그램
>
> 대규모의 로그데이터가 발생하면 효율적으로 수집하고 저장하기위해 관리
>
> * flume, chukwa, scribe, fluented, splunk

## 설정

1. 다운로드(압축풀기)
2. .bashrc에 설정 정보 등록

3. flume-env.sh rename하고 정보등록
   * jdk홈디렉토리
   * hadoop홈디렉토리
4. flume설정 파일
   * flume-conf.properties.template을 rename해서 XXXX.properties
   * flume agent의 source, channel, sink에 대한 정보를 등록



## 구성요소

> flume의 실행 중인 프로세스를 agent라 부르며 source, channel, sink로 구성

1. source

   > 데이터가 유이보디는 지정(어떤 방식으로 데이터가 유임되는지 type으로 명시)

   `agent명.sources.source명.type=값`

   * type

     * `netcat` : telnet을 통해서 터미널로 들어오는 입력데이터

       ​				 (bind: 접속IP, port: 접속할 port)

     * `spoolDir` : 특정 폴더에 저장된 파일

       ​				 (spoolDir : 폴더명)

2. channel

   > 데이터를 보관하는 곳(source와 sink사이븨 Queue)

3. sink

   > 데이터를 내보내는 곳(어떤 방식으로 내보낼지 정의)

   * type

     * `logger` : flume서버 콘솔에 출력이 전달

       * flume을 실행할 때 `-Dflume.root.logger=INFO,console`을 추가

     * `file_roll` : file을 읽어서 가져오는 경우

       ​					(directory : 읽어온 파일을 저장할 output폴더를 명시)



## 실행방법

> apache-flume-1.6.0-bin]$ ./bin/flume-ng agent --conf conf --conf-file ./conf/console.properties --name myConsole -Dflume.root.logger=INFO,console
>
> ------------------------------------------------------------------------1
>
> source가 telnet으로 입력하는 데이터인 경우

* 실행명령어: `./bin/flume-ng agent`
* 옵션
  * `--conf` : 설정파일이 저장된 폴더명(-c)
  * `--conf-file` : 설정파일명(-f)
  * `--name` : agent의 이름(-n)
  * `-Dflume.root.logger=INFO.console` : flume의 로그창에 기록