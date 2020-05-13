package com.example.restusingretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ToDoServices {
    @GET("todos")
    Call<List<ToDO>> listTodo();
}
