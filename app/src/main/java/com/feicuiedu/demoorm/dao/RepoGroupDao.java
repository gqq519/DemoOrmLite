package com.feicuiedu.demoorm.dao;

import android.content.Context;
import android.widget.Button;

import com.feicuiedu.demoorm.DBHelp;
import com.feicuiedu.demoorm.model.RepoGroup;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gqq on 2016/12/14.
 */


public class RepoGroupDao {

    private Dao<RepoGroup, Long> dao;

    public RepoGroupDao(DBHelp dbHelp) {
        try {
            // getDao方法，用来构建指定实体的Dao文件
            // dao是对哪一个表操作？
            // 这个表的id是什么类型？
            dao = dbHelp.getDao(RepoGroup.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 用来对RepoGroup表添加和更新
    public void createOrUpdate(RepoGroup repoGroup) {
        try {
            dao.createOrUpdate(repoGroup);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 查询RepoGroup表所有数据
    public List<RepoGroup> queryForAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 查询指定id的数据
    public RepoGroup queryForId(long id) {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
