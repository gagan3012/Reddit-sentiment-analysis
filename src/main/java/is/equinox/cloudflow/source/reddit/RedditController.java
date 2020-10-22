package is.equinox.cloudflow.source.reddit;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


@SpringBootApplication
@RestController
public class RedditController {
    @GetMapping(path = "/reddit/{subR}/{n}/{search}")
    public String controller(@PathVariable String subR, @PathVariable int n, @PathVariable String search) throws FileNotFoundException {
        RedditStream output = new RedditStream();
        String data = output.queryReddit(subR, n, search);
        try (PrintStream out = new PrintStream(new FileOutputStream("data.csv"))) {
            out.print(data);
        }
        return data;
    }
}




