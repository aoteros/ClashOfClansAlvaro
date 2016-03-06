package net.infobosccoma.clashofclansalvaro.views.interfaces;

import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;
import net.infobosccoma.clashofclansalvaro.views.impl.adapters.AtacListAdapter;

import java.util.List;

public interface IMainView {

    public void createList(AtacListAdapter adapter);

    public AtacListAdapter createPersonAdapter(List<Atac> persons);

    public void goToDetailActivity(Atac atac);

    public void showProgressBar();

    public void hideProgressBar();

    public void showRetryButton();

    public void hideRetryButton();

    public void showList();

    public void hideList();

    public void showMessage(String message);

}
