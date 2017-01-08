package org.talcrafts.digigyan.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class LBlockContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<LBlock> ITEMS = new ArrayList<LBlock>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, LBlock> ITEM_MAP = new HashMap<String, LBlock>();

    private static final int COUNT = 25;
    private static AtomicInteger item_no=new AtomicInteger(0);

    static {


        // Read all files sorted into the values-array
        File dir = new File("/");
        if (!dir.canRead()) {
            //setTitle(dir.toString() + " (inaccessible)");
        }
        String[] list = dir.list();
        if (list != null) {
            for (String file : list) {
                if (!file.startsWith(".")) {
                    addItem(createLBlock(file));
                }
            }
        }
    }

    private static void addItem(LBlock item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static LBlock createDummyItem(int position) {
        return new LBlock(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static LBlock createLBlock(String fileName) {
        return new LBlock(String.valueOf(item_no.incrementAndGet()), "LBlock: " + fileName, makeLBlockDetails(fileName));
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    private static String makeLBlockDetails(String fileName) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(fileName);
        builder.append("\nMore details information here about" + fileName);
        return builder.toString();
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class LBlock {
        public final String id;
        public final String content;
        public final String details;

        public LBlock(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
