import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { Agente } from 'src/app/models/agente';
import { Cliente } from 'src/app/models/cliente';
import { Condicion } from 'src/app/models/condicion';
import { Estado } from 'src/app/models/estado';
import { Imagen } from 'src/app/models/imagen';
import { Moneda } from 'src/app/models/moneda';
import { Multimedia } from 'src/app/models/multimedia';
import { Propiedad } from 'src/app/models/propiedad';
import { Tipo } from 'src/app/models/tipo';
import { Ubicacion } from 'src/app/models/ubicacion';
import * as uuid from 'uuid';
import { CondicionService } from '../../basicos/condicion/condicion.service';
import { EstadoService } from '../../basicos/estado/estado.service';
import { TipoService } from '../../basicos/tipo/tipo.service';
import { UbicacionService } from '../../basicos/ubicacion/ubicacion.service';
import { ImagenService } from '../../media/imagen/imagen.service';
import { MultimediaService } from '../../media/multimedia/multimedia.service';
import { MonedaService } from '../../otros/moneda/moneda.service';
import { AgenteService } from '../../usuarios/agente/agente.service';
import { ClienteService } from '../../usuarios/cliente/cliente.service';
import { PropiedadService } from './propiedad.service';
import {animate, state, style, transition, trigger} from '@angular/animations';
import {MatPaginator, PageEvent} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import {MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition,} from '@angular/material/snack-bar';
import {DateAdapter, MAT_DATE_LOCALE} from '@angular/material/core';
import { DetalleFotosPropiedadService } from './detalle-fotos-propiedad/detalle-fotos-propiedad.service';
import { DetalleFotosPropiedad } from 'src/app/models/detalle-fotos-propiedad';
import { LoginService } from '../../base/login/login.service';
import { FormControl } from '@angular/forms';
import { AuthenticationService } from 'src/app/service/authentication.service';
@Component({
  selector: 'app-propiedad',
  templateUrl: './propiedad.component.html',
  styleUrls: ['./propiedad.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
  providers: [
    {provide: MAT_DATE_LOCALE, useValue: 'ja-JP'},
  ],
})
export class PropiedadComponent implements OnInit {
  /* variables de tabla*/
  ELEMENT_DATA: Propiedad[]= [];
  dataSource = new MatTableDataSource<Propiedad>(this.ELEMENT_DATA);
  columnsToDisplay = ['estado', 'tipo', 'ubicacion', 'condicion'];
  expandedElement: Propiedad | null;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  /*variables de multimedia*/
  @ViewChild('imagenInputFile', {static: false}) imagenFile: ElementRef;
  @ViewChild('multimediaInputFile', {static: false}) multimediaFile: ElementRef;
  /*banderas*/
  formAct = false;
  vistaEsp = false;
  vistaEspSinLog = false;
  vistaTabla = false;
  formGeneral = false;
  formEspe = false;
  formMedia = false;
  formListaFotos = false;
  mostrarFoto = true;
  mostrarMultimedia = true;
  mostrarFormuCasa = false;
  mostrarFormuDepartamento = false;
  mostrarFormuLocalComercial = false;
  mostrarFormuLocalIndustrial = false;
  mostrarFormuTerreno = false;
  mostrarFormuOficina = false;
  editar = false;
  isProgress = false;
  /*variables de filtro y busqueda*/
  pickerDate:Date;
  pickerDateFinal:Date;
  checked=false;
  public search : string = '';
  filtroEstado: Estado[] = null;
  filtroTipo: Tipo[] = null;
  filtroUbicacion: Ubicacion[] = null;
  filtroPropxAgente = false;
  filtroTipoMonedaMenor: Moneda = null;
  filtroTipoMonedaMayor: Moneda = null;
  precioMayor = null;
  precioMenor = null;
  canDormitorios: number[] = null;
  canBanios: number[] = null;
  canCocheras: number[] = null;
  areaMinima = null;
  areaMaxima = null;
  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';
  /*arreglos vacios*/
  propiedades:Propiedad[]=[];
  propiedadesBus:Propiedad[]=[];
  clientes:Cliente[]=[];
  imagenes: Imagen[] = [];
  multimedias: Multimedia[] = [];
  tipos:Tipo[]=[];
  estados:Estado[]=[];
  monedas: Moneda[] = [];
  ubicaciones:Ubicacion[]=[];
  condiciones:Condicion[]=[];
  agentes:Agente[]=[];
  detalles: DetalleFotosPropiedad[] = [];
  cantidades: number[] = [0,1,2,3,4,5,6,7,8,9,10];
  estOficinas: string[] = ["gris","implementado"];
  distribuciones: string[] = ["flat","duplex"];
  
  /*objetos*/
  selected: string = null;
  propiedad:Propiedad = new Propiedad();
  propiedadVista:Propiedad = new Propiedad();
  image: Imagen = new Imagen();
  imagenMin: Imagen = new Imagen();
  fotoId:string = null;
  multimediaId:string = null;
  imagen: File;
  multimedia: File;
  multimediaMin: File;
  slideIndex = 1;

  /*paginacion*/
  page_size: number = 10;
  page_number: number = 1;
  
  constructor(public agenteService: AgenteService,private multimediaservice: MultimediaService,private imagenService: ImagenService, 
    public condicionService: CondicionService,public clienteService: ClienteService,private _adapter: DateAdapter<any>,
    public tipoService: TipoService,public estadoService: EstadoService,public ubicacionService: UbicacionService, 
    public monedaService: MonedaService, public propiedadService: PropiedadService,private _snackBar: MatSnackBar,
    public detalleService: DetalleFotosPropiedadService,public loginservice: LoginService,public authService:AuthenticationService) { }

  ngOnInit(): void {
    this.cargarDatos();
    this._adapter.setLocale('es');
    if(this.propiedadService.busquedaBarra){
      this.limpiarfiltros();
      if(this.propiedadService.estadoBarra != null){
        this.filtroEstado=this.propiedadService.estadoBarra;
      }
      if(this.propiedadService.tipoBarra != null){
        this.filtroTipo=this.propiedadService.tipoBarra;
      }
      if(this.propiedadService.ubicacionBarra != null){
        this.filtroUbicacion=this.propiedadService.ubicacionBarra;
      }
      if(this.propiedadService.estadoBarra == null &&
        this.propiedadService.tipoBarra == null &&
        this.propiedadService.ubicacionBarra == null){
          this.limpiarfiltros();
        }
      this.filtro();
    }
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  openSnackBar(mensaje:string) {
    this._snackBar.open(mensaje, 'OK', {
      duration: 1000,
      horizontalPosition: "center",
      verticalPosition: "top",
    });
  }

  /*funciones de carga de datos*/
  cargarDatos(){
    this.cargarCombos();
    this.cargarImagenes();
    this.cargarMultimedias();
    this.cargarPropiedades();
    this.cargarTabla();
  }
  cargarTabla(){
    this.propiedadService.getList().subscribe(data=>{
      this.ELEMENT_DATA=data;
      this.dataSource = new MatTableDataSource<Propiedad>(this.ELEMENT_DATA);
    });
  }
  cargarCombos(): void{
    this.tipoService.getList().subscribe(data=>{
      this.tipos=data;
    });
    this.estadoService.getList().subscribe(data=>{
      this.estados=data;
    });
    this.ubicacionService.getList().subscribe(data=>{
      this.ubicaciones=data;
    });
    this.condicionService.getList().subscribe(data=>{
      this.condiciones=data;
    });
    this.monedaService.getList().subscribe(data=>{
      this.monedas=data;
    });
    this.agenteService.getAgentes().subscribe(data=>{
      this.agentes=data;
    });
    this.clienteService.getClientes().subscribe(data=>{
      this.clientes=data;
    });
  }
  cargarPropiedades(): void{
    this.propiedadService.getList().subscribe(data=>{
      this.propiedades=data;
    });
    this.propiedades.forEach(p => {
      this.detalleService.getListxProp(p.idPropiedad).subscribe(data=>{
        p.listaDetalleFotosPropiedad=data;
      });
    });
  }
  cargarImagenes(): void {
    this.imagenService.list().subscribe(
      data => {
        this.imagenes = data;
      }
    );
  }
  cargarMultimedias(): void {
    this.multimediaservice.list().subscribe(
      data => {
        this.multimedias = data;
      }
    );
  }
  /*funciones de cambio con banderas*/
  Agregar(){
    this.formAct=true;
    this.formGeneral = true;
    this.formMedia = false;
    this.formEspe = false;
    this.formListaFotos = false;
    this.editar=false;
    this.propiedad = new Propiedad();
    this.propiedad.idPropiedad=uuid().replace(/-/g, '');//asigna id propiedad
    this.condiciones.forEach(element => {
      if(element.condicion=="inicial"){
        this.propiedad.condicion=element;
      }
    });
    this.propiedad.fechaIngreso = new Date();
    this.propiedad.fechaActualizacion = new Date();
  }
  Regresar(){
    this.formAct=false;
    this.formGeneral = false;
    this.formMedia = false;
    this.formEspe = false;
    this.formListaFotos = false;
    this.selected=null;
  }

  cambiarTipoFormu(){
      this.mostrarFormuCasa=false;
      this.mostrarFormuDepartamento=false;
      this.mostrarFormuTerreno=false;
      this.mostrarFormuLocalComercial=false;
      this.mostrarFormuLocalIndustrial=false;
      this.mostrarFormuOficina=false;
      if(this.selected=="03faf4f8e75e4be794fdea98a081588d"){
        this.mostrarFormuCasa=true;
      }else if(this.selected=="bf602f20e2da47ffbeba28f008e5feef"){
        this.mostrarFormuDepartamento=true;
      }else if(this.selected=="c22de0d0ff4e4392bedbdf7a522fe314"){
        this.mostrarFormuTerreno=true;
      }else if(this.selected=="cf72a97be37f4338a251bb0859327420"){
        this.mostrarFormuLocalComercial=true;
      }else if(this.selected=="efbab777a44c4920b4a897f06cacb9aa"){
        this.mostrarFormuLocalIndustrial=true;
      }else if(this.selected=="60e0a1e143ad4d58b8081374f6ef4946"){
        this.mostrarFormuOficina=true;
      }
  }
  CambiarVista(){
    this.Regresar();
    if(this.vistaTabla == false){
      this.vistaTabla = true;
    }else{
      this.vistaTabla = false;
    }
  }
  VistaEspecifica(prop: Propiedad){
    this.formGeneral = false;
    this.formMedia = false;
    this.formEspe = false;
    this.formListaFotos = false;
    this.vistaEsp = true;
    this.propiedadVista=prop;
    this.detalleService.getListxProp(prop.idPropiedad).subscribe(data=>{
      this.detalles=data;
    });
  }
  SalirVista(){ 
    this.formGeneral = false;
    this.formMedia = false;
    this.formEspe = false;
    this.formListaFotos = false;
    this.vistaEsp = false;
    this.propiedadVista= new Propiedad();
  }
  vistasinLog(prop: Propiedad){
    this.propiedadVista=prop;
    this.vistaEspSinLog = true;
    this.detalleService.getListxProp(prop.idPropiedad).subscribe(data=>{
      this.detalles=data;
    });
  }

  salirvistasinLog(){
    this.vistaEspSinLog = false;
    this.propiedadVista= new Propiedad();
  }
  FormGeneral(){
    this.formGeneral = true;
    this.formMedia = false;
    this.formEspe = false;
    this.formListaFotos = false;
  }

  FormMedia(){
    this.isProgress = true;
    if(this.validar()==true){
      this.cambiarTipoFormu();
      this.formGeneral = false;
      this.formMedia = true;
      this.formEspe = false;
      this.formListaFotos = false;
    }else{
      this.openSnackBar("Llena todos los campos de la propiedad");
    }
    this.isProgress = false;
  }

  FormEspe(){
    this.formGeneral = false;
    this.formMedia = false;
    this.formEspe = true;
    this.formListaFotos = false;
  }
  
  FormLista(){
    this.formGeneral = false;
    this.formMedia = false;
    this.formEspe = false;
    this.formListaFotos = true;
  }
  /*funciones de validacion*/
  validar(){
      if(this.propiedad.tipo.idTipo==null){
        return false;
      }else{
          if(this.propiedad.estado.idEstado==null){
            return false;
          }else{
            if(this.propiedad.ubicacion.idUbicacion==null){
              return false;
            }else{
              if(this.propiedad.cliente.idCliente==null){
                return false;
              }else{
                if(this.propiedad.agente.idAgente==null){
                  return false;
                }else{
                    if(this.propiedad.moneda.idMoneda==null){
                      return false;
                    }else{
                      if(this.propiedad.monedamantenimiento.idMoneda==null){
                        return false;
                      }else{
                        return true;
                      }
                    }
                }
              }
            }
          }
      }
  }

  validarFoto(){
    if(this.propiedad.foto == null && this.fotoId == null){
      this.propiedad.foto = "d79a952eae8e46659d6581e24c848fc4";
    }else if(this.fotoId != null){
      this.imagenes.forEach(i => {
        if(i.id==this.fotoId){
          this.propiedad.foto = i.imagenurl;
        }
      });
    }
    this.fotoId=null;
  }
  
  /*funciones de filtros y busqueda*/
  handlePage(e:PageEvent){
    this.page_size=e.pageSize;
    this.page_number=e.pageIndex + 1;
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  limpiarfiltros(){
    this.cargarDatos();
    this.filtroEstado = null;
    this.filtroPropxAgente = false;
    this.filtroTipo = null;
    this.filtroUbicacion = null;
    this.precioMayor = null;
    this.precioMenor = null;
    this.filtroTipoMonedaMenor = null;
    this.filtroTipoMonedaMayor = null;
    this.areaMinima = null;
    this.areaMaxima = null;
  }
  filtro(){
    this.propiedadService.getList().subscribe(data=>{
      this.dataSource.data=data;
      if(this.filtroPropxAgente){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
          if (obj.agente.idAgente ==  this.loginservice.agente.idAgente) {
            this.propiedadesBus.push(obj);
          };
        };
        this.dataSource.data=this.propiedadesBus;
      }
      if(this.filtroEstado != null){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
          for( let o of this.filtroEstado){
            if (obj.estado.idEstado == o.idEstado) {
              this.propiedadesBus.push(obj);
            };
          }
        };
        this.dataSource.data=this.propiedadesBus;
      }
      if(this.filtroTipo != null){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
          for( let o of this.filtroTipo){
            if (obj.tipo.idTipo == o.idTipo) {
              this.propiedadesBus.push(obj);
            };
          }
        };
        this.dataSource.data=this.propiedadesBus;
      }
      if(this.filtroUbicacion != null){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
          for (let o of this.filtroUbicacion) {
            if (obj.ubicacion.idUbicacion == o.idUbicacion) {
              this.propiedadesBus.push(obj);
            };
          }
        };
        this.dataSource.data=this.propiedadesBus;
      }
      if(this.precioMenor != null && this.filtroTipoMonedaMenor.moneda != null){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
          if(this.filtroTipoMonedaMenor.moneda == 'sol'){
              if(obj.moneda.moneda == 'dolar'){
                obj.precio = obj.precio*3.63;
              }
              if(obj.moneda.moneda == 'euro'){
                obj.precio = obj.precio*4.46;
              }
          }
          if(this.filtroTipoMonedaMenor.moneda == 'dolar'){
              if(obj.moneda.moneda == 'sol'){
                obj.precio = obj.precio/3.63;
              }
              if(obj.moneda.moneda == 'euro'){
                obj.precio = obj.precio*0.81;
              }
          }
        };
        for (let obj of this.dataSource.data) {
          if (obj.precio >= this.precioMenor) {
            this.propiedadesBus.push(obj);
          };
        }
        this.dataSource.data=this.propiedadesBus;
        for (let obj of this.dataSource.data) {
          if(this.filtroTipoMonedaMenor.moneda == 'sol'){
              if(obj.moneda.moneda == 'dolar'){
                obj.precio = obj.precio/3.63;
              }
              if(obj.moneda.moneda == 'euro'){
                obj.precio = obj.precio/4.46;
              }
          }
          if(this.filtroTipoMonedaMenor.moneda == 'dolar'){
              if(obj.moneda.moneda == 'sol'){
                obj.precio = obj.precio*3.63;
              }
              if(obj.moneda.moneda == 'euro'){
                obj.precio = obj.precio/0.81;
              }
          }
        };
      }
      if(this.precioMayor != null && this.filtroTipoMonedaMayor.moneda != null){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
          if(this.filtroTipoMonedaMayor.moneda == 'sol'){
              if(obj.moneda.moneda == 'dolar'){
                obj.precio = obj.precio*3.63;
              }
              if(obj.moneda.moneda == 'euro'){
                obj.precio = obj.precio*4.46;
              }
          }
          if(this.filtroTipoMonedaMayor.moneda == 'dolar'){
              if(obj.moneda.moneda == 'sol'){
                obj.precio = obj.precio/3.63;
              }
              if(obj.moneda.moneda == 'euro'){
                obj.precio = obj.precio*0.81;
              }
          }
        };
        for (let obj of this.dataSource.data) {
          if (obj.precio <= this.precioMayor) {
            this.propiedadesBus.push(obj);
          };
        };
        this.dataSource.data=this.propiedadesBus;
        for (let obj of this.dataSource.data) {
          if(this.filtroTipoMonedaMayor.moneda == 'sol'){
              if(obj.moneda.moneda == 'dolar'){
                obj.precio = obj.precio/3.63;
              }
              if(obj.moneda.moneda == 'euro'){
                obj.precio = obj.precio/4.46;
              }
          }
          if(this.filtroTipoMonedaMayor.moneda == 'dolar'){
              if(obj.moneda.moneda == 'sol'){
                obj.precio = obj.precio*3.63;
              }
              if(obj.moneda.moneda == 'euro'){
                obj.precio = obj.precio/0.81;
              }
          }
        };
      }
      if(this.canDormitorios != null){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
            for( let o of this.canDormitorios){
                if (obj.dormitorios == o) {
                  this.propiedadesBus.push(obj);
                };
            }
        };
        this.dataSource.data=this.propiedadesBus;
      }
      if(this.canBanios != null){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
            for( let o of this.canBanios){
                if (obj.banios == o) {
                  this.propiedadesBus.push(obj);
                };
            }
        };
        this.dataSource.data=this.propiedadesBus;
      }
      if(this.canCocheras != null){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
            for( let o of this.canCocheras){
                if (obj.cocheras == o) {
                  this.propiedadesBus.push(obj);
                };
            }
        };
        this.dataSource.data=this.propiedadesBus;
      }
      if(this.areaMinima != null){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
              if (obj.tamanoArea >= this.areaMinima) {
                this.propiedadesBus.push(obj);
              };
        };
        this.dataSource.data=this.propiedadesBus;
      }
      if(this.areaMaxima != null){
        this.propiedadesBus=[];
        for (let obj of this.dataSource.data) {
            if (obj.tamanoArea <= this.areaMaxima) {
              this.propiedadesBus.push(obj);
            };
        };
        this.dataSource.data=this.propiedadesBus;
      }
    });
  }


  BuscarFecha(da1: Date,da2: Date):void{
    if (da1 === null || da2 === null){
      this.propiedadService.getList().subscribe(data=>{
        this.dataSource.data=data;
      })
    }else{
      this.propiedadesBus=[];
      for (let obj of this.propiedades) {
        var res = new Date(da1).getTime() < new Date(obj.fechaIngreso).getTime();
        var res2 = new Date(da2).getTime() > new Date(obj.fechaIngreso).getTime();
        if (res) {
          if(res2){
            this.propiedadesBus.push(obj);
          }
        };
      };
      this.dataSource.data=this.propiedadesBus;
    }
  }

  /*funciones crud*/
  setearCombos(){
      this.tipos.forEach(obj => {
        if(obj.idTipo==this.propiedad.tipo.idTipo){
          this.propiedad.tipo=obj;
        }
      }); 
      this.estados.forEach(obj => {
        if(obj.idEstado==this.propiedad.estado.idEstado){
          this.propiedad.estado=obj;
        }
      });
  
      this.ubicaciones.forEach(obj => {
        if(obj.idUbicacion==this.propiedad.ubicacion.idUbicacion){
          this.propiedad.ubicacion=obj;
        }
      }); 
  
  
      this.agentes.forEach(obj => {
        if(obj.idAgente==this.propiedad.agente.idAgente){
          this.propiedad.agente=obj;
        }
      });
  
      this.clientes.forEach(obj => {
        if(obj.idCliente==this.propiedad.cliente.idCliente){
          this.propiedad.cliente=obj;
        }
      });
      this.monedas.forEach(obj => {
        if(obj.idMoneda==this.propiedad.moneda.idMoneda){
          this.propiedad.moneda=obj;
        }
        if(obj.idMoneda==this.propiedad.monedamantenimiento.idMoneda){
          this.propiedad.monedamantenimiento=obj;
        }
      });
  }
  Guardar(){
    this.isProgress = true;
    if (this.validar()) {
      this.validarFoto();
      this.propiedad.fechaActualizacion = new Date();//fecha de actualizacion
      this.setearCombos();//asigna combos
      this.isProgress = false;
      this.propiedadService.create(this.propiedad).subscribe(data=>{
        this.openSnackBar("Propiedad se agrego con exito");
      });
      this.cargarDatos();
      this.Regresar();
    }
    else{
      this.openSnackBar("Llena todos los campos de la propiedad");
    }
  }

  Editar(propiedad: Propiedad){
    this.cargarCombos();
    this.cargarPropiedades();
    this.propiedad = propiedad;
    this.formAct=true;
    this.formGeneral = true;
    this.formMedia = false;
    this.formEspe = false;
    this.formListaFotos = false;
    this.editar=true;
  }

  AsignarFotos(propiedad: Propiedad){
    this.cargarCombos();
    this.cargarPropiedades();
    this.propiedad = propiedad;
    this.formAct=true;
    this.formGeneral = false;
    this.formMedia = false;
    this.formEspe = false;
    this.formListaFotos = true;
    this.editar=true;
  }

  Actualizar(){
    this.isProgress = true;
    if (this.validar()) {
      this.validarFoto();
      this.propiedad.fechaActualizacion = new Date();//fecha de actualizacion
      this.setearCombos();//asigna combos
      this.isProgress = false;
      this.propiedadService.update(this.propiedad).subscribe(data=>{
        this.openSnackBar("Propiedad se actualizo con exito");
      });
      this.cargarDatos();
      this.Regresar();
    }
    else{
      this.openSnackBar("Llena todos los campos de la propiedad");
    }
    
  }
  
  Eliminar(propiedad: Propiedad):void{
    this.propiedadService.delete(propiedad.idPropiedad).subscribe(data=>{
      this.propiedades=this.propiedades.filter(p=>p!==propiedad);
    });
    this.openSnackBar("Propiedad se elimino con exito");
    this.cargarDatos();
    this.SalirVista();
  }
  
  /*funciones crud externas*/
    
  onUpload(): void {
    this.isProgress = true;
    this.fotoId = uuid().replace(/-/g, '');//crea id de foto
    this.imagenService.upload(this.imagen,this.fotoId).subscribe(
      data => {
        this.cargarImagenes();
        this.reset();
        this.mostrarFoto=false;
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


  onFileChangeMultimedia(event) {
    this.multimedia = event.target.files[0];
    const fr = new FileReader();
    fr.onload = (evento: any) => {
      this.multimediaMin = evento.target.result;
    };
    fr.readAsDataURL(this.multimedia);
  }

  onUploadMultimedia(): void {
    this.isProgress = true;
    this.multimediaId = uuid().replace(/-/g, '');
    this.multimediaservice.upload(this.multimedia,this.multimediaId).subscribe(
      data => {
        this.cargarMultimedias();
        this.resetMultimedia();
        this.mostrarMultimedia=false;
        this.isProgress = false;
      },
      err => {
        alert(err.error.mensaje);
        this.resetMultimedia();
      }
    );
  }

  resetMultimedia(): void {
    this.multimedia = null;
    this.multimediaMin = null;
    this.multimediaFile.nativeElement.value = '';
  }

}
