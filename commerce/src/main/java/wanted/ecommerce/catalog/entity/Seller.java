package wanted.ecommerce.catalog.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sellers")
@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",
		nullable = false)
	private Long id;

	@Column(name = "name",
		nullable = false,
		length = 100)
	private String name;

	@Column(name = "description",
		nullable = true,
		columnDefinition = "TEXT")
	private String description;

	@Column(name = "logo_url",
		nullable = true,
		length = 255)
	private String logoUrl;

	@Column(name = "rating",
		nullable = true,
		precision = 3,
		scale = 2)
	private BigDecimal rating;

	@Column(name = "contact_email",
		nullable = true,
		length = 100)
	private String contactEmail;

	@Column(name = "contact_phone",
		nullable = true,
		length = 20)
	private String contactPhone;

	@Column(name = "created_at",
		nullable = true,
		updatable = false,
		columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;
}
