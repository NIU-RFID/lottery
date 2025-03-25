package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mDrawButton;
    private TextView mResultTextView;

    private List<Integer> mNumbers = new ArrayList<>();
    private static final int MAX_NUMBER = 49;
    private static final int NUMBER_OF_PICKS = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawButton = findViewById(R.id.draw_button);
        mResultTextView = findViewById(R.id.result_text_view);

        for (int i = 1; i <= MAX_NUMBER; i++) {
            mNumbers.add(i);
        }

        mDrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(mNumbers, new Random());
                List<Integer> picks = mNumbers.subList(0, NUMBER_OF_PICKS);
                Collections.sort(picks);

                StringBuilder result = new StringBuilder();
                for (int i = 0; i < picks.size(); i++) {
                    result.append(picks.get(i));
                    if (i != picks.size() - 1) {
                        result.append(", ");
                    }
                }

                mResultTextView.setText(result.toString());
            }
        });
    }
}
