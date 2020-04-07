package exam.day03.view.advencedview;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressActivity extends AppCompatActivity {

    // 뷰의 주소 값을 담을 참조 변수
    ProgressBar bar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);

        bar4 = (ProgressBar)findViewById(R.id.progressBar4);
    }

}
