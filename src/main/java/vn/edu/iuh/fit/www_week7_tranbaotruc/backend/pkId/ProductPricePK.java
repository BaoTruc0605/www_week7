package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.pkId;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ProductPricePK implements Serializable {
    private long product;
    private LocalDate date;
}
