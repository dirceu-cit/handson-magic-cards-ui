package magiccards.ui.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Expansion {
	private String expansionId;
	private String name;
	private String ptBrName;
	private String linkName;
	private String code;
	private String launchDate;
	private Integer expansionCategoryId;
	private Boolean promo;
	private Boolean legal;

	public Expansion(String id, String name, String ptBrName, String linkName, String code, String launchDate, Integer category,
					 Boolean promo, Boolean legal){
		expansionId = id;
		this.name = name;
		this.ptBrName = ptBrName;
		this.linkName = linkName;
		this.code = code;
		this.launchDate = launchDate;
		this.expansionCategoryId = category;
		this.promo = promo;
		this.legal = legal;

	}
}

