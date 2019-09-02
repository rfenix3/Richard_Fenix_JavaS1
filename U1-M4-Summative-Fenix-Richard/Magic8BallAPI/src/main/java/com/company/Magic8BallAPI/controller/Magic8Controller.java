package com.company.Magic8BallAPI.controller;

import com.company.Magic8BallAPI.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Magic8Controller {

    // List to store question and answer objects in a list.
    List<Answer> answerList = new ArrayList<>();

    // Create array to store magic-8-ball responses.
    String[] responseArray = new String[20];

    // Create initialization block to initialize variables. The function below is run only once.
    {
        responseArray[0] = "As I see it, yes.";
        responseArray[1] = "Ask again later.";
        responseArray[2] = "Better not tell you now.";
        responseArray[3] = "Cannot predict now";
        responseArray[4] = "Concentrate and ask again.";
        responseArray[5] = "Don't count on it.";
        responseArray[6] = "It is certain.";
        responseArray[7] = "It is decidedly so.";
        responseArray[8] = "Most likely.";
        responseArray[9] = "My reply is no.";
        responseArray[10] = "My sources say no.";
        responseArray[11] = "Outlook not so good.";
        responseArray[12] = "Outlook good.";
        responseArray[13] = "Reply is hazy, try again.";
        responseArray[14] = "Signs point to yes.";
        responseArray[15] = "Very doubtful.";
        responseArray[16] = "Without a doubt.";
        responseArray[17] = "Yes.";
        responseArray[18] = "Yes - definitely.";
        responseArray[19] = "You may rely on it.";
    }

    @PostMapping(path="/magic")
    @ResponseStatus(value= HttpStatus.CREATED)
    public Answer getAnswer(@RequestBody String question){

        Random random = new Random();

        // get the number of objects in responseArray;
        int arrayLength = responseArray.length;
        System.out.println("responseArray length: " + arrayLength);

        if (arrayLength == -1){
            throw new NullPointerException("There are no magic-8 responses available.");
        }

        // get the random index based on the response array.
        int i = random.nextInt(arrayLength);
        System.out.println("Index of response " + i + " out of total Words of " + arrayLength);

        // Create Answer object to store both question and the random magic-8-ball response.
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setAnswer(responseArray[i]);

        // Save question and answer in answer list.
        answerList.add(answer);

        return answer;
    }

    // Extra controller to display list of questions and answers in memory.
    @GetMapping (path ="/magic")
    @ResponseStatus(value= HttpStatus.OK)
    public List<Answer> getAnswers(){

        return answerList;
    }

}
