package learningspringboot;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class IssueController {

    private final IssueManager issueManager;


    @RequestMapping("/manager")
    public String index (final Model model){
        model.addAttribute("issues", issueManager.findOpenIssues());
        return "index";
    }
}
