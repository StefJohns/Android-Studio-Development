package io.github.stefjohns.signalsfrommars.UI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Stack;

import io.github.stefjohns.signalsfrommars.R;

import io.github.stefjohns.signalsfrommars.Model.Page;
import io.github.stefjohns.signalsfrommars.Model.Story;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    private Story story;
    private Page page;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choiceOneButton;
    private Button choiceTwoButton;
    private String name;
    private Intent intent;
    private Drawable image;
    private Stack<Integer> pageStack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = findViewById(R.id.storyImageView);
        storyTextView = findViewById(R.id.storyTextView);
        choiceOneButton = findViewById(R.id.choiceOneButton);
        choiceTwoButton = findViewById(R.id.choiceTwoButton);

        intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));
        Log.d(TAG, name);

        story = new Story();
        loadPage(0);

    }

    private void loadPage(int pageNumber) {
        pageStack.push(pageNumber);
        page = story.getPage(pageNumber);

        image = ContextCompat.getDrawable(this, page.getImageId());
        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextId());
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);

        if (page.isFinalPage()) {
            choiceOneButton.setVisibility(View.INVISIBLE);
            choiceTwoButton.setText(R.string.play_again_button_text);
            choiceTwoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        } else {
            loadButtons();
        }
    }

    private void loadButtons() {
        choiceOneButton.setVisibility(View.VISIBLE);
        choiceOneButton.setText(page.getChoice1().getTextId());
        choiceOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = page.getChoice1().getNextPage();
                loadPage(nextPage);
            }
        });

        choiceTwoButton.setVisibility(View.VISIBLE);
        choiceTwoButton.setText(page.getChoice2().getTextId());
        choiceTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = page.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if (pageStack.isEmpty()) {
            super.onBackPressed();
        }
        else {
            loadPage(pageStack.pop());
        }
    }
}
