package model;

public class Player {
    private int id ;
    private String name ;
    private char symbol ;
    private PlayerType type ;

    public Player(int id, String name, char symbol, PlayerType type){
        this.id=id ;
        this.name=name ;
        this.symbol=symbol ;
        this.type=type ;
    }
    public char getSymbol() {
        return symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Move makeMove(){
        return null ;
    }
}
