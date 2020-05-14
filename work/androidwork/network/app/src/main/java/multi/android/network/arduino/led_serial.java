package multi.android.network.arduino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import multi.android.network.R;

public class led_serial extends AppCompatActivity {
    Button ledOn;
    Button ledOff;
    AsyncTaskLED taskLED;
    Socket socket;
    OutputStream os;
    PrintWriter pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_serial);
        ledOn = findViewById(R.id.ledOn);
        ledOff = findViewById(R.id.ledOff);
        taskLED = new AsyncTaskLED();

        taskLED.execute();
        ledOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        pw.println(1);
                        pw.flush();
                    }
                }).start();
            }
        });
        ledOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        pw.println(0);
                        pw.flush();
                    }
                }).start();
            }
        });
    }
    class AsyncTaskLED extends AsyncTask<Void, String, String>{

        @Override
        protected String doInBackground(Void... voids) {
            try {
                socket = new Socket("70.12.227.188", 12345);
                if(socket!=null) {
                    ioWork();
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
        public void ioWork(){
            try {
                os = socket.getOutputStream();
                pw = new PrintWriter(os,true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
