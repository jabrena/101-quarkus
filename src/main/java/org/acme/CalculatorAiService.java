package org.acme;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = MCPCalculator.class)
public interface CalculatorAiService {

    @SystemMessage("You are a calculator that can perform basic arithmetic operations.")
    @UserMessage(
        """
        Given the operator1 '{operator1}' and operator2 '{operator2}' and operation '{operation}', calculate the result.
        """)
    String calculate(String operator1, String operator2, String operation);
}