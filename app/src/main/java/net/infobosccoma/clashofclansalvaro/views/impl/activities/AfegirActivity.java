package net.infobosccoma.clashofclansalvaro.views.impl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import net.infobosccoma.clashofclansalvaro.R;
import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;
import net.infobosccoma.clashofclansalvaro.models.persistence.daos.impl.AtacsSQLiteDAO;

/**
 * Created by aoteros on 01/03/2016.
 */
public class AfegirActivity extends AppCompatActivity{

    private EditText txtName;
    private EditText txtTh;
    private EditText txtTropes;
    private EditText txtPocions;
    private EditText txtDescripcio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afegir_main);



    }


    public void clickButtonAcceptar(View view){
        txtTh = (EditText) findViewById(R.id.editText_th_afegir);
        txtName = (EditText) findViewById(R.id.editText_name_afegir);
        txtTropes = (EditText) findViewById(R.id.editText_tropes_afegir);
        txtPocions = (EditText) findViewById(R.id.editText_pocions_afegir);
        txtDescripcio = (EditText) findViewById(R.id.editText_descripcio_afegir);

        Atac atac1 = new Atac(Integer.valueOf(txtTh.getText().toString()), txtName.getText().toString(), txtTropes.getText().toString(), txtPocions.getText().toString(), txtDescripcio.getText().toString());

        AtacsSQLiteDAO atacSQL = new AtacsSQLiteDAO(getBaseContext());

        atacSQL.save(atac1);
    }



}
