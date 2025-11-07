package main;

public class Hero extends Character {
    // メンバ変数
    int m_level;
    int m_exp;

    // コンストラクタ
    public Hero(String name, int maxHp, int attack, int defense) {
        super(name, maxHp, attack, defense);

        m_level = 1;
        m_exp = 0;
    }

    // Getter
    public int getLevel() {
        return m_level;
    }

    public int getExp() {
        return m_exp;
    }

    // 経験値を加算する
    public void gainExp(int amount) {
        m_exp += amount;
        System.out.println(getName() + "は" + amount + "の経験値を得た！");

        while (m_exp >= 100) {
            levelUp();
        }
    }

    // レベルアップ
    public void levelUp() {
        final int l_subExp = 100;
        final int l_addHp = 5;
        final int l_addAttack = 2;
        final int l_addDefense = 1;

        m_level++;
        m_exp -= l_subExp; // 経験値を減らす

        m_maxHp += l_addHp;
        m_attack += l_addAttack;
        m_defense += l_addDefense;
        m_hp = m_maxHp; // 全回復
        System.out.println(getName() + "はレベル" + m_level + "に上がった！");
    }
}
