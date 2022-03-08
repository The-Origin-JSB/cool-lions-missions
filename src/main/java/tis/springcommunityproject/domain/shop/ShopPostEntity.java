package tis.springcommunityproject.domain.shop;

import tis.springcommunityproject.domain.BoardPostEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SHOP")
public class ShopPostEntity extends BoardPostEntity {
}
