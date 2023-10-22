package net.cerveny.DataParsing;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Movement {
    byte qualifier;
    long assignedAccountNumber;
    long accountNumber;
    long documentNumber;
    double ammount;
    byte billingCode;
    long variableSymbol;
    long constantSymbol;
    long specificSymbol;
    String clientName;
    short currencyCode;
    Date dueDate;

    public Movement(String data) throws Exception {
        this.qualifier = Byte.parseByte(data.substring(0, 3));
        this.assignedAccountNumber = Long.parseLong(data.substring(3, 19));
        this.accountNumber = Long.parseLong(data.substring(19, 35));
        this.documentNumber = Long.parseLong(data.substring(35, 48));
        this.ammount = Double.parseDouble(data.substring(48, 60));
        this.billingCode = Byte.parseByte(data.substring(60, 61));
        this.variableSymbol = Long.parseLong(data.substring(61, 71));
        this.constantSymbol = Long.parseLong(data.substring(71, 81));
        this.specificSymbol = Long.parseLong(data.substring(81, 91));
        this.clientName = data.substring(97, 117).trim();
        this.currencyCode = Short.parseShort(data.substring(118, 122));
        this.dueDate = StringToDate(data.substring(122, 128));
    }

    public String toString() {
        return String.format(
                "{\"qualifier\":\"%s\",\"assignedAccountNumber\":\"%s\",\"accountNumber\":\"%s\",\"documentNumber\":\"%s\",\"ammount\":\"%s\",\"billingCode\":\"%s\",\"variableSymbol\":\"%s\",\"constantSymbol\":\"%s\",\"specificSymbol\":\"%s\",\"clientName\":\"%s\",\"currencyCode\":\"%s\",\"dueDate\":\"%s\"}",
                this.qualifier, this.assignedAccountNumber, this.accountNumber, this.documentNumber, this.ammount,
                this.billingCode, this.variableSymbol, this.constantSymbol, this.specificSymbol, this.clientName,
                this.currencyCode, this.dueDate);
    }

    public Document toDoc() {
        Document doc = new Document("_id", new ObjectId())
                .append("qualifier", this.qualifier)
                .append("assignedAccountNumber", this.assignedAccountNumber)
                .append("accountNumber", this.accountNumber)
                .append("documentNumber", this.documentNumber)
                .append("ammount", this.ammount)
                .append("billingCode", this.billingCode)
                .append("variableSymbol", this.variableSymbol)
                .append("constantSymbol", this.constantSymbol)
                .append("specificSymbol", this.specificSymbol)
                .append("clientName", this.clientName)
                .append("currencyCode", this.currencyCode)
                .append("dueDate", this.dueDate);
        return doc;
    }

    public Date StringToDate(String input) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
        return formatter.parse(input);
    }

    public byte getQualifier() {
        return qualifier;
    }

    public void setQualifier(byte qualifier) {
        this.qualifier = qualifier;
    }

    public long getAssignedAccountNumber() {
        return assignedAccountNumber;
    }

    public void setAssignedAccountNumber(long assignedAccountNumber) {
        this.assignedAccountNumber = assignedAccountNumber;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public byte getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(byte billingCode) {
        this.billingCode = billingCode;
    }

    public double getVariableSymbol() {
        return variableSymbol;
    }

    public void setVariableSymbol(long variableSymbol) {
        this.variableSymbol = variableSymbol;
    }

    public double getConstantSymbol() {
        return constantSymbol;
    }

    public void setConstantSymbol(long constantSymbol) {
        this.constantSymbol = constantSymbol;
    }

    public double getSpecificSymbol() {
        return specificSymbol;
    }

    public void setSpecificSymbol(long specificSymbol) {
        this.specificSymbol = specificSymbol;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public short getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(short currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

}
