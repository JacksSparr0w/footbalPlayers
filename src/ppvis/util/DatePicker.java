package ppvis.util;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.util.Date;
import java.util.Properties;


public class DatePicker {
    private JDatePickerImpl datePicker;

    DatePicker(){
        UtilDateModel model = new UtilDateModel();
        model.setDate(1990, 8, 24);
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

    public Date getDate(){
        return (Date) datePicker.getModel().getValue();

    }

}
