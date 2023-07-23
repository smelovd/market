import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Action {
    private static final TreeMap<Integer, Integer> bidList = new TreeMap<>();
    private static final TreeMap<Integer, Integer> askList = new TreeMap<>();
    protected static void update(String action, String price, String size) {
        switch (action) {
            case "bid" -> // add to bid list
                    bidList.put(Integer.parseInt(price), Integer.parseInt(size));

            case "ask" -> // add to ask list
                    askList.put(Integer.parseInt(price), Integer.parseInt(size));
        }

    }

    protected static void operation(String action, String size) {
        switch (action) {
            case "sell" -> // sell n-size
                    bidList.replace(bidList.lastKey(), bidList.lastEntry().getValue() - Integer.parseInt(size));
            case "buy" -> // buy n-size
                    askList.replace(askList.firstKey(), askList.firstEntry().getValue() - Integer.parseInt(size));
        }
    }

    protected static void question(String action, FileWriter output) throws IOException {
        switch (action) {
            case "best_bid" -> // out print best bid // more expensive in bid
                    output.write(bidList.lastKey() + "," + bidList.lastEntry().getValue() + "\n");
            case "best_ask" -> // out print best ask // cheapest in ask
                    output.write(askList.firstKey() + "," + askList.firstEntry().getValue() + "\n");
        }
    }

    protected static void questionSize(String size, FileWriter output) throws IOException {


        int i = 0;

        for (Map.Entry<Integer, Integer> entry : bidList.entrySet()) {

            if (entry.getKey() == Integer.parseInt(size)){
                i++;
                output.write(entry.getValue() + "\n");
                break;
            }
        }
        for (Map.Entry<Integer, Integer> entry : askList.entrySet()) {

            if (entry.getKey() == Integer.parseInt(size)) {
                i++;
                output.write(entry.getValue() + "\n");
                break;
            }
        }
        if (i == 0) {
            output.write("0" + "\n");
        }
    }
}
