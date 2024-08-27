package Gun;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class GunDefault {
    private final String name;
    private final int ammo;
    private final float caliber;
    public GunDefault(String name, int ammo, float caliber) {
        this.name = name;
        this.ammo = ammo;
        this.caliber = caliber;
    }
}
