package com.watayouxiang.androiddemo.provider.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.watayouxiang.androiddemo.R;

import java.util.List;

/**
 * Created by johnny on 2016/10/24.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder> {

    private Context mContext;
    private List<PersonBean> mList;
    private LayoutInflater mInflater;
    private static final String POSITION_KEY="POSITION_KEY";

    public PersonAdapter(Context context, List<PersonBean> list) {
        mContext = context;
        mList = list;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(R.layout.recyclerview_item_person, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PersonBean bean = mList.get(position);
        holder.tvName.setText(bean.getName());
        holder.tvAge.setText(String.valueOf(bean.getAge()));
        switch (bean.getSex()) {
            case 0:
                holder.tvSex.setText("male");
                break;
            case 1:
                holder.tvSex.setText("female");
                break;
        }
        holder.tvDesc.setText(bean.getDesc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        TextView tvName;
        TextView tvAge;
        TextView tvSex;
        TextView tvDesc;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAge = (TextView) itemView.findViewById(R.id.tv_age);
            tvSex = (TextView) itemView.findViewById(R.id.tv_sex);
            tvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("编辑");
            Intent intent=new Intent();
            intent.putExtra(POSITION_KEY,getAdapterPosition());
            menu.add(0,0,0,"修改").setIntent(intent);
            menu.add(0,1,0,"删除").setIntent(intent);
        }
    }

}
