#ggplot2패키지에서 제공되는 mpg데이터를 분석
#### step1. mpg를 dataframe로 변경 ####
mpg <- as.data.frame(mpg)
#### step2. mpg의 정보를 출력 ####
# 행 갯수, 열의 갯수, 위에서 10개, 끝에서 10개 출력
nrow(mpg)
ncol(mpg)
dim(mpg)
head(mpg, 10)
tail(mpg, 10)
#### step3. mpg의 컬럼명을 변경 ####
# cty => city, hwy => highway
library("dplyr")
mpg <- rename(mpg, city=cty)
mpg <- rename(mpg, highway=hwy)
mpg
#### step4. 파생변수 생성하기 ####
# total컬럼을 추가 => cty와 hwy의 합
# avg컬럼을 추가 => cty와 hwy의 평균
mpg$total <- mpg$city+mpg$highway
mpg$avg <- mpg$total/2
mpg
#### step5. 생성된 total을 가지고 요약정보 확인 #### 
summary(mpg$total)
#### step6. info컬럼 추가 ####
# total값을 이용해서 평가 - 30이상이면 pass, fail
mpg[,"info"] <- ifelse(test = mpg$total>=30,
                       yes = "pass",
                       no = "fail")
mpg
#### step7. grade컬럼 추가 ####
# total값을 이용해서 평가 - 40이상이면 A, 35이상이면 B, 30이상이면 C, 나머지 D
mpg[,"info2"] <- ifelse(test = mpg$total>=40,
                       yes = "A",
                       no = ifelse(test = mpg$total>=35,
                                   yes = "B",
                                   no = ifelse(test = mpg$total>=30,
                                               yes = "C",
                                               no = "D")))
mpg












