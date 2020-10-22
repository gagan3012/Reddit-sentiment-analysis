package is.equinox.cloudflow.source.reddit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

//@SpringBootApplication
///@EnableBinding(Source.class)
public class RedditInterface {
    Logger logger = LoggerFactory.getLogger(RedditInterface.class);

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT,poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
    public MessageSource<String> RedditData() {
        RedditStream output = new RedditStream();
        String reddit = output.queryReddit("AFR100",1,"stock");
        logger.info("\n\n {}",reddit );
        return ()-> MessageBuilder.withPayload(reddit).build();
    }

}
