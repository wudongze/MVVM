package com.example.wudz.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.wudz.bean.UserBean;
import com.example.wudz.mvvm.databinding.ActivityMvvmBinding;
import com.example.wudz.mvvm.databinding.ItemUserBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * USER：wudz on 2016/11/2 09:54
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class MVVMActivity extends AppCompatActivity {
    //在这里会生成ViewDataBinding的形势的类，继承ViewDataBinding
    private ActivityMvvmBinding binding;
    private ListView lvUser;
    private List<UserBean> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
        binding.setMyEvent(new MyEvent());
        lvUser = (ListView) binding.getRoot().findViewById(R.id.lv_user);
        UserBean user = new UserBean();
        user.setAge("20");
        user.setName("小明");
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        lvUser.setAdapter(new MyAdapter());
    }

    public class MyEvent{
        public void setInf(View view){
            UserBean user = new UserBean();
            user.setAge("20");
            user.setName("小明");
            binding.setUser(user);
        }
    }
    class MyAdapter extends BaseAdapter{
        ItemUserBinding itemUserBinding;
        @Override
        public int getCount() {
            return list.size();
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
            if(convertView == null){
                itemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(MVVMActivity.this),R.layout.item_user,parent,false);
                convertView = itemUserBinding.getRoot();
                convertView.setTag(itemUserBinding);
            }else{
                itemUserBinding = (ItemUserBinding) convertView.getTag();
            }
            itemUserBinding.setUser(list.get(position));
            return convertView;
        }
    }
}
