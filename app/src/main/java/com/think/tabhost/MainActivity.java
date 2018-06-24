package com.think.tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

/*
TabHost的使用demo
TabWidget : 该组件就是TabHost标签页中上部 或者 下部的按钮, 可以点击按钮切换选项卡;

TabSpec : 代表了选项卡界面, 添加一个TabSpec即可添加到TabHost中;

-- 创建选项卡 : newTabSpec(String tag), 创建一个选项卡;

-- 添加选项卡 : addTab(tabSpec);

2. TabHost使用步骤
a. 定义布局 : 在XML文件中使用TabHost组件, 并在其中定义一个FrameLayout选项卡内容;
b. 继承TabActivity : 显示选项卡组件的Activity继承TabActivity;
c. 获取组件 : 通过调用getTabHost()方法, 获取TabHost对象;
d. 创建添加选项卡 : 通过TabHost创建添加选项卡;

3. 将按钮放到下面
布局文件中TabWidget代表的就是选项卡按钮, Fragement组件代表内容;

设置失败情况 : 如果Fragement组件没有设置 Android:layout_weight属性, 那么将TabWidget放到下面, 可能不会显示按钮;

设置权重 : 设置了Fragment组件的权重之后, 就可以成功显示该选项卡按钮;

设置Android自带id : XML布局文件中, 可以使用<TabHost> 标签设置, 其中的id 需要引用 android的自带id : android:id="@android:id/tabhost" ;

getHost()获取前提 : 设置了该id之后, 在Activity界面可以使用 getHost(), 获取这个TabHost 视图对象;
设置android自带id : 这个组件的id要设置成android的自带id : android:id="@android:id/tabs" ;

TabHost必备组件 : 该组件与FrameLayout组件是TabHost组件中必备的两个组件;

切换按钮下方显示 : 如果想要将按钮放到下面, 可以将该组件定义在下面, 但是注意,FrameLayout要设置android:layout_widget = "1";

设置TabWidget大小 : 如果想要设置该按钮组件的大小, 可以设置该组件与FrameLayout组件的权重;

 */
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取TabHost
        TabHost tabHost = getTabHost();

        String[] titles = {"杨坤", "欢欢", "那英"};
        int[] ids = {R.id.alwayswet, R.id.isanimal, R.id.nezha};
        for (int i = 0; i < titles.length; i++) {
            View view = View.inflate(this, R.layout.layout_indicator, null);
            TextView textView = view.findViewById(R.id.title_tv);
            textView.setText(titles[i]);
            //创建并设置选项标签名称,以及对应布局视图
            TabHost.TabSpec page = tabHost.newTabSpec("tab" + i)
//                .setIndicator("杨坤")
                    .setIndicator(view)
                    .setContent(ids[i]);
            //添加选项
            tabHost.addTab(page);
        }

    }
}
