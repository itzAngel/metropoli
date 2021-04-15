import { Alquiler } from './alquiler';
import { Cliente } from './cliente';

export class DetalleAlquilerCliente {
    idDetalleAlquilerCliente: string= null;
    alquiler: Alquiler = new  Alquiler();
    cliente: Cliente = new  Cliente();
}
