package kk.techbytecare.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer watch;
    Button btnSwitch;

    boolean start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        watch = findViewById(R.id.watch);
        btnSwitch = findViewById(R.id.btnSwitch);

        watch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                watch = chronometer;
            }
        });

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (start)  {
                    watch.stop();
                    start = false;
                    ((Button)view).setText("Start");
                }
                else {
                    watch.setBase(SystemClock.elapsedRealtime());
                    watch.start();
                    start = true;
                    ((Button)view).setText("Stop");
                }
            }
        });
    }
}
