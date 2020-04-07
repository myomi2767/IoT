package exam.day03.view.advencedview;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeekBarActivity extends AppCompatActivity {

    // 뷰의 주소 값을 담을 참조변수
    SeekBar seek1, seek2;
    TextView text1, text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_main);

        seek1 = (SeekBar)findViewById(R.id.seekBar);
        seek2 = (SeekBar)findViewById(R.id.seekBar2);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

        SeekBarListener listener = new SeekBarListener();
       
    }

   
}









