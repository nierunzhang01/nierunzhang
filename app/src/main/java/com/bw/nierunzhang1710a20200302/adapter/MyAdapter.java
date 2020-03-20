package com.bw.nierunzhang1710a20200302.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.nierunzhang1710a20200302.util.NetUtils;
import com.bw.nierunzhang1710a20200302.R;
import com.bw.nierunzhang1710a20200302.bean.LouterBean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.2<p>
 * <p>更改时间：2020.3.2<p>
 */
public class MyAdapter extends BaseAdapter {
    private static final int viewtypetop=0;
    private static final int viewtypeleft=1;
    private List<LouterBean.ListdataBean> list;

    public MyAdapter(List<LouterBean.ListdataBean> list) {
        this.list = list;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
//②　根据接口中的itemType字段完成多条目（itemType值为1展示图片在左边，type值为2展示图片在上面）（代码分5分，效果分5分）
    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getItemType()==1){
            return viewtypeleft;
        }else {
            return viewtypetop;
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            if (getItemViewType(position)==viewtypeleft){
                convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_left, parent, false);
            }else {
                convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_top, parent, false);
            }
            viewHolder=new ViewHolder();
            viewHolder.imageView=convertView.findViewById(R.id.img);
            viewHolder.title=convertView.findViewById(R.id.titlee);
            viewHolder.content=convertView.findViewById(R.id.contentt);
            viewHolder.type=convertView.findViewById(R.id.typee);
            viewHolder.lishi=convertView.findViewById(R.id.lish);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        final LouterBean.ListdataBean listdataBean = list.get(position);
        viewHolder.title.setText(listdataBean.getTitle());
        viewHolder.content.setText(listdataBean.getContent());
        viewHolder.type.setText(listdataBean.getType());
        viewHolder.lishi.setText(listdataBean.getPublishedAt());
        NetUtils.getInstance().doGetPhoto(listdataBean.getImageurl(), viewHolder.imageView);
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView title,content,type,lishi;
    }
}
