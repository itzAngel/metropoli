import { Cliente } from './cliente';
import { Propiedad } from './propiedad';

export class AsignaPropiedadCliente {
    idAsignaPropiedad: string = null;
    propiedad: Propiedad = new  Propiedad();
    cliente: Cliente = new  Cliente();
    fechaInicio: Date = null;
    fechaFin: Date = null;
}
