package net.infobosccoma.clashofclansalvaro.helpers;

import net.infobosccoma.clashofclansalvaro.models.business.entities.Ajuntament;

import java.util.ArrayList;
import java.util.List;

public class AjuntamentBuilder {

    public AjuntamentBuilder() {
    }

    public List<Ajuntament> getAjuntaments() {
        List<Ajuntament> ajuntaments = new ArrayList<>();

        ajuntaments.add(new Ajuntament(7, "Farm", "http://192.168.0.247", "Ajuntament de farm. Fort contra BARCH, BAM, BAG."));
        ajuntaments.add(new Ajuntament(8, "Guerra", "http://www.google.com", "Ajuntament de guerra. Fort contra atacs aeris."));
        ajuntaments.add(new Ajuntament(9, "Guerra", "http://www.youtube.com", "Ajuntament de guerra. Fort contra GoWiPe."));
        ajuntaments.add(new Ajuntament(10, "Guerra", "http://www.infobosccoma.net", "Ajuntament de guerra. Fort contra atacs terrestres."));

        return ajuntaments;
    }
}
