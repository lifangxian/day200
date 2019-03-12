package com.example.www.dazonghe.tab;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ListView;

import com.example.www.dazonghe.BaseFragment;
import com.example.www.dazonghe.HttpUtil;
import com.example.www.dazonghe.MyListAdapater;
import com.example.www.dazonghe.R;
import com.example.www.dazonghe.bean.One;
import com.example.www.dazonghe.sql.SQLHelp;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

public class Tab1 extends BaseFragment {

    private PullToRefreshListView plist;
    String str="http://172.17.8.100/small/commodity/v1/commodityList";
    private SQLiteDatabase db;

    @Override
    protected int bindlayout() {
        return R.layout.tab1;
    }

    @Override
    protected void initView() {
        plist = bindView(R.id.plist);
        plist.setMode(PullToRefreshBase.Mode.BOTH);
        plist.setPullToRefreshOverScrollEnabled(true);
        //创建数据库对象

        SQLHelp help = new SQLHelp(getActivity());
        db = help.getReadableDatabase();
    }

    @Override
    protected void initData() {
        if(HttpUtil.isNetworkConnected(getActivity())){
            HttpUtil.getAsyncTask(str, new HttpUtil.Callback() {

                private MyListAdapater adapater;
                private ArrayList<One> ones;

                @Override
                public void getClass(String s) {
                    ones = new ArrayList<>();
                    //设置适配器
                    adapater = new MyListAdapater(getActivity(),ones);
                    plist.setAdapter(adapater);

                    Cursor cursor = db.query("person", null, null, null, null, null, null);
                    if(!cursor.moveToFirst()){
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("title",s);
                        db.insert("person",null,contentValues);
                    }
                }
            });
        }
    }

    @Override
    protected void bindEvent() {
        plist.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                if(HttpUtil.isNetworkConnected(getActivity())){
                    HttpUtil.getAsyncTask(str, new HttpUtil.Callback() {
                        @Override
                        public void getClass(String s) {

                        }
                    });
                }
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }
}
