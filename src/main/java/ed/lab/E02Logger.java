package ed.lab;

import java.util.HashMap;
import java.util.Map;

public class E02Logger {

    private final Map<String, Integer> messageTimestamps;

    public E02Logger() {
        this.messageTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message)) {
            // Primer vez que vemos este mensaje
            messageTimestamps.put(message, timestamp);
            return true;
        }

        int lastPrinted = messageTimestamps.get(message);
        if (timestamp - lastPrinted >= 10) {
            // Han pasado al menos 10 segundos, se puede imprimir
            messageTimestamps.put(message, timestamp);
            return true;
        }

        // No han pasado 10 segundos, no se puede imprimir
        return false;
    }
}
