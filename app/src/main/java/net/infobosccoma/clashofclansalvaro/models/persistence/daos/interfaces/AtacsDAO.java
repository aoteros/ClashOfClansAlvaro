package net.infobosccoma.clashofclansalvaro.models.persistence.daos.interfaces;

import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;

import java.util.List;

/**
 * Created by aoteros on 29/02/2016.
 */
public interface AtacsDAO {


    Atac getById(long id);

    List<Atac> getAll();

    boolean save(Atac person);

    boolean update(Atac person);

    boolean delete(Atac person);
}
