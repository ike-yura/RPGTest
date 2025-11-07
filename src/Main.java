import main.Battle;
import main.Character;
import main.Enemy;
import main.Hero;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("勇者", 30, 8, 3);
        Enemy slime = new Enemy("スライム", 15, 5, 1, 200, 10);

        Battle battle = new Battle(hero, slime);

        battle.startBattleLoop();
    }
}
