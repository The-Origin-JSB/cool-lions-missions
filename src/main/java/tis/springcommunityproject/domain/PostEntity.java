package tis.springcommunityproject.domain;

import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import tis.springcommunityproject.api.PostDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Posts")
public class PostEntity {
	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private Long id;

	private String title;

	private String content;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	//TODO 등록일자와 수정일자는 공통으로 처리가 가능하다.
	@Column(updatable = false)
	@CreatedDate
	private LocalDateTime createAt;

	@Column(insertable = false)
	@LastModifiedDate
	private LocalDateTime updateAt;

	protected PostEntity() {
	}

	private PostEntity(String title, String content, UserEntity user) {
		this(null, title, content, user, null, null);
	}

	private PostEntity(Long id, String title, String content, UserEntity user, LocalDateTime createAt, LocalDateTime updateAt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.user = user;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public static PostEntity of(Long id, String title, String content, UserEntity user, LocalDateTime createAt, LocalDateTime updateAt) {
		return new PostEntity(id, title, content, user, createAt, updateAt);
	}

	public static PostEntity of(String title, String content, UserEntity user) {
		return new PostEntity(title, content, user);
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public UserEntity getUser() {
		return user;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
}
