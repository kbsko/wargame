package com.dev.mobile.wargame.soviet;

import com.dev.mobile.wargame.Tank;

import java.util.Random;

/**
 * Created by Kubish on 21.07.2015.
 */
public class MS_1 extends Tank {
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmorfront() {
        return armorfront;
    }

    public int getArmorback() {
        return armorback;
    }

    public int getArmorbort() {
        return armorbort;
    }

    public MS_1(int health, int attackarmormax, int attackarmormin, int armorfront, int armorback, int armorbort, int damagemin, int damagemax, int speedattack, double timesved, double razbros) {
        this.health = health;
        this.attackarmormax = attackarmormax;
        this.attackarmormin = attackarmormin;
        this.armorfront = armorfront;
        this.armorback = armorback;
        this.armorbort = armorbort;
        this.damagemin = damagemin;
        this.damagemax = damagemax;
        this.speedattack = speedattack;
        this.timesved = timesved;
        this.razbros = razbros;
    }

    public MS_1() {
        this.health = 90;
        this.attackarmormax = 43;
        this.attackarmormin = 26;
        this.armorfront = 18;
        this.armorback = 16;
        this.armorbort = 16;
        this.damagemin = 23;
        this.damagemax = 38;
        this.speedattack = 24;
        this.timesved = 1.7;
        this.razbros = 0.57;
    }

    //здоровье
    private int health=90;
    //бронепробиваемость
    private int attackarmormax=43;
    private int attackarmormin=26;
    //броня
    private int armorfront=18;
    private int armorback=16;
    private int armorbort=16;
    // урон
    private int damagemin=23;
    private int damagemax=38;
    //скорострельность
    private int speedattack=24;
    //сведение
    private double timesved=1.7;
    // Разброс орудия
    private double razbros=0.57;

    public boolean probability_Hitting(int fast_or_long) {
        final Random random = new Random();
        double koef=0;
        double probability=((1-razbros)*fast_or_long+koef)*100;
        int testprob=random.nextInt(100);
        if (testprob<probability) {
            return true;
        }
        else return false;
    }
    public int probability_armorattack() {
        final Random random = new Random();
        return attackarmormin+random.nextInt(attackarmormax-attackarmormin);
    }
    public int probability_damage() {
        final Random random = new Random();
        return damagemin+random.nextInt(damagemax-damagemin);
    }
}
