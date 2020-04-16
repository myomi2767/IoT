package multi.android.material_design_pro.tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;
import multi.android.material_design_pro.exam.ExamFirstFragment;
import multi.android.material_design_pro.exam.ExamListFragment;
import multi.android.material_design_pro.exam.ExamThirdFragment;

public class TabTest extends AppCompatActivity {
    ExamFirstFragment firstFragment;
    ExamListFragment secondFragment;
    ExamThirdFragment thirdFragment;
    ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);

        firstFragment = new ExamFirstFragment();
        secondFragment = new ExamListFragment();
        thirdFragment = new ExamThirdFragment();

        tabLayout = findViewById(R.id.mytab);
        bottomNavigationView = findViewById(R.id.bottomNavi);

        //탭 추가
        tabLayout.addTab(tabLayout.newTab().setText("설정"));

        //처음 실행할 때 보여줄 프레그먼트 지정
        getSupportFragmentManager().beginTransaction().
                replace(R.id.content_container,firstFragment).commit();
        //탭에 이벤트 연결하기
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //탭이 선택될 때 호출되는 메소드
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();//탭의 순서를 받아오기
                Log.d("tab",position+"");
                Fragment fragment = null;
                if(position==0){
                    fragment = firstFragment;
                }else if(position==1){
                    fragment = secondFragment;
                }else{
                    fragment = thirdFragment;
                }
                //탭을 선택할 때 지저오딘 프레그먼트 객체가 show되도록 연결
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.content_container,fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //BottomNavigationView 이벤트 연결
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.bottom_item2){
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.content_container,secondFragment).commit();
                }
                return false;
            }
        });
    }
}
