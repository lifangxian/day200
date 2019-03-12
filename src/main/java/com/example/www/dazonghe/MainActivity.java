package com.example.www.dazonghe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.www.dazonghe.fragemnt.Fragment_ni;
import com.example.www.dazonghe.fragemnt.Fragment_ren;
import com.example.www.dazonghe.fragemnt.Fragment_shou;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private FrameLayout frame;
    private RadioGroup radioGroup;
    private Fragment_shou fragment_shou;
    private Fragment_ni fragment_ni;
    private Fragment_ren fragment_ren;
    private FragmentManager manager;

    @Override
    public int bindlayout()
    {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
            frame = findViewById(R.id.frame);
            radioGroup = findViewById(R.id.radio);

    }

    @Override
    protected void initData() {
        //创建数据
        fragment_shou = new Fragment_shou();
        fragment_ni = new Fragment_ni();
        fragment_ren = new Fragment_ren();
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.frame,fragment_shou).add(R.id.frame,fragment_ni).add(R.id.frame,fragment_ren)
                .show(fragment_shou).hide(fragment_ni).hide(fragment_ren).commit();
    }

    @Override
    protected void bindEvent() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    FragmentTransaction transacti = manager.beginTransaction();
                    switch (checkedId){
                        case R.id.rb1:
                            transacti.show(fragment_shou).hide(fragment_ni).hide(fragment_ren);
                            break;
                        case R.id.rb2:
                            transacti.show(fragment_ni).hide(fragment_shou).hide(fragment_ren);
                            break;
                        case R.id.rb3:
                            transacti.show(fragment_ren).hide(fragment_ni).hide(fragment_shou);
                            break;
                    }
                    transacti.commit();
                }
            });
    }
}
