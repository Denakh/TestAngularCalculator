package data;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider
    public Object[][] calculatorPositiveTestData() {
        return new Object[][]{
                {"111", "222", "+", "333", "Error in correct addition result"},
                {"111", "-222", "+", "-111", "Error in correct addition result"},
                {"0", "11.1", "+", "11.1", "Error in correct addition result"},
                {"111", "333", "/", "0.3333333333333333", "Error in correct division result"},
                {"-33.3", "11.1", "/", "-3", "Error in correct division result"},
                {"0", "333", "/", "0", "Error in correct division result"},
                {"11", "33", "*", "363", "Error in correct multiplication result"},
                {"-1.1", "3.3", "*", "-3.63", "Error in correct multiplication result"},
                {"0", "5", "*", "0", "Error in correct multiplication result"},
        };
    }

    @DataProvider
    public Object[][] calculatorNegativeTestData() {
        return new Object[][]{
                {"", "", "+", "NaN", "Error in incorrect addition result"},
                {"a", "b", "+", "NaN", "Error in incorrect addition result"},
                {"???", "$$$", "+", "NaN", "Error in incorrect addition result"},
                {"1a", "2b", "+", "NaN", "Error in incorrect addition result"},
                {"", "", "/", "NaN", "Error in incorrect division result"},
                {"111", "0", "/", "Infinity", "Error in incorrect division result"},
                {"a", "0", "/", "NaN", "Error in incorrect division result"},
                {"3a", "2b", "/", "NaN", "Error in incorrect division result"},
                {"", "", "*", "NaN", "Error in incorrect multiplication result"},
                {"a", "b", "*", "NaN", "Error in incorrect multiplication result"},
                {"&&&", "???", "*", "NaN", "Error in incorrect multiplication result"},
                {"5a", "3b", "*", "NaN", "Error in incorrect multiplication result"},
        };
    }

}
