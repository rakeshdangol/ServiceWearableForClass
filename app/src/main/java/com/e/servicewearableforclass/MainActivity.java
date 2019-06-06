package com.e.servicewearableforclass;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {

    private Button btnDisplayNotification1;
    private Button btnDisplayNotification2;

    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnDisplayNotification1 = findViewById(R.id.btnFirst);
        btnDisplayNotification2 = findViewById(R.id.btnSecond);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        btnDisplayNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();

            }

            private void DisplayNotification() {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "Channel1")
                        .setSmallIcon(R.drawable.ic_insert_emoticon_black_24dp)
                        .setContentTitle("First Message")
                        .setContentText("This is First Message")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE);
                notificationManagerCompat.notify(1, builder.build());



            }

        });

        btnDisplayNotification2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();

            }

            private void DisplayNotification2() {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "Channel2")
                        .setSmallIcon(R.drawable.ic_insert_emoticon_black_24dp)
                        .setContentTitle("Second Message")
                        .setContentText("This is Second Message")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE);
                notificationManagerCompat.notify(2, builder.build());


            }
        }));

    }
}
