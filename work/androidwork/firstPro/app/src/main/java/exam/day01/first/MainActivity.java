package exam.day01.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
//Activity의 LifeCycle
public class MainActivity extends AppCompatActivity {
    //Activity가 생성될때 자동으로 호출
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //System.out.println("oncreate호출");
        Log.d("test", "onCreate()호출");
        setContentView(R.layout.activity_main);
    }
    public void myclickOk(View v){
        Toast.makeText(this,"확인버튼이 눌렸습니다.",Toast.LENGTH_LONG).show();
    }
    public void myclickNOk(View v){
        Toast.makeText(this,"취소버튼이 눌렸습니다.",Toast.LENGTH_SHORT).show();
    }
    public void myclickDelte(View v){
        Toast.makeText(this,"삭제버튼이 눌렸습니다.",Toast.LENGTH_LONG).show();
    }
}
