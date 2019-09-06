package com.company.Magic8BallAPI.controller;

import com.company.Magic8BallAPI.dao.MagicDao;
import com.company.Magic8BallAPI.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Magic8Controller {

    // We instantiate MagicDao to get the response list and get() method into this controller
    private static MagicDao magicDao = new MagicDao();

    // Create Answer object to store both question and the random magic-8-ball response.
    private static Answer answer = new Answer();

    // We create list to store Answer objects.
    private static List<Answer> answerList = new ArrayList<>();

    @PostMapping(path="/magic")
    @ResponseStatus(value= HttpStatus.CREATED)
    public Answer getAnswer(@RequestBody String question){

        Random random = new Random();

        // get the random index based on the response array. Since we have 20 responses, we set bound to 20.
        int i = random.nextInt(20);
        System.out.println("Index of response is " + i);

        answer.setQuestion(question);
        answer.setAnswer(magicDao.get(i));

        // Save question and answer in answer list.
        answerList.add(answer);

        // Return both question and answer as an object;
        return answer;
    }

    // Extra controller to display list of questions and answers in memory.
    @GetMapping (path ="/magic")
    @ResponseStatus(value= HttpStatus.OK)
    public List<Answer> getAnswers(){

        return answerList;
    }

}
