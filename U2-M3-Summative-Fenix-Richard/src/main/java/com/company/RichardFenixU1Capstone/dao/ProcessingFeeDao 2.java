package com.company.RichardFenixU1Capstone.dao;

import com.company.RichardFenixU1Capstone.dto.ProcessingFee;

import java.util.List;

public interface ProcessingFeeDao {
    ProcessingFee addProcessingFee(ProcessingFee processingFee);

    ProcessingFee getProcessingFee(String productType);

    List<ProcessingFee> getAllProcessingFees();

    void updateProcessingFee(ProcessingFee processingFee);

    void deleteProcessingFee(String productType);

}
