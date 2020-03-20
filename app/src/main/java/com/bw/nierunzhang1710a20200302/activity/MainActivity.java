package com.bw.nierunzhang1710a20200302.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.nierunzhang1710a20200302.adapter.MyAdapter;
import com.bw.nierunzhang1710a20200302.util.NetUtils;
import com.bw.nierunzhang1710a20200302.R;
import com.bw.nierunzhang1710a20200302.base.BaseActivity;
import com.bw.nierunzhang1710a20200302.bean.LouterBean;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
private XListView xListView;
private RelativeLayout relativeLayout;
private List<LouterBean.ListdataBean> list=new ArrayList<>();
private static int page=1;



    @Override
    protected void initData() {
getData();
    }

    private void getData() {
        if (NetUtils.getInstance().hasNet(this)){
            xListView.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            String httpUrl="";
            if (page==1){
                httpUrl="http://blog.zhaoliang5156.cn/api/pengpainews/pengpai1.json";
            }else  if (page==2){
                httpUrl="http://blog.zhaoliang5156.cn/api/pengpainews/pengpai2.json";
            }else {
                httpUrl="http://blog.zhaoliang5156.cn/api/pengpainews/pengpai3.json";
            }
            NetUtils.getInstance().doGet(httpUrl, new NetUtils.MyCallBack() {
                @Override
                public void ondoSerssecc(String json) {
                    final LouterBean louterBean = new Gson().fromJson(json, LouterBean.class);
                    list.addAll(louterBean.getListdata());
                    final MyAdapter myAdapter = new MyAdapter(list);
                    xListView.setAdapter(myAdapter);
                }

                @Override
                public void onEroor() {
                    Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            xListView.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "请检查网络", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void initView() {
xListView=findViewById(R.id.xlv);
relativeLayout=findViewById(R.id.rel);
xListView.setPullRefreshEnable(true);
xListView.setPullLoadEnable(true);
xListView.setXListViewListener(new XListView.IXListViewListener() {
    @Override
    public void onRefresh() {
        list.clear();
        page=1;
        getData();
        xListView.stopRefresh();
    }

    @Override
    public void onLoadMore() {
        page++;
        getData();
        xListView.stopLoadMore();
    }
});
    }
    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
