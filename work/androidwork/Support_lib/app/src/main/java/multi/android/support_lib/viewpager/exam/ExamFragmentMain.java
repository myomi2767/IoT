package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;

public class ExamFragmentMain extends AppCompatActivity {
    ExamFirstFragment firstFragment;
    //ExamSecondFragment secondFragment;
    ExamListFragment secondFragment;
    ExamThirdFragment thirdFragment;
    ExamMapFragment mapFragment;
    ViewPager examPager;
    ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        FragmentManager fragmentManager = getSupportFragmentManager();
        firstFragment = new ExamFirstFragment();
        secondFragment = new ExamListFragment();
        thirdFragment = new ExamThirdFragment();
        mapFragment = new ExamMapFragment();

        examPager = findViewById(R.id.examViewPager);

        fragmentList.add(firstFragment);
        fragmentList.add(secondFragment);
        fragmentList.add(thirdFragment);
        fragmentList.add(mapFragment);

        ExamViewPagerAdapter adapter = new ExamViewPagerAdapter(fragmentManager, fragmentList.size());
        examPager.setAdapter(adapter);
        examPager.addOnPageChangeListener(new PageListener());
    }
    class ExamViewPagerAdapter extends FragmentPagerAdapter {

        public ExamViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm,behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }


    public void btn_click(View view){
        examPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
    }

    public void setFragment(String idx){
        Log.d("fragment",idx);
        FragmentManager fragmentManager = getSupportFragmentManager();
        //프래그먼트의 변화를 관리하는 객체
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (idx){
            case "0":
                transaction.replace(R.id.container,firstFragment);
                break;
            case "1":
                transaction.replace(R.id.container,secondFragment);
                break;
            case "2":
                transaction.replace(R.id.container,thirdFragment);
                break;
        }
        transaction.commit();
    }

    class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을 때
            Toast.makeText(ExamFragmentMain.this, "페이지가 전환",
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
