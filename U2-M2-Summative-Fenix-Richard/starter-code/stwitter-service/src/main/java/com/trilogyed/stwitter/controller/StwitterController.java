package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.StwitterServiceLayer;
import com.trilogyed.stwitter.util.feign.PostClient;
import com.trilogyed.stwitter.viewmodel.StwitterViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class StwitterController {

    @Autowired
    // All DAOs for each model is created with ServiceLayer's constructor.
    private final StwitterServiceLayer serviceLayer;

    StwitterController(StwitterServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public StwitterViewModel createPost(@RequestBody @Valid StwitterViewModel stwitterViewModel) throws Exception {
        return serviceLayer.saveStwitterViewModel(stwitterViewModel);
    };

    @RequestMapping(value="/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public StwitterViewModel findPost(@PathVariable int id) throws Exception{
        StwitterViewModel stwitterViewModel = serviceLayer.findStwitterViewModel(id);
        if (stwitterViewModel == null) {
            throw new Exception("Post not found.");
        }
        return stwitterViewModel;
    }

    @RequestMapping(value = "/posts/user/{posterName}", method = RequestMethod.GET)
    public List<StwitterViewModel> findAllPostsForPosterName(@PathVariable String posterName){
        return serviceLayer.findAllPostsForPosterName(posterName);
    };

}
