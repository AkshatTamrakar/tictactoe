package com.akshat.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Extends means ResultDialog properties come from Dialog class. It creates a dialog window.
public class ResultDialog extends Dialog {

    private final String message; // To store the message to be displayed in the dialog (eg. Result of game)
    private final MainActivity mainActivity;
    private final Context context; // Add a context field


    // This is Constructor for "ResultDialog" that takes 3 Parameters: "context", "message", "MainActivity"
    public ResultDialog(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.context = context; // Initialize the context field
        this.message = message;
        this.mainActivity = mainActivity;
    }


    // This is called the method. It sets the content view to a layout XML named "activity_result_dialog"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);

        TextView messageText = findViewById(R.id.messageText);
        Button startAgainButton = findViewById(R.id.startAgainButton);

        messageText.setText(message);


        //This is home button. When the button is clicked, it creates an Intent to start the AddPlayers activity.
        Button home;
        home = findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(context, AddPlayers.class); // Use the context field here
                context.startActivity(iNext); // Use context to start the activity
            }
        });


        // This is Start Again Button.  When clicked, it calls the restartMatch method in MainActivity to restart the game.
        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restartMatch();
                dismiss();// Close the dialog box.
            }
        });
    }
}
