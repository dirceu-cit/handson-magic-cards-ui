package magiccards.ui.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Expansion {
	private int expansionId;
	private String name;
	private String ptBrName;
	private String linkName;
	private String code;
	private String launchDate;
	private Integer expansionCategoryId;
	private int isPromo;
	private int isLegal;
}
