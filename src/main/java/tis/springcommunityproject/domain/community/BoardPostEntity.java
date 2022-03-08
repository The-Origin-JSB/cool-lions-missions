package tis.springcommunityproject.domain.community;


import tis.springcommunityproject.domain.PostEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("BOARD")
public class BoardPostEntity extends PostEntity {

	protected BoardPostEntity() {
	}

	public BoardPostEntity(String title, String content) {
		super(title, content);
	}
}