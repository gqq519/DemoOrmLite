package com.feicuiedu.demoorm.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by gqq on 2016/12/14.
 * 仓库类别表
 *
 */

@DatabaseTable(tableName = "repostiory_group")
public class RepoGroup {

    // 这是个主键
    @DatabaseField(id = true)
    private int id;

    @DatabaseField(columnName = "NAME")
    private String name;

    @Override
    public String toString() {
        return "RepoGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
