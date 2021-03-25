package com.watayouxiang.myandroid.content_provider.demo.ui;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.watayouxiang.myandroid.R;
import com.watayouxiang.myandroid.content_provider.demo.db.PersonProvider;

public class AddOrModifyActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etAge;
    private RadioGroup rgSex;
    private EditText etDesc;
    private Button btnSave;

    private int sex;//0-男，1-女
    private boolean is_add;
    private ContentResolver resolver;
    private String name, age, desc;
    private PersonBean bean;
    private static final String IS_ADD_KEY = "IS_ADD_KEY";
    private static final String PERSON_BEAN_KEY = "PERSON_BEAN_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_modify);
        initView();
        initData();
    }

    private void initData() {
        resolver = getContentResolver();
        is_add = getIntent().getBooleanExtra(IS_ADD_KEY, true);
        if (!is_add) {
            bean = getIntent().getParcelableExtra(PERSON_BEAN_KEY);
            etName.setText(bean.getName());
            etAge.setText(String.valueOf(bean.getAge()));
            switch (bean.getSex()) {
                case 0:
                    rgSex.check(R.id.rb_male);
                    break;
                case 1:
                    rgSex.check(R.id.rb_female);
                    break;
            }
            etDesc.setText(bean.getDesc());
        }
    }

    private void initView() {
        etName = (EditText) findViewById(R.id.et_name);
        etAge = (EditText) findViewById(R.id.et_age);
        etDesc = (EditText) findViewById(R.id.et_desc);
        rgSex = (RadioGroup) findViewById(R.id.rg_sex);
        btnSave = (Button) findViewById(R.id.btn_save);
        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_male) {
                    sex = 0;
                } else if (checkedId == R.id.rb_female) {
                    sex = 1;
                }
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                age = etAge.getText().toString();
                desc = etDesc.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    showToast("请输入姓名");
                } else if (TextUtils.isEmpty(age)) {
                    showToast("请输入年龄");
                } else if (rgSex.getCheckedRadioButtonId() == -1) {
                    showToast("请选择性别");
                } else if (TextUtils.isEmpty(desc)) {
                    showToast("请输入简介");
                } else {
                    savePerson();
                }
            }
        });
    }

    private void savePerson() {
        ContentValues values = getContentValues();
        if (is_add) {
            Uri uri = resolver.insert(PersonProvider.CONTENT_URI, values);
            if (uri != null) {
                showToast("保存成功");
            } else {
                showToast("保存失败");
            }
            finish();
        } else {
            Uri uri = ContentUris.withAppendedId(PersonProvider.CONTENT_URI, bean.getId());
            int result = resolver.update(uri, values, null, null);
            if (result > 0) {
                showToast("保存成功");
            } else {
                showToast("保存失败");
            }
            finish();
        }
    }

    @NonNull
    private ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("sex", sex);
        values.put("desc", desc);
        return values;
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
