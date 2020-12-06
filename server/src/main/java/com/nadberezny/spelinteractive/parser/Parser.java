package com.nadberezny.spelinteractive.parser;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Parser {
    SpelExpressionParser parser = new SpelExpressionParser();

    public SpelExpression parseRaw(String str) {
//        parser.parseExpression("");
        return parser.parseRaw(str);
    }

    public Expression parse(String str) {
        return parser.parseExpression(str);
    }
}
