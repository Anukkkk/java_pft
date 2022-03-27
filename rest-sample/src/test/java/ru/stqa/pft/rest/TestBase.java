package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Executor;
import org.apache.http.message.BasicNameValuePair;
import org.testng.SkipException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static com.sun.javafx.runtime.async.BackgroundExecutor.getExecutor;

public class TestBase {

    public boolean isIssueOpen(int issueId) throws IOException {
        String issueById = getExecutor().execute(Request.Get(String.format("https://bugify.stqa.ru/api/%s.json", issueId)))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(issueById);
        JsonElement jsonIssues = parsed.getAsJsonObject().get("issues");
        Set<Issue> setIssues = new Gson().fromJson(jsonIssues, new TypeToken<Set<Issue>>() {}.getType());

        Issue selectedIssue = setIssues.iterator().next();
        System.out.println("state_name = " + selectedIssue.getStatus());

        if (selectedIssue.getStatus().equals("resolved") || selectedIssue.getStatus().equals("closed"))
    {
            return false;
    } else{return true;}
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    private Executor getExecutor() {
        return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
    }
}
