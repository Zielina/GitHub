package Rest.GitHub;

/**
 * Created by bartosz.zielinski on 2017-02-14.
 */
public class GitHubRest {

    private GitHub gitHub;
    private GitHubAbsence gitHubAbsence;


    public GitHubRest(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    public GitHubRest(GitHubAbsence gitHubAbsence) {
        this.gitHubAbsence = gitHubAbsence;
    }

    public GitHub getGitHub() {
        return gitHub;
    }

    public GitHubAbsence getGitHubAbsence() {
        return gitHubAbsence;
    }

    public void setGitHub(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    public void setGitHubAbsence(GitHubAbsence gitHubAbsence) {
        this.gitHubAbsence = gitHubAbsence;
    }
}
