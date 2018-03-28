package io.github.stefjohns.randomfacts;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class RandomFactActivity extends AppCompatActivity {
    // Initiate new Class Objects
    private String TAG = RandomFactActivity.class.getSimpleName();
    private FactBook factBook = new FactBook();
    private ColorWheel colorWheel = new ColorWheel();
    // Declare View Variables
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_fact);

        // Assign Views to Corresponding Variables
        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);
        relativeLayout = findViewById(R.id.relativeLayout);

        // Initiate onClickListener for showFactButton
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = factBook.getFact();
                Integer color = colorWheel.getColor();
                // Update View With New Fact
                factTextView.setText(fact);

                // Update View Background with new Color
                relativeLayout.setBackgroundColor(color);

                // Update Button Text Color
                showFactButton.setTextColor(color);
            }
        };
        showFactButton.setOnClickListener(listener);

        // Log Debugger
        Log.d(TAG, "Activity Created!");
    }
}
