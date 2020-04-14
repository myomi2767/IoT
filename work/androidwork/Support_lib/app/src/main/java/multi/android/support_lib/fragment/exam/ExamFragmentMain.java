package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;

public class ExamFragmentMain extends AppCompatActivity {
    ExamFirstFragment firstFragment = new ExamFirstFragment();
    ExamSecondFragment secondFragment = new ExamSecondFragment();
    ExamThirdFragment thirdFragment = new ExamThirdFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear02);

    }
    public void btn_click(View view){
        setFragment(view.getTag().toString());
    }

    public void setFragment(String idx){
        Log.d("fragment",idx);
        FragmentManager fragmentManager = getSupportFragmentManager();
        //프래그먼트의 변화를 관리하는 객체
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (idx){
            case "0":
                transaction.replace(R.id.container,firstFragment);
                break;
            case "1":
                transaction.replace(R.id.container,secondFragment);
                break;
            case "2":
                transaction.replace(R.id.container,thirdFragment);
                break;
        }
        transaction.commit();
    }
}
