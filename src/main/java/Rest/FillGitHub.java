package Rest;

import Rest.Controler.GetController;
import Rest.GitHub.GitHub;
import Rest.RepoJson.RepoJson;
import ch.qos.logback.classic.Level;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by bartosz.zielinski on 2017-02-12.
 */
public class FillGitHub {


    private final static Logger logFillGitHub = Logger.getLogger(FillGitHub.class.getName());
    private String oauth_token;

    public void autharizationGitHub (){
        try {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://api.github.com/Zielina/whmcs_payu?client_id=7b2ca377239c78534cac&client_secret=8041694f5e15aa76e63c43dc2ae5cdb2eb7bf2ab");

        HttpResponse response =client.execute(httpGet);
        System.out.println(EntityUtils.toString(response.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public  RepoJson fillGitHubRepository(String owners , String reponame) {
            logFillGitHub.info("FillGitHubRepository owners :"+owners);
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

            String jsonEntity=httpClientRest(owners,reponame);
            RepoJson repoJson =gson.fromJson(jsonEntity,RepoJson.class);
            return repoJson;
    }

    private String httpClientRest(String owners,String reponame){

            String jsonEntity = null;
            try {
                HttpClient client = HttpClientBuilder.create().build();

                HttpGet httpGet = new HttpGet("https://api.github.com/repos/"+owners+"/"+reponame);
                //httpGet.setHeader("Zielina: ","ed0b71699941abaefe916c56070ee73c0a9be61e");
                HttpResponse response =client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                jsonEntity = EntityUtils.toString(entity);
                System.out.println(jsonEntity);
            } catch (IOException e) {
                logFillGitHub.info("Exception :: " + e.getMessage());
            }

            return jsonEntity;

    }

}
