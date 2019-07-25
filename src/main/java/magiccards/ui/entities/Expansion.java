package magiccards.ui.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class Expansion {
	private int expansionId;
    private String name;
    private String ptBrName;
    private String linkName;
    private String code;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date launchDate;
    private int expansionCategoryId;
    private boolean isPromo;
    private boolean isLegal;
}
