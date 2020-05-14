int pin[] = {A1, A2};
int pin_length = sizeof(pin)/sizeof(int);

void setup() {
  // 아두이노의 입출력판을 초기화
  //pinNide(사용하는 핀 번호, 핀의 용도)
  //핀의 용도 : OUTPUT =>output용 핀, INPUT => input용 핀
  for(int i=0;i<pin_length;i++){
    pinMode(pin[i],OUTPUT);  
  }
}

void loop() {
  //디지털팬의 전압을 LOW, HIGH로 설정 => LOW:0V, HIGH:5V
  for(int i=0;i<pin_length;i++){
    digitalWrite(pin[i],HIGH);
    delay(1000);
    digitalWrite(pin[i],LOW);
    delay(1000);
  }
  
  
  
}
