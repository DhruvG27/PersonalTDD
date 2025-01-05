package org.strategies;

import org.strategies.HitStrategy;

public class RulesFactory {

    private final HitStrategy hitStrategy;
    private final GameWinStrategy gameWinStrategy;
    private final NewGameStrategy newGameStrategy;

    public RulesFactory() {
        this.hitStrategy = new BasicHitStrategy();
        this.gameWinStrategy = new PlayerWinsOnTieStrategy();
        this.newGameStrategy = new InternationalNewGameStrategy();
    }

    public RulesFactory(HitStrategy hitStrategy, GameWinStrategy gameWinStrategy, NewGameStrategy newGameStrategy) {
        this.hitStrategy = hitStrategy;
        this.gameWinStrategy = gameWinStrategy;
        this.newGameStrategy = newGameStrategy;
    }

    public HitStrategy getHitStrategy() {
        return hitStrategy;
    }

    public GameWinStrategy getGameWinStrategy() {
        return gameWinStrategy;
    }

    public NewGameStrategy getNewGameStrategy() {
        return newGameStrategy;
    }
}
