package com.example.codetribe.gridapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.net.Uri;
import android.widget.Toast;


public class CallCounsellor extends AppCompatActivity {

    GridView grid;
    String[] web = {"South African Police Services Line", "ChildLine", "LifeLine", "Social Development Substance Abuse Line", "Police and Trauma Line", "Suicide Crisis Line", "The South African Depression and Anxiety Group"};
    int imageId[] = {R.drawable.ic_phone, R.drawable.ic_phone, R.drawable.ic_phone, R.drawable.ic_phone, R.drawable.ic_phone, R.drawable.ic_phone, R.drawable.ic_phone,};
    String[] callInfo = {"10111", "0728951364", "0785763759", "0812536123", "0120256321", "10111", "10111"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_counsellor);

        CustomGrid adapter = new CustomGrid(CallCounsellor.this, web, imageId, callInfo);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(CallCounsellor.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+callInfo[position]));
                if (ActivityCompat.checkSelfPermission(CallCounsellor.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    System.out.println("Permission not granted");
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);

                //      if(position ==0)
//                {
//                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                callIntent.setData(Uri.parse("10111"));
//                startActivity(callIntent);
//                }
            }
        });

    }

}