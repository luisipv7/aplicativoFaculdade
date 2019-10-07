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

import fadergs.squadmaker.Model.Team;

public class TeamAdapter extends BaseAdapter {

    private List<Team> teamsList;
    private Context context;
    private LayoutInflater inflater;

    public TeamAdapter(Context context, List<Team> teamList){
        this.context = context;
        this.teamsList = teamList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return teamsList.size();
    }

    @Override
    public Object getItem(int i) {
        return teamsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        suportHandler sp = new suportHandler();

        if(view == null){
            view = inflater.inflate(R.layout.activity_layout_list,null);
            sp.tvID = (TextView) view.findViewById(R.id.LTVID);
            sp.tvName = (TextView) view.findViewById(R.id.LTVName);
            sp.layout = (LinearLayout) view.findViewById(R.id.layout);
            view.setTag(sp);
        }else{
            sp = (suportHandler) view.getTag();
        }

        Team team = teamsList.get(i);
        sp.tvID.setText(String.valueOf(team.getID()));
        sp.tvName.setText(String.valueOf(team.getName()));

        if( i % 2 == 0){
            sp.layout.setBackgroundColor(Color.WHITE);
        }else{
            sp.layout.setBackgroundColor(Color.rgb(230,230,230) );
        }

        return view;
    }

    private class suportHandler{
        private TextView tvID;
        private TextView tvName;
        private LinearLayout layout;
    }
}
