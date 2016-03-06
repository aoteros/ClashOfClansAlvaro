package net.infobosccoma.clashofclansalvaro.views.impl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import net.infobosccoma.clashofclansalvaro.R;
import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;
import net.infobosccoma.clashofclansalvaro.models.persistence.daos.impl.AtacsSQLiteDAO;
import net.infobosccoma.clashofclansalvaro.presenters.impl.DetailViewPresenterImpl;
import net.infobosccoma.clashofclansalvaro.presenters.interfaces.IDetailViewPresenter;
import net.infobosccoma.clashofclansalvaro.views.interfaces.IDetailView;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity implements IDetailView {

    private TextView txtName;
    private TextView txtTh;
    private TextView txtTropes;
    private TextView txtPocions;
    private TextView txtDescripcio;

    final int INTENT_REQUEST = 1;

    private IDetailViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_atac);

        txtName = (TextView) findViewById(R.id.txtview_name);
        txtTh = (TextView) findViewById(R.id.txtview_th);
        txtTropes = (TextView) findViewById(R.id.txtview_tropes);
        txtPocions = (TextView) findViewById(R.id.txtview_pocions);
        txtDescripcio = (TextView) findViewById(R.id.txtview_descripcio);

        presenter = new DetailViewPresenterImpl();
        presenter.onCreate(this, getAtacFromIntent(getIntent()));
    }


//    @Override
//    public void setImage(String url) {
//        // per si tinguessim un ImageView, per exemple...
//    }

    @Override
    public void setTh_Atac(int th) {
        txtTh.setText(String.valueOf(th));
    }

    @Override
    public void setName(String name) {
        txtName.setText(name);
    }

    @Override
    public void setTropesView(String tropes) {
        txtTropes.setText(tropes);
    }

    @Override
    public void setPocionsView(String pocions) {
        txtPocions.setText(pocions);
    }

    @Override
    public void setDescripcioView(String descripcio) {
        txtDescripcio.setText(descripcio);
    }


    private Atac getAtacFromIntent(Intent intent) {
        return (Atac) Parcels.unwrap(intent.getParcelableExtra("ATAC"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_second, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_context_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                delete();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void delete() {
        Intent i = new Intent (this, MainActivity.class);
        txtTh = (TextView) findViewById(R.id.txtview_th);
        txtName = (TextView) findViewById(R.id.txtview_name);
        txtTropes = (TextView) findViewById(R.id.txtview_tropes);
        txtPocions = (TextView) findViewById(R.id.txtview_pocions);
        txtDescripcio = (TextView) findViewById(R.id.txtview_descripcio);

        AtacsSQLiteDAO atacSQL = new AtacsSQLiteDAO(getBaseContext());
        atacSQL.delete(atacSQL.getByOther(txtName.getText().toString()));
        startActivityForResult(i, INTENT_REQUEST);
    }

}
