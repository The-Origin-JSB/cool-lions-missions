package tis.springcommunityproject.domain.area;

import javax.persistence.Embeddable;

@Embeddable
public class State {
	private String state;

	protected State() {
	}

	public State(String state) {
		this.state = state;
	}
}
