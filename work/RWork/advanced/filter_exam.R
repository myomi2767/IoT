mpg
nrow(mpg)
mpg %>% 
  group_by(class) %>% 
  summarise(avg_city = mean(city))

mpg %>% 
  group_by(class) %>% 
  summarise(avg_city = mean(city)) %>% 
  arrange(desc(avg_city))

mpg %>% 
  group_by(manufacturer) %>% 
  summarise(avg_hwy = mean(highway)) %>% 
  arrange(desc(avg_hwy)) %>% 
  head(3)

mpg %>% 
  filter(class=="compact") %>% 
  group_by(manufacturer) %>% 
  summarise(num = n())
