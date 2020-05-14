int myarr[2] = {10,10};
//mynumarr배열을 선언하고 10,20,30,40,50의 값을 할당
//int를 리턴하는 sumArray함수를 정의
//sumArray함수는 배열을 매개변수로 받는다.
//매개변수로 전달된 배열의 합을 리턴하는 함수
//loop에서는 배열을 전달하며 sumArray호출해서 결과 출력하기
int mynumarr[5] = {10,20,30,40,50};
int mynumarr_length = sizeof(mynumarr)/sizeof(int);
void setup() {
  Serial.begin(9600);
}

void loop() {
  sum(100,200);
  delay(2000);
//  int result = sum2(100,200);
//  Serial.print("결과:");
//  Serial.println(result);
  int result = sumArray(mynumarr);
  Serial.println(result);
}
void sum(int num1, int num2){
  int result = num1+num2;
  //Serial.println(result);
  return;
}

int sum2(int num1, int num2){
  int result = num1+num2;
  return result;
}

int sumArray(int mynumarr[5]){
  int result;
  for(int i=0;i<mynumarr_length;i++){
    result += mynumarr[i];
  }
  return result;
}
