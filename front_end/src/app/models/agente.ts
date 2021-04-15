import { AsignaAgencia } from './asigna-agencia';
import { DetalleAlquilerAgente } from './detalle-alquiler-agente';
import { DetalleVentaAgente } from './detalle-venta-agente';
import { Imagen } from './imagen';
import { OportunidadInversion } from './oportunidad-inversion';
import { Pedido } from './pedido';
import { Propiedad } from './propiedad';
import { Seguimiento } from './seguimiento';

export class Agente {
    idAgente: string = null;
	correo: string = null;
	contrasena: string = null;
	nombre: string = null;
	apellido: string = null;
	celular: string = null;
	urlWeb: string = null;
	permisosPerfil: string = null;
	imagen: string = null;
	comentario: string= null; 
    listaPropiedad: Propiedad[];
    listaOportunidadInversion: OportunidadInversion[] = [];
    listaAsignaAgencia: AsignaAgencia[] = [];
    listaSeguimiento: Seguimiento[] = [];
    listaDetalleAlquilerAgente: DetalleAlquilerAgente[] = [];
    listaDetalleVentaAgente: DetalleVentaAgente[] = [];
	listaPedido: Pedido[] = [];
	habilitado: string= null; 
}
