import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Cliente } from 'src/app/models/cliente';
import { Imagen } from 'src/app/models/imagen';
import { ImagenService } from 'src/app/modules/media/imagen/imagen.service';
import { ClienteService } from './cliente.service';
import * as uuid from 'uuid';
import { Tipo } from 'src/app/models/tipo';
import { Estado } from 'src/app/models/estado';
import { Ubicacion } from 'src/app/models/ubicacion';
import { Moneda } from 'src/app/models/moneda';
import { MonedaService } from '../../otros/moneda/moneda.service';
import { UbicacionService } from '../../basicos/ubicacion/ubicacion.service';
import { EstadoService } from '../../basicos/estado/estado.service';
import { TipoService } from '../../basicos/tipo/tipo.service';
import { Preferencia } from 'src/app/models/preferencia';
import { PreferenciaService } from '../../otros/preferencia/preferencia.service';
import { AgenteService } from '../agente/agente.service';
import { Agente } from 'src/app/models/agente';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from '../../base/login/login.service';
import { PageEvent } from '@angular/material/paginator';
import { AuthenticationService } from 'src/app/service/authentication.service';
interface EstadoCliente {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  @ViewChild('imagenInputFile', { static: false }) imagenFile: ElementRef;

  /*banderas*/
  formAct = false;
  vistaEsp = false;
  modal = false;
  mostrarFoto = true;
  mostrarPreferencia = true;
  editar = false;
  isProgress = false;
  checked = false;
  /*arreglos vacios*/
  preferencias: Preferencia[] = [];
  clientes: Cliente[] = [];
  clientesBus: Cliente[] = [];
  imagenes: Imagen[] = [];
  tipos: Tipo[] = [];
  estados: Estado[] = [];
  ubicaciones: Ubicacion[] = [];
  monedas: Moneda[] = [];
  agentes: Agente[] = [];
  /*variables de filtro y busqueda*/
  filtroComprador = false;
  filtroVendedor = false;
  filterPost = '';
  filterPost2 = '';
  /*objetos*/
  selected = null;
  preferencia: Preferencia = new Preferencia();
  cliente: Cliente = new Cliente();
  clienteVista: Cliente = new Cliente();
  image: Imagen = new Imagen();
  fotoPrueba: Imagen = new Imagen();
  imagenMin: Imagen = new Imagen();
  fotoId: string = null;
  preferenciaId: string = null;
  imagen: File;
  /*interfaces*/
  estadosCliente: EstadoCliente[] = [
    { value: 'comprador', viewValue: 'Comprador' },
    { value: 'vendedor', viewValue: 'Vendedor ' }
  ];
  /*paginacion*/
  page_size: number = 10;
  page_number: number = 1;
  constructor(public dialog: MatDialog, public preferenciaService: PreferenciaService, public agenteService: AgenteService,
    private imagenService: ImagenService, public clienteService: ClienteService, private http: HttpClient,
    public tipoService: TipoService, public estadoService: EstadoService, public ubicacionService: UbicacionService,
    public monedaService: MonedaService, private _snackBar: MatSnackBar, public loginservice: AuthenticationService) { }

  ngOnInit(): void {
    this.cargarCombos();
  }

  openSnackBar(mensaje: string) {
    this._snackBar.open(mensaje, 'OK', {
      duration: 1000,
      horizontalPosition: "center",
      verticalPosition: "top",
    });
  }

  /*funciones de carga de datos*/
  cargarCombos(): void {
    this.tipoService.getList().subscribe(data => {
      this.tipos = data;
    });
    this.estadoService.getList().subscribe(data => {
      this.estados = data;
    });
    this.ubicacionService.getList().subscribe(data => {
      this.ubicaciones = data;
    });
    this.monedaService.getList().subscribe(data => {
      this.monedas = data;
    });
    this.agenteService.getAgentes().subscribe(data => {
      this.agentes = data;
    });
    this.preferenciaService.getPreferencias().subscribe(data => {
      this.preferencias = data;
    });
    this.clienteService.getClientes().subscribe(data => {
      this.clientes = data;
    });
    this.imagenService.list().subscribe(
      data => {
        this.imagenes = data;
      }
    );
  }
  /*funciones de cambio con banderas*/
  Agregar() {
    this.formAct = true;
    this.editar = false;
    this.mostrarPreferencia = true;
    this.cliente = new Cliente();
    this.preferencia = new Preferencia();
    this.cliente.fechaIngreso = new Date();
    this.cliente.fechaActualizacion = new Date();
  }
  Regresar() {
    this.formAct = false;
  }

  cambiarPreferencia() {
    if (this.selected == "vendedor") {
      this.mostrarPreferencia = false;
    } else {
      this.mostrarPreferencia = true;
    }
  }

  VistaEspecifica(cliente: Cliente) {
    this.vistaEsp = true;
    this.clienteVista = cliente;
  }
  SalirVista() {
    this.vistaEsp = false;
    this.clienteVista = new Cliente();
  }
  /*funciones de validacion*/
  validar() {
    if (this.cliente.nombre != null && this.cliente.apellido != null && this.cliente.estadoCliente != null && this.cliente.telefono != null
      && this.cliente.correo != null && this.cliente.dni != null) {
      return true;
    } else {
      return false;
    }
  }
  validarFoto() {
    if (this.cliente.foto == null && this.fotoId == null) {
      this.cliente.foto = "d79a952eae8e46659d6581e24c848fc4";
    } else if (this.fotoId != null) {
      this.imagenes.forEach(i => {
        if (i.id == this.fotoId) {
          this.cliente.foto = i.imagenurl;
        }
      });
    }
    this.fotoId = null;
  }

  validarPreferencia() {
    if (this.preferencia.tipo != null &&
      this.preferencia.estado && this.preferencia.ubicacion && this.preferencia.monedamenor &&
      this.preferencia.monedamayor && this.preferencia.preciomenor && this.preferencia.preciomayor) {
      return true;
    } else {
      return false;
    }
  }

  /*funciones de filtros y busqueda*/
  handlePage(e: PageEvent) {
    this.page_size = e.pageSize;
    this.page_number = e.pageIndex + 1;
  }
  limpiarFiltros() {
    this.cargarCombos();
    this.filtroComprador = null;
    this.filtroVendedor = null;
    this.filterPost = null;
    this.filterPost2 = null;
  }
  filtro() {
    this.clienteService.getClientes().subscribe(data => {
      this.clientes = data;
      if (this.filtroComprador) {
        this.clientesBus = [];
        for (let cli of this.clientes) {
          if (cli.estadoCliente.toLowerCase().indexOf("comprador") > -1) {
            this.clientesBus.push(cli);
          };
        };
        this.clientes = this.clientesBus;
      }
      if (this.filtroVendedor) {
        this.clientesBus = [];
        for (let cli of this.clientes) {
          if (cli.estadoCliente.toLowerCase().indexOf("vendedor") > -1) {
            this.clientesBus.push(cli);
          };
        };
        this.clientes = this.clientesBus;
      }
      if (this.filterPost != null) {
        this.clientesBus = [];
        for (let cli of this.clientes) {
          if (cli.nombre.toLowerCase().indexOf(this.filterPost.toLowerCase()) > -1) {
            this.clientesBus.push(cli);
          };
        };
        this.clientes = this.clientesBus;
      }
      if (this.filterPost2 != null) {
        this.clientesBus = [];
        for (let cli of this.clientes) {
          if (cli.empresa.toLowerCase().indexOf(this.filterPost2.toLowerCase()) > -1) {
            this.clientesBus.push(cli);
          };
        };
        this.clientes = this.clientesBus;
      }
    });
  }

  /*funciones crud*/
  limpiar() {
    this.cliente = new Cliente();
  }

  setearCombos() {
    this.tipos.forEach(obj => {
      if (obj.idTipo == this.cliente.preferencia.tipo.idTipo) {
        this.cliente.preferencia.tipo = obj;
      }
    });
    this.estados.forEach(obj => {
      if (obj.idEstado == this.cliente.preferencia.estado.idEstado) {
        this.cliente.preferencia.estado = obj;
      }
    });

    this.ubicaciones.forEach(obj => {
      if (obj.idUbicacion == this.cliente.preferencia.ubicacion.idUbicacion) {
        this.cliente.preferencia.ubicacion = obj;
      }
    });

    this.agentes.forEach(obj => {
      if (obj.idAgente == this.cliente.agente.idAgente) {
        this.cliente.agente = obj;
      }
    });

    this.monedas.forEach(obj => {
      if (obj.idMoneda == this.cliente.preferencia.monedamayor.idMoneda) {
        this.cliente.preferencia.monedamayor = obj;
      }
      if (obj.idMoneda == this.cliente.preferencia.monedamenor.idMoneda) {
        this.cliente.preferencia.monedamenor = obj;
      }
    });
  }

  Guardar() {
    if (this.validar()) {
      this.validarFoto();
      this.cliente.preferencia = this.preferencia;//asigna preferencia
      this.cliente.idCliente = uuid().replace(/-/g, '');//asigna id cliente
      this.cliente.fechaActualizacion = new Date();//fecha de actualizacion
      this.setearCombos();
      this.clienteService.createCliente(this.cliente).subscribe(data => {
        this.openSnackBar("Cliente se agrego con exito");
        this.formAct = false;
        this.cargarCombos();
      });
    } else {
      this.openSnackBar("Llena todos los campos del cliente");
    }
  }

  Editar(id: string) {
    this.limpiar();
    this.LimpiarPreferencia();
    this.clientes.forEach(c => {
      if (c.idCliente == id) {
        this.cliente = c;
      }
    });
    this.preferencia = this.cliente.preferencia;
    this.formAct = true;
    this.editar = true;
    this.mostrarPreferencia = true;
  }

  Actualizar() {
    if (this.validar()) {
      this.imagenes.forEach(i => {
        if (i.id == this.fotoId) {
          this.cliente.foto = i.imagenurl;//asigna foto
        }
      });
      this.cliente.preferencia = this.preferencia;//asigna preferencia
      this.cliente.fechaActualizacion = new Date();//fecha de actualizacion
      this.setearCombos();
      this.clienteService.updatCliente(this.cliente).subscribe(data => {
        this.openSnackBar("Cliente se actualizo con exito");
        this.cargarCombos();
        this.Regresar();
      });
    } else {
      this.openSnackBar("Llena todos los campos del cliente");
    }
  }

  Eliminar(cliente: Cliente): void {
    this.clienteService.deleteCliente(cliente.idCliente).subscribe(data => {
      this.clientes = this.clientes.filter(p => p !== cliente);
    });
    this.openSnackBar("Cliente se elimino con exito");
    this.SalirVista();
  }

  /*funciones crud externas*/
  GuardarPreferencia() {
    if (this.validarPreferencia()) {
      if (this.editar) {
        this.preferenciaService.updatePreferencia(this.preferencia).subscribe(data => {
          this.cargarCombos();
          this.mostrarPreferencia = false;
        });
      } else {
        this.preferenciaId = uuid().replace(/-/g, '');
        this.preferencia.idPreferencia = this.preferenciaId;
        this.preferenciaService.createPreferencia(this.preferencia).subscribe(data => {
          this.cargarCombos();
          this.mostrarPreferencia = false;
        });
      }
    } else {
      this.openSnackBar("Llena todos los campos de la preferencia para registrarla");
    }
  }

  LimpiarPreferencia() {
    this.preferencia = new Preferencia();
  }

  onUpload(): void {
    this.isProgress = true;
    this.fotoId = uuid().replace(/-/g, '');//crea id de foto
    this.imagenService.upload(this.imagen, this.fotoId).subscribe(
      data => {
        this.cargarCombos();
        this.reset();
        this.mostrarFoto = false;
        this.isProgress = false;
      },
      err => {
        alert(err.error.mensaje);
        this.reset();
      }
    );
  }
  onFileChange(event) {
    this.imagen = event.target.files[0];
    const fr = new FileReader();
    fr.onload = (evento: any) => {
      this.imagenMin = evento.target.result;
    };
    fr.readAsDataURL(this.imagen);
  }

  reset(): void {
    this.imagen = null;
    this.imagenMin = null;
  }


}
