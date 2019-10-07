package fadergs.squadmaker.Model;

public class Team {

    private int id;
    private String name;

    public String getName()
    {
        return name;

    }

    public int getID(){ return this.id; }


    public void setID(int id){
        this.id = id;
    }

    public void setName(String name){

        this.name = name;
    }

    @Override
    public String toString(){
        return  "ID do time: "+this.getID()+
                "Nome do time: "+this.getName();
    }
}
