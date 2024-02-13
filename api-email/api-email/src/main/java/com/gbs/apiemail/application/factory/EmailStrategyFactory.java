package com.gbs.apiemail.application.factory;

import com.gbs.apiemail.application.interfaces.EmailStrategy;

import java.util.HashMap;
import java.util.Map;

public class EmailStrategyFactory {
    private Map<String, EmailStrategy> strategyMap = new HashMap<>();
    public void addStrategy(String key, EmailStrategy strategy) {
        strategyMap.put(key, strategy);
    }
    public EmailStrategy getStrategy(String key) {
        return strategyMap.get(key);
    }

}
