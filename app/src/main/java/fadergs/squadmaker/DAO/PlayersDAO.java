package fadergs.squadmaker.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fadergs.squadmaker.DB.Persistence;
import fadergs.squadmaker.Model.Players;

public class PlayersDAO {

    public static void insertPlay(Context contexto, Players players){

        Persistence banco = new Persistence(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("IdTeam",players.getIdTeam());
        values.put("namePlayer",players.getName());
        values.put("numberShirt",players.getNumberShirt());
        db.insert("players",null,values);

    }

    public static void editPlayers(Context contexto , Players players){
        Persistence banco = new Persistence(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("namePlayer",players.getName());
        values.put("numberShirt",players.getNumberShirt());
        values.put("idTeam",players.getIdTeam());
        db.update("players",values,"idPlayer="+players.getIdPlayer(),null);
    }


    public static void exclud(Context contexto , int idPlayer){
        Persistence banco = new Persistence(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("players","idPlayer="+idPlayer,null);


    }

    public static List<Players> getPlay(Context contexto, Integer idTeam){

        List<Players> listPlayers = new ArrayList<>();

        Persistence banco = new Persistence(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM players WHERE idTeam = "+idTeam,null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            //System.out.println(cursor);

            do {
                Players j = new Players();
                j.setIdPlayer(cursor.getInt(0));
                j.setName(cursor.getString(1));
                j.setNumberShirt(cursor.getString(3));
                j.setIdTeam(cursor.getInt(2));
                listPlayers.add(j);

            }while(cursor.moveToNext());
        }
        return listPlayers;

    }

    public static Players getPlayersById(Context contexto, int idPlayer){

        Persistence banco = new Persistence(contexto);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery( "SELECT * FROM players WHERE idPlayer = " + idPlayer ,null);

        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();

            Players j = new Players();
            j.setIdPlayer(  cursor.getInt( 0 ) );
            j.setName( cursor.getString( 1 ) );
            j.setNumberShirt( cursor.getString( 3 ) );
            j.setIdTeam(cursor.getInt(2));

            return j;
        }else {
            return null;
        }
    }

}
