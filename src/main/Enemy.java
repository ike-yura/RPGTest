package main;

public class Enemy extends Character {

    private final int m_expReward;
    private final int m_goldReward;

    // コンストラクタ
    public Enemy(String name, int maxHp, int attack, int defense, int expReward, int goldReward) {
        super(name, maxHp, attack, defense);

        if (expReward < 0) {
            throw new IllegalArgumentException("expRewardは0以上である必要があります");
        }

        if (goldReward < 0) {
            throw new IllegalArgumentException("goldRewardは0以上である必要があります");
        }

        m_expReward = expReward;
        m_goldReward = goldReward;
    }

    // Getter
    public int getExpReward() {
        return m_expReward;
    }

    public int getGoldReward() {
        return m_goldReward;
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + "の攻撃！（敵専用メッセージ）");
        super.attack(target); // 親クラスの攻撃処理を呼ぶ
    }

    @Override
    public String toString() {
        return String.format(
                "[%s] HP:%d/%d ATK:%d DEF:%d EXP報酬:%d GOLD報酬:%d",
                m_name, m_hp, m_maxHp, m_attack, m_defense, m_expReward, m_goldReward);
    }
}
