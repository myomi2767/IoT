install.packages("mongolite")
library("stringr")
library("mongolite")

url <-"https://www.clien.net/service/group/community"
url_data <- readLines(url,encoding = "UTF-8")
url_data
#정보확인===========================
#class(url_data)
#length(url_data)
#head(url_data)
#tail(url_data)
#===================================
url_data[200]
#조건에 만족하는 데이터를 필터링
#문자열에 패턴을 적용해서 일치여부를 T/F로 리턴

####데이터 필터링:title####
#1. str_detect(패턴을 검사할 문자열, 패턴)을 이용해서 웹페이지 전체에서 필요한 데이터만 먼저 추출
filter_data <- url_data[str_detect(url_data,"subject_fixed")]

#2. 추출한 데이터 전체에서 내가 필요한 문자열만 추출
#str_extract -> 패턴에 일치하는 문자열을 리턴
#후방,전방 탐색 정규 표현식
title <- str_extract(filter_data,"(?<=\">).*(?=</span>)")
title

####데이터 필터링:hit####
hit_data <- url_data[str_detect(url_data,"<span class=\"hit\">")]
hit_data
hit <- str_extract(hit_data,"(?<=\">).*(?=</span>)")
t(t(hit))

####데이터 필터링:url####
myurl <- url_data[(which(str_detect(url_data,"subject_fixed"))-3)]
myurl
url_val <- str_extract(myurl,"(?<=href=\").*(?=data-role)")
url_val
#필요없는 문자열을 잘라내기 - end = 3 : 뒤에서 3개 잘라내기
url_val <- str_sub(url_val,end = -3)
url_val
? str_sub
url_val <- paste0("http://www.clien.net",url_val)
url_val

####csv파일로 생성####
final_data <- cbind(title,hit,url_val)
final_data
write.csv(final_data,"crawl_data.csv")
