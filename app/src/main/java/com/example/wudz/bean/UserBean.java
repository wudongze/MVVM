package com.example.wudz.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

/**
 * USER：wudz on 2016/11/2 09:57
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class UserBean extends BaseObservable implements Serializable {
    private String name;
    private String age;

    public void setName(String name) {
        this.name = name;
    }
    @Bindable
    public String getName() {
        return name;
    }
    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
