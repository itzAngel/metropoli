import { Alquiler } from './alquiler';
import { Cliente } from './cliente';

export class DetalleAlquilerClienteDestino {
    idDetalleAlquilerClienteDestino: string = null;
    alquiler: Alquiler = new  Alquiler();
    cliente: Cliente = new  Cliente();
}
