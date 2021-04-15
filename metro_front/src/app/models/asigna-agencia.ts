import { Agencia } from './agencia';
import { Agente } from './agente';

export class AsignaAgencia {
    idAsignaAgencia: string = null;
    agencia: Agencia = new  Agencia();
    agente: Agente = new  Agente();
    fechaInicio: Date = null;
    fechaFin: Date = null;
}
