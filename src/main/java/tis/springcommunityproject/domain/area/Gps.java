package tis.springcommunityproject.domain.area;

import javax.persistence.Embeddable;

@Embeddable
public class Gps {
	private String latitude;
	private String longitude;

	protected Gps() {
	}

	public Gps(String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
