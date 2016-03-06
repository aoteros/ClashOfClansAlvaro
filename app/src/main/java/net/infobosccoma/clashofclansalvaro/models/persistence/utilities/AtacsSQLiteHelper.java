package net.infobosccoma.clashofclansalvaro.models.persistence.utilities;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aoteros on 29/02/2016.
 */
public class AtacsSQLiteHelper extends SQLiteOpenHelper {

    public AtacsSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public AtacsSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    private final String SQL_CREATE_ATACS =  "CREATE TABLE Atacs(" +
            "   codi INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "   th INTEGER, " +
            "   nom TEXT, " +
            "   tropes TEXT," +
            "   pocions TEXT, " +
            "   descripcio TEXT)";

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ATACS);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Atacs");
        db.execSQL(SQL_CREATE_ATACS);
        db.execSQL("INSERT INTO ATACS(th, nom, tropes, pocions, descripcio) VALUES (7, 'Dracs', '10 Dracs','2 rajos, 1 rabia, 1 terratremol, 1 veri', 'Utilitzar 2 rajos mes terratremol a un antiaeri i despres tirar tots els dracs. Quant els dracs estiguin en el centre de l'aldea tirar la rabia en ells o un antiaeri tirar rabia.')");
        db.execSQL("INSERT INTO ATACS(th, nom, tropes, pocions, descripcio) VALUES (9, 'GoWiPE', '2 Golems, 20 mags, 2 P.E.K.K.A, 8 Rompemuros, 2 arqueres, 1 Hog Rider','2 Rabies, 1 Curacio, 1 Salt', 'Atacar per on hi ha la reina i el castell del clan excepte si es divideix molt l'exercit. Per entrar al centre utilitzar salt i rabia.')");
        db.execSQL("INSERT INTO ATACS(th, nom, tropes, pocions, descripcio) VALUES (9, 'GoHog', '2 Golems, 8 Mags, 4 Rompemuros, 26 Hogs Raiders' ,'1 Rabia 3 Curacions', 'Entrar amb el golem i reis per matar el castell i detonar bombes. Finalment acabar amb els hogs utilitzant les pocions de curacio a les torres de mags o bombes.')");
        db.execSQL("INSERT INTO ATACS(th, nom, tropes, pocions, descripcio) VALUES (10, 'GoLaloon', '2 Golems, 2 Gossos de lava, 12 Globus, 8 Trencamurs, 3 Arqueres, 12 Mags','2 Rabies, 1 Salt, 3 Velocitat, 1 Veri', 'Entrar amb la part terrestre per acabar amb reina, castell, 1 antiaeri mes controlador aeri o dos antiaeris. Despres acabar amb la part aerea.')");


    }

}
