
import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.*;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.util.Date;


public class CSVtoJavaObj {


    private void readWithCsvBeanReader(File csvFile) throws Exception {

        ICsvBeanReader beanReader = null;
        try {
            beanReader = new CsvBeanReader(new FileReader(csvFile), CsvPreference.STANDARD_PREFERENCE);

            // the header elements are used to map the values to the bean (names must match)
            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = this.getProcessors();

            CustomerBean customer;
            while( (customer = beanReader.read(CustomerBean.class, header, processors)) != null ) {
                System.out.println(String.format("lineNo=%s, rowNo=%s, customer=%s", beanReader.getLineNumber(),
                        beanReader.getRowNumber(), customer));
            }

        }
        finally {
            if( beanReader != null ) {
                beanReader.close();
            }
        }
    }

    private CellProcessor[] getProcessors() {

        final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+"; // just an example, not very robust!
        StrRegEx.registerMessage(emailRegex, "must be a valid email address");

        final CellProcessor[] processors = new CellProcessor[] {
                new UniqueHashCode(), // customerNo (must be unique)
                new NotNull(), // firstName
                new NotNull(), // lastName
                new ParseDate("dd/MM/yyyy"), // birthDate
                new NotNull(), // mailingAddress
                new Optional(new ParseBool()), // married
                new Optional(new ParseInt()), // numberOfKids
                new NotNull(), // favouriteQuote
                new StrRegEx(emailRegex), // email
                new LMinMax(0L, LMinMax.MAX_LONG) // loyaltyPoints
        };

        return processors;
    }

    public static void main(String args[]){



        File f = new File("dorel.ds");
        System.out.print(f.getAbsoluteFile());

        File csv = new File(
                "./src/main/resources/test.csv");




        CSVtoJavaObj converter = new CSVtoJavaObj();
        try {
            converter.readWithCsvBeanReader(csv);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
        }
    }
}
