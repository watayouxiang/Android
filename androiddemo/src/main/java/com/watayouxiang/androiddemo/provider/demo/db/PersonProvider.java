package com.watayouxiang.androiddemo.provider.demo.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by johnny on 2016/10/24.
 * <p>
 * 内容提供者
 */
public class PersonProvider extends ContentProvider {

    // 包名
    private static final String PACKAGE_NAME = "com.watayouxiang.androiddemo";
    // 表名
    private static final String TABLE_NAME = "person";
    // 数据库名字
    private static final String DB_NAME = "person.db";
    // 数据库版本号
    private static final int DB_VERSION = 1;
    // Uri 的 authority 部分
    private static final String AUTHORITY = PACKAGE_NAME + ".provider.demo.db.PersonProvider";
    // Uri
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);


    // content type: 单条
    private static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/" + PACKAGE_NAME + "." + TABLE_NAME;
    // content type: 集合
    private static final String CONTENT_TYPE = "vnd.android.cursor.dir/" + PACKAGE_NAME + "." + TABLE_NAME;
    // 多条记录 code
    private static final int PERSON_ALL = 0;
    // 单条记录 code
    private static final int PERSON_ONE = 1;


    private UriMatcher matcher;
    private DbHelper dbHelper;


    @Override
    public boolean onCreate() {
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITY, "person", PERSON_ALL);
        matcher.addURI(AUTHORITY, "person/#", PERSON_ONE);
        dbHelper = new DbHelper(getContext(), DB_NAME, null, DB_VERSION);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        selection = handleWhereClause(uri, selection);
        return db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
    }

    private String handleWhereClause(Uri uri, String selection) {
        int code = matcher.match(uri);// 获取 uri 中的 code
        switch (code) {
            case PERSON_ALL://不需要处理
                break;
            case PERSON_ONE:
                long id = ContentUris.parseId(uri);// 获取 uri 中的 id
                if (TextUtils.isEmpty(selection)) {
                    selection = "id=" + id;
                } else {
                    selection += "and id=" + id;
                }
                break;
        }
        return selection;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int code = matcher.match(uri);
        switch (code) {
            case PERSON_ALL:
                return CONTENT_TYPE;
            case PERSON_ONE:
                return CONTENT_ITEM_TYPE;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // nullColumnHack 如果为null，那么 ContentValues 就不能为null
        // nullColumnHack 如果不为null，那么 ContentValues 就能为null
        long rowId = db.insert(TABLE_NAME, null, values);

        if (rowId > 0) {
            getContext().getContentResolver().notifyChange(PersonProvider.CONTENT_URI, null);
            return ContentUris.withAppendedId(uri, rowId);
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        selection = handleWhereClause(uri, selection);
        int result = db.delete(TABLE_NAME, selection, selectionArgs);
        if (result > 0) {
            getContext().getContentResolver().notifyChange(PersonProvider.CONTENT_URI, null);
        }
        return result;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        selection = handleWhereClause(uri, selection);
        int result = db.update(TABLE_NAME, values, selection, selectionArgs);
        if (result > 0) {
            getContext().getContentResolver().notifyChange(PersonProvider.CONTENT_URI, null);
        }
        return result;
    }
}
