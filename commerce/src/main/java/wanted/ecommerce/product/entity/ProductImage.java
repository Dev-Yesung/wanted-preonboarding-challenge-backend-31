package wanted.ecommerce.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_images")
@Entity
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "url",
		nullable = false,
		length = 255)
	private String url;

	@Column(name = "alt_text",
		nullable = true,
		length = 255)
	private String altText;

	@Column(name = "is_primary",
		nullable = true,
		columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean isPrimary = false;

	@Column(name = "display_order",
		nullable = true,
		columnDefinition = "INTEGER DEFAULT 0")
	private Integer displayOrder = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id",
		nullable = false)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "option_id")
	private ProductOption productOption;
}
