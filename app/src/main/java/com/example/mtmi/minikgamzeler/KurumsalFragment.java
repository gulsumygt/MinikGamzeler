package com.example.mtmi.minikgamzeler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by glsmy on 27.08.2016.
 */
public class KurumsalFragment extends Fragment {
    RelativeLayout biz_kimiz_layout;
    RelativeLayout neden_cocuklar_layout;
    RelativeLayout yonetim_kurulu_layout;
    RelativeLayout dernek_tuzugu_layout;
    RelativeLayout sorulan_sorular_layout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kurumsal_layout, container, false);


//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                switch (v.getId()) {
//                    case R.id.biz_kimiz:
//                        break;
//                    case R.id.neden_cocuklar:
//                        break;
//                    case R.id.yonetim_kurulu:
//                        break;
//                    case R.id.dernek_tuzugu:
//                        break;
//                    case R.id.sikça_sorulan_sorular:
//                        break;
//                }
//            }
//        };


        //Biz kimiz kategorisini içeren view bulur
        biz_kimiz_layout = (RelativeLayout) view.findViewById(R.id.biz_kimiz);

        //Bu view'e click listener uygular
        biz_kimiz_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //BizKimizActivity'sini açmak için yeni bir intent(içerik) oluşturur
                Intent biz_kimiz_intent = new Intent(getActivity(), BizKimizActivity.class);

                //Yeni activity başlatılır
                startActivity(biz_kimiz_intent);
            }
        });


        //Neden Çocuklar kategorisini içeren view bulur
        neden_cocuklar_layout = (RelativeLayout) view.findViewById(R.id.neden_cocuklar);

        //Bu view'e click listener uygular
        neden_cocuklar_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //NedenCocularActivity'sini açmak için yeni bir intent(içerik) oluşturur
                Intent neden_cocuklar_intent = new Intent(getActivity(), NedenCocuklarActivity.class);

                //Yeni activity başlatılır
                startActivity(neden_cocuklar_intent);
            }
        });

        //Yönetim Kurulumuz kategorisini içeren view bulur
        yonetim_kurulu_layout = (RelativeLayout) view.findViewById(R.id.yonetim_kurulu);

        //Bu view'e click listener uygular
        yonetim_kurulu_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //YonetimKuruluActivity'sini açmak için yeni bir intent(içerik) oluşturur
                Intent yonetim_kurulu_intent = new Intent(getActivity(), YonetimKuruluActivity.class);

                //Yeni activity başlatılır
                startActivity(yonetim_kurulu_intent);
            }
        });

        //Dernek Tüzüğümüz kategorisini içeren view bulur
        dernek_tuzugu_layout = (RelativeLayout) view.findViewById(R.id.dernek_tuzugu);

        //Bu view'e click listener uygular
        dernek_tuzugu_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //DernekTuzuguActivity'sini açmak için yeni bir intent(içerik) oluşturur
                Intent dernek_tuzugu_intent = new Intent(getActivity(), DernekTuzuguActivity.class);

                //Yeni activity başlatılır
                startActivity(dernek_tuzugu_intent);
            }
        });

        //Sıkça Sorulan Sorular kategorisini içeren view bulur
        sorulan_sorular_layout = (RelativeLayout) view.findViewById(R.id.sikca_sorulan_sorular);

        //Bu view'e click listener uygular
        sorulan_sorular_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SorulanSorularActivity'sini açmak için yeni bir intent(içerik) oluşturur
                Intent sorulan_sorular_intent = new Intent(getActivity(), SorulanSorularActivity.class);

                //Yeni activity başlatılır
                startActivity(sorulan_sorular_intent);
            }
        });
        return view;
    }
}
