package com.example.gamerx.Model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model(){

    }

    List<Post> data = new LinkedList<Post>();
}
