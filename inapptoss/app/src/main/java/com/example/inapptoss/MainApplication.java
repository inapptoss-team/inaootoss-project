// MainApplication.java
package com.example.inapptoss;

import android.app.Application;
import com.example.inapptoss.manager.game.GameManager; // Make sure this import is correct

public class MainApplication extends Application {

    private GameManager gameManager;

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize your GameManager here
        gameManager = new GameManager(this);
    }

    public GameManager getGameManager() {
        return gameManager;
    }
}
