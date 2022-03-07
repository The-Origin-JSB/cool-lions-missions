package tis.springcommunityproject.api;

import tis.springcommunityproject.domain.PostEntity;
import tis.springcommunityproject.domain.UserEntity;

import java.time.LocalDateTime;

public class PostDto {
	private String title;

	private String content;

	private UserEntity user;

	private LocalDateTime createAt;

	private LocalDateTime updateAt;

	public PostEntity newPostEntity() {
		return PostEntity.of(title, content, user);
	}

}
