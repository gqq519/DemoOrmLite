package com.feicuiedu.demoorm.dao;

import com.feicuiedu.demoorm.model.RepoGroup;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gqq on 2016/12/14.
 * <p>
 * <p>
 * ORMLite
 * <p>
 * ORMLite有提供 OrmLiteSqliteOpenHelper
 * <p>
 * 支持将实体类，直接映射到数据库
 * <p>
 * 写实体类 (用它提供的注解，表明TableName,和每个字段)
 * <p>
 * TableUtils --- 一些方法 可以（将实体类，直接映射到数据库）
 * OrmLiteSqliteOpenHelper --- getDao(实体类)可以构建出这个表的Dao
 */
public class RepoGroupDao {
    // RepoGroup表Dao对象 (使用ORMLite构建)
    private Dao<RepoGroup, Long> dao;

    public RepoGroupDao(DBHelp dbHelp) {
        try {
            // 使用ORMLite构建Dao对象
            dao = dbHelp.getDao(RepoGroup.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createOrUpdate(List<RepoGroup> list) {
        for (RepoGroup repo : list) {
            createOrUpdate(repo);
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
