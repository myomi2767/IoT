package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FrameChange extends AppCompatActivity {
    LinearLayout linear1;
    LinearLayout linear2;
    LinearLayout linear3;
    EditText loginId;
    EditText loginPass;
    EditText signName;
    EditText signId;
    EditText signPass;
    TextView result1;
    TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_change);
        //View
        linear1 = findViewById(R.id.frameLogin);
        linear2 = findViewById(R.id.frameSign);
        linear3 = findViewById(R.id.frameDetail);
        //login
        loginId = findViewById(R.id.loginId);
        loginPass = findViewById(R.id.loginPassword);
        result1 = findViewById(R.id.result1);
        //sign
        signName = findViewById(R.id.signName);
        signId = findViewById(R.id.signId);
        signPass = findViewById(R.id.signPass);
        result2 = findViewById(R.id.result2);

        //login
        Button btnLoginSend = findViewById(R.id.btnLoginSend);
        btnLoginSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = loginId.getText().toString();
                String pass = loginPass.getText().toString();
                result1.setText(id+"\t"+pass);
            }
        });
        //sign
        Button btnSignSend = findViewById(R.id.btnSignSend);
        btnSignSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = signName.getText().toString();
                String id = signId.getText().toString();
                String pass = signPass.getText().toString();
                result2.setText(name+"\t"+id+"\t"+pass);
            }
        });
    }
    // Button이 클릭될 때 호출되는 메소드 = View.OnclickListener의
    // public void onClick(View v) 메소드와 동일한 역할
    public void myclick(View v){
        if(v.getId()==R.id.btnlogin){
            linear1.setVisibility(View.VISIBLE);
            linear2.setVisibility(View.INVISIBLE);
            linear3.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.btnsign){
            linear1.setVisibility(View.INVISIBLE);
            linear2.setVisibility(View.VISIBLE);
            linear3.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.btndetail){
            linear1.setVisibility(View.INVISIBLE);
            linear2.setVisibility(View.INVISIBLE);
            linear3.setVisibility(View.VISIBLE);
        }
    }
}
