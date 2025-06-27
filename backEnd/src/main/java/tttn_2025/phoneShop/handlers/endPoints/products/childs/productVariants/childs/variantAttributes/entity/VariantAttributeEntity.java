package tttn_2025.phoneShop.handlers.endPoints.products.childs.productVariants.childs.variantAttributes.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tttn_2025.phoneShop.common.entities.audit.AuditableEntity;
import tttn_2025.phoneShop.handlers.endPoints.products.childs.productVariants.entity.ProductVariantEntity;

@Entity
@Table(name = "variant_attributes", uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                                "name", "variant_uid"
                })
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class VariantAttributeEntity extends AuditableEntity {

        @Id
        @GeneratedValue(generator = "UUID")
        @Column(name = "uid", updatable = false, nullable = false)
        private UUID uid;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "value", nullable = false)
        private String value;

        @Column(name = "group_name", nullable = false)
        private String groupName;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "variant_uid", nullable = false)
        private ProductVariantEntity variant;

}
