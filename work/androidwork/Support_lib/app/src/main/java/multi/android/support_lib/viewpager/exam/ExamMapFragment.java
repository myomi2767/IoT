package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.MapFragment;

import multi.android.support_lib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamMapFragment extends Fragment {

    public ExamMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exam_map, container, false);
    }
}
