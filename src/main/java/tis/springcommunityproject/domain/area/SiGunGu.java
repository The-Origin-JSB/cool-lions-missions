package tis.springcommunityproject.domain.area;

import javax.persistence.*;

@Embeddable
public class SiGunGu {
	private String siGunGu;

	protected SiGunGu() {
	}

	public SiGunGu(String siGunGu) {
		this.siGunGu = siGunGu;
	}
}
