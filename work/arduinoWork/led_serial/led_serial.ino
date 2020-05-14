int pin[] = {A0, A1, A2};
int pin_length = sizeof(pin)/sizeof(int);
void setup() {
  Serial.begin(9600);
  for(int i=0;i<pin_length;i++){
    pinMode(pin[i],OUTPUT);  
  }
}
//\n을 제외하고 읽기
//readStringUntil('\n')
void loop() {
  //String str = Serial.readStringUntil('\n');
  if(Serial.available()>0){
    char c = Serial.read();
    if(c=='A'){
      char num = Serial.read();
      if(num=='0'){
        digitalWrite(pin[0],HIGH);
        delay(1000);
        digitalWrite(pin[0],LOW);
        delay(1000);
      }else if(num=='1'){
        digitalWrite(pin[1],HIGH);
        delay(1000);
        digitalWrite(pin[1],LOW);
        delay(1000);
      }else if(num=='2'){
        digitalWrite(pin[2],HIGH);
        delay(1000);
        digitalWrite(pin[2],LOW);
        delay(1000);
      }
    }
  }
}
