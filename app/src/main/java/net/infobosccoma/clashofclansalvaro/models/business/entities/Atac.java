package net.infobosccoma.clashofclansalvaro.models.business.entities;

import org.parceler.Parcel;

@Parcel
public class Atac {

    private long codi;

    private int th;

    private String nom;

    private String tropes;

    private String pocions;

    private String descripcio;

    public Atac() {

    }

    public Atac(int th,  String nom, String tropes, String pocions, String descripcio) {
        this.th = th;
        this.nom = nom;
        this.tropes = tropes;
        this.pocions = pocions;
        this.descripcio = descripcio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTh() {
        return th;
    }

    public void setTh(int th) {
        this.th = th;
    }

    public String getTropes() {
        return tropes;
    }

    public void setTropes(String tropes) {
        this.tropes = tropes;
    }

    public String getPocions() {
        return pocions;
    }

    public void setPocions(String pocions) {
        this.pocions = pocions;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public long getCodi() {
        return codi;
    }

    public void setCodi(long codi) {
        this.codi = codi;
    }
}
