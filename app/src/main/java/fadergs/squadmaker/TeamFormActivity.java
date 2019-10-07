package fadergs.squadmaker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fadergs.squadmaker.DAO.TeamsDAO;
import fadergs.squadmaker.Model.Team;

public class TeamFormActivity extends AppCompatActivity {

    private EditText ETTeamName;
    private Button btnCreateTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_form);
        ETTeamName = (EditText) findViewById(R.id.ETTeamName);
        btnCreateTeam = (Button) findViewById(R.id.btnCreateTeam);
        Intent intent = getIntent();
        final Bundle extras = intent.getExtras();

        if(extras != null){
            ETTeamName.setText(extras.getString("teamName"));
            btnCreateTeam.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    update(extras);
                }
            });
        }else{
            btnCreateTeam.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    save();
                }
            });
        }

    }

    protected void update(Bundle extras) {
        String name = ETTeamName.getText().toString();
        if(name.isEmpty()){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setIcon(android.R.drawable.ic_dialog_alert);
            alert.setTitle("Atenção, vacilão");
            alert.setMessage("Preenche o time aí, tá de sacanagem?");
            alert.setPositiveButton("OK",null);
            alert.show();
        }else{
            int teamID = extras.getInt("teamID");

            Team t = new Team();

            t.setID(teamID);
            t.setName(name);

            TeamsDAO.updateTeam(this,t);

            this.finish();

        }
    }

    private void save(){
        String name = ETTeamName.getText().toString();

        if(name.isEmpty()){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setIcon(android.R.drawable.ic_dialog_alert);
            alert.setTitle("Atenção, vacilão");
            alert.setMessage("Preenche o time aí, tá de sacanagem?");
            alert.setPositiveButton("OK",null);
            alert.show();
        }else{
            Team t = new Team();

            t.setName(name);

            TeamsDAO.insertTeam(this,t);

            this.finish();
        }
    }


}
