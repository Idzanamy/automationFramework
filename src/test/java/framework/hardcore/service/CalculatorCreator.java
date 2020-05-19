package framework.hardcore.service;

import framework.hardcore.model.Calculator;

public class CalculatorCreator {
    public static final String NUMBER = "testdata.calculator.numberOfInstances";
    public static final String REGION = "Frankfurt";
    public static final String CLASS_VM = "regular";
    public static final String TOTAL_PRICE = "testdata.calculator.totalPrice";
    public static final String EMAIL_TOTAL_PRICE = "testdata.calculator.emailTotalPrice";
    public static final String TIME_USAGE = "1 Year";
    public static final String TYPE_INS = "n1-standard-8";
    public static final String LOCAL_SSD = "2x375 GiB";


    public static Calculator withQueryFromProperty(){
        return new Calculator(TestDataReader
                .getTestData(NUMBER),REGION,CLASS_VM,TestDataReader
                .getTestData(TOTAL_PRICE),TestDataReader
                .getTestData(EMAIL_TOTAL_PRICE),TIME_USAGE,TYPE_INS,LOCAL_SSD);
    }
}