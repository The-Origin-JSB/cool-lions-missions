package tis.springcommunityproject.domain.area;

import javax.persistence.*;

@Entity
@Table(name = "area")
@Embeddable
public class AreaEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Embedded
	private State state;

	@Embedded
	private Town town;

	@Embedded
	private SiGunGu siGunGu;

	@Embedded
	private Gps gps;

	protected AreaEntity() {
	}

	public AreaEntity(Long id, String state, String siGunGu, String town, Gps gps) {
		this.id = id;
		this.state = new State(state);
		this.town = new Town(town);
		this.siGunGu = new SiGunGu(siGunGu);
	}

	public AreaEntity of(Long id, String state, String siGunGu, String town, Gps gps) {
		return new AreaEntity(id, state, siGunGu, town, gps);
	}
}
