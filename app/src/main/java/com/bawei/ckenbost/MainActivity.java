package com.bawei.ckenbost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.bawei.ckenbost.apdate.Shop;
import com.bawei.ckenbost.bean.ShopBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private List<ShopBean> list= new ArrayList<>();;
    private Shop mshop;
    private TextView zongjia;
    private int ye=0;
    private  int count=30;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.ListView);
        initDate();
        mshop = new Shop(this,list);
        listView.setAdapter(mshop);
        zongjia = (TextView) findViewById(R.id.TextView_zongjia);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState)
            {
                if(scrollState==AbsListView.OnScrollListener.SCROLL_STATE_IDLE)
                {
                    int lastVisiblePosition = view.getLastVisiblePosition();
                    if(lastVisiblePosition==list.size()-1)
                    {
                        ye=ye+count;
                        initDate();
                        mshop.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    private void initDate()
    {

        for (int i =ye; i<count+ye; i++)
        {
            ShopBean shopbean =new ShopBean("第"+i+"个商品",10+i,i);
            list.add(shopbean);
        }
    }

    public void quanxun(View view)
    {
        for (int i = 0; i <list.size() ; i++)
        {
            list.get(i).setBoo(true);

        }
        mshop.notifyDataSetChanged();
        setjiage();
    }

    public void danxun(View view)
    {
        setjiage();
        for (int i = 0; i <list.size() ; i++)
        {
            list.get(i).setBoo(!list.get(i).isBoo());

        }
        mshop.notifyDataSetChanged();
        setjiage();
    }
    public void setjiage()
    {
         int price=0;
        for (int i = 0; i <list.size() ; i++)
        {
            boolean boo = list.get(i).isBoo();
            if(boo)
            {
                price +=list.get(i).getPrice()*list.get(i).getCount();
            }

        }
        zongjia.setText("总价"+price);
    }


}
