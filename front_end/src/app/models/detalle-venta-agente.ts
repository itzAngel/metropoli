import { Agente } from './agente';
import { Venta } from './venta';

export class DetalleVentaAgente {
    idDetalle: string = null;
    venta: Venta = new  Venta();
    agente: Agente = new  Agente();
	comision: number = null;
}
