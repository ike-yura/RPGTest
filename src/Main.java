import java.util.ArrayList;
import java.util.List;
import main.Battle;
import main.Enemy;
import main.Hero;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("勇者", 300, 8, 3);
        Enemy slime = new Enemy("スライム", 15, 5, 1, 200, 10);
        Enemy boss = new Enemy("ボス", 30, 5, 1, 200, 10);

        List<Enemy> enemy_list = new ArrayList<Enemy>();
        enemy_list.add(slime);
        enemy_list.add(boss);

        for (Enemy enemy : enemy_list) {
            System.out.println("=== " + enemy.getName() + "が現れた！ ===");

            Battle battle = new Battle(hero, enemy);
            battle.startBattleLoop();

            // 勇者が倒れたらゲームオーバー
            if (hero.isDead()) {
                System.out.println(hero.getName() + "は倒れてしまった...");
                System.out.println("ゲームオーバー");
                break;
            }

            System.out.println(enemy.getName() + "を倒した！");
            System.out.println();
        }

        // 全員倒せたら
        if (!hero.isDead()) {
            System.out.println(hero.getName() + "は全ての敵を倒した！");
        }

    }
}
