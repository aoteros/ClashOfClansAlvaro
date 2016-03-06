package net.infobosccoma.clashofclansalvaro.models.business.entities;

public class Ajuntament {

    private int lvlAjuntament;

    private String tipusAjuntament;

    private String urlAjuntament;

    private String descripcioAjuntament;

    public Ajuntament() {
    }

    public Ajuntament(int lvlAjuntament, String tipusAjuntament, String urlAjuntament, String descripcioAjuntament) {
        this.lvlAjuntament = lvlAjuntament;
        this.tipusAjuntament = tipusAjuntament;
        this.urlAjuntament = urlAjuntament;
        this.descripcioAjuntament = descripcioAjuntament;
    }

    public int getLvlAjuntament() {
        return lvlAjuntament;
    }

    public void setLvlAjuntament(int lvlAjuntament) {
        this.lvlAjuntament = lvlAjuntament;
    }

    public String getTipusAjuntament() {
        return tipusAjuntament;
    }

    public void setTipusAjuntament(String tipusAjuntament) {
        this.tipusAjuntament = tipusAjuntament;
    }

    public String getUrlAjuntament() {
        return urlAjuntament;
    }

    public void setUrlAjuntament(String urlAjuntament) {
        this.urlAjuntament = urlAjuntament;
    }

    public String getDescripcioAjuntament() {
        return descripcioAjuntament;
    }

    public void setDescripcioAjuntament(String descripcioAjuntament) {
        this.descripcioAjuntament = descripcioAjuntament;
    }
}
