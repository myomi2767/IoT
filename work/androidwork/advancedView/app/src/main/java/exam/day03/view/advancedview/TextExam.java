package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextExam extends AppCompatActivity {
    EditText txtarea1;
    EditText txtarea2;
    EditText txtsend;
    String msg = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_exam);
        txtarea1 = findViewById(R.id.area1);
        txtarea2 = findViewById(R.id.area2);
        txtsend = findViewById(R.id.textsend);

        Button btnsend = findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtarea1.append(txtsend.getText()+"\n");
                txtarea2.append(txtsend.getText()+"\n");
                txtsend.setText("");
            }
        });
    }
}
