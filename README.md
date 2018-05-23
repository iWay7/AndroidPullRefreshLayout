# AndroidPullRefreshLayout
Android 下拉刷新布局。可以是任意的子视图。

### 本应用的示例

![image](https://github.com/iWay7/AndroidPullRefreshLayout/blob/master/sample.gif)   

### 本示例基于 AndroidHelpers 库，访问 https://github.com/iWay7/AndroidHelpers 添加依赖。

#### 开始使用：
##### 类似这样，在布局文件中声明一个 PullRefreshLayout 视图并添加头部视图和内容视图：
```
<site.iway.androidhelpers.PullRefreshLayout
    android:id="@+id/pullRefreshLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:contentViewId="@+id/pullRefreshListView"
    app:headerViewId="@+id/pullRefreshHeader">
    
    <site.iway.androidhelpers.PullRefreshHeader
        android:id="@id/pullRefreshHeader"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
        
    <ListView
        android:id="@id/pullRefreshListView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
        
</site.iway.androidhelpers.PullRefreshLayout>
```

##### 必须放入头部视图和内容视图，并指定 app:headerViewId 以及 app:contentViewId 属性。

##### 通过以下方法设置回调：
```
mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.pullRefreshLayout);
mPullRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
    @Override
    public void onRefresh(PullRefreshLayout pullRefreshLayout) {
        // 这里编写用户请求刷新后相应的操作
    }
});
```

##### 通过以下方法设置刷新状态：
```
mPullRefreshLayout.setRefreshing(...); // 布尔值指示刷新状态
```

##### 相关的 View 属性：
```
app:headerViewId 指定下拉头部视图
app:contentViewId 指定内容视图
```

##### 如果需要自定义头部视图，可以继承自 site.iway.androidhelpers.PullRefreshHeader 并重写相关方法。
