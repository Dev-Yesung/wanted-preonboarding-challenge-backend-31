package wanted.ecommerce.catalog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "brands",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "slug")
	})
@Entity
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",
		nullable = false)
	private Long id;

	@Column(name = "name",
		nullable = false,
		length = 100)
	private String name;

	@Column(name = "slug",
		nullable = false,
		unique = true,
		length = 100)
	private String slug;

	@Lob
	@Column(name = "description",
		nullable = true,
		columnDefinition = "TEXT")
	private String description;

	@Column(name = "logo_url",
		nullable = true,
		length = 255)
	private String logoUrl;

	@Column(name = "website",
		nullable = true,
		length = 255)
	private String website;
}
