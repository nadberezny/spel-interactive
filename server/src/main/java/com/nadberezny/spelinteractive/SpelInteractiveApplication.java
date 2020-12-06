package com.nadberezny.spelinteractive;

import com.nadberezny.spelinteractive.parser.Parser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpelInteractiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpelInteractiveApplication.class, args);
		Parser parser = new Parser();

		StandardEvaluationContext context = new StandardEvaluationContext();
		context.setVariable("myVar", 42);

		SpelExpression spelExpression = parser.parseRaw("43L");
		Expression expression = parser.parse("2 * #myVar");

		System.out.println(
				spelExpression.getValue()
		);
		System.out.println(
				spelExpression.getValueType()
		);

		System.out.println(
				expression.getValue(context)
		);
		System.out.println(
				expression.getValueType(context)
		);

	}

	@GetMapping("/eval")
	public String eval(@RequestParam(value = "expression") String expression) {
//		return String.format("Hello %s!", expression);
		Parser parser = new Parser();
		Expression result = parser.parse(expression);
		return result.getValue().toString();
	}
}
