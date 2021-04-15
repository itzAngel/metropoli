import { Imagen } from "./imagen";
import { Propiedad } from "./propiedad";

export class DetalleFotosPropiedad {
    idDetalleFotosPropiedad: string;
    foto: string = null;
    propiedad: Propiedad = new Propiedad();
}
