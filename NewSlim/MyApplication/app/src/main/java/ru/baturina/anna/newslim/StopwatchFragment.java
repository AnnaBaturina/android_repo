package ru.baturina.anna.newslim;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StopwatchFragment extends Fragment implements View.OnClickListener {

    private static final String SECONDS = "seconds";
    private static final String IS_RUNNING = "isRunning";
    private static final String WAS_RUNNING = "wasRunning";

    private int seconds = 20;
    private boolean isRunning = false;
    private boolean wasRunning = false;

    Button buttonStart;
    TextView timeView;
    TextView instruction1;
    String time;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(SECONDS, seconds);
        savedInstanceState.putBoolean(IS_RUNNING, isRunning);
        savedInstanceState.putBoolean(WAS_RUNNING, wasRunning);
        super.onSaveInstanceState(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt(SECONDS);
            isRunning = savedInstanceState.getBoolean(IS_RUNNING);
            wasRunning = savedInstanceState.getBoolean(WAS_RUNNING);
        }

        View stopwatch_layout = inflater.inflate(R.layout.stopwatch_layout, container, false);
        //

        buttonStart = (Button) stopwatch_layout.findViewById(R.id.button_start);
        buttonStart.setOnClickListener(this);
        runTimer(stopwatch_layout);
        return stopwatch_layout;
    }


    public void onResume() {
        super.onResume();
        if (wasRunning) {
            isRunning = true;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button_start:
                seconds = 20;
                isRunning = true;
                break;


        }
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }



    private void runTimer(View view) {

        timeView = (TextView) view.findViewById(R.id.textView);


        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int secs = seconds;

                time = String.format("%02d", secs);
if (secs >0) {

    timeView.setText(time);

}
                if (isRunning) {
                    buttonStart.setTextSize(16);
                      buttonStart.setText(R.string.holdposition);
                        seconds--;
                    if (secs == 0) {
                        isRunning = false;
                        timeView.setText(R.string.great);

                        buttonStart.setText(R.string.repeat);
                    }
                }

                handler.postDelayed(this, 1000);
            }
        });

    }
}