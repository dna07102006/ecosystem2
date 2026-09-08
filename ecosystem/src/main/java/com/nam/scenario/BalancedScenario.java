package com.nam.scenario;

public class BalancedScenario extends AbstractScenario {
    @Override
    public String getName() { return "Balanced Ecosystem"; }

    @Override
    protected int grassCount() { return 500; }

    @Override
    protected int rabbitCount() { return 25; }

    @Override
    protected int wolfCount() { return 5; }
}
