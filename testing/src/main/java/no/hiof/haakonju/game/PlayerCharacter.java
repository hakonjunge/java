package no.hiof.haakonju.game;

public class PlayerCharacter {
    private String name, nickName;
    private int health, level;
    private boolean isNoob;

    public PlayerCharacter(){
        name= "Mario";
        health = 30;
        level = 1;
        isNoob = true;
    }

    public void takeDamage(int damage){
        health -= damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isNoob() {
        return isNoob;
    }

    public void setNoob(boolean noob) {
        isNoob = noob;
    }
}
