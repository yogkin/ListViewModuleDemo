# ListViewModuleDemo
#### 该库是对1SmartRefreshLayout1库的封装，具备以下几个特点：
* 集成了分页逻辑处理，你完全不需要关心分页逻辑
* 空页面自动显示empty 底图，该图也可以自定义。
* 可以设置为纯列表模式（除了下拉刷新的其他所有特点）
* 默认有2个下拉刷新样式，如需要更多可以到[SmartRefreshLayout](https://github.com/scwang90/SmartRefreshLayout)查找，或者自定义

## 使用步骤
* 添加依赖 
```kotlin
implementation 'com.github.yogkin:ListViewModuleDemo:Tag'
```

2. 需要下拉刷新的`view`实现`IRefreshView<T> T`为`adapter` 实体的`Bean`，实现里面关键的3个方法
3. 在需要加载时候调用`refresh_layout.setAdapterAndLoad(this)`
