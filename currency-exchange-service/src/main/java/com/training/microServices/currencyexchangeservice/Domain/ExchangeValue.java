package com.training.microServices.currencyexchangeservice.Domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
 @Table(name = "exchange")
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="from_value")
    private String from;

    @Column(name="to_value")
    private String to;

    @Column(name="conversion_multiple")
    private BigDecimal conversionMultiple;

    @Column(name="port_number")
    private int port;

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public ExchangeValue() {
    }

    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
