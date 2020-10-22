package is.equinox.cloudflow.source.reddit;


import java.util.Date;


class SentimentScore {
    private final Date timestamp;
    private final String id;
    private final SentimentType polarity;
    private final String text;
    private final int weight;

    SentimentScore(Date timestamp, String id, SentimentType polarity, int weight, String text) {
        this.timestamp = timestamp;
        this.id = id;
        this.polarity = polarity;
        this.weight = weight;
        this.text = text;
    }

    Date getTimestamp() {
        return timestamp;
    }

    String getId() {
        return id;
    }

    SentimentType getPolarity() {
        return polarity;
    }

    int getWeight() {
        return weight;
    }

    String getText(){ return  text;}

    @Override
    public String toString() {
        return timestamp +
                "," + text +
                "," + id +
                "," + polarity +
                "," + weight + "\n";
    }

}


