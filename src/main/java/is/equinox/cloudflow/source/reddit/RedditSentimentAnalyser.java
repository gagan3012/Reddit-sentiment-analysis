package is.equinox.cloudflow.source.reddit;

import net.dean.jraw.models.PublicContribution;
import net.dean.jraw.tree.CommentNode;

import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;
public class RedditSentimentAnalyser {

    public Stream<SentimentScore> analyze(Stream<CommentNode<PublicContribution<?>>> textStream) {
        return textStream.map(comment -> {
            String txt = comment.getSubject().getBody();

            if (txt == null){
                return null;
            }
            txt.trim().replaceAll("http.*?[\\S]+", "")
                    .replaceAll("@[\\S]+", "")
                    .replaceAll("#", "")
                    .replaceAll("[\\s]+", " ");

            RedditSentiment analyser = new RedditSentiment();
            String id = comment.getSubject().getId();
            Date created = comment.getSubject().getCreated();
            SentimentType polarity = analyser.analyseReddit(txt);
            int weight = comment.getSubject().getScore();

            return new SentimentScore(created, id, polarity, weight,txt);
        });
    }
}

