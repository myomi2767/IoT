package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncTaskExam extends AppCompatActivity {
    ProgressBar progressBar;
    TextView txt;
    Button btn1;
    Button btn2;
    ImageView imageView;
    int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_exam);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        txt = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);

    }
    public void ck_bt(View view){
        AsyncExam asyncExam = new AsyncExam();
        asyncExam.execute(1,50);
        progressBar.incrementProgressBy(1);
    }

    class AsyncExam extends AsyncTask<Integer, Integer, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            progressBar.setMax(50);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for(int i=integers[0];i<=integers[1];i++){
                progressBar.setProgress(i);
                txt.setText(i+"");
                SystemClock.sleep(100);
                publishProgress(i);
                sum = sum+i;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(sum);
            return sb.toString();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if(values[0]%2==0){
                imageView.setImageResource(R.drawable.d1);
            }else {
                imageView.setImageResource(R.drawable.d2);
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            txt.setText("result:"+s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}
