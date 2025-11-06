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
}
