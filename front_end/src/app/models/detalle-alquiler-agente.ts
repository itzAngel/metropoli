import { Agente } from './agente';
import { Alquiler } from './alquiler';

export class DetalleAlquilerAgente {
    idDetalleAlquilerAgente: string = null;
    alquiler: Alquiler= new  Alquiler();
    agente: Agente= new  Agente();
	comision: number= null;
}
