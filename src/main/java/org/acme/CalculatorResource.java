package org.acme;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.io.InputStream;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/calculate")
public class CalculatorResource {

    @Inject
    CalculatorAiService calculatorAiService;
    
    @Inject
    ObjectMapper objectMapper;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String calculate(String jsonBody) {
        try {
            System.out.println("Received raw JSON: " + jsonBody);
            CalculationRequest request = objectMapper.readValue(jsonBody, CalculationRequest.class);
            System.out.println("Parsed request: " + request);
            
            var result = calculatorAiService.calculate(
                request.operator1(), 
                request.operator2(), 
                request.operation()
            );
            
            System.out.println("Result: " + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
