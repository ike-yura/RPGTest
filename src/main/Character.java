package main;

/**
 * RPG内のキャラクターを表すクラス。
 * 名前・HP・攻撃力・防御力を持ち、HP管理を担当する。
 */
public class Character {
    // メンバ変数
    protected String m_name; // 名前
    protected int m_maxHp; // 最大HP
    protected int m_hp; // 現在HP
    protected int m_attack; // 攻撃力
    protected int m_defense; // 防御力

    // コンストラクタ
    public Character(String name, int maxHp, int attack, int defense) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("nameがnullまたは空白です");
        }

        if (maxHp <= 0) {
            throw new IllegalArgumentException("maxHpは1以上である必要があります");
        }

        if (attack < 0) {
            throw new IllegalArgumentException("attackは0以上である必要があります");
        }

        if (defense < 0) {
            throw new IllegalArgumentException("defenseは0以上である必要があります");
        }

        m_name = name;
        m_maxHp = maxHp;
        m_hp = maxHp;
        m_attack = attack;
        m_defense = defense;
    }

    // Getter
    public String getName() {
        return m_name;
    }

    public int getMaxHp() {
        return m_maxHp;
    }

    public int getHp() {
        return m_hp;
    }

    public int getAttack() {
        return m_attack;
    }

    public int getDefense() {
        return m_defense;
    }

    // ダメージを受けた際の関数
    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("damageは0以上である必要があります");
        }

        m_hp -= damage;

        if (m_hp <= 0) {
            m_hp = 0;
        }

        System.out.println(m_name + "のHPは現在" + m_hp + "です!");
    }

    // 回復をされて際の関数
    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amountは0以上である必要があります");
        }

        m_hp += amount;

        if (m_hp >= m_maxHp) {
            m_hp = m_maxHp;
        }

        System.out.println(m_name + "のHPは現在" + m_hp + "です!");
    }

    // 生死判定
    public boolean isDead() {
        if (m_hp <= 0) {
            System.out.println(m_name + "は倒れてしまいました・・・");
            return true;
        } else {
            return false;
        }
    }

    // 攻撃判定
    public void attack(Character target) {
        if (target == null) {
            throw new IllegalArgumentException("targetがnullです");
        }

        System.out.println(m_name + "の攻撃!");

        // 攻撃先のダメージ判定
        int l_damage;
        l_damage = m_attack - target.getDefense();

        if (l_damage <= 1) {
            l_damage = 1;
        }

        target.takeDamage(l_damage);
    }

    @Override
    public String toString() {
        return m_name + "HP: "
                + m_hp + "/" + m_maxHp
                + " ATK: " + m_attack
                + " DEF: " + m_defense;
    }
}
