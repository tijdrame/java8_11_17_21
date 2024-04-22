package lets_get_certified.lambdas.collections;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class BasicsCollections {
    public static void main(String[] args) {
        Map<String, Integer> channelToSubscribers = new TreeMap<>(); // channelName, numSubscribers
        Map<String, String> channelToPublisher = new TreeMap<>(); // channelName, publisher
        Map<String, Integer> publisherToSubscribers = new TreeMap<>(); // publisher, numSubscribers

        // channel -> number of subscribers (K, V1)
        channelToSubscribers.put("JustForLaughs", 120_000);
        channelToSubscribers.put("JustForGags", 10_000);
        channelToSubscribers.put("ContemplationTechniques", 10_000);
        channelToSubscribers.put("A New Earth", 20_000);

        // channel -> publisher (K, V2)
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        channelToSubscribers.forEach((channel, numSubscribers) -> {
            String publisher = channelToPublisher.get(channel);
            if(publisherToSubscribers.containsKey(publisher)){
                int currentSubs = publisherToSubscribers.get(publisher);
                int newVal = currentSubs + numSubscribers;
                publisherToSubscribers.put(publisher, newVal);
            }else {
                publisherToSubscribers.put(publisher, numSubscribers);
            }
        });
        publisherToSubscribers.forEach((k,v) -> System.out.println(String.format("publisher: %s - numSubscribers: %s", k, v)));

        int minSubscribers = Collections.min(publisherToSubscribers.values());
        int maxSubscribers = Collections.max(publisherToSubscribers.values());
        publisherToSubscribers.forEach((publisher,numSubscribers) -> {
            if (numSubscribers == maxSubscribers) {
                System.out.println(String.format("Publisher with most subscribers: %s with value: %s",publisher, numSubscribers));
            }else if (numSubscribers == minSubscribers) {
                System.out.println(String.format("Publisher with fewer subscribers: %s with value: %s",publisher, numSubscribers));
            }
        });
    }
}
