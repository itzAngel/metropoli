import { Cliente } from './cliente';
import { Venta } from './venta';

export class DetalleVentaClienteDestino {
    idDetalleVentaClienteDestino: string = null;
    venta: Venta = new  Venta();
    cliente: Cliente = new  Cliente();
}
