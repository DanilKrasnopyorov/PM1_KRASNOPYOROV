package space.milko.saperr;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random rand;
    private TextView result;
    private int num;
    private int counter;
    private Button buttons[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rand = new Random();
        buttons = new Button[9];
        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        buttons[2] = findViewById(R.id.btn3);
        buttons[3] = findViewById(R.id.btn4);
        buttons[4] = findViewById(R.id.btn5);
        buttons[5] = findViewById(R.id.btn6);
        buttons[6] = findViewById(R.id.btn7);
        buttons[7] = findViewById(R.id.btn8);
        buttons[8] = findViewById(R.id.btn9);
        result = findViewById(R.id.result);
        Toast.makeText(this, String.valueOf(buttons.length), Toast.LENGTH_SHORT).show();
        refreshRandom();
    }
    public void tap1(View view) {
        checkMin(0);
    }
    public void tap2(View view) {
        checkMin(1);
    }
    public void tap3(View view) {
        checkMin(2);
    }
    public void tap4(View view) {
        checkMin(3);
    }
    public void tap5(View view) {
        checkMin(4);
    }
    public void tap6(View view) {
        checkMin(5);
    }
    public void tap7(View view) {
        checkMin(6);
    }
    public void tap8(View view) {
        checkMin(7);
    }
    public void tap9(View view) {
        checkMin(8);
    }
    public void refreshRandom(){
        num = rand.nextInt(8);
    }
    public void refreshButtons(){
        for(int i=0; i<buttons.length; i++){
            buttons[i].setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
            buttons[i].setEnabled(true);
        }
    }
    public void checkMin(int num){
        counter+=1;
        if (counter == 9) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Ура")
                    .setMessage("Вы получаете звание везунчик!")
                    .setCancelable(false)
                    .setPositiveButton("Начать заново",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    refreshRandom();
                                    refreshButtons();
                                    counter=0;
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else {
            if(this.num == num){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Оу")
                        .setMessage("вы подорвались на мине")
                        .setCancelable(false)
                        .setPositiveButton("Начать заново",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        refreshRandom();
                                        refreshButtons();
                                        counter=0;
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
            else
            {
                buttons[num].setBackgroundColor(getResources().getColor(R.color.design_default_color_error));
                buttons[num].setEnabled(false);
            }
        }


    }
    public void onclick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Разработчик №1")
                .setMessage("студент ОМАВИАТА")
                .setCancelable(false)
                .setNegativeButton("Закрыть",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void onclick2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Разработчик №2")
                .setMessage("отсутсвует")
                .setCancelable(false)
                .setNegativeButton("Закрыть",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}