package tis.springcommunityproject.domain.area;

import javax.persistence.Embeddable;

@Embeddable
public class Town {
	private String town;

	public Town(String town) {
		this.town = town;
	}

	protected Town() {
	}
}
