package multi.android.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ExamSecondActivity extends AppCompatActivity {
    String code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_secondview);

        TextView txt = findViewById(R.id.exam_result_txt);
        Button secondbtn = findViewById(R.id.exam_close);
        final CheckBox check = findViewById(R.id.member_state);
        final Intent intent = getIntent();

        String id = intent.getStringExtra("name");
        if(id==null){
            User dto = intent.getParcelableExtra("dto");
            txt.setText(dto.name+","+dto.getTelNum());
        }else{
            String tel = intent.getStringExtra("tel");
            txt.setText("입력한 id:"+id+", 입력한 pass:"+tel);
        }

        code = intent.getStringExtra("code");
        secondbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (code){
                    case "btn":
                        String data = "일반회원설정:";
                        if(check.isChecked()){
                            data = "우수회원설정";
                        }
                        intent.putExtra("second", data);
                        setResult(RESULT_OK,intent);
                        finish();
                }
            }
        });


    }
}
