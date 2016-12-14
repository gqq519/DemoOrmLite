package com.feicuiedu.demoorm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.feicuiedu.demoorm.dao.DBHelp;
import com.feicuiedu.demoorm.dao.RepoGroupDao;
import com.feicuiedu.demoorm.model.RepoGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // alt+enter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // 添加10个测试数据
//        DBHelp dbHelp = DBHelp.getInstaance(this);
//        RepoGroupDao repoGroupDao = new RepoGroupDao(dbHelp);
//        for(int i=0; i<10; i++) {
//            RepoGroup repoGroup = new RepoGroup();
//            repoGroup.setId(i+1);
//            repoGroup.setName("类别"+i);
//            repoGroupDao.createOrUpdate(repoGroup);
//        }
//        // 查询输出log
//        List<RepoGroup> repoGroups = repoGroupDao.queryForAll();
//        for(RepoGroup repoGroup:repoGroups){
//            Log.d("TAG", repoGroup.toString());
//        }
//        // 查询输出log(查id为5的类别)
//        RepoGroup repoGroup = repoGroupDao.queryForId(5);
//        Log.d("TAG", "id为5的："+repoGroup.toString());
    }

    // ORM 对象关系映射
    // 快速的实现 数据库操作， SQL，提高开发效率

    // 1. 回顾一下android中数据库处理
    //
    // ----- 可能就会感觉到不方便的地方,你就会想，要是有一个框架就好了

    // 针对刚才的讲解，问题可以在公众号进行反馈
    // 我们50开始下一个环节

    // 2. 学习这种框架使用  ORMLite
    // 2.1 了解
    // 技术迁移
    // 比较轻量级，使用相对简单，上手快

    // ORMLite: 反射
    // GreenDAO:生成代码

    // 2.2 实现 (15:20开始)
    // 1. 导包
    // compile 'com.j256.ormlite:ormlite-core:5.0'
    // compile 'com.j256.ormlite:ormlite-android:5.0'
    // 2. OpenHelp
    // 3. 编写实体类（对应着表来写）
    // 4. 编写Dao类 (看你要对这个表做什么功能)



    /*
    将实体类，直接映射到数据库

    @DatabaseTable(tableName="NEWS")
    public class News{

        @DatabaseField(id = true)
        private int id;

        @DatabaseField(columnName="Title")
        private String title;
    }

    public class NewsDao{

        private Dao dao;

        public NewsDao(){
            dao = ...getDao(News.class);
        }

        public void update(News news){
            dao.createOrUpdate(news);
        }
    }



     */

}
