package sg.edu.rp.c346.id19018582.democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cb;
    Button btnCheck;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb = findViewById(R.id.checkBoxDiscount);
        btnCheck = findViewById(R.id.buttonCheck);
        tvShow = findViewById(R.id.textView);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");
                if(cb.isChecked()){
                    double pay = calcPay(100, 20);
                    tvShow.setText("Discount is given. You need to pay " + pay);
                }
                else{
                    double pay = calcPay(100,0);
                    tvShow.setText("Discount is not given. You need to pay " + pay);
                }


                Toast.makeText(MainActivity.this, "CheckBox Status " + cb.isChecked(), Toast.LENGTH_LONG).show();
            }
        });

    }
    private double calcPay(double price, double discount){
        double pay = price* (1-discount/100);
        return pay;
    }
}
