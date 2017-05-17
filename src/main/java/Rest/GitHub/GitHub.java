package Rest.GitHub;


/**
 * Created by bartosz.zielinski on 2017-02-12.
 */
public class GitHub {

    private  String fullName ;
    private  String description;
    private  String cloneUrl;
    private  int stars;
    private  String createdAt;

    public GitHub(String fullName, String description, String cloneUrl, int stars, String createdAt) {
        this.fullName = fullName;
        this.description = description;
        this.cloneUrl = cloneUrl;
        this.stars = stars;
        this.createdAt = createdAt;
    }


    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public int getStars() {
        return stars;
    }

    public String getCreatedAt() {
        return createdAt;
    }

}
