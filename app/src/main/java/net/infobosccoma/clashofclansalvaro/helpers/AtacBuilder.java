package net.infobosccoma.clashofclansalvaro.helpers;

import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;

import java.util.ArrayList;
import java.util.List;

public class AtacBuilder {
    public AtacBuilder() {
    }

    public List<Atac> getAtacs() {

        List<Atac> atacs = new ArrayList<>();

        atacs.add(new Atac(7, "Dracs", "10 Dracs","2 rajos, 1 rabia, 1 terratremol, 1 veri", "Utilitzar 2 rajos mes terratremol a un antiaeri i despres tirar tots els dracs. Quant els dracs estiguin en el centre de l'aldea tirar la rabia en ells o un antiaeri tirar rabia."));
        atacs.add(new Atac(9, "GoWiPE", "2 Golems, 20 mags, 2 P.E.K.K.A, 8 Rompemuros, 2 arqueres, 1 Hog Rider","2 Rabies, 1 Curacio, 1 Salt", "Atacar per on hi ha la reina i el castell del clan excepte si es divideix molt l'exercit. Per entrar al centre utilitzar salt i rabia."));
        atacs.add(new Atac(9, "GoHog", "2 Golems, 8 Mags, 4 Rompemuros, 26 Hogs Raiders" ,"1 Rabia 3 Curacions", "Entrar amb el golem i reis per matar el castell i detonar bombes. Finalment acabar amb els hogs utilitzant les pocions de curacio a les torres de mags o bombes."));
        atacs.add(new Atac(10, "GoLaloon", "2 Golems, 2 Gossos de lava, 12 Globus, 8 Trencamurs, 3 Arqueres, 12 Mags ","2 Rabies, 1 Salt, 3 Velocitat, 1 Veri", "Entrar amb la part terrestre per acabar amb reina, castell, 1 antiaeri mes controlador aeri o dos antiaeris. Despres acabar amb la part aerea."));

        return atacs;
    }
}
