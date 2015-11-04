package com.weightloss.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weightloss.R;
import com.weightloss.common.Utils;
import com.weightloss.ui.vo.SportDateVO;


import java.util.ArrayList;
import java.util.List;

/**
 * 运动天记录适配器
 * Created by admin on 2015/11/4.
 */
public class SportDateAdapter extends SelfBaseAdapter {
    private List<SportDateVO> list;

    public SportDateAdapter(Context context) {
        super(context);
    }

    public void setData(List<SportDateVO> data) {
        this.list = new ArrayList<>(data);
    }

    @Override
    public int getCount() {
        return !Utils.isEmpty(list) ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_sport_date_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTime.setText(list.get(position).getDate());
        return convertView;
    }

    class ViewHolder {
        TextView tvTime;
    }
}
