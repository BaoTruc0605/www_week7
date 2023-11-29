package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.pkId;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderDetailPK implements Serializable {
    private long order;
    private long product;
}
