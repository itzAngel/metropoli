import { Cliente } from './cliente';
import { Venta } from './venta';

export class DetalleVentaCliente {
    idDetalle: string = null;
    venta: Venta = new  Venta();
    cliente: Cliente = new  Cliente();
}
