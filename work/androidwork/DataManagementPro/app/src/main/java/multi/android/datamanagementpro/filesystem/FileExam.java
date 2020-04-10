package multi.android.datamanagementpro.filesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import multi.android.datamanagementpro.R;

public class FileExam extends AppCompatActivity {
    boolean permission_state;
    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_exam);
        txt = findViewById(R.id.txt);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED&ContextCompat.checkSelfPermission
                (this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED){
            permission_state = true;
        }else{
            permission_state = false;
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},998);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==998&&grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED&grantResults[1]==PackageManager.PERMISSION_GRANTED){
                permission_state = true;
                Toast.makeText(this,"권한설정 완료",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"권한설정이 되지않아 불가",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void openExam(View v) {
        FileInputStream fis = null;
        DataInputStream dis = null;

        File external = Environment.getExternalStorageDirectory();
        String dirPath = external.getAbsolutePath() + "/mynote";
        File dir = new File(dirPath);

        StringBuffer sb = new StringBuffer();
        String str = null;
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(dir + "/" + getToday() + "_note.txt"));
                while ((str = br.readLine()) != null) {
                    sb.append(str);
                    sb.append("\n");
                }

                txt.setText(sb);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void saveExam(View v){
        String state = Environment.getExternalStorageState();
        StringBuffer sb2 = new StringBuffer();
        sb2.append(txt.getText());
        if(state.equals(Environment.MEDIA_MOUNTED)){
            File external = Environment.getExternalStorageDirectory();
            String dirPath = external.getAbsolutePath()+"/mynote";
            File dir = new File(dirPath);
            if(!dir.exists()){
                dir.mkdir();
            }
            FileWriter fw = null;
            try {
                fw = new FileWriter(dir+"/"+getToday()+"_note.txt");
                fw.write(sb2.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(fw!=null){
                        fw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void createExam(View v){
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            File external = Environment.getExternalStorageDirectory();
            String dirPath = external.getAbsolutePath() + "/mynote/"+getToday()+"_note.txt";
            File dir = new File(dirPath);
            dir.delete();
        }

    }

    public String getToday(){
        Date getToday = Calendar.getInstance().getTime();

        SimpleDateFormat day = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat month = new SimpleDateFormat("MM", Locale.getDefault());
        SimpleDateFormat year = new SimpleDateFormat("yyyy", Locale.getDefault());
        String today = year.format(getToday)+month.format(getToday)+day.format(getToday);
        return today;
    }
}
