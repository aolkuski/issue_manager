package learningspringboot;

import data.Issue;
import lombok.RequiredArgsConstructor;
import org.springframework.social.github.api.GitHubIssue;
import org.springframework.social.github.api.impl.GitHubTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@ConfigurationProperties(prefix = "manager")
@RequiredArgsConstructor
public class IssueManager {

    private final IssueManagerConfiguration config;


    public List<Issue> findOpenIssues(){
        GitHubTemplate gitHubTemplate = new GitHubTemplate(config.getGithubToken());
        List<Issue> openIssues = new ArrayList<>();

        for(String repo: config.getRepos()){
            final List<GitHubIssue> issues = gitHubTemplate.repoOperations().getIssues(config.getOrg(), repo);
            List<Issue> openedIssuesPerRepo = issues.stream()
                    .filter(i -> i.getState().equalsIgnoreCase("open"))
                    .map(i -> new Issue(repo, i))
                    .collect(Collectors.toList());
            openIssues.addAll(openedIssuesPerRepo);
        }

        return openIssues;
    }

}
