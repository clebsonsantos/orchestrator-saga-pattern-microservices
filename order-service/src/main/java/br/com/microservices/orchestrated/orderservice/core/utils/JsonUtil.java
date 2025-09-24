package br.com.microservices.orchestrated.orderservice.core.utils;

import br.com.microservices.orchestrated.orderservice.core.document.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JsonUtil {

    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return this.objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            return "";
        }
    }

    public Event toEvent(String json) {
        try {
            return this.objectMapper.readValue(json, Event.class);
        } catch (Exception ex) {
            return null;
        }
    }
}
