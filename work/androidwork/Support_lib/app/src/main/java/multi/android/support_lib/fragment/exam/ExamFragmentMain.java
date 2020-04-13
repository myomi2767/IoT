package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
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
        setContentView(R.layout.activity_view_pager_main);

        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("first");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("second");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("third");
            }
        });
    }
    public void setFragment(String name){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (name){
            case "first":
                transaction.replace(R.id.container,firstFragment);
                break;
            case "second":
                transaction.replace(R.id.container,secondFragment);
                break;
            case "third":
                transaction.replace(R.id.container,thirdFragment);
                break;
        }
        transaction.commit();
    }
}
