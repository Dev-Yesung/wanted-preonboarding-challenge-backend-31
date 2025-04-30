package wanted.ecommerce.user.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reviews")
@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_id",
		nullable = false)
	private Long productId;

	@Check(constraints = "rating BETWEEN 1 AND 5")
	@Column(name = "rating",
		nullable = false)
	private Integer rating;

	@Column(name = "title",
		nullable = true,
		length = 255)
	private String title;

	@Lob
	@Column(name = "content",
		nullable = true,
		columnDefinition = "TEXT")
	private String content;

	@Column(name = "created_at",
		nullable = false,
		updatable = false,
		columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	@Column(name = "updated_at",
		nullable = false,
		columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime updatedAt;

	@Column(name = "verified_purchase",
		nullable = false,
		columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean verifiedPurchase = false;

	@Column(name = "helpful_votes",
		nullable = false,
		columnDefinition = "INTEGER DEFAULT 0")
	private Integer helpfulVotes = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
}
