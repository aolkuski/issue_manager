package data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.social.github.api.GitHubIssue;


@AllArgsConstructor
@Getter
public class Issue {

    private String repo;
    private GitHubIssue githubIssue;

}
