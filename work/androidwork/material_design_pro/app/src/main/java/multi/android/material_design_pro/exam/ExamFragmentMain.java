package multi.android.material_design_pro.exam;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;

public class ExamFragmentMain extends AppCompatActivity {

    ExamFirstFragment firstFragment;
    //ExamSecondFragment secondFragment;
    ExamListFragment secondFragment;
    ExamThirdFragment thirdFragment;

    TabLayout tabLayout;
    ViewPager examPager;
    ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    String[] tablist = {"추천 여행지","축제", "나의 여행지"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        examPager = findViewById(R.id.examViewPager);
        tabLayout = findViewById(R.id.tabs);

        tabLayout.setTabTextColors(Color.CYAN,Color.WHITE);

        firstFragment = new ExamFirstFragment();
        secondFragment = new ExamListFragment();
        thirdFragment = new ExamThirdFragment();

        fragmentList.add(firstFragment);
        fragmentList.add(secondFragment);
        fragmentList.add(thirdFragment);

        ExamViewPagerAdapter adapter = new ExamViewPagerAdapter(getSupportFragmentManager(),
                fragmentList.size());
        examPager.setAdapter(adapter);
        //examPager.addOnPageChangeListener(new PageListener());

        tabLayout.setupWithViewPager(examPager);
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

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tablist[position];
        }
    }
/*

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
    }*/

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
