package multi.android.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExamFirstActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int SECOND_EXAM=1;
    public static final int OBJECT_INTENT=11;
    Button btn;
    Button btn2;
    EditText name;
    EditText tel;
    TextView firstTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstexam);
        btn = findViewById(R.id.Button01);
        btn2 = findViewById(R.id.Button02);
        name = findViewById(R.id.EditText01);
        tel = findViewById(R.id.EditText02);
        firstTxt = findViewById(R.id.first_return);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //액티비티를 호출하면서 인텐트에 객체를 공유
                Intent intent = new Intent(ExamFirstActivity.this,ExamSecondActivity.class);
                User dto = new User(name.getText().toString(),tel.getText().toString());
                intent.putExtra("dto",dto);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onClick(View v) {
        //명시적 intent
        Intent intent = new Intent(this,ExamSecondActivity.class);
        intent.putExtra("name",name.getText().toString());
        intent.putExtra("tel",tel.getText().toString());

        /*intent.putExtra("code","btn");
        intent.putExtra("data","입력한 id:"+edit1.getText()+
                ", 입력한 pass:"+edit2.getText());*/

        startActivityForResult(intent,SECOND_EXAM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode==SECOND_EXAM){
            if(resultCode==RESULT_OK){
                firstTxt.setText(intent.getStringExtra("second"));
            }
        }

    }
}
