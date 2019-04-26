package ppvis.util;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.text.ParseException;
import java.util.Date;
import java.util.Properties;


public class DatePicker {
    private JDatePickerImpl datePicker;

    DatePicker(){
        UtilDateModel model = new UtilDateModel();
        //model.setDate(new Date());
        model.setSelected(true);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }

    public JDatePickerImpl getDatePicker(){
        return datePicker;
    }

    public Date getDate() throws ParseException {
        validate();
        return (Date) datePicker.getModel().getValue();
    }

    private void validate() throws ParseException {
        if (datePicker.getModel().getValue() == null)
            datePicker.getModel().setDate(1000, 1, 1);
    }

}
