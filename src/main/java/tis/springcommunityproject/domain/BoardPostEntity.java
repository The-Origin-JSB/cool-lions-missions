package tis.springcommunityproject.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("BOARD")
public class BoardPostEntity extends PostEntity{

	protected BoardPostEntity() {
	}

	public BoardPostEntity(String title, String content) {
		super(title, content);
	}
}
