package com.watayouxiang.myandroid.content_provider.demo.ui;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.watayouxiang.myandroid.R;
import com.watayouxiang.myandroid.content_provider.demo.db.PersonObserver;
import com.watayouxiang.myandroid.content_provider.demo.db.PersonProvider;

import java.util.ArrayList;
import java.util.List;

public class ContentProviderDemoActivity extends AppCompatActivity {

    private RecyclerView rvPerson;
    private Button btnAdd;

    private PersonAdapter mAdapter;
    private List<PersonBean> mList;
    private ContentResolver resolver;
    private PersonObserver observer;
    private static final int WHAT = 100;
    private static final String IS_ADD_KEY = "IS_ADD_KEY";
    private static final String PERSON_BEAN_KEY = "PERSON_BEAN_KEY";
    private static final String POSITION_KEY = "POSITION_KEY";

    private Handler observerHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case WHAT:
                    initData();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        resolver = getContentResolver();
        observer = new PersonObserver(observerHandler);
        resolver.registerContentObserver(PersonProvider.CONTENT_URI, true, observer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        mList.clear();
        Cursor cursor = resolver.query(PersonProvider.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            PersonBean bean = new PersonBean();
            bean.setId(cursor.getInt(cursor.getColumnIndex("id")));
            bean.setName(cursor.getString(cursor.getColumnIndex("name")));
            bean.setAge(cursor.getInt(cursor.getColumnIndex("age")));
            bean.setSex(cursor.getInt(cursor.getColumnIndex("sex")));
            bean.setDesc(cursor.getString(cursor.getColumnIndex("desc")));
            mList.add(bean);
        }
        cursor.close();
        mAdapter.notifyDataSetChanged();
    }

    private void initView() {
        rvPerson = (RecyclerView) findViewById(R.id.rv_person);
        btnAdd = (Button) findViewById(R.id.btn_add);
        rvPerson.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        mAdapter = new PersonAdapter(this, mList);
        rvPerson.setAdapter(mAdapter);
        registerForContextMenu(rvPerson);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentProviderDemoActivity.this, AddOrModifyActivity.class);
                intent.putExtra(IS_ADD_KEY, true);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0://修改
                int position = item.getIntent().getIntExtra(POSITION_KEY, 0);
                PersonBean bean = mList.get(position);
                startAddOrModifyActivity(bean);
                break;
            case 1://删除
                deletePerson(item);
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void startAddOrModifyActivity(PersonBean bean) {
        Intent intent = new Intent(this, AddOrModifyActivity.class);
        intent.putExtra(IS_ADD_KEY, false);
        intent.putExtra(PERSON_BEAN_KEY, bean);
        startActivity(intent);
    }

    private void deletePerson(MenuItem item) {
        int position = item.getIntent().getIntExtra(POSITION_KEY, 0);
        final PersonBean bean = mList.get(position);
        new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("确定删除联系人[" + bean.getName() + "]吗?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uri = ContentUris.withAppendedId(PersonProvider.CONTENT_URI, bean.getId());
                        int result = resolver.delete(uri, null, null);
                        if (result > 0) {
                            Toast.makeText(ContentProviderDemoActivity.this, "删除成功", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ContentProviderDemoActivity.this, "删除失败", Toast.LENGTH_LONG).show();
                        }
                    }
                }).setNegativeButton("取消", null)
                .show();
    }
}
