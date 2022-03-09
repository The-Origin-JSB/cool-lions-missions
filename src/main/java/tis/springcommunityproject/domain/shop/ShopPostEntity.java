package tis.springcommunityproject.domain.shop;

import tis.springcommunityproject.domain.PostEntity;
import tis.springcommunityproject.domain.UserEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@DiscriminatorValue("SHOP")
public class ShopPostEntity extends PostEntity {

	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "post_id")
	private List<ShopReviewEntity> shopReview = new ArrayList<>();

	protected ShopPostEntity() {
	}

	public ShopPostEntity(Long id, String title, String content, UserEntity user, List<ShopReviewEntity> shopReview) {

		//유효성 검사

		super(id, title, content, user);
		this.shopReview = shopReview;
	}

	public ShopPostEntity(String title, String content) {
		this(null, title, content, null, null);
	}

	public static ShopPostEntity of(String title, String content) {
		return new ShopPostEntity(title, content);
	}

	public List<ShopReviewEntity> getShowReview() {
		if (shopReview == null) {
			return Collections.emptyList();
		}
		return shopReview;
	}

}