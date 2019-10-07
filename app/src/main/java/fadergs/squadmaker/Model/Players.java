package fadergs.squadmaker.Model;

public class Players {

    private int idPlayer;
    private int idTeam;
    private String name;
    private String numberShirt;

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberShirt() {
        return numberShirt;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public void setNumberShirt(String numberShirt) {
        this.numberShirt = numberShirt;
    }

    @Override
    public String toString(){
        return "Id :" + this.idPlayer + " Nome:"+this.name+ " Numero Camiseta:"+this.numberShirt +" Id Time:"+this.idTeam ;
    }

}


