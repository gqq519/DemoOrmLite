package com.feicuiedu.demoorm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.feicuiedu.demoorm.dao.DBHelp;
import com.feicuiedu.demoorm.dao.RepoGroupDao;
import com.feicuiedu.demoorm.model.RepoGroup;

import java.util.List;

public class FavoriteFragment extends Fragment implements View.OnClickListener,PopupMenu.OnMenuItemClickListener {

    private ImageButton btnFilter;
    private RepoGroupDao mRepoGroupDao;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepoGroupDao = new RepoGroupDao(DBHelp.getInstaance(getContext()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnFilter = (ImageButton) view.findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showPopupMenu(v);
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
        // 拿到menu
        Menu menu = popupMenu.getMenu();
        // 向上面添加menu项
        // 将表中内容拿出来，加上去
        // 怎么拿出来? 不是有dao了吗？
        List<RepoGroup> repoGroups = mRepoGroupDao.queryForAll();
        for(RepoGroup repo:repoGroups){
            menu.add(Menu.NONE, repo.getId() ,Menu.NONE, repo.getName());
        }
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(getContext(), "click : " + item.getItemId(), Toast.LENGTH_SHORT).show();
        // 更新对应数据
        return true;
    }
}
