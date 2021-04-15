import { Documento } from './documento';
import { Venta } from './venta';

export class DetalleVentaDocumento {
    idDetalleDocumentoVenta: string = null;
    venta: Venta = new  Venta();
    documento: Documento = new  Documento();
}
