import { GameManager } from './gameManager.js';
import { MapManager } from './mapManager.js';
import { PuzzleManager } from './puzzleManager.js';
import { UIManager } from './uiManager.js';

document.querySelectorAll('.click-area').forEach(el => {
    el.addEventListener('click', () => {
        const action = el.dataset.action;
        UIManager.handleClick(action);
    });
});

document.getElementById('close-puzzle').addEventListener('click', () => {
    PuzzleManager.closePuzzle();
});
