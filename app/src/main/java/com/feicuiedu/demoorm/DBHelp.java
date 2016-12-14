package com.feicuiedu.demoorm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.feicuiedu.demoorm.model.RepoGroup;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by gqq on 2016/12/14.
 */

public class DBHelp extends OrmLiteSqliteOpenHelper{

    private static DBHelp dbHelp;

    private Context context;

    private DBHelp(Context context) {
        super(context, "testdb", null, 1);
        this.context = context;
    }

    public static synchronized DBHelp getInstaance(Context context){
        if(dbHelp == null){
            dbHelp = new DBHelp(context.getApplicationContext());
        }
        return dbHelp;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        // 创建表
        try {
            TableUtils.createTableIfNotExists(connectionSource,RepoGroup.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        // 更新表
        try {
            TableUtils.dropTable(connectionSource,RepoGroup.class, true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
