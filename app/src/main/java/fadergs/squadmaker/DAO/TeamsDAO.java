package fadergs.squadmaker.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fadergs.squadmaker.DB.Persistence;
import fadergs.squadmaker.Model.Team;

public class TeamsDAO {

        public static void insertTeam(Context context, Team teams){
            Persistence connection = new Persistence(context);
            SQLiteDatabase db = connection.getWritableDatabase();

            ContentValues contentValues = new ContentValues();

            contentValues.put("nameTeam", teams.getName());

            db.insert("teams",null,contentValues);
        }


        public static void updateTeam(Context context , Team team){
            Persistence banco = new Persistence(context);
            SQLiteDatabase db = banco.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put("nameTeam",team.getName());
            db.update("teams",valores,"IdTeam="+team.getID(),null);

        }

        public static void deleteTeam(Context contexto, int idtime){
            Persistence banco = new Persistence(contexto);
            SQLiteDatabase db = banco.getWritableDatabase();

            db.delete("teams","IdTeam="+idtime,null);

        }

        public static List<Team> getTeam(Context contexto){
            List<Team> listTeams = new ArrayList<>();
            Persistence persistence = new Persistence(contexto);

            SQLiteDatabase db = persistence.getWritableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM teams ORDER BY nameTeam",null);

            if(cursor.getCount()>0){
                cursor.moveToFirst();

                System.out.println(cursor);

                do {
                    Team t = new Team();
                    t.setID(cursor.getInt(0));
                    t.setName((cursor.getString(1)));
                    listTeams.add(t);
                }while(cursor.moveToNext());
            }
            return listTeams;
        }

        public static Team getTeamByID(Context context, int teamID){
            Persistence banco = new Persistence(context);
            SQLiteDatabase db = banco.getWritableDatabase();

            Cursor cursor = db.rawQuery( "SELECT * FROM teams WHERE IdTeam = " + teamID ,null);

            if(cursor.getCount()>0){

                cursor.moveToFirst();

                Team t = new Team();

                t.setID(cursor.getInt(0));
                t.setName(cursor.getString(1));

                return t;
            }else{

                return null;
            }

        }
    }

