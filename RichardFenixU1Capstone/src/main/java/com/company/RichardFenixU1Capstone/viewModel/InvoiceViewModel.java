package com.company.RichardFenixU1Capstone.viewModel;

import com.company.RichardFenixU1Capstone.dto.Console;
import com.company.RichardFenixU1Capstone.dto.Game;
import com.company.RichardFenixU1Capstone.dto.TShirt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InvoiceViewModel {
    private int invoiceId;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private List<Console> consoleList = new ArrayList<>();
    private List<Game> gameList = new ArrayList<>();
    private List<TShirt> tShirtList = new ArrayList<>();

    /*
    The itemIds will be the consoleId, gameId, and tShirtId;
    private int itemIds;

   The unitPrice will be the price for each table row price.
    private BigDecimal unitPrice;
     */

    private int quantity;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
    private BigDecimal total;
}
