package uk.co.mruoc.race;

public class DefaultTrackDistanceProvider extends DefaultDistanceProvider {

    public DefaultTrackDistanceProvider() {
        add("0-1", 800d);
        add("1-2", 1200d);
        add("2-3", 300d);
        add("3-6", 700d);
        add("6-7", 800d);
        add("7-8", 1200d);
        add("8-9", 400d);
        add("9-0", 600d);

        add("3-4", 200d);
        add("4-5", 200d);
        add("5-6", 500d);
    }

}
