import { Alquiler } from './alquiler';
import { Documento } from './documento';

export class DetalleAlquilerDocumento {
    idDetalleDocumentoAlquiler: string = null;
    alquiler: Alquiler = new  Alquiler();
    documento: Documento = new  Documento();
}
