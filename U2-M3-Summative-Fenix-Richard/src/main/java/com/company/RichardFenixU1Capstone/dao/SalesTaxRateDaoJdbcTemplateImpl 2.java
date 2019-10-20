package com.company.RichardFenixU1Capstone.dao;

import com.company.RichardFenixU1Capstone.dto.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxRateDaoJdbcTemplateImpl implements SalesTaxRateDao{

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_SALES_TAX_RATE_SQL =
            "insert into sales_tax_rate (state, rate) values (?, ?)";

    private static final String SELECT_SALES_TAX_RATE_SQL =
            "select * from sales_tax_rate where state = ?";

    private static final String SELECT_ALL_SALES_TAX_RATES_SQL =
            "select * from sales_tax_rate";

    private static final String UPDATE_SALES_TAX_RATE_SQL =
            "update sales_tax_rate set rate = ? where state = ?";

    private static final String DELETE_SALES_TAX_RATE_SQL =
            "delete from sales_tax_rate where state =  ?";

    @Autowired
    public SalesTaxRateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SalesTaxRateDaoJdbcTemplateImpl() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("AL");
        salesTaxRate.setRate(new BigDecimal("0.05"));
        this.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setState("AK");
        salesTaxRate.setRate(new BigDecimal("0.06"));
        this.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setState("AZ");
        salesTaxRate.setRate(new BigDecimal("0.04"));
        this.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setState("AR");
        salesTaxRate.setRate(new BigDecimal("0.06"));
        this.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setState("CA");
        salesTaxRate.setRate(new BigDecimal("0.06"));
        this.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setState("CO");
        salesTaxRate.setRate(new BigDecimal("0.04"));
        this.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setState("CT");
        salesTaxRate.setRate(new BigDecimal("0.03"));
        this.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setState("DE");
        salesTaxRate.setRate(new BigDecimal("0.05"));
        this.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setState("FL");
        salesTaxRate.setRate(new BigDecimal("0.06"));
        this.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setState("GA");
        salesTaxRate.setRate(new BigDecimal("0.07"));
        this.addSalesTaxRate(salesTaxRate);

    }

    @Override
    @Transactional
    public SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(
                INSERT_SALES_TAX_RATE_SQL,
                salesTaxRate.getState(),
                salesTaxRate.getRate());

        // Since table has natural composite primary key (no DB-generated id), code below is not needed
        // int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        //salesTaxRate.setProductType(id);

        return salesTaxRate;
    }

    @Override
    public SalesTaxRate getSalesTaxRate(String state) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_SALES_TAX_RATE_SQL,
                    this::mapRowToSalesTaxRate,
                    state);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }
    }

    @Override
    public List<SalesTaxRate> getAllSalesTaxRates() {
        return jdbcTemplate.query(
                SELECT_ALL_SALES_TAX_RATES_SQL,
                this::mapRowToSalesTaxRate);
    }

    @Override
    public void updateSalesTaxRate(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(
                UPDATE_SALES_TAX_RATE_SQL,
                salesTaxRate.getRate(),
                salesTaxRate.getState());

    }

    @Override
    public void deleteSalesTaxRate(String state) {
        jdbcTemplate.update(DELETE_SALES_TAX_RATE_SQL, state);
    }

    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState(rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate"));

        return salesTaxRate;
    }

}
