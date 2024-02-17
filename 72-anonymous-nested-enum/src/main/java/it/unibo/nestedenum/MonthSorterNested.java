package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    enum Month{
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private int days;

        Month(int days){
            this.days = days;
        }

        Month fromString(final String month){
            try {
                return valueOf(month);
            } catch (Exception e) {
                switch (month.toLowerCase()) {
                    case "january":
                        return  Month.JANUARY;
                    
                    case "february":
                        return  Month.FEBRUARY;
                   
                    case "march":
                        return  Month.MARCH;
                    break;
                    case "april":
                        return  Month.APRIL;
                    break;
                    case "may":
                        return  Month.MAY;
                    break;
                    case "june":
                        return  Month.JUNE;
                    break;
                    case "july":
                        return  Month.JULY;
                    break;
                    case "august":
                        return  Month.AUGUST;
                    break;
                    case "september":
                        return  Month.SEPTEMBER;
                    break;
                    case "october":
                        return  Month.OCTOBER;
                    break;
                    case "november":
                        return  Month.NOVEMBER;
                    break;
                    case "december":
                        return  Month.DECEMBER;
                    break;
                    
                }
                throw e;
                
            }
        }
    }
    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
