package fadergs.squadmaker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fadergs.squadmaker.DAO.PlayersDAO;
import fadergs.squadmaker.DAO.TeamsDAO;
import fadergs.squadmaker.Model.Players;
import fadergs.squadmaker.Model.Team;

public class PlayerFormActivity extends AppCompatActivity {

    private EditText etNome, etNrCamisa;
    private Button btnSave;
    private String acao;
    private int idTeam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_form);

        etNome = (EditText) findViewById(R.id.etNome);
        etNrCamisa = (EditText) findViewById(R.id.etNrCamisa);

        btnSave = (Button) findViewById(R.id.btnSave);




        Intent intent = getIntent();
        final Bundle extras = intent.getExtras();


        //System.out.println(extras);

        if (extras != null) {
            etNome.setText(extras.getString("namePlayer"));
            etNrCamisa.setText(extras.getString("numberShirt"));
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    update(extras);
                }
            });
        } else {
            idTeam = extras.getInt("teamID");
            etNome.setText(extras.getString("namePlayer"));
            etNrCamisa.setText(extras.getString("numberShirt"));
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    save(extras);
                }
            });
        }

    }

    protected void update(Bundle extras) {
        String name = etNome.getText().toString();
        if(name.isEmpty()){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setIcon(android.R.drawable.ic_dialog_alert);
            alert.setTitle("Atenção, vacilão");
            alert.setMessage("Preenche o time aí, tá de sacanagem?");
            alert.setPositiveButton("OK",null);
            alert.show();
        }else{
            int idPlayer = extras.getInt("idPlayer");

            Players t = new Players();

            t.setIdPlayer(idPlayer);
            t.setName(name);

            PlayersDAO.editPlayers(this,t);

            this.finish();

        }
    }

    private void save(Bundle extras){
        int idTeam = extras.getInt("teamID");
        String name = etNome.getText().toString();
        String numberShirt = etNrCamisa.getText().toString();


        if(name.isEmpty()){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setIcon(android.R.drawable.ic_dialog_alert);
            alert.setTitle("Atenção, vacilão");
            alert.setMessage("Preenche o time aí, tá de sacanagem?");
            alert.setPositiveButton("OK",null);
            alert.show();
        }else{
            Players t = new Players();

            t.setIdTeam(idTeam);
            t.setName(name);
            t.setNumberShirt(numberShirt);

            PlayersDAO.insertPlay(this,t);

            this.finish();
        }
    }

}