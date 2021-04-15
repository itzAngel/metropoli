import { Agente } from './agente';
import { DetalleFotosOportunidad } from './detalle-fotos-oportunidad';

export class OportunidadInversion {
    idOportunidadInversion: string = null;
    agente: Agente = new  Agente();
	telefono: string = null;
	direccion: string = null;
    listaDetalleFotosOportunidad: DetalleFotosOportunidad[] =[];
}
