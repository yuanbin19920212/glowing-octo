# glowing-octo
Learn from yesterday,live for today,hope for tomorrow.


使用注意事项：

 1.<CheckBox
        android:id="@+id/checkbox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:clickable="false"
        android:focusableInTouchMode="false"
        android:focusable="false"
        />
    CheckBox 属性设置android:clickable="false" android:focusableInTouchMode="false" android:focusable="false"

 2.设置选中：listView.setItemChecked(5,true);

 3.checkablelayout 使用<com.wj.yuanbin.checkableview.CheckableLayout xmlns:android="http://schemas.android.com/apk/res/android"
                         xmlns:app="http://schemas.android.com/apk/res-auto"
                         android:layout_width="match_parent"
                         android:layout_height="match_parent"
                         app:layout="@layout/check_layout"
                         app:checkboxId="@id/checkbox"
                         />
 4.设置选中模式：ListViandroid:choiceMode="singleChoice"