m1 <- matrix(c(80,90,70,100,80,99,78,72,90,78,82,78,99,89,78,90),ncol=4,byrow = T)
m1
colnames(m1) <- c("국어", "영어", "과학", "수학")
rownames(m1) <- c("kim","lee","hong","jang")
m1 #? mean
avg_name <- c(mean(m1[1,]),mean(m1[2,]),mean(m1[3,]),mean(m1[4,]))
avg_name
avg_subject <- c(mean(m1[,1]),mean(m1[,2]),mean(m1[,3]),mean(m1[,4])) 
avg_subject
