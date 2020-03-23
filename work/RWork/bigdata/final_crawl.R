######모두의 광장의 1페이지 : 10페이지의 모든 게시글 크롤링#####
# 1. 모든페이지의 title, hit, url,content 추출하기
# 2. crawl_result.csv, crawl_result.RData저장
# 3. mongodb저장 (300개 저장)
# 4. for, if문을 활용
library("stringr")
library("mongolite")
con <- mongo(collection = "final",
             db = "bigdata",
             url = "mongodb://127.0.0.1")

#0번 부터 9번 페이지까지 반복 작업
final_data_list = NULL
for (i in 0:9) {
  #페이지마다 연결할 주소가 달라지므로 변수로 처리
  url <- paste0("https://www.clien.net/service/group/community?&od=T31&po=",i)
  url_data <- readLines(url,encoding = "UTF-8")
  url_data
  ##title 추출
  final_filter_data <- url_data[str_detect(url_data,"subject_fixed")]
  title <- str_extract(final_filter_data,"(?<=\">).*(?=</span>)")
  title
  ##hit 추출
  hit_data <- url_data[str_detect(url_data,"<span class=\"hit\">")]
  hit <- str_extract(hit_data,"(?<=\">).*(?=</span>)")[-1]
  t(t(hit))
  ##url 추출
  myurl <- url_data[(which(str_detect(url_data,"subject_fixed"))-3)]
  url_val <- str_extract(myurl,"(?<=href=\").*(?=data-role)")
  url_val <- str_sub(url_val,end = -3)
  url_val <- paste0("http://www.clien.net",url_val)
  url_val
  
  ####### url을 이용해서 content항목 추출
  contentlist = NULL #최초 변수 선언시 null로 초기화
  for (page in 1:length(url_val)) {
    contentdata <- readLines(url_val[page], encoding = "UTF-8")
    contentdata
    
    start = which(str_detect(contentdata,"post_content"))
    end = which(str_detect(contentdata,"post_ccls"))
    
    content_filter_data <- contentdata[start:end]
    content_filter_data <- paste(content_filter_data,collapse = "")
    content_filter_data <- gsub("<.*?>","",content_filter_data)
    content_filter_data <- gsub("\t|&nbsp;","",content_filter_data)
    #기존에 저장되어 있는 contentlist의 내용에 추가
    contentlist <- c(contentlist,content_filter_data)
    cat("\n",page)
  }
  final_data <- cbind(title,hit,url_val,contentlist)
  final_data_list <- rbind(final_data_list,final_data)
  cat("\n",i)
}


####csv파일로 생성####

final_data
write.csv(final_data_list,"final_data.csv")
save(final_data_list,file = "final_data.RData")

####mongodb에 저장하기####
if(con$count()>0){
  con$drop()
}
##mongodb에 데이터를 저장하기 위해서 dataframe으로 변환
final_mongo_data <- data.frame(final_data_list)
con$insert(final_data_list)

