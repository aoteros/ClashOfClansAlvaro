package net.infobosccoma.clashofclansalvaro.presenters.interfaces;


import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;
import net.infobosccoma.clashofclansalvaro.views.interfaces.IDetailView;

public interface IDetailViewPresenter {

	public void onCreate(IDetailView view, Atac atac);

}
