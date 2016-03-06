package net.infobosccoma.clashofclansalvaro.models.persistence.utilities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;

/**
 * Created by aoteros on 29/02/2016.
 */
public class SQLiteUtils {
    static final String NOM_BD = "Atacs.db";
    static final int VERSIO_BD = 2;

    public static SQLiteDatabase getConnection(Context context) {
        return new AtacsSQLiteHelper(context, NOM_BD, null, VERSIO_BD).getReadableDatabase();
    }

    public static Atac getAtac(Cursor reader) {
        Atac atac = new Atac();

        atac.setCodi(reader.getLong(reader.getColumnIndex("codi")));

        atac.setTh(reader.getInt(reader.getColumnIndex("th")));

        atac.setNom(reader.getString(reader.getColumnIndex("nom")));

        atac.setTropes(reader.getString(reader.getColumnIndex("tropes")));

        atac.setPocions(reader.getString(reader.getColumnIndex("pocions")));

        atac.setDescripcio(reader.getString(reader.getColumnIndex("descripcio")));

        return atac;
    }
}
