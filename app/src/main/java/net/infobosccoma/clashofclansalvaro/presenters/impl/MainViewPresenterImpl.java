package net.infobosccoma.clashofclansalvaro.presenters.impl;


import android.content.Context;

import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;
import net.infobosccoma.clashofclansalvaro.models.persistence.daos.impl.AtacsSQLiteDAO;
import net.infobosccoma.clashofclansalvaro.models.persistence.daos.interfaces.AtacsDAO;
import net.infobosccoma.clashofclansalvaro.presenters.interfaces.IMainViewPresenter;
import net.infobosccoma.clashofclansalvaro.views.interfaces.IMainView;

import java.util.List;

public class MainViewPresenterImpl implements IMainViewPresenter {


    private IMainView view;
    private List<Atac> atacs;

    private Context context;

    @Override
    public void onCreate(IMainView view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void getAtacFromService() {
        //view.showProgressBar();
        view.hideList();

        // Aquí, és on demanem les dades
        // En aquest exemple, agafo les dades d'un "creador" de persones
        //PersonBuilder personBuiler = new PersonBuilder();
        //persons = personBuiler.getPersons();

        AtacsDAO atacsDAO = new AtacsSQLiteDAO(context);
        atacs = atacsDAO.getAll();

        showList();
    }

    @Override
    public void showList() {
        //view.hideProgressBar();
        view.createList(view.createPersonAdapter(atacs));
        view.showList();
    }

    @Override
    public void onItemClicked(int position) {
        view.goToDetailActivity(atacs.get(position));
    }
}

