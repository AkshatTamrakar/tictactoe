package com.akshat.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// Here Extend keyword is used so that we can use or have atrributes from a parent class(AppCompatActivity) in child class(AddPlayers)
public class AddPlayers extends AppCompatActivity {
    @Override // @Override annotation is used to indicate that a method in a subclass is intended to override a method from its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        EditText playerOne = findViewById(R.id.playerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);
        Button startGameButton = findViewById(R.id.startGameButton);

        // I have add TextWatcher have for text limit
        playerOne.addTextChangedListener(new TextLimitWatcher(playerOne, 10));
        playerTwo.addTextChangedListener(new TextLimitWatcher(playerTwo, 10));

        // Here this part of code will check weather players name is empty or not
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getPlayerOneName = playerOne.getText().toString();
                String getPlayerTwoName = playerTwo.getText().toString();
                if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                    Toast.makeText(AddPlayers.this, "Please enter player name", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                    intent.putExtra("playerOne", getPlayerOneName);
                    intent.putExtra("playerTwo", getPlayerTwoName);
                    startActivity(intent);
                }
            }
        });


        // This is Toast Method this display Warning
//     Toast.makeText(AddPlayers.this, "Warning! Game is Under Development Mode.", Toast.LENGTH_LONG).show();

        // Here I have credits_button renamed as about in Layout.
        Button credits_button = findViewById(R.id.credits_button);
        credits_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(AddPlayers.this, credits.class);
                startActivity(iNext);
            }
        });
    }

    // Interface(implement TextWatcher) is used to apply or implement attributes from another class(TextWatcher). This is Example of Inheritance.
    private class TextLimitWatcher implements TextWatcher {
        private final EditText editText;
        private final int maxLength;

        public TextLimitWatcher(EditText editText, int maxLength) {
            this.editText = editText;
            this.maxLength = maxLength;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() > maxLength) {
                s.delete(maxLength, s.length());
            }
        }
    }
}
