package com.company.RichardFenixU1Capstone.dao;

import com.company.RichardFenixU1Capstone.dto.Invoice;
import java.util.List;

public interface InvoiceDao {
    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int id);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int id);

//    List<Invoice> getInvoiceByItemType(String itemType);

}
