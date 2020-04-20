package multi.android.map_location_pro.location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import multi.android.map_location_pro.R;
//현재 위치정보를 가져와서 맵에 연결해서 출력 - avd, device
public class LocationMapExam extends AppCompatActivity implements LocationListener, OnMapReadyCallback {
    LocationManager locationManager;
    GoogleMap map;
    boolean permission_state;
    List<String> provider_list; //전체 위치 제공자 목록
    List<String> enableProvider_list; //사용 가능한 위치 제공자 목록

    double latitude;
    double longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_map_exam);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        FragmentManager manager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)manager.findFragmentById(R.id.map);


        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED |
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},1000);
        }else {
            permission_state = true;

            getProviderList();
            getLocation();
            mapFragment.getMapAsync(this);
        }

    }
    public void getProviderList(){
        //제공되는 모든 provider목록을 가져오기
        provider_list= locationManager.getAllProviders();

        //사용가능한 목록
        enableProvider_list = locationManager.getProviders(true);
    }

    //ㅅ용가능 provider를 이용해서 위치정보를 받아오기
    public void getLocation(){
        for(String provider:enableProvider_list){
            Location location = null;
            try {
                location = locationManager.getLastKnownLocation(provider);
                if(location!=null){
                    //이벤트 연결
                    locationManager.requestLocationUpdates(provider,3000,1,this);
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                }
                Log.d("msg","========성공========");
            }catch (SecurityException e){
                Log.d("msg","========"+e.getMessage()+"=======");
            }

        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("msg", "위치정보가 변경되었습니다.");
        String provider = location.getProvider();
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        onMapReady(map);
        Log.d("msg",location.getLatitude()+"에베베"+location.getLongitude()+"");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1000 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED
                    & grantResults[1]==PackageManager.PERMISSION_GRANTED){
                permission_state = true;
            }else{
                Toast.makeText(this,"권한 설정을 하지 않았으므로 " +
                        "기능을 사용할 수 없습니다.",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if(map!=null){
            LatLng latLng= new LatLng(latitude,longitude);
            map.getUiSettings().setZoomControlsEnabled(true);
           // map.getUiSettings().setMyLocationButtonEnabled(true);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
            map.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
