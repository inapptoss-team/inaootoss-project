package com.example.inapptoss.manager.game;

import android.content.Context;

// Correctly import all the manager classes from their expected packages
import com.example.inapptoss.manager.map.MapManager;
import com.example.inapptoss.manager.puzzle.PuzzleManager;
import com.example.inapptoss.manager.script.ScriptManager;
import com.example.inapptoss.manager.ui.UIManager;

public class GameManager {
    // These are all your custom manager classes
    private final PlayerManager playerManager;
    private final GameStateManager gameStateManager;
    private final ScriptManager scriptManager;
    private final UIManager uiManager;
    private final ResourceManager resourceManager; // Use your own ResourceManager
    private final MapManager mapManager;
    private final PuzzleManager puzzleManager;

    public GameManager(Context context) {
        // Instantiate your own managers
        this.resourceManager = new ResourceManager(context);
        this.uiManager = new UIManager();
        this.scriptManager = new ScriptManager(resourceManager);
        this.playerManager = new PlayerManager();
        this.gameStateManager = new GameStateManager(context);
        this.mapManager = new MapManager();
        this.puzzleManager = new PuzzleManager(scriptManager);
    }

    public void startGame() {
        // This assumes your MapManager will have a CallMap method
        if (mapManager != null) {
            mapManager.CallMap("lab_intro");
        }

        if (playerManager != null) {
            playerManager.setState(State.PlayerState.IN_GAME);
        }
    }

    public void saveProgress() {
        // This assumes your managers have these methods
        if (gameStateManager != null && playerManager != null) {
            gameStateManager.save(playerManager.getState());
        }
    }

    public void loadProgress() {
        // This assumes your managers have these methods
        if (playerManager != null && gameStateManager != null) {
            playerManager.setState(gameStateManager.load());
        }
    }
}
