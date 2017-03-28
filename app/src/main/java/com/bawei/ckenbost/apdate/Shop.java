package com.bawei.ckenbost.apdate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.ckenbost.MainActivity;
import com.bawei.ckenbost.R;
import com.bawei.ckenbost.bean.ShopBean;

import java.util.List;

/**
 * Created by 1 on 2017/3/22.
 */
public class Shop extends BaseAdapter
{
      private Context context;
     private List<ShopBean> list;

     public Shop(Context context, List<ShopBean> list) {
        this.context = context;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
         final ViewHodle mViewHodle;
        if(convertView == null)
        {
            mViewHodle = new ViewHodle();
            convertView = View.inflate(context, R.layout.item,null);
            mViewHodle.title = (TextView) convertView.findViewById(R.id.TextView_title);
            mViewHodle.price = (TextView) convertView.findViewById(R.id.TextView_price);
            mViewHodle.count = (TextView) convertView.findViewById(R.id.TextView_count);
            mViewHodle.mCheckBox = (CheckBox) convertView.findViewById(R.id.CheckBox);
            convertView.setTag(mViewHodle);
        }else
        {
            mViewHodle = (ViewHodle) convertView.getTag();
        }
        mViewHodle.title.setText(list.get(position).getTitle());
        mViewHodle.price.setText(list.get(position).getPrice()+"");
        mViewHodle.count.setText(list.get(position).getCount()+"");
        mViewHodle.mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                boolean checked = mViewHodle.mCheckBox.isChecked();
                list.get(position).setBoo(checked);
                MainActivity main= (MainActivity) context;
                main.setjiage();
            }
        });
        mViewHodle.mCheckBox.setChecked(list.get(position).isBoo());

        return convertView;
    }
    class ViewHodle
    {
        TextView title;
        TextView price;
        TextView count;
        CheckBox mCheckBox;
    }
}
