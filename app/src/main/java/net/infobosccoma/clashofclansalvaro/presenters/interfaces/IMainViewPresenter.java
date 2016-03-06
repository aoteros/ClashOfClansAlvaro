package net.infobosccoma.clashofclansalvaro.presenters.interfaces;


import android.content.Context;

import net.infobosccoma.clashofclansalvaro.views.interfaces.IMainView;

public interface IMainViewPresenter {

    public void onCreate(IMainView view, Context context);

    public void getAtacFromService();

    public void showList();

    public void onItemClicked(int position);

}
