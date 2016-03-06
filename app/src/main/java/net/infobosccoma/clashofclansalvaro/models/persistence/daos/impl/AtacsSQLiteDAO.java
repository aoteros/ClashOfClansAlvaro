package net.infobosccoma.clashofclansalvaro.models.persistence.daos.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;
import net.infobosccoma.clashofclansalvaro.models.persistence.daos.interfaces.AtacsDAO;
import net.infobosccoma.clashofclansalvaro.models.persistence.utilities.SQLiteUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aoteros on 29/02/2016.
 */
public class AtacsSQLiteDAO implements AtacsDAO{

    private Context context;

    public AtacsSQLiteDAO(Context context){
        this.context = context;
    }

    public Atac getById(long id){
        Atac atac = null;

        SQLiteDatabase conn = SQLiteUtils.getConnection(context);
        Cursor result = conn.query(true, "Atacs",
                new String[]{"codi", "th", "nom", "tropes", "pocions", "descripcio"},
                "codi = ?", new String[]{String.valueOf(id)}, null, null, null, null, null);

        atac = SQLiteUtils.getAtac(result);
        conn.close();
        return atac;

    }

    public Atac getByOther(String nom){
        Atac atac = null;

        SQLiteDatabase conn = SQLiteUtils.getConnection(context);
        Cursor result = conn.query(true, "Atacs",
                new String[]{"codi", "th", "nom", "tropes", "pocions", "descripcio"},
                "nom = ?", new String[]{nom.toString()},null , null, null, null, null);
        atac = SQLiteUtils.getAtac(result);
        conn.close();
        return atac;

    }

    public List<Atac> getAll () {
        List<Atac> atacs = new ArrayList<>();

        SQLiteDatabase conn = SQLiteUtils.getConnection(context);
        Cursor result = conn.query(true, "Atacs",
                new String[]{"codi", "th", "nom", "tropes", "pocions", "descripcio"},
                null, null, null, null, null, null);

        while (result.moveToNext()){
            atacs.add(SQLiteUtils.getAtac(result));
        }
        conn.close();
        return atacs;
    }

    public boolean save(Atac atac) {
        ContentValues dades = new ContentValues();
        SQLiteDatabase conn = SQLiteUtils.getConnection(context);

        dades.put("th", atac.getTh());
        dades.put("nom", atac.getNom());
        dades.put("tropes", atac.getTropes());
        dades.put("pocions", atac.getPocions());
        dades.put("descripcio", atac.getDescripcio());

        try{
            long codi = conn.insertOrThrow("Atacs", null, dades);
            atac.setCodi(codi);
            return true;
        }catch(SQLException e){
            Log.e("Atacs", e.getMessage());
            return false;
        }
    }

    public boolean update(Atac atac) {
        ContentValues dades = new ContentValues();
        SQLiteDatabase conn = SQLiteUtils.getConnection(context);

        dades.put("th", atac.getTh());
        dades.put("nom", atac.getNom());
        dades.put("tropes", atac.getTropes());
        dades.put("pocions", atac.getPocions());
        dades.put("descripcio", atac.getDescripcio());

        return conn.update("Atacs", dades, "codi = ?", new String[] {String.valueOf(atac.getCodi())}) > 0;
    }

    public boolean delete(Atac atac) {

        SQLiteDatabase conn = SQLiteUtils.getConnection(context);

        return conn.delete("Atacs", "codi = ?", new String[] {String.valueOf(atac.getCodi())})>0;
    }
}
