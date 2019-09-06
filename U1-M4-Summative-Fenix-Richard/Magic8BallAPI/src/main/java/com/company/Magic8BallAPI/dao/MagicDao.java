package com.company.Magic8BallAPI.dao;

public class MagicDao {

    private String[] responseArray = new String[20];

    // Constructor will create responseArray when class is instantiated.
    // We create the list of 20 responses in DAO implementation file since we do not have a database.
    // This serves as in memory DAO.
    public MagicDao() {
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

    public String get(int i){
        return responseArray[i];
    }
}