package com.watayouxiang.androiddemo.provider;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/03/24
 *     desc   :
 * </pre>
 */
public class ContentResolverDemoActivity extends Activity {

    private static final int CONTACTS_REQUEST_CODE = 1001;

    private final String[] contactsPermissions = {Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS};
    private ContentResolver resolver;
    private List<ContactsBean> mContacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resolver = getContentResolver();
        mContacts = new ArrayList<>();

        boolean isGranted = checkSelfPermission(this);
        if (!isGranted) {
            requestPermissions(this);
        } else {
            queryContact();
        }
    }

    /**
     * ContentResolver 修改
     */
    private boolean deleteContact(long id) {
        // 删除 ContactsContract.RawContacts，而不是 ContactsContract.Data？
        // 因为 ContactsContract.RawContacts 是主键，ContactsContract.Data 是外键
        // 所以删除 ContactsContract.RawContacts 后，会自动删除 ContactsContract.Data 中的数据
        int result = resolver.delete(ContactsContract.RawContacts.CONTENT_URI,
                ContactsContract.RawContacts._ID + "=?",
                new String[]{String.valueOf(id)});
        return result > 0;
    }

    /**
     * ContentResolver 修改
     */
    private boolean updateContact(String name, String phone, long id) {
        ContentValues values = new ContentValues();
        values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, name);
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phone);
        int result = resolver.update(ContactsContract.Data.CONTENT_URI, values,
                ContactsContract.Data.RAW_CONTACT_ID + "=?",
                new String[]{String.valueOf(id)});
        return result > 0;
    }

    /**
     * ContentResolver 插入
     */
    private boolean insertContact(String name, String phone) {
        // 首先向 raw_contacts 表中插入一条空记录，目的是获取 raw_contact_id
        ContentValues values = new ContentValues();
        Uri rawContactUri = resolver.insert(ContactsContract.RawContacts.CONTENT_URI, values);
        long rawContactId = ContentUris.parseId(rawContactUri);

        // 插入联系人姓名
        values.clear();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
        values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, name);
        Uri nameUri = resolver.insert(ContactsContract.RawContacts.CONTENT_URI, values);

        // 插入手机号
        values.clear();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phone);
        Uri phoneUri = resolver.insert(ContactsContract.RawContacts.CONTENT_URI, values);

        return nameUri != null && phoneUri != null;
    }

    /**
     * ContentResolver 查询
     */
    private void queryContact() {
        Cursor cursor = resolver.query(ContactsContract.RawContacts.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            ContactsBean bean = new ContactsBean();
            bean.id = cursor.getInt(cursor.getColumnIndex(ContactsContract.RawContacts._ID));
            bean.name = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));

            Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.Data.RAW_CONTACT_ID + "=?",
                    new String[]{String.valueOf(bean.id)},
                    null);
            if (phoneCursor.moveToFirst()) {
                bean.phone = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            }
            phoneCursor.close();

            mContacts.add(bean);
        }
        cursor.close();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CONTACTS_REQUEST_CODE) {
            boolean result = true;
            int length = grantResults.length;
            if (length == contactsPermissions.length) {
                for (int grantResult : grantResults) {
                    if (grantResult == PackageManager.PERMISSION_DENIED) {
                        result = false;
                        break;
                    }
                }
            }
            if (result) {
                notifyReqPermissionsSuccess();
            }
        }
    }

    private void notifyReqPermissionsSuccess() {
        // 通知请求权限成功
        queryContact();
    }

    public boolean checkSelfPermission(Context context) {
        int readContacts = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS);
        int writeContacts = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CONTACTS);
        return readContacts == PackageManager.PERMISSION_GRANTED
                && writeContacts == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions(Activity activity) {
        ActivityCompat.requestPermissions(activity, contactsPermissions, CONTACTS_REQUEST_CODE);
    }

    public static class ContactsBean {
        public int id;
        public String name;
        public String phone;
    }
}
