package net.cerveny.DataParsing;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Statement {
    byte qualifier;
    long accountNumber;
    String accountName;
    Date oldBalanceDate;
    double oldBalanceValue;
    char oldBalanceChar;
    double newBalanceValue;
    char newBalanceChar;
    double debitTurnOver;
    char debitTurnOverChar;
    double creditTurnOver;
    char creditTurnOverChar;
    short statementSerialNumber;
    Date billingDate;
    String emptySpace;

    public Statement(String data) throws Exception {
        this.qualifier = Byte.parseByte(data.substring(0, 3));
        this.accountNumber = Long.parseLong(data.substring(3, 19));
        this.accountName = data.substring(19, 39).trim();
        this.oldBalanceDate = StringToDate(data.substring(39, 45));
        this.oldBalanceValue = (Double.parseDouble(data.substring(45, 59)) / 100);
        this.oldBalanceChar = data.charAt(59);
        this.newBalanceValue = (Double.parseDouble(data.substring(60, 74)) / 100);
        this.newBalanceChar = data.charAt(74);
        this.debitTurnOver = (Double.parseDouble(data.substring(75, 89)) / 100);
        this.debitTurnOverChar = data.charAt(89);
        this.creditTurnOver = (Double.parseDouble(data.substring(90, 104)) / 100);
        this.creditTurnOverChar = data.charAt(104);
        this.statementSerialNumber = Short.parseShort(data.substring(105, 108));
        this.billingDate = StringToDate(data.substring(108, 114));
        this.emptySpace = data.substring(114, 128).trim();
    }

    public String toString() {
        return String.format(
                "{\"qualifier\":\"%s\",\"accountNumber\":\"%s\",\"accountName\":\"%s\",\"oldBalanceDate\":\"%s\",\"oldBalanceValue\":\"%s\",\"oldBalanceChar\":\"%s\",\"newBalanceValue\":\"%s\",\"newBalanceChar\":\"%s\",\"debitTurnOver\":\"%s\",\"debitTurnOverChar\":\"%s\",\"creditTurnOver\":\"%s\",\"creditTurnOverChar\":\"%s\",\"statementSerialNumber\":\"%s\",\"billingDate\":\"%s\",\"emptySpace \":\"%s\"}",
                this.qualifier, this.accountNumber, this.accountName, this.oldBalanceDate, this.oldBalanceValue,
                this.oldBalanceChar, this.newBalanceValue, this.newBalanceChar, this.debitTurnOver,
                this.debitTurnOverChar, this.creditTurnOver, this.creditTurnOverChar, this.statementSerialNumber,
                this.billingDate, this.emptySpace);
    }

    public Document toDoc() {
        Document doc = new Document("_id", new ObjectId())
                .append("qualifier", this.qualifier)
                .append("accountNumber", this.accountNumber)
                .append("accountName", this.accountName)
                .append("oldBalanceDate", this.oldBalanceDate)
                .append("oldBalanceChar", this.oldBalanceChar)
                .append("newBalanceValue", this.newBalanceValue)
                .append("newBalanceChar", this.newBalanceChar)
                .append("debitTurnOver", this.debitTurnOver)
                .append("debitTurnOverChar", this.debitTurnOverChar)
                .append("creditTurnOver", this.creditTurnOver)
                .append("creditTurnOverChar", this.creditTurnOverChar)
                .append("statementSerialNumber", this.statementSerialNumber)
                .append("billingDate", this.billingDate)
                .append("emptySpace", this.emptySpace);
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

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getOldBalanceDate() {
        return oldBalanceDate;
    }

    public void setOldBalanceDate(Date oldBalanceDate) {
        this.oldBalanceDate = oldBalanceDate;
    }

    public double getOldBalanceValue() {
        return oldBalanceValue;
    }

    public void setOldBalanceValue(double oldBalanceValue) {
        this.oldBalanceValue = oldBalanceValue;
    }

    public char getOldBalanceChar() {
        return oldBalanceChar;
    }

    public void setOldBalanceChar(char oldBalanceChar) {
        this.oldBalanceChar = oldBalanceChar;
    }

    public double getNewBalanceValue() {
        return newBalanceValue;
    }

    public void setNewBalanceValue(double newBalanceValue) {
        this.newBalanceValue = newBalanceValue;
    }

    public char getNewBalanceChar() {
        return newBalanceChar;
    }

    public void setNewBalanceChar(char newBalanceChar) {
        this.newBalanceChar = newBalanceChar;
    }

    public double getDebitTurnOver() {
        return debitTurnOver;
    }

    public void setDebitTurnOver(double debitTurnOver) {
        this.debitTurnOver = debitTurnOver;
    }

    public char getDebitTurnOverChar() {
        return debitTurnOverChar;
    }

    public void setDebitTurnOverChar(char debitTurnOverChar) {
        this.debitTurnOverChar = debitTurnOverChar;
    }

    public double getCreditTurnOver() {
        return creditTurnOver;
    }

    public void setCreditTurnOver(double creditTurnOver) {
        this.creditTurnOver = creditTurnOver;
    }

    public char getCreditTurnOverChar() {
        return creditTurnOverChar;
    }

    public void setCreditTurnOverChar(char creditTurnOverChar) {
        this.creditTurnOverChar = creditTurnOverChar;
    }

    public short getStatementSerialNumber() {
        return statementSerialNumber;
    }

    public void setStatementSerialNumber(short statementSerialNumber) {
        this.statementSerialNumber = statementSerialNumber;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getEmptySpace() {
        return emptySpace;
    }

    public void setEmptySpace(String emptySpace) {
        this.emptySpace = emptySpace;
    }
}
