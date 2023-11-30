package com.poec.crm.model;

import java.math.BigInteger;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "type_presta")
    private String typePresta;

    private String designation;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "nb_days")
    private Integer nbDays;

    @Column(name = "unit_price", columnDefinition = "NUMERIC")
    private BigInteger unitPrice;
    @Column(name = "total_exclude_taxe", columnDefinition = "NUMERIC")
    private BigInteger totalExcludeTaxe;
    @Column (name = "total_with_taxe", columnDefinition = "NUMERIC")
    private Double totalWithTaxe;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="state", columnDefinition = "int4")
    private OrderStatus status;




    public Order() {
    }


    public Order(Integer Id, String typePresta, String designation, Client client, Integer nbDays, BigInteger unitPrice, BigInteger totalExcludeTaxe, Double totalWithTaxe, OrderStatus status) {
        this.Id = Id;
        this.typePresta = typePresta;
        this.designation = designation;
        this.client = client;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.totalExcludeTaxe = totalExcludeTaxe;
        this.totalWithTaxe = totalWithTaxe;
        this.status = status;
    }


    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getTypePresta() {
        return this.typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getNbDays() {
        return this.nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public BigInteger getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(BigInteger unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigInteger getTotalExcludeTaxe() {
        return this.totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(BigInteger totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Double getTotalWithTaxe() {
        return this.totalWithTaxe;
    }

    public void setTotalWithTaxe(Double totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", typePresta='" + getTypePresta() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", client='" + getClient() + "'" +
            ", nbDays='" + getNbDays() + "'" +
            ", unitPrice='" + getUnitPrice() + "'" +
            ", totalExcludeTaxe='" + getTotalExcludeTaxe() + "'" +
            ", totalWithTaxe='" + getTotalWithTaxe() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }



}
