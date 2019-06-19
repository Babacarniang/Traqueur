package com.example.traqueur.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RetrofitClient {

    public interface GitHubService {
        @GET("users/{user}/repos")
        Call<List<RetrofitClient>> listRepos(@Path("user") String user);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        Call<List<RetrofitClient>> repos = service.listRepos("octocat");
    }

}

