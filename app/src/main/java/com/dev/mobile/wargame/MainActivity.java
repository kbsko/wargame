package com.dev.mobile.wargame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dev.mobile.wargame.soviet.MS_1;


public class MainActivity extends ActionBarActivity {
    MS_1 player1=new MS_1();
    MS_1 player2=new MS_1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView= (TextView) findViewById(R.id.textView4);
        TextView textView2= (TextView) findViewById(R.id.textView5);
        String text1= Integer.toString(player1.getHealth());
        textView.setText(text1);
        player2.setHealth(60);
        textView2.setText(Integer.toString(player2.getHealth()));
    }

    public void shot(View v) {
        TextView textView= (TextView) findViewById(R.id.textView10);
        TextView bron= (TextView) findViewById(R.id.textView6);
        TextView damagetext= (TextView) findViewById(R.id.textView8);
        TextView textView2= (TextView) findViewById(R.id.textView5);
        if (player1.probability_Hitting(1)) {
           textView.setText("YES");
            int armorpalyer2=player2.getArmorfront();
            int attackshot=player1.probability_armorattack();
            if (armorpalyer2>attackshot) {
                bron.setText("Не пробил");
            } else {
                bron.setText(Integer.toString(attackshot));
                int damage=player1.probability_damage();
                damagetext.setText(Integer.toString(damage));
                player2.setHealth(player2.getHealth() - damage);
                textView2.setText(Integer.toString(player2.getHealth()));
            }

        } else  textView.setText("NO");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
