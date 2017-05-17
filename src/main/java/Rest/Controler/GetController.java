package Rest.Controler;


import Rest.FillGitHub;
import Rest.GitHub.GitHub;
import Rest.GitHub.GitHubAbsence;
import Rest.RepoJson.RepoJson;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by bartosz.zielinski on 2017-02-10.
 */
@RestController
public class GetController {

    private static FillGitHub gitHub;
    private final static Logger LOGGER = Logger.getLogger(GetController.class.getName());


    @RequestMapping( method= RequestMethod.GET, value="/")
    public GitHubAbsence gitHubErrorRepositories ( ){
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Absence repository ");
        return new GitHubAbsence(4,"Absence repository in url : Please start url with repository");
    }

    @RequestMapping( method= RequestMethod.GET, value="/repositories")
    public GitHubAbsence gitHubErrorOwner ( ){
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Absence repository in url : Please start url with repository ");
        return new GitHubAbsence(3,"Absence Owner in url : Please write Owner and  Repository");
    }

    @RequestMapping( method= RequestMethod.GET, value="{repositories}")
    public GitHubAbsence gitHubErrorOwner (@PathVariable("repositories") String repositories ){
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Absence repository in url : Please start url with repositories not "+repositories);
        return new GitHubAbsence(2,"Absence repository in url : Please start url with repository not "+repositories);
    }

    @RequestMapping( method= RequestMethod.GET, value="/repositories/{owner}")
    public GitHubAbsence gitHubErrorRepositoryname (@PathVariable("owner") String owner ){
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Rest owner "+owner + "Absence Repository name ");
        return new GitHubAbsence(1,"Absence repository name in url : Please write Repository title of repository");
    }

    //curl -X GET   "http://localhost:8080/repositories/PayU/plugin_prestashop"
    // respond -> {"fullName":"PayU/plugin_prestashop","description":"PayU plugin for PrestaShop 1
    //.4, 1.5, 1.6 and 1.7","cloneUrl":"https://github.com/PayU/plugin_prestashop.git"
    //,"stars":34,"createdAt":"2012-06-29T15:46:17Z"}

    @RequestMapping( method= RequestMethod.GET, value="/repositories/{owner}/{repositoryname}")
    public Object gitHub (@PathVariable("owner") String owner , @PathVariable("repositoryname") String repositoryname ) {

        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Rest owner " + owner + " repositoryname :" + repositoryname);


        gitHub = new FillGitHub();
        //gitHub.autharizationGitHub();
        RepoJson repoJson = gitHub.fillGitHubRepository(owner, repositoryname);

        String fullname = repoJson.getFullName();
        String description = repoJson.getDescription();
        String cloneUrl = repoJson.getCloneUrl();
        int stars = repoJson.getStargazersCount();
        String createdAt = repoJson.getCreatedAt();

        if (fullname != null) {

            LOGGER.info("fullname :" + fullname +
                    " description :" + description +
                    " cloneUrl :" + cloneUrl +
                    " stars :" + stars +
                    " createdAt :" + createdAt);

            return new GitHub(fullname, description, cloneUrl, stars, createdAt);

        }else if (fullname==null) {
            LOGGER.info("Owner or repository name is incorrect");
            return new GitHubAbsence(6,"Owner or repository name is incorrect");

        }
        return new GitHubAbsence(7,"Other error");
    }

    }




