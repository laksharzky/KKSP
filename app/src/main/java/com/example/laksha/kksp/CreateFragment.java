package com.example.laksha.kksp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFragment extends Fragment{
    View view;

    EditText edt_nama_lengkap,edt_Tempat_Lahir,edt_Tgl_Lahir,edt_Nama_ortu,edt_ketrampilan;
    RadioButton btnLaki,btnPerempuan,btnOrangTua,btn_Jalanan,btn_SD,btn_SMP,btn_SMA;
    Button btnUpload;

    laporan laporan;
    DatabaseReference databaseReport;
    FirebaseDatabase database;
    String gender="";
    String pendidikan="";
    String status="";


    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_create, container, false);

        databaseReport = FirebaseDatabase.getInstance().getReference("laporan");



        //define variables
        edt_nama_lengkap = (EditText) view.findViewById(R.id.edt_nama_lengkap);
        edt_Tempat_Lahir = (EditText) view.findViewById(R.id.edt_Tempat_Lahir);
        edt_Tgl_Lahir = (EditText) view.findViewById(R.id.edt_Tgl_Lahir);
        edt_Nama_ortu = (EditText) view.findViewById(R.id.edt_Nama_ortu);
        edt_ketrampilan = (EditText) view.findViewById(R.id.edt_ketrampilan);

        btnLaki = view.findViewById(R.id.btnLaki);
        btnPerempuan = view.findViewById(R.id.btnPerempuan);
        btnOrangTua = view.findViewById(R.id.btnOrangTua);
        btn_Jalanan = view.findViewById(R.id.btn_Jalanan);
        btn_SD = view.findViewById(R.id.btn_SD);
        btn_SMP = view.findViewById(R.id.btn_SMP);
        btn_SMA = view.findViewById(R.id.btn_SMA);

        btnUpload = (Button) view.findViewById(R.id.btnUpload);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edt_nama_lengkap.getText().toString().trim();
                String tempatLahir = edt_Tempat_Lahir.getText().toString();
                String tanggalLahir = edt_Tgl_Lahir.getText().toString();
                String namaOrtu = edt_Nama_ortu.getText().toString();
                String ketrampilan = edt_ketrampilan.getText().toString();

               gender();
               status();
               pendikan();


                if (!TextUtils.isEmpty(name)){
                    String id = databaseReport.push().getKey();
                    laporan laporan1 = new laporan(
                            id,
                            name,
                            gender,
                            tempatLahir,
                            tanggalLahir,
                            namaOrtu,
                            status,
                            pendidikan,
                            ketrampilan
                            );
                    databaseReport.child(id).setValue(laporan1);
                    Toast.makeText(getActivity(),"Report Added",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(),"Please Enter Your Name",Toast.LENGTH_SHORT).show();


            }
        });


return view;

    }

    private void gender(){

        if (btnLaki.isChecked()){
            gender="Laki-Laki";
        }
        if (btnPerempuan.isChecked()){
            gender="perempuan";
        }

    }
    private void status(){
        if (btnOrangTua.isChecked()){
            status="OrangTua";
        }
        if (btn_Jalanan.isChecked()){
            status="Dijalanan";
        };


    }
    private void pendikan(){
        if (btn_SD.isChecked()){
            pendidikan="SD";
        }
        if (btn_SMP.isChecked()){
            pendidikan="SMP";
        }
        if (btn_SMA.isChecked()){
            pendidikan="SMA";
        }

    }
}
