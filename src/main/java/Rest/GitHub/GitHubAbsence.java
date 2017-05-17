package Rest.GitHub;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bartosz.zielinski on 2017-02-13.
 */
public class GitHubAbsence {

    private int error;
    private String errorMessage;

    public GitHubAbsence(int error, String errorMessage) {
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
