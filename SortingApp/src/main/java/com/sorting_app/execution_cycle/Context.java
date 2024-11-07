package com.sorting_app.execution_cycle;

import com.sorting_app.strategy.IStrategy;

public class Context {
    private IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void commandSelected() {
        strategy.generationResult();
    }
}
