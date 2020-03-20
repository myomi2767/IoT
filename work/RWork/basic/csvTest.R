#csv는 기본 패키지로 사용가능
#csv를 읽기
mdf  <-  read.csv("csv_exam.csv")
mdf
mdf[2,]
#dataframe에서 조건에 만족하는 데이터를 조회
m <-matrix(1:20,ncol = 4)
m
d <- data.frame(m)
d
myresult <- d[d$X3>=13,]
myresult
#조건에 만족하는 데이터를 result.csv로 저장
write.csv(myresult,file = "result.csv")

#csv.exam.csv를 읽어서 데이터를 수정한 후 csv_exam_result.csv로 저장하기
# - science가 80이상인 데이터를 추출
# - 추출된 데이터에 mytotal과 myavg컬럼을 추가
# - mytotal : 모든 과목의 총점
# - myavg : 모든 과목의 평균

csvresult <- mdf[mdf$science>=80,]
csvresult$mytotal <- c(sum(csvresult[1,3:5]),sum(csvresult[2,3:5]),sum(csvresult[3,3:5]),sum(csvresult[4,3:5]))
csvresult
avg <- c(csvresult$mytotal/3)
csvresult$myavg <- avg
csvresult
write.csv(csvresult,file = "csv_exam_result.csv")
