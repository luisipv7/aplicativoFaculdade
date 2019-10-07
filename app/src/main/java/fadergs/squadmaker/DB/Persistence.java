package fadergs.squadmaker.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Persistence extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String NOME = "AppSquadMaker";

    public Persistence(Context context){
        super(context,NOME,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS teams ( "+
                "idTeam INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                "nameTeam TEXT);");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS players( " +
                "idPlayer INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                "namePlayer TEXT,"+
                "IdTeam INTEGER,"+
                "numberShirt INTEGER,"+
                "FOREIGN KEY(IdTeam) REFERENCES team(idTeam));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
