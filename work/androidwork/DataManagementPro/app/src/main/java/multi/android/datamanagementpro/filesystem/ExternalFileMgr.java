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
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class ExternalFileMgr extends AppCompatActivity {
    boolean permission_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_file_mgr);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED){
            permission_state = true;

        }else{
            permission_state = false;
            printToast("권한 설정 필요");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 999);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==999 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                permission_state = true;
                printToast("권한설정 완료!");
            }else {
                printToast("권한설정이 되지 않아 사용불가!");
            }
        }
    }

    public void printToast(String msg){
        Toast.makeText(this, msg,Toast.LENGTH_LONG).show();
    }

    public void saveExternalFileSystem(View v){
        if(permission_state){
            printToast("권한성공");
            String state = Environment.getExternalStorageState();
            if(state.equals(Environment.MEDIA_MOUNTED)){//사용 가능한 상태
                printToast("사용가능");
                File external = Environment.getExternalStorageDirectory();
                //외부저장소/임의의디렉토리를 생성 - 앱을 삭제해도 데이터는 남아있다.
                //String dirPath = external.getAbsolutePath()+"/myApp";
                //외부저장소/android/data/앱의 패키지명으로 디렉토리 생성
                //=> 앱을 삭제하면 데이터가 같이 삭제된다.
                String dirPath = external.getAbsolutePath();
                String pkg = getPackageName();
                File dir = new File(dirPath+"/android/data/"+pkg);
                //디렉토리 없으면 생성
                //File dir = new File(dirPath);
                if(!dir.exists()){
                    dir.mkdir();
                }
                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir+"/test1.txt");
                    fw.write("외부저장소 테스트중");
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(fw!=null){
                            fw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }else {
                printToast("사용불가능");
            }
        }else{
            printToast("권한 설정하세요");
        }
    }

   /* public void openInternalFile(View v){
        if(permission_state){
            printToast("권한 설정완료");
        }else{
            printToast("권한 설정하세요");
        }
    }*/
}
