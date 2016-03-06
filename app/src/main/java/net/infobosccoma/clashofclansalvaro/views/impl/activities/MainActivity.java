package net.infobosccoma.clashofclansalvaro.views.impl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import net.infobosccoma.clashofclansalvaro.R;
import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;
import net.infobosccoma.clashofclansalvaro.presenters.impl.MainViewPresenterImpl;
import net.infobosccoma.clashofclansalvaro.presenters.interfaces.IMainViewPresenter;
import net.infobosccoma.clashofclansalvaro.views.impl.adapters.AtacListAdapter;
import net.infobosccoma.clashofclansalvaro.views.interfaces.IMainView;

import org.parceler.Parcels;

import java.util.List;


public class MainActivity extends AppCompatActivity implements IMainView, AdapterView.OnItemClickListener {


    final int INTENT_REQUEST = 1;
    private ListView list;
    private ProgressBar progressBar;
    private Button btnRetry;
    private IMainViewPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        presenter = new MainViewPresenterImpl();
        presenter.onCreate(this, getBaseContext());
        presenter.getAtacFromService();
    }

    @Override
    public AtacListAdapter createPersonAdapter(List<Atac> atacs) {
        return new AtacListAdapter(this, atacs);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
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
            case R.id.action_edit:
                edit();
                return true;
            case R.id.action_afegir:
                add();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void edit() {
        Intent i = new Intent (this, ImatgeActivity.class);

        startActivityForResult(i, INTENT_REQUEST);
    }

    private void add() {
        Intent i = new Intent (this, AfegirActivity.class);

        startActivityForResult(i, INTENT_REQUEST);
    }

    @Override
    public void goToDetailActivity(Atac atac) {
        Intent intent = new Intent(this, DetailActivity.class);
        // quan s'han d'enviar objectes es fa embolcallant-los.
        // ens ajudem d'una llibreria externa, per no haver d'implementar la interface Parcelable
        intent.putExtra("ATAC", Parcels.wrap(atac));
        startActivity(intent);
    }

    @Override
    public void createList(AtacListAdapter adapter) {
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRetryButton() {
        btnRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetryButton() {
        btnRetry.setVisibility(View.GONE);
    }

    @Override
    public void showList() {
        list.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideList() {
        list.setVisibility(View.GONE);
    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }


}
