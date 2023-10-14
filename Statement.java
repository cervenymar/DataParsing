public class Statement {  
        String qualifier;
        String accountNumber;
        String accountName;
        String oldBalanceDate;
        String oldBalanceValue;
        String oldBalanceChar;
        String newBalanceValue;
        String newBalanceChar;
        String debitTurnOver;
        String debitTurnOverChar;
        String creditTurnOver;
        String creditTurnOverChar;
        String steatementSerialNumber;
        String billingDate;
        String emptySpace;      

        public Statement(String data){
            this.qualifier = data.substring(0,3);
            this.accountNumber = data.substring(3,19);
            this.accountName    = data.substring(19,39);
            this.oldBalanceDate = data.substring(39,45);
            this.oldBalanceValue = data.substring(45, 59);
            this.oldBalanceChar = data.substring(59,60);
            this.newBalanceValue = data.substring(60,74);
            this.newBalanceChar = data.substring(74,75);
            this.debitTurnOver = data.substring(75,89);
            this.debitTurnOverChar = data.substring(89,90);
            this.creditTurnOver = data.substring(90,104);
            this.creditTurnOverChar = data.substring(104,105);
            this.steatementSerialNumber = data.substring(105,108);
            this.billingDate = data.substring(108,114);
            this.emptySpace = data.substring(114,128);            
        }
        public String getQualifier(){
            return qualifier;
        }
        public int getAccountNumber(){
            return Integer.parseInt(accountNumber,10);
        }
    }

