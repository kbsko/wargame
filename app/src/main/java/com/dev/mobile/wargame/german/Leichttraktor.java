package com.dev.mobile.wargame.german;

import java.util.Random;

/**
 * Created by Kubish on 21.07.2015.
 */
public class Leichttraktor {
    //здоровье
    private int health=110;
    //бронепробиваемость
    private int attackarmormax=23;
    private int attackarmormin=46;
    //броня
    private int armorfront=14;
    private int armorback=12;
    private int armorbort=12;
    // урон
    private int damagemin=11;
    private int damagemax=12;
    //скорострельность
    private int speedattack=115;
    //сведение
    private double timesved=1.7;
    // Разброс орудия
    private double razbros=0.57;

    private double probability_Hitting(double razbros,double fast_or_long) {
        final Random random = new Random();
        double koef=0;
        double probability=((1-razbros)*fast_or_long+koef)*100;
        int testprob=random.nextInt(100);
        if (testprob<probability) {
            return 1;
        }
         else return 0;
    }
    private int probability_armorattack(int attackarmormin,int attackarmormax) {
        final Random random = new Random();
        return attackarmormin+random.nextInt(attackarmormax-attackarmormin);
    }
    private int probability_damage(int damagemin,int damagemax) {
        final Random random = new Random();
        return damagemin+random.nextInt(damagemax-damagemin);
    }

}
