package main;

public class Battle {
    // キャラクター
    private Character m_attacker;
    private Character m_defender;

    // コンストラクタ
    public Battle(Character attacker, Character defender) {
        if (attacker == null) {
            throw new IllegalArgumentException("attackerがnullです");
        }

        if (defender == null) {
            throw new IllegalArgumentException("defenderがnullです");
        }

        m_attacker = attacker;
        m_defender = defender;
    }

    // 攻撃者の攻撃処理
    public void startBattleOnce() {
        m_attacker.attack(m_defender);
        m_defender.isDead();
    }

    // 戦闘のループ処理
    public void startBattleLoop() {
        int l_turn = 1; // ターン数

        while (true) {
            System.out.println("\n===" + l_turn + "ターン目 ===");
            showStatus();
            m_attacker.attack(m_defender);
            // 防御側の判定
            if (m_defender.isDead()) {
                System.out.println(m_attacker.getName() + "の勝利！");

                if (m_attacker instanceof Hero && m_defender instanceof Enemy) {
                    Hero hero = (Hero) m_attacker;
                    Enemy enemy = (Enemy) m_defender;
                    hero.gainExp(enemy.getExpReward());
                }
                break;
            }

            // 攻撃側と防御側を入れ替える
            Character temp = m_attacker;
            m_attacker = m_defender;
            m_defender = temp;
            // ターンの加算
            l_turn++;
        }
    }

    // ターンごとのステータス表示
    private void showStatus() {
        System.out.println("===ステータス表示===");
        System.out.println(m_attacker);
        System.out.println("===ここで区切り===");
        System.out.println(m_defender);
        System.out.println("===ステータス表示終了===\n");
    }
}
