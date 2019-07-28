package magiccards.services.impl;

import magiccards.services.ExpansionService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExpansionServiceImpl implements ExpansionService {

    public ExpansionServiceImpl(){

    }

    /**
     * Convert millisec in a formated data
     * @param millisec in millisec
     * @return Formated date yyy-MM-dd
     */
    public String getFormatedDateString(Long millisec) {
        Date millisecDate = new Date(millisec);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(millisecDate);
    }
}
