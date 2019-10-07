package fadergs.squadmaker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fadergs.squadmaker.Model.Players;

public class PlayerAdapter extends BaseAdapter {

    private List<Players> playersList;
    private Context context;
    private LayoutInflater inflater;

    public PlayerAdapter(Context context, List<Players> playersList){
        this.context = context;
        this.playersList = playersList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return playersList.size();
    }

    @Override
    public Object getItem(int i) {
        return playersList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        suportHandler sp = new suportHandler();

        if (view == null){
            view = inflater.inflate(R.layout.list_player, null);
            sp.lvnamePLayer = (TextView) view.findViewById(R.id.lvtname);
            sp.lvNumberShirt= (TextView) view.findViewById(R.id.lvtnumber);
            sp.layout = (LinearLayout) view.findViewById(R.id.layout);
            view.setTag(sp);

        }else{
            sp = (suportHandler) view.getTag();
        }

        Players players = playersList.get(i);
        sp.lvNumberShirt.setText(String.valueOf(players.getNumberShirt()));
        sp.lvnamePLayer.setText(String.valueOf(players.getName()));

        if( i % 2 == 0 ){
            sp.layout.setBackgroundColor(Color.WHITE);
        }else {
            sp.layout.setBackgroundColor(Color.rgb(230,230,230));
        }

        return view;


        }
    private class suportHandler{
        private TextView lvNumberShirt;
        private TextView lvnamePLayer;
        private LinearLayout layout;
    }
}
