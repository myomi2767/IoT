package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//이벤트가 발생시킬 소스 객체가 있는 액티비티에서 이벤트를 처리하는 작업도같이 할 수 있도록 구현
//1. 이벤트에 반응하는(미리 정해져 있다.) 클래스를 상속받는다
//2, 메소드를 오버라이팅한다.
//  ex) 버튼을 클릭함.
//      실행할 리스터 => View.OnclickListener의 onClick메소드가 호출
public class scroll_imageview_exam01 extends AppCompatActivity implements View.OnClickListener{
    ImageView firstView;
    ImageView secondView;
    Button btnfirst;
    Button btnsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_imageview_exam01);
        //layout에 디자인한 imageView와 Button 객체를 받아오기
        firstView = findViewById(R.id.imgexam01);
        secondView = findViewById(R.id.imgexam02);
        btnfirst = findViewById(R.id.btnup);
        btnsecond = findViewById(R.id.btndown);
        //setOnClickListener라는 메소드를 이용해서 이벤트소스에 이벤트가 발생했을 때 처리할 기능이
        // 구현된 리스너객체가 어떤 것인지 등록
        btnfirst.setOnClickListener(this);
        btnsecond.setOnClickListener(this);
    }
    //onClick메소드를 호출하는 이벤트 소스객체는 다양
    //매개변수에 전달되는 View는 이벤트를 발생시킨 소스객체
    @Override
    public void onClick(View v) {
        Log.d("myevent", "이벤트가 발생되었습니다. - 이벤트 처리합니다.");
        if(v.getId()==R.id.btnup){
            imageUp();
        }else if(v.getId()==R.id.btndown){
            imageDown();
        }
    }
    public void imageDown(){
        //ImageView에 이미지리소스를 추가
        secondView.setImageResource(R.drawable.beach);
        firstView.setImageResource(0); //이미지 없애기
        //setImageResource메소드를 이용해서 이미지를 변경했다고 하더라도
        //화면이 갱신이 자동으로 되지 않기 때문에 변경되지 않습니다.
        //애니메이션을 적용하는 경우는 바로바로 반영이 되어야 하므로 화면을 갱신해야 한다.
        secondView.invalidate();
        firstView.invalidate();
    }
    public void imageUp(){
        //ImageView에 이미지리소스를 추가
        secondView.setImageResource(0);
        firstView.setImageResource(R.drawable.beach); //이미지 없애기
        //setImageResource메소드를 이용해서 이미지를 변경했다고 하더라도
        //화면이 갱신이 자동으로 되지 않기 때문에 변경되지 않습니다.
        //애니메이션을 적용하는 경우는 바로바로 반영이 되어야 하므로 화면을 갱신해야 한다.
        secondView.invalidate();
        firstView.invalidate();
    }

    /* public void clickUp(View v){
        setImg();
    }
    public void clickDown(View v){
        setImg();
    }
    public void setImg(){
        if(index==0){
            imgexam01.setVisibility(View.VISIBLE);
            imgexam02.setVisibility(View.INVISIBLE);
            index = 1;
        }else if(index==1){
            imgexam01.setVisibility(View.INVISIBLE);
            imgexam02.setVisibility(View.VISIBLE);
            index = 0;
        }
    }
*/
}
