package org.strategies;

public class RulesFactory {

    private final HitStrategy hitStrategy;

    public RulesFactory() {
        this.hitStrategy = new Soft17HitStrategy(); // Default strategy
    }

    public RulesFactory(HitStrategy hitStrategy) {
        this.hitStrategy = hitStrategy != null ? hitStrategy : new Soft17HitStrategy();
    }

    public HitStrategy getHitStrategy() {
        return hitStrategy;
    }
}
