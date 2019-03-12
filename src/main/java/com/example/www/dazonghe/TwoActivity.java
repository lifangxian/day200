package com.example.www.dazonghe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TwoActivity extends BaseActivity implements View.OnClickListener {


    private GridView gridView;
    private GridView grid;
    private ArrayList<String> list1;
    private ArrayList<String> list2;
    private GridAdapater adapater1;
    private GridAdapater adapater2;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fanhui:
            case R.id.finish:
                Intent intent=new Intent();
                intent.putStringArrayListExtra("key",list1);
                setResult(100,intent);
                finish();
                break;
        }
    }

    @Override
    public int bindlayout() {
        return R.layout.activity_two;
    }

    @Override
    protected void initView() {
        bindView(R.id.finish).setOnClickListener(this);
        bindView(R.id.fanhui).setOnClickListener(this);
        gridView = bindView(R.id.gridview);
        grid = bindView(R.id.grid);

    }

    @Override
    protected void initData() {
        Intent intent=getIntent();
        //gridview1数据
        list1 = intent.getStringArrayListExtra("key");
        //grid数据
        list2 = new ArrayList();
        for (int i=0;i<10;i++){
            list2.add("竹恩晨sm"+i);
        }
        //由于t1中的数据t2肯定没有,所以我们要把t2中和T1一样的数据删掉
        list2.remove(list1);
        //适配器
        adapater1 = new GridAdapater(TwoActivity.this,list1);
        adapater2 = new GridAdapater(TwoActivity.this,list2);
        //设置适配器
        grid.setAdapter(adapater1);
        gridView.setAdapter(adapater2);

    }

    @Override
    protected void bindEvent() {
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //得到我们目前要删除的内容
                String s = list1.get(position);
                //删除内容
                list1.remove(s);
                list2.add(s);
                //刷新适配器
                adapater1.notifyDataSetChanged();
                adapater2.notifyDataSetChanged();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = list2.get(position);
                list2.remove(s);
                list1.add(s);
                adapater1.notifyDataSetChanged();
                adapater2.notifyDataSetChanged();
            }
        });
    }

}
