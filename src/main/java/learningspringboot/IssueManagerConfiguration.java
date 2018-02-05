package learningspringboot;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "manager")
public class IssueManagerConfiguration {

    private String org;
    private String githubToken;
    private String[] repos;

}
