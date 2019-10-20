package com.company.RichardFenixU1Capstone.dto;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {
    @Size(max = 20)
    private String productType;
    // fee can be null;
    private BigDecimal fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return getProductType().equals(that.getProductType()) &&
                Objects.equals(getFee(), that.getFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductType(), getFee());
    }
}
