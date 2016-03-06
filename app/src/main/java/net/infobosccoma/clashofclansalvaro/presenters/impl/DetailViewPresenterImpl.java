package net.infobosccoma.clashofclansalvaro.presenters.impl;


import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;
import net.infobosccoma.clashofclansalvaro.presenters.interfaces.IDetailViewPresenter;
import net.infobosccoma.clashofclansalvaro.views.interfaces.IDetailView;

public class DetailViewPresenterImpl implements IDetailViewPresenter {

	private IDetailView view;
	private Atac atac;

	@Override
	public void onCreate(IDetailView detailView, Atac atac) {
		view = detailView;
		this.atac = atac;

		view.setTh_Atac(atac.getTh());
		view.setName(atac.getNom());
		view.setTropesView(atac.getTropes());
		view.setPocionsView(atac.getPocions());
		view.setDescripcioView(atac.getDescripcio());

	}

}
