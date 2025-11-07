import main.Battle;
import main.Character;

public class Main {
    public static void main(String[] args) {
        Character hero = new Character("勇者", 20, 5, 2);
        Character slime = new Character("スライム", 10, 3, 1);

        Battle battle = new Battle(hero, slime);

        battle.startBattleLoop();
    }
}
